package me.luka.easyscript;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.graalvm.polyglot.Value;

public class ScriptEvents implements Listener {

    private final EasyScript plugin;

    public ScriptEvents(EasyScript plugin) {
        this.plugin = plugin;
    }

    public void on(Class<? extends Event> eventClass, Value callback) {
        Bukkit.getPluginManager().registerEvent(eventClass, this, EventPriority.NORMAL, (l, event) -> {
            if (eventClass.isInstance(event)) {
                callback.execute(event);
            }
        }, plugin);
    }

    public void unregisterAll() {
        org.bukkit.event.HandlerList.unregisterAll(this);
    }
}
