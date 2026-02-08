package me.luka.easyscript;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.graalvm.polyglot.Value;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScriptCommands {

    private final EasyScript plugin;
    private static CommandMap commandMap;
    private final List<String> registeredCommands = new ArrayList<>();

    public ScriptCommands(EasyScript plugin) {
        this.plugin = plugin;
        setupCommandMap();
    }

    private void setupCommandMap() {
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
        } catch (Exception e) {
            plugin.getLogger().warning("Failed to get CommandMap: " + e.getMessage());
        }
    }

    public void register(String name, String description, String usage, Value callback) {
        Command command = new Command(name) {
            @Override
            public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel,
                    @NotNull String[] args) {
                callback.execute(sender, args);
                return true;
            }
        };
        command.setDescription(description);
        command.setUsage(usage);
        command.setAliases(new ArrayList<>());

        commandMap.register(plugin.getName(), command);
        registeredCommands.add(name);
    }

    @SuppressWarnings("unchecked")
    public void unregisterAll() {
        try {
            Field knownCommandsField = null;
            Class<?> clazz = commandMap.getClass();
            while (clazz != null && knownCommandsField == null) {
                try {
                    knownCommandsField = clazz.getDeclaredField("knownCommands");
                } catch (NoSuchFieldException e) {
                    clazz = clazz.getSuperclass();
                }
            }

            if (knownCommandsField != null) {
                knownCommandsField.setAccessible(true);
                Map<String, Command> knownCommands = (Map<String, Command>) knownCommandsField.get(commandMap);

                for (String name : registeredCommands) {
                    knownCommands.remove(name);
                    knownCommands.remove(plugin.getName().toLowerCase() + ":" + name);
                }
            }
            registeredCommands.clear();
        } catch (Exception e) {
            plugin.getLogger().warning("Failed to unregister commands: " + e.getMessage());
        }
    }
}
