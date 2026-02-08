package me.luka.easyscript;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;

public class PlaceholderIntegration {

    public String setPlaceholders(OfflinePlayer player, String text) {
        return PlaceholderAPI.setPlaceholders(player, text);
    }

    public String setBracketPlaceholders(OfflinePlayer player, String text) {
        return PlaceholderAPI.setBracketPlaceholders(player, text);
    }
}
