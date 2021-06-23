package de.jatitv.commandguiv2.cmdManagement;

import de.jatitv.commandguiv2.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.gui.GUI_GUI;
import de.jatitv.commandguiv2.system.config.select.Select_config;
import de.jatitv.commandguiv2.system.config.select.Select_msg;
import de.jatitv.commandguiv2.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GUI_CmdExecuter_GUI implements CommandExecutor, TabCompleter {
    String Prefix;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Prefix = Main.Prefix;
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
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
            } else {
                if (Main.guiHashMap.containsKey(args[0])) {
                    GUI_Objekt gui = Main.guiHashMap.get(args[0]);
                    if (gui.GUI_Enable || player.hasPermission("commandgui.bypass")) {
                        if (!gui.Command_Permission_Enable || player.hasPermission("commandgui.command." + gui.Command_Command) || player.hasPermission("commandgui.bypass")) {
                            GUI_GUI.openGUI(player, gui);
                            if (Select_config.Sound_Enable && Select_config.Sound_OpenInventory_Enable) {
                                player.playSound(player.getLocation(), Select_config.Sound_OpenInventory, 3, 1);
                            }
                        } else player.sendMessage(Select_msg.NoPermissionForCommand.replace("[cmd]", "/commandgui " + gui.Command_Command)
                                .replace("[perm]", "commandgui.command." + args[0].toLowerCase()));
                    } else player.sendMessage(Select_msg.GUIIsDisabled.replace("[gui]", gui.Command_Command));
                } else sender.sendMessage(Select_msg.GUInotFound);
            }
        } else sender.sendMessage(Select_msg.OnlyForPlayer);
        return false;
    }

    //TabCompleter

    public static HashMap<String, String> arg1 = new HashMap<String, String>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                for (String command : arg1.keySet()) {
                    Boolean passend = true;
                    for (int i = 0; i < args[0].length(); i++) {
                        if (args[0].length() >= command.length()) {
                            passend = false;
                        } else {
                            if (args[0].charAt(i) != command.charAt(i)) {
                                passend = false;
                            }
                        }
                    }
                    if (hasPermission(p, arg1.get(command)) && passend) {
                        list.add(command);
                    }
                }
            }
        }
        return list;
    }

    public static boolean hasPermission(Player player, String permission) {
        if (player.isOp()) {
            return true;
        }
        if (permission.equals("")) {
            return true;
        }
        String[] Permissions = permission.split(";");
        for (String perm : Permissions) {
            if (player.hasPermission(perm)) {
                return true;
            }
        }
        return false;
    }
}

