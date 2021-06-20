package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.config.select.Select_config;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.logging.Level;

public class send {
    public static void console(String msg) {
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public static void debug(String msg) {
      //  if (!new File(Main.getPath(), "config.yml").exists()) return;
        if (Main.plugin.getConfig().getBoolean("Plugin.Debug")) Bukkit.getConsoleSender().sendMessage(Main.Prefix + " §5DEBUG: §6" + msg);
    }

    public static void debugmsg(String msg) {
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + " §5DEBUG-MSG: §6" + msg);
    }

    public static void player(Player player, String msg) {
        player.sendMessage(msg);
    }

    public static void sender(CommandSender sender, String msg) {
        sender.sendMessage(msg);
    }

    public static void info(String msg) {
        Main.getPlugin().getLogger().log(Level.INFO, msg);
    }

    public static void warning(String msg) {
        Main.getPlugin().getLogger().log(Level.WARNING, msg);
    }

    public static void error(String msg) {
        Main.getPlugin().getLogger().log(Level.SEVERE, msg);
    }
}
