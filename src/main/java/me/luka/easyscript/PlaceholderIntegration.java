package me.luka.easyscript;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;

public class PlaceholderIntegration {

    public String setPlaceholders(OfflinePlayer player, String text) {
        try {
            return PlaceholderAPI.setPlaceholders(player, text);
        } catch (Exception e) {
            return text;
        }
    }

    public String setBracketPlaceholders(OfflinePlayer player, String text) {
        try {
            return PlaceholderAPI.setBracketPlaceholders(player, text);
        } catch (Exception e) {
            return text;
        }
    }
}
