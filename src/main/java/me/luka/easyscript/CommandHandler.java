package me.luka.easyscript;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandHandler implements CommandExecutor {

    private final EasyScript plugin;

    public CommandHandler(EasyScript plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
            @NotNull String[] args) {
        if (!sender.hasPermission("easyscript.admin")) {
            sender.sendMessage("§cNo permission.");
            return true;
        }

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.getScriptManager().reload();
                sender.sendMessage("§aEasyScript scripts reloaded!");
                return true;
            }

            if (args[0].equalsIgnoreCase("list")) {
                sender.sendMessage("§b--- Available Scripts ---");
                plugin.getScriptManager().getAllScriptNames().forEach(name -> {
                    sender.sendMessage("§f- " + name);
                });
                sender.sendMessage("§7Use /es status to see which are running.");
                return true;
            }

            if (args[0].equalsIgnoreCase("status")) {
                sender.sendMessage("§b--- Script Status ---");
                java.util.Set<String> active = plugin.getScriptManager().getActiveScriptNames();
                plugin.getScriptManager().getAllScriptNames().forEach(name -> {
                    String status = active.contains(name) ? "§a[LOADED]" : "§c[NOT LOADED]";
                    sender.sendMessage(status + " §f" + name);
                });
                return true;
            }
        }

        sender.sendMessage("§bEasyScript v" + plugin.getDescription().getVersion());
        sender.sendMessage("§f/es reload - Reload all scripts");
        sender.sendMessage("§f/es list - List all script files");
        sender.sendMessage("§f/es status - Show script loading status");
        return true;
    }
}
