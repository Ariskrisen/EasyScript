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

        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            plugin.getScriptManager().reload();
            sender.sendMessage("§aEasyScript scripts reloaded!");
            return true;
        }

        sender.sendMessage("§bEasyScript v" + plugin.getDescription().getVersion());
        sender.sendMessage("§f/es reload - Reload all scripts");
        return true;
    }
}
