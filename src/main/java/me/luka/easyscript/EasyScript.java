package me.luka.easyscript;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class EasyScript extends JavaPlugin {

    private ScriptManager scriptManager;

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

        this.scriptManager = new ScriptManager(this);
        this.scriptManager.loadScripts();

        getCommand("easyscript").setExecutor(new CommandHandler(this));

        getLogger().info("EasyScript enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("EasyScript disabled!");
    }

    public ScriptManager getScriptManager() {
        return scriptManager;
    }
}
