package de.jatitv.commandguiv2.Spigot.cmdManagement;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.Objekte.GUI_Obj_Select;
import de.jatitv.commandguiv2.Spigot.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.Spigot.cmdManagement.register.AliasRegister;
import de.jatitv.commandguiv2.Spigot.gui.GUI_GUI;
import de.jatitv.commandguiv2.Spigot.system.GUI_Give_UseItem;
import de.jatitv.commandguiv2.Spigot.system.TextBuilder;
import de.jatitv.commandguiv2.Spigot.system.config.ConfigCreate;
import de.jatitv.commandguiv2.Spigot.system.config.languages.LanguagesCreate;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_config;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_msg;
import de.jatitv.commandguiv2.Spigot.system.database.Select_Database;
import de.jatitv.commandguiv2.Spigot.system.send;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Commands {
    private static Plugin plugin = Main.plugin;
    private static String Prefix = Main.Prefix;
    private static String Autor = String.valueOf(Main.Autor);
    private static String Version = Main.Version;
    private static String Spigot = Main.Spigot;
    private static String Discord = Main.Discord;

    public static void info(CommandSender sender) {

        send.sender(sender, Main.Prefix + "§4======= §8[§4Command§9GUI§8] §4=======");
        send.sender(sender, Prefix + " §2Autor: §6" + String.valueOf(Autor).replace("[", "").replace("]", ""));

        if (Main.update_version.equalsIgnoreCase(Version)) {
            send.sender(sender, Prefix + " §2Version: §6" + Version);
        } else {
            sender.sendMessage(Prefix + " §6A new version was found!");
            TextComponent comp = new TextBuilder(Prefix + " §6Your version: §c" + Version + " §7- §6Current version: §a" + Main.update_version)
                    .addHover("§6You can download it here: §e" + Main.Spigot).addClickEvent(ClickEvent.Action.OPEN_URL, Main.Spigot).build();
            sender.spigot().sendMessage(comp);
            TextComponent comp2 = new TextBuilder(Prefix + " §6You can find more information on Discord.")
                    .addHover("§e" + Main.Discord).addClickEvent(ClickEvent.Action.OPEN_URL, Main.Discord).build();
            sender.spigot().sendMessage(comp2);
        }

        send.sender(sender, Prefix + " §2Spigot: §6" + Spigot);
        send.sender(sender, Prefix + " §2Discord: §6" + Discord);
        send.sender(sender, Prefix + "§4======= §8[§4Command§9GUI§8] §4=======");
    }

    public static void reload(CommandSender sender) {
        if (sender instanceof Player) sender.sendMessage(Select_msg.ReloadStart);
        send.console(Prefix + "§8-------------------------------");
        send.console(Prefix + " §6Plugin reload...");
        send.console(Prefix + "§8-------------------------------");

        ConfigCreate.configCreate();
        Select_config.onSelect();

        LanguagesCreate.langCreate();

        GUI_Obj_Select.onSelect();
        Select_msg.onSelect(Prefix);
        Select_config.sound(Main.Prefix);
        try {
            AliasRegister.onRegister();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Select_config.Bungee){
            Bukkit.getMessenger().registerOutgoingPluginChannel(Main.plugin, "commandgui:bungee");

        }
        if (sender instanceof Player) sender.sendMessage(Select_msg.ReloadWarning);
        send.warning(plugin, "To enable / disable alias commands, reload / restart the server!");

        if (sender instanceof Player) sender.sendMessage(Select_msg.ReloadEnd);
        send.console(Prefix + "§8-------------------------------");
        send.console(Prefix + " §2Plugin successfully reloaded.");
        send.console(Prefix + "§8-------------------------------");
    }

    public static void give(CommandSender sender, Player target) {
        if (Bukkit.getPlayer(target.getName()) != null) {
            GUI_Give_UseItem.onGive(target);
            send.sender(sender, Select_msg.Give_Sender.replace("[player]", target.getName()).replace("[item]", Select_config.UseItem_Name));
            send.player(target, Select_msg.Give_Receiver.replace("[sender]", sender.getName()).replace("[item]", Select_config.UseItem_Name));
            if (Select_config.Sound_Give_Enable && Select_config.Sound_Enable) {
                target.playSound(target.getLocation(), Select_config.Sound_Give, 3, 1);
            }
        } else {
            sender.sendMessage(Select_msg.PlayerNotFond.replace("[player]", target.getName()));
            if (Select_config.Sound_PlayerNotFound_Enable && Select_config.Sound_Enable) {
                if (sender instanceof Player)
                    ((Player) sender).playSound(((Player) sender).getLocation(), Select_config.Sound_PlayerNotFound, 3, 1);
            }
        }
    }

    public static void itemOn(Player player) {
        for (int iam = 0; iam < player.getInventory().getSize() - 5; iam++) {
            ItemStack itm = player.getInventory().getItem(iam);
            if (itm != null) {
                if (itm.getType() == Material.valueOf(Select_config.UseItem_Material) || itm.getType() == Main.Head) {
                    if (itm.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                        player.getInventory().remove(itm);
                        player.updateInventory();
                        break;
                    }
                }
            }
        }
        Integer slot = null;
        if (Select_Database.selectSlot(player) == null) {
            slot = Select_config.UseItem_InventorySlot;
        } else {
            slot = Select_Database.selectSlot(player);
        }
        send.debug(plugin,String.valueOf(slot));
        if (player.getInventory().getItem(slot - 1) == null) {
            Select_Database.setItemStatusTrue(player);
            GUI_Give_UseItem.onGive(player);
        } else {
            boolean empty = false;
            for (int i = 0; i < 9; i++) {
                if (player.getInventory().getItem(i) == null) {
                    empty = true;
                    break;
                }
            }
            if (empty) {
                Select_Database.setItemStatusTrue(player);
                GUI_Give_UseItem.onGiveADD(player);
                send.player(player, Select_msg.ItemON);
            } else {
                player.sendMessage(Select_msg.NoInventorySpace);
                if (Select_config.Sound_NoInventorySpace_Enable && Select_config.Sound_Enable) {
                    player.playSound(player.getLocation(), Select_config.Sound_NoInventorySpace, 3, 1);
                }
            }
        }
    }

    public static void itemOff(Player player) {
        Select_Database.setItemStatusFalse(player);
        for (int iam = 0; iam < player.getInventory().getSize() - 5; iam++) {
            ItemStack itm = player.getInventory().getItem(iam);
            if (itm != null) {
                if (itm.getType() == Material.valueOf(Select_config.UseItem_Material) || itm.getType() == Main.Head) {
                    if (itm.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                        player.getInventory().remove(itm);
                        player.updateInventory();
                        send.player(player, Select_msg.ItemOFF);
                    }
                }
            }
        }
    }

    public static void onSetSlot(Player player, Integer setSlot) {
        if (Select_config.UseItem_AllowSetSlot) {
            if (setSlot < 1) {
                send.player(player, Select_msg.ItemSlot_wrongValue);
                return;
            }
            if (setSlot > 9) {
                send.player(player, Select_msg.ItemSlot_wrongValue);
                return;
            }
            ItemStack itm1 = player.getInventory().getItem(setSlot - 1);
            if (itm1 != null) {
                if (itm1.getType() == Material.valueOf(Select_config.UseItem_Material) || itm1.getType() == Main.Head) {
                    if (itm1.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                        player.sendMessage(Select_msg.ItemSlotAlreadySet.replace("[slot]", setSlot.toString()));
                        return;
                    }
                }
            }
            if (Select_config.UseItem_InventorySlotEnforce || player.getInventory().getItem(setSlot - 1) != null) {
                send.player(player, Select_msg.ItemSlotNotEmpty.replace("[slot]", setSlot.toString()));
                return;
            }
            for (int iam = 0; iam < player.getInventory().getSize() - 5; iam++) {
                ItemStack itm = player.getInventory().getItem(iam);
                if (itm != null) {
                    if (itm.getType() == Material.valueOf(Select_config.UseItem_Material) || itm.getType() == Main.Head) {
                        if (itm.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                            player.getInventory().remove(itm);
                            player.updateInventory();
                            break;
                        }
                    }
                }
            }
            Select_Database.setSlot(player, setSlot);
            if (Select_Database.selectItemStatus(player)) {
                GUI_Give_UseItem.onGive(player);
            }
            send.player(player, Select_msg.ItemSlot.replace("[slot]", setSlot.toString()));
        } else player.sendMessage(Main.Prefix + " §4Function disabled");
    }

    public static void gui(Player player) {
        if (Main.guiHashMap.containsKey(Select_config.DefaultGUI)) {
            GUI_Objekt gui = Main.guiHashMap.get(Select_config.DefaultGUI);
            if (gui.GUI_Enable || player.hasPermission("commandgui.bypass")) {
                if (!gui.Command_Permission_Enable || player.hasPermission("commandgui.command") || player.hasPermission("commandgui.bypass")) {
                    GUI_GUI.openGUI(player, gui);
                    if (Select_config.Sound_Enable && Select_config.Sound_OpenInventory_Enable) {
                        player.playSound(player.getLocation(), Select_config.Sound_OpenInventory, 3, 1);
                    }
                } else player.sendMessage(Select_msg.NoPermissionForCommand.replace("[cmd]", "/commandgui")
                        .replace("[perm]", "commandgui.giveitem.command"));
            } else player.sendMessage(Select_msg.GUIIsDisabled.replace("[gui]", gui.GUI_Name));
        }
    }
    public static void gui(Player player, String arg){
        if (Main.guiHashMap.containsKey(arg)) {
            GUI_Objekt gui = Main.guiHashMap.get(arg);
            if (gui.GUI_Enable || player.hasPermission("commandgui.bypass")) {
                if (!gui.Command_Permission_Enable || player.hasPermission("commandgui.command." + gui.Command_Command) || player.hasPermission("commandgui.bypass")) {
                    GUI_GUI.openGUI(player, gui);
                    if (Select_config.Sound_Enable && Select_config.Sound_OpenInventory_Enable) {
                        player.playSound(player.getLocation(), Select_config.Sound_OpenInventory, 3, 1);
                    }
                } else player.sendMessage(Select_msg.NoPermissionForCommand.replace("[cmd]", "/commandgui " + gui.Command_Command)
                        .replace("[perm]", "commandgui.command." + arg.toLowerCase()));
            } else player.sendMessage(Select_msg.GUIIsDisabled.replace("[gui]", gui.Command_Command));
        } else player.sendMessage(Select_msg.GUInotFound);
    }
}
