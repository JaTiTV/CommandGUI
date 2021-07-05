package de.jatitv.commandguiv2.Spigot.system;

import net.md_5.bungee.BungeeCord;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

public class send {
    public static void console(String msg) {
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public static void player(Player player, String msg) {
        player.sendMessage(msg);
    }

    public static void playerTitle(Player player, String Title, String SubTitle, Integer FadeIn, Integer ShowTime, Integer FadeOut){
        player.sendTitle(Replace.replace(player, Title), Replace.replace(SubTitle), FadeIn, ShowTime, FadeOut);
    }

    public static void sender(CommandSender sender, String msg) {
        sender.sendMessage(msg);
    }

    public static void debug(Plugin plugin, String msg) {
        //  if (!new File(Main.getPath(), "config.yml").exists()) return;
        if (plugin.getConfig().getBoolean("Plugin.Debug")) Bukkit.getConsoleSender().sendMessage(plugin.getDescription().getPrefix() + " §5DEBUG: §6" + msg);
    }

    public static void debugmsg(Plugin plugin, String msg) {
        Bukkit.getConsoleSender().sendMessage(plugin.getDescription().getPrefix() + " §5DEBUG-MSG: §6" + msg);
    }

    public static void info(Plugin plugin,String msg) {
        plugin.getLogger().log(Level.INFO, msg);
    }

    public static void warning(Plugin plugin,String msg) {
        plugin.getLogger().log(Level.WARNING, msg);
    }

    public static void error(Plugin plugin,String msg) {
        plugin.getLogger().log(Level.SEVERE, msg);
    }


}
