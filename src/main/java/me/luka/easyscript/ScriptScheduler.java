package me.luka.easyscript;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.graalvm.polyglot.Value;

public class ScriptScheduler {

    private final Plugin plugin;

    public ScriptScheduler(Plugin plugin) {
        this.plugin = plugin;
    }

    public void runLater(long delayTicks, Value callback) {
        Bukkit.getScheduler().runTaskLater(plugin, callback::execute, delayTicks);
    }

    public void runSync(Value callback) {
        Bukkit.getScheduler().runTask(plugin, callback::execute);
    }

    public void runAsync(Value callback) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, callback::execute);
    }
}
