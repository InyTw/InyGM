package io.github.gamemode;

import org.bukkit.ChatColor;

public class MessageUtils {
    private static final String PREFIX = ChatColor.translateAlternateColorCodes('&', "&6[&bIny&eGM&6] ");

    public static String format(String message) {
        return PREFIX + ChatColor.translateAlternateColorCodes('&', message);
    }
}
