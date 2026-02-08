// Comprehensive EasyScript Example
// Path: plugins/EasyScript/scripts/main.js

const PlayerJoinEvent = Java.type('org.bukkit.event.player.PlayerJoinEvent');
const PlayerDeathEvent = Java.type('org.bukkit.event.entity.PlayerDeathEvent');

// 1. Handling Events
events.on(PlayerJoinEvent, (event) => {
    const player = event.getPlayer();

    // Support for PlaceholderAPI
    const message = placeholder.setPlaceholders(player, "§6[EasyScript] §fДобро пожаловать, %player_name%!");
    player.sendMessage(message);

    // Native Bukkit API access
    player.sendTitle("§bEasyScript", "§fПлагин готов к работе", 10, 70, 20);
});

// 2. Registering Custom Commands
commands.register("test", "Тестовая команда", "/test", (sender, args) => {
    sender.sendMessage("§aВы выполнили команду /test!");
    if (args.length > 0) {
        sender.sendMessage("§fВаши аргументы: " + args.join(", "));
    }
});

// 3. Simple Death Counter (logic in JS)
let deaths = {};

events.on(PlayerDeathEvent, (event) => {
    const player = event.getEntity();
    if (!(player instanceof org.bukkit.entity.Player)) return;

    const name = player.getName();
    deaths[name] = (deaths[name] || 0) + 1;

    player.sendMessage(`§cОй! Это была ваша смерть №${deaths[name]}`);
});
