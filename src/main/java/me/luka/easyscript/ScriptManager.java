package me.luka.easyscript;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;

public class ScriptManager {

    private final EasyScript plugin;
    private final Map<String, ScriptInstance> activeScripts = new HashMap<>();

    private static class ScriptInstance {
        Context context;
        ScriptEvents events;
        ScriptCommands commands;

        ScriptInstance(Context context, ScriptEvents events, ScriptCommands commands) {
            this.context = context;
            this.events = events;
            this.commands = commands;
        }

        void unload() {
            events.unregisterAll();
            commands.unregisterAll();
            context.close();
        }
    }

    public ScriptManager(EasyScript plugin) {
        this.plugin = plugin;
        System.setProperty("polyglot.engine.WarnInterpreterOnly", "false");
    }

    public void loadScripts() {
        File scriptsDir = new File(plugin.getDataFolder(), "scripts");
        File[] files = scriptsDir.listFiles((dir, name) -> name.endsWith(".js"));

        if (files == null)
            return;

        for (File file : files) {
            loadScript(file);
        }
    }

    public void loadScript(File file) {
        try {
            Context context = Context.newBuilder("js")
                    .allowHostAccess(HostAccess.ALL)
                    .allowHostClassLookup(s -> true)
                    .hostClassLoader(plugin.getClass().getClassLoader())
                    .build();

            // Bind basic objects
            ScriptEvents events = new ScriptEvents(plugin);
            ScriptCommands commands = new ScriptCommands(plugin);

            context.getBindings("js").putMember("plugin", plugin);
            context.getBindings("js").putMember("server", plugin.getServer());
            context.getBindings("js").putMember("logger", plugin.getLogger());
            context.getBindings("js").putMember("placeholder", new PlaceholderIntegration());
            context.getBindings("js").putMember("events", events);
            context.getBindings("js").putMember("commands", commands);
            context.getBindings("js").putMember("scheduler", new ScriptScheduler(plugin));
            context.getBindings("js").putMember("papi", plugin.getExpansion());
            context.getBindings("js").putMember("Bukkit", org.bukkit.Bukkit.class);

            String content = Files.readString(file.toPath());
            context.eval("js", content);

            activeScripts.put(file.getName(), new ScriptInstance(context, events, commands));
            plugin.getLogger().info("Loaded script: " + file.getName());

        } catch (Exception e) {
            plugin.getLogger().severe("Failed to load script " + file.getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void unloadAll() {
        if (plugin.getExpansion() != null) {
            plugin.getExpansion().clearPlaceholders();
        }
        activeScripts.values().forEach(ScriptInstance::unload);
        activeScripts.clear();
    }

    public void reload() {
        unloadAll();
        loadScripts();
    }

    public Set<String> getActiveScriptNames() {
        return activeScripts.keySet();
    }

    public Set<String> getAllScriptNames() {
        File scriptsDir = new File(plugin.getDataFolder(), "scripts");
        if (!scriptsDir.exists())
            return Collections.emptySet();

        File[] files = scriptsDir.listFiles((dir, name) -> name.endsWith(".js"));
        if (files == null)
            return Collections.emptySet();

        return Arrays.stream(files).map(File::getName).collect(Collectors.toSet());
    }
}
