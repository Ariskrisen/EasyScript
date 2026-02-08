// World Border Upgrade Script for EasyScript
// Path: plugins/EasyScript/scripts/border_logic.js

const PlayerCommandPreprocessEvent = Java.type('org.bukkit.event.player.PlayerCommandPreprocessEvent');
const PlayerJoinEvent = Java.type('org.bukkit.event.player.PlayerJoinEvent');
const ItemStack = Java.type('org.bukkit.inventory.ItemStack');
const Material = Java.type('org.bukkit.Material');
const Bukkit = Java.type('org.bukkit.Bukkit');
const File = Java.type('java.io.File');
const Files = Java.type('java.nio.file.Files');
const StandardOpenOption = Java.type('java.nio.file.StandardOpenOption');

// --- Configuration & Data ---
const DATA_FILE = new File(plugin.getDataFolder(), "player_data.json");
let data = {};

function loadData() {
    if (DATA_FILE.exists()) {
        try {
            const content = Files.readString(DATA_FILE.toPath());
            data = JSON.parse(content);
        } catch (e) {
            logger.severe("Could not load player data: " + e);
        }
    }
}

function saveData() {
    try {
        const content = JSON.stringify(data, null, 2);
        Files.writeString(DATA_FILE.toPath(), content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (e) {
        logger.severe("Could not save player data: " + e);
    }
}

loadData();

const LEVELS = [
    { size: 100, cost: "Начальный уровень", req: null },
    { size: 200, cost: "32 Железа", req: (p) => takeItems(p, Material.IRON_INGOT, 32) },
    { size: 400, cost: "64 Железа", req: (p) => takeItems(p, Material.IRON_INGOT, 64) },
    { size: 800, cost: "$5,000", req: (p) => takeMoney(p, 5000) },
    { size: 1600, cost: "$20,000", req: (p) => takeMoney(p, 20000) },
    { size: 3200, cost: "32 Алмаза + $50,000", req: (p) => takeItems(p, Material.DIAMOND, 32) && takeMoney(p, 50000) },
    { size: 6400, cost: "1 Звезда Незера + $100,000", req: (p) => takeItems(p, Material.NETHER_STAR, 1) && takeMoney(p, 100000) }
];

// --- Helpers ---
function isInOwnWorld(player) {
    const result = placeholder.setPlaceholders(player, "%worldsystem_is_creator%");
    const lowered = result.toLowerCase();
    return lowered === "yes" || lowered === "true" || lowered === "1";
}

function takeItems(player, material, amount) {
    if (!player.getInventory().contains(material, amount)) {
        player.sendMessage("§cУ вас недостаточно ресурсов! Нужно: " + amount + " " + material);
        return false;
    }
    const item = new ItemStack(material, amount);
    player.getInventory().removeItem(item);
    return true;
}

function takeMoney(player, amount) {
    // Basic Vault check (via Bukkit Services)
    const rsp = Bukkit.getServicesManager().getRegistration(Java.type('net.milkbowl.vault.economy.Economy').class);
    if (rsp == null) {
        player.sendMessage("§cЭкономика недоступна!");
        return false;
    }
    const econ = rsp.getProvider();
    if (econ.getBalance(player) < amount) {
        player.sendMessage("§cУ вас недостаточно денег! Нужно: $" + amount);
        return false;
    }
    econ.withdrawPlayer(player, amount);
    return true;
}

function updateBorder(player, size) {
    player.getWorld().getWorldBorder().setSize(size);
    player.sendMessage(`§aГраница мира расширена до ${size} блоков!`);
}

// --- Event Handlers ---

events.on(PlayerCommandPreprocessEvent, (event) => {
    const msg = event.getMessage().toLowerCase();
    const player = event.getPlayer();
    const uuid = player.getUniqueId().toString();

    if (msg.startsWith("/ws home")) {
        if (!data[uuid]) {
            data[uuid] = { first_time: true, level: 0 };
            saveData();

            // Schedule notification after 10 seconds (200 ticks)
            scheduler.runLater(200, () => {
                // Double check if player is online and in their world
                if (player.isOnline() && isInOwnWorld(player)) {
                    player.sendMessage("§c§lОЙ! §fМир ограничен!");
                    player.sendMessage("§fВаш текущий мир имеет лимит. Чтобы увеличить барьер, используйте команду §b/upgrade-border");
                    player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1, 1);
                }
            });
        }
    }
});

// --- Commands ---

commands.register("upgrade-border", "Улучшить границу мира", "/upgrade-border", (sender, args) => {
    if (!(sender instanceof org.bukkit.entity.Player)) {
        sender.sendMessage("Только для игроков!");
        return;
    }

    const player = sender;

    if (!isInOwnWorld(player)) {
        player.sendMessage("§cЭту команду можно использовать только в своем мире!");
        return;
    }

    const uuid = player.getUniqueId().toString();
    const pData = data[uuid] || { level: 0 };
    const nextLevel = pData.level + 1;

    if (nextLevel >= LEVELS.length) {
        player.sendMessage("§6У вас максимальный уровень границы мира!");
        return;
    }

    const levelInfo = LEVELS[nextLevel];
    player.sendMessage("§b--- Улучшение границы мира ---");
    player.sendMessage(`§fТекущий размер: §a${LEVELS[pData.level].size}`);
    player.sendMessage(`§fСледующий размер: §e${levelInfo.size}`);
    player.sendMessage(`§fСтоимость: §c${levelInfo.cost}`);
    player.sendMessage("§fЧтобы подтвердить, пропишите: §b/upgrade-border confirm");

    if (args.length > 0 && args[0] === "confirm") {
        if (levelInfo.req(player)) {
            pData.level = nextLevel;
            data[uuid] = pData;
            saveData();
            updateBorder(player, levelInfo.size);
        }
    }
});
