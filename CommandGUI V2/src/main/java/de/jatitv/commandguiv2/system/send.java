package de.jatitv.commandguiv2.system;

import com.mysql.cj.x.protobuf.MysqlxNotice;
import de.jatitv.commandguiv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class send {
    public static void Console(String msg){
        Bukkit.getConsoleSender().sendMessage(msg);
    }
    public static void Player(Player player, String msg){
        player.sendMessage(msg);
    }
    public static void Sender(CommandSender sender, String msg){
        sender.sendMessage(msg);
    }

    public static void Info(String msg){
        Main.getPlugin().getLogger().log(Level.INFO, msg);
    }
    public static void Warning(String msg){
        Main.getPlugin().getLogger().log(Level.WARNING, msg);
    }
    public static void Error(String msg){
        Main.getPlugin().getLogger().log(Level.SEVERE, msg);
    }
}
