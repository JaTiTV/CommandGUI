package de.jatitv.commandguiv2.Spigot.system;

import de.jatitv.commandguiv2.Spigot.Listener.UseItem_Listener.UseItem_1_10bis1_15;
import de.jatitv.commandguiv2.Spigot.Listener.UseItem_Listener.UseItem_1_8bis1_9;
import de.jatitv.commandguiv2.Spigot.Listener.UseItem_Listener.UseItem_ab1_16;
import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.cmdManagement.Commands;
import de.jatitv.commandguiv2.Spigot.cmdManagement.Help;
import de.jatitv.commandguiv2.Spigot.system.config.DefaultGUICreate;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_msg;
import de.jatitv.commandguiv2.Spigot.system.database.Select_Database;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class API {
    public static Boolean JoinDisable = false;

    public static void onItemChange(Player player) {
        if (player.hasPermission("commandgui.get.guiitem.at.login")) {
            if (Main.minecraft1_8 || Main.minecraft1_9) {
                UseItem_1_8bis1_9.itemChange(player);
            } else if (Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12 || Main.minecraft1_13 || Main.minecraft1_14 || Main.minecraft1_15) {
                UseItem_1_10bis1_15.itemChange(player);
            } else UseItem_ab1_16.itemChange(player);
        }
    }

    public static void disableItemGiveOnJoin(Boolean disableItemGiveOnJoin) {

        JoinDisable = disableItemGiveOnJoin;

    }

    public static Boolean selectPlayerItemEnable(Player player) {
        return Select_Database.selectItemStatus(player);
    }

    public static Integer selectPlayerItemSlot(Player player) {
        return Select_Database.selectSlot(player);
    }

    public static void setPlayerItemEnable(Player player, Boolean value) {
        if (value) {
            Select_Database.setItemStatusTrue(player);
        } else Select_Database.setItemStatusFalse(player);
    }

    public static void setPlayerItemSlot(Player player, Integer value) {
        Select_Database.setSlot(player, value);
    }

    public static void openDefaultGUI(Player player) {
        Commands.gui(player);
    }

    public static void openGUI(Player player, String GUI_CommandName) {
        Commands.gui(player, GUI_CommandName);
    }

    public static void sendHelp(CommandSender sender) {
        Help.sendHelp(sender, Main.Prefix);
    }

    public static void sendPluginInfo(CommandSender sender) {
        if (sender.hasPermission("commandgui.command.info")) {
            Commands.info(sender);
        } else sender.sendMessage(Select_msg.NoPermissionForCommand
                .replace("[cmd]", "/commandguiadmin").replace("[perm]", "commandgui.command.info"));
    }

    public static void createDefaultGUI(CommandSender sender) {
        if (sender.hasPermission("commandgui.admin")) {
            DefaultGUICreate.configCreate();
            sender.sendMessage(Select_msg.DefaultGUIcreate.replace("[directory]", Main.getPath() + "\\GUIs\\default.yml"));
        } else sender.sendMessage(Select_msg.NoPermissionForCommand
                .replace("[cmd]", "/commandguiadmin").replace("[perm]", "commandgui.admin"));
    }

    public static void reload(CommandSender sender) {
        if (sender.hasPermission("commandgui.admin")) {
            Commands.reload(sender);
        } else sender.sendMessage(Select_msg.NoPermissionForCommand
                .replace("[cmd]", "/commandguiadmin").replace("[perm]", "commandgui.admin"));
    }


}
