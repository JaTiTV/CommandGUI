package de.jatitv.commandguiv2.cmdManagement;

import de.jatitv.commandguiv2.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.gui.GUI_GUI;
import de.jatitv.commandguiv2.select.Select_config;
import de.jatitv.commandguiv2.select.Select_msg;
import de.jatitv.commandguiv2.select.Select_sound;
import de.jatitv.commandguiv2.system.Main;
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
                sender.sendMessage("1");
                sender.sendMessage(Select_config.DefaultGUI);
                sender.sendMessage(Main.guiHashMap.toString());
                if (Main.guiHashMap.containsKey(Select_config.DefaultGUI)) {
                    //ToDO Perm Abfrage & ob enable
                    sender.sendMessage("2");
                    GUI_Objekt gui = Main.guiHashMap.get(Select_config.DefaultGUI);
                    if (!gui.Command_Permission_Enable || player.hasPermission("commandgui.command")) {
                        sender.sendMessage("3");
                        GUI_GUI.openGUI(player, gui);
                        if (Select_sound.Sound_Enable && Select_sound.Sound_OpenInventory_Enable) {
                            player.playSound(player.getLocation(),Select_sound.Sound_OpenInventory, 3, 1);
                        }
                    } else player.sendMessage(Select_msg.NoPermissionForCommand.replace("[cmd]", "/commandgui")
                            .replace("[perm]", "commandgui.giveitem.command"));
                }
            } else {
                if (Main.guiHashMap.containsKey(args[0])) {
                    GUI_Objekt gui = Main.guiHashMap.get(args[0]);
                    if (!gui.Command_Permission_Enable || player.hasPermission("commandgui.command." + gui) || player.hasPermission("commandgui.admin")) {
                        GUI_GUI.openGUI(player, gui);
                        if (Select_sound.Sound_Enable && Select_sound.Sound_OpenInventory_Enable) {
                            player.playSound(player.getLocation(), Select_sound.Sound_OpenInventory, 3, 1);
                        }
                    } else player.sendMessage(Select_msg.NoPermissionForCommand.replace("[cmd]", "/commandgui " + args[0])
                            .replace("[perm]", "commandgui.command." + gui));
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

