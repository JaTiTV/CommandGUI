package de.jatitv.commandguiv2.Spigot.cmdManagement;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.Objekte.Obj_Select;
import de.jatitv.commandguiv2.Spigot.Objekte.Objekt;
import de.jatitv.commandguiv2.Spigot.cmdManagement.register.AliasRegister;
import de.jatitv.commandguiv2.Spigot.gui.OpenGUI;
import de.jatitv.commandguiv2.Spigot.system.Give_UseItem;
import de.jatitv.commandguiv2.Spigot.system.TextBuilder;
import de.jatitv.commandguiv2.Spigot.system.config.config.ConfigCreate;
import de.jatitv.commandguiv2.Spigot.system.config.languages.LanguagesCreate;
import de.jatitv.commandguiv2.Spigot.system.config.config.SelectConfig;
import de.jatitv.commandguiv2.Spigot.system.config.languages.SelectMessages;
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
        if (sender instanceof Player) {
            Player player = (Player) sender;
            send.player(player, Main.Prefix + "§4======= §8[§4Command§9GUI§8] §4=======");
            send.player(player, Prefix + " §2Autor: §6" + String.valueOf(Autor).replace("[", "").replace("]", ""));


            if (Main.update_version.equalsIgnoreCase(Version)) {
                send.player(player, Prefix + " §2Version: §6" + Version);
            } else {
                player.sendMessage(Prefix + " §6A new version was found!");
                TextComponent comp = new TextBuilder(Prefix + " §6Your version: §c" + Version + " §7- §6Current version: §a" + Main.update_version)
                        .addHover("§6You can download it here: §e" + Main.Spigot).addClickEvent(ClickEvent.Action.OPEN_URL, Main.Spigot).build();
                player.spigot().sendMessage(comp);
                TextComponent comp2 = new TextBuilder(Prefix + " §6You can find more information on Discord.")
                        .addHover("§e" + Main.Discord).addClickEvent(ClickEvent.Action.OPEN_URL, Main.Discord).build();
                player.spigot().sendMessage(comp2);
            }


            send.player(player, Prefix + " §2Spigot: §6" + Spigot);
            send.player(player, Prefix + " §2Discord: §6" + Discord);
            send.player(player, Prefix + "§4======= §8[§4Command§9GUI§8] §4=======");
        } else {
            send.sender(sender, Main.Prefix + "§4======= §8[§4Command§9GUI§8] §4=======");
            send.sender(sender, Prefix + " §2Autor: §6" + String.valueOf(Autor).replace("[", "").replace("]", ""));

            if (Main.update_version.equalsIgnoreCase(Version)) {
                send.sender(sender, Prefix + " §2Version: §6" + Version);
            } else {
                send.console("§6A new version was found!");
                send.console("§6Your version: §c" + Version + " §7- §6Current version: §a" + Main.update_version);
                send.console("§6You can download it here: §e" + Main.Spigot);
                send.console("§6You can find more information on Discord: §e" + Main.Discord);
            }

            send.sender(sender, Prefix + " §2Spigot: §6" + Spigot);
            send.sender(sender, Prefix + " §2Discord: §6" + Discord);
            send.sender(sender, Prefix + "§4======= §8[§4Command§9GUI§8] §4=======");
        }
    }

    public static void reload(CommandSender sender) {
        if (sender instanceof Player) sender.sendMessage(SelectMessages.ReloadStart);
        send.console(Prefix + "§8-------------------------------");
        send.console(Prefix + " §6Plugin reload...");
        send.console(Prefix + "§8-------------------------------");

        ConfigCreate.configCreate();
        SelectConfig.onSelect();

        LanguagesCreate.langCreate();

        Obj_Select.onSelect();
        SelectMessages.onSelect(Prefix);
        SelectConfig.sound(Main.Prefix);
        try {
            AliasRegister.onRegister();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (SelectConfig.Bungee){
            Bukkit.getMessenger().registerOutgoingPluginChannel(Main.plugin, "commandgui:bungee");

        }

        if (sender instanceof Player) sender.sendMessage(SelectMessages.ReloadEnd);
        send.console(Prefix + "§8-------------------------------");
        send.console(Prefix + " §2Plugin successfully reloaded.");
        send.console(Prefix + "§8-------------------------------");
    }

    public static void give(CommandSender sender, Player target) {
        if (Bukkit.getPlayer(target.getName()) != null) {
            Give_UseItem.onGive(target);
            send.sender(sender, SelectMessages.Give_Sender.replace("[player]", target.getName()).replace("[item]", SelectConfig.UseItem_Name));
            send.player(target, SelectMessages.Give_Receiver.replace("[sender]", sender.getName()).replace("[item]", SelectConfig.UseItem_Name));
            if (SelectConfig.Sound_Give_Enable && SelectConfig.Sound_Enable) {
                target.playSound(target.getLocation(), SelectConfig.Sound_Give, 3, 1);
            }
        } else {
            sender.sendMessage(SelectMessages.PlayerNotFond.replace("[player]", target.getName()));
            if (SelectConfig.Sound_PlayerNotFound_Enable && SelectConfig.Sound_Enable) {
                if (sender instanceof Player)
                    ((Player) sender).playSound(((Player) sender).getLocation(), SelectConfig.Sound_PlayerNotFound, 3, 1);
            }
        }
    }

    public static void itemOn(Player player) {
        for (int iam = 0; iam < player.getInventory().getSize() - 5; iam++) {
            ItemStack itm = player.getInventory().getItem(iam);
            if (itm != null) {
                if (itm.getType() == Material.valueOf(SelectConfig.UseItem_Material) || itm.getType() == Main.Head) {
                    if (itm.getItemMeta().getDisplayName().equals(SelectConfig.UseItem_Name)) {
                        player.getInventory().remove(itm);
                        player.updateInventory();
                        break;
                    }
                }
            }
        }
        Integer slot = null;
        if (Select_Database.selectSlot(player) == null) {
            slot = SelectConfig.UseItem_InventorySlot;
        } else {
            slot = Select_Database.selectSlot(player);
        }
        send.debug(plugin,String.valueOf(slot));
        if (player.getInventory().getItem(slot - 1) == null) {
            Select_Database.setItemStatusTrue(player);
            Give_UseItem.onGive(player);
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
                Give_UseItem.onGiveADD(player);
                send.player(player, SelectMessages.ItemON);
            } else {
                player.sendMessage(SelectMessages.NoInventorySpace);
                if (SelectConfig.Sound_NoInventorySpace_Enable && SelectConfig.Sound_Enable) {
                    player.playSound(player.getLocation(), SelectConfig.Sound_NoInventorySpace, 3, 1);
                }
            }
        }
    }

    public static void itemOff(Player player) {
        Select_Database.setItemStatusFalse(player);
        for (int iam = 0; iam < player.getInventory().getSize() - 5; iam++) {
            ItemStack itm = player.getInventory().getItem(iam);
            if (itm != null) {
                if (itm.getType() == Material.valueOf(SelectConfig.UseItem_Material) || itm.getType() == Main.Head) {
                    if (itm.getItemMeta().getDisplayName().equals(SelectConfig.UseItem_Name)) {
                        player.getInventory().remove(itm);
                        player.updateInventory();
                        send.player(player, SelectMessages.ItemOFF);
                    }
                }
            }
        }
    }

    public static void onSetSlot(Player player, Integer setSlot) {
        if (SelectConfig.UseItem_AllowSetSlot) {
            if (setSlot < 1) {
                send.player(player, SelectMessages.ItemSlot_wrongValue);
                return;
            }
            if (setSlot > 9) {
                send.player(player, SelectMessages.ItemSlot_wrongValue);
                return;
            }
            ItemStack itm1 = player.getInventory().getItem(setSlot - 1);
            if (itm1 != null) {
                if (itm1.getType() == Material.valueOf(SelectConfig.UseItem_Material) || itm1.getType() == Main.Head) {
                    if (itm1.getItemMeta().getDisplayName().equals(SelectConfig.UseItem_Name)) {
                        player.sendMessage(SelectMessages.ItemSlotAlreadySet.replace("[slot]", setSlot.toString()));
                        return;
                    }
                }
            }
            if (SelectConfig.UseItem_InventorySlotEnforce || player.getInventory().getItem(setSlot - 1) != null) {
                send.player(player, SelectMessages.ItemSlotNotEmpty.replace("[slot]", setSlot.toString()));
                return;
            }
            for (int iam = 0; iam < player.getInventory().getSize() - 5; iam++) {
                ItemStack itm = player.getInventory().getItem(iam);
                if (itm != null) {
                    if (itm.getType() == Material.valueOf(SelectConfig.UseItem_Material) || itm.getType() == Main.Head) {
                        if (itm.getItemMeta().getDisplayName().equals(SelectConfig.UseItem_Name)) {
                            player.getInventory().remove(itm);
                            player.updateInventory();
                            break;
                        }
                    }
                }
            }
            Select_Database.setSlot(player, setSlot);
            if (Select_Database.selectItemStatus(player)) {
                Give_UseItem.onGive(player);
            }
            send.player(player, SelectMessages.ItemSlot.replace("[slot]", setSlot.toString()));
        } else player.sendMessage(Main.Prefix + " §4Function disabled");
    }

    public static void gui(Player player) {
        if (Main.guiHashMap.containsKey(SelectConfig.DefaultGUI)) {
            Objekt gui = Main.guiHashMap.get(SelectConfig.DefaultGUI);
            if (gui.GUI_Enable || player.hasPermission("commandgui.bypass")) {
                if (!gui.Command_Permission_Enable || player.hasPermission("commandgui.command") || player.hasPermission("commandgui.bypass")) {
                    OpenGUI.openGUI(player, gui, SelectConfig.DefaultGUI);
                    if (SelectConfig.Sound_Enable && SelectConfig.Sound_OpenInventory_Enable) {
                        player.playSound(player.getLocation(), SelectConfig.Sound_OpenInventory, 3, 1);
                    }
                } else player.sendMessage(SelectMessages.NoPermissionForCommand.replace("[cmd]", "/commandgui")
                        .replace("[perm]", "commandgui.giveitem.command"));
            } else player.sendMessage(SelectMessages.GUIIsDisabled.replace("[gui]", gui.GUI_Name));
        }
    }
    public static void gui(Player player, String arg){
        if (Main.guiHashMap.containsKey(arg)) {
            Objekt gui = Main.guiHashMap.get(arg);
            if (gui.GUI_Enable || player.hasPermission("commandgui.bypass")) {
                if (!gui.Command_Permission_Enable || player.hasPermission("commandgui.command." + gui.Command_Command) || player.hasPermission("commandgui.bypass")) {
                    OpenGUI.openGUI(player, gui, arg);
                    if (SelectConfig.Sound_Enable && SelectConfig.Sound_OpenInventory_Enable) {
                        player.playSound(player.getLocation(), SelectConfig.Sound_OpenInventory, 3, 1);
                    }
                } else player.sendMessage(SelectMessages.NoPermissionForCommand.replace("[cmd]", "/commandgui " + gui.Command_Command)
                        .replace("[perm]", "commandgui.command." + arg.toLowerCase()));
            } else player.sendMessage(SelectMessages.GUIIsDisabled.replace("[gui]", gui.Command_Command));
        } else player.sendMessage(SelectMessages.GUInotFound);
    }
}
