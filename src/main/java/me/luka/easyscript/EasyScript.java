package me.luka.easyscript;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class EasyScript extends JavaPlugin {

    private ScriptManager scriptManager;

    private EasyScriptExpansion expansion;

    @Override
    public void onEnable() {
        // Create scripts folder
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        File scriptsDir = new File(getDataFolder(), "scripts");
        if (!scriptsDir.exists()) {
            scriptsDir.mkdirs();
            saveResource("scripts/border_logic.js", false);
        }

        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            this.expansion = new EasyScriptExpansion(this);
            this.expansion.register();
        }

        this.scriptManager = new ScriptManager(this);
        this.scriptManager.loadScripts();

        getCommand("easyscript").setExecutor(new CommandHandler(this));

        getLogger().info("EasyScript enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("EasyScript disabled!");
    }

    public EasyScriptExpansion getExpansion() {
        return expansion;
    }

    public ScriptManager getScriptManager() {
        return scriptManager;
    }
}
