package me.luka.easyscript;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class EasyScriptExpansion extends PlaceholderExpansion {

    private final EasyScript plugin;
    private final Map<String, BiFunction<OfflinePlayer, String, String>> placeholders = new HashMap<>();

    public EasyScriptExpansion(EasyScript plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "easyscript";
    }

    @Override
    public @NotNull String getAuthor() {
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    public void registerPlaceholder(String prefix, BiFunction<OfflinePlayer, String, String> handler) {
        placeholders.put(prefix, handler);
    }

    public void clearPlaceholders() {
        placeholders.clear();
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        // Syntax: %easyscript_<prefix>_<subparams>%
        for (Map.Entry<String, BiFunction<OfflinePlayer, String, String>> entry : placeholders.entrySet()) {
            if (params.startsWith(entry.getKey() + "_")) {
                String subParams = params.substring(entry.getKey().length() + 1);
                return entry.getValue().apply(player, subParams);
            }
        }
        return null;
    }
}
