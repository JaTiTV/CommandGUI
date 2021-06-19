package de.jatitv.commandguiv2.cmdManagement;

import de.jatitv.commandguiv2.Objekte.GUI_Obj_Select;
import de.jatitv.commandguiv2.system.config.DefaultGUICreate;
import de.jatitv.commandguiv2.system.config.select.Select_config;
import de.jatitv.commandguiv2.system.config.select.Select_msg;
import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.send;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GUI_CmdExecuter_Admin implements CommandExecutor, TabCompleter {
    String Prefix;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Prefix = Main.Prefix;
        if (sender.hasPermission("commandgui.admin") || sender.isOp()) {
            if (args.length == 0) {
                Help.sendHelp(sender, Prefix);
            } else {
                switch (args[0].toLowerCase()) {
                    case "reload":
                    case "rl":
                        if (sender instanceof Player) sender.sendMessage(Prefix + Select_msg.ReloadStart);
                        send.Console(Prefix + "§8-------------------------------");
                        send.Console(Prefix + "§6Plugin reload...");
                        send.Console(Prefix + "§8-------------------------------");

                        Select_config.onSelect();
                        GUI_Obj_Select.onSelect();
                        Select_msg.onSelect(Prefix);
                        sender.sendMessage("§6To enable / disable alias commands, reload / restart the server!");

                        if (sender instanceof Player) sender.sendMessage(Prefix + Select_msg.ReloadEnd);
                        send.Console(Prefix + "§8-------------------------------");
                        send.Console(Prefix + "§2Plugin successfully reloaded.");
                        send.Console(Prefix + "§8-------------------------------");
                        break;
                    case "createdefaultgui":
                        DefaultGUICreate.configCreate();
                        sender.sendMessage(Prefix + "§2DefaultGUI was created. You can find it in the directory: §eplugins/CommandGUI/GUIs/default.yml");
                        break;
                    case "help":
                    default:
                        Help.sendHelp(sender, Prefix);
                        break;
                   /* case "give":
                        if (args.length == 3) {
                            if (sender.hasPermission("commandgui.giveitem.other")) {
                                if (Bukkit.getPlayer(args[1]) != null) {
                                    Give.giveCommand(sender, args[1], args[2]);
                                } else {
                                    sender.sendMessage(DefaultValue.PlayerNotFound.replace("[player]", args[1]));
                                    if (DefaultValue.Sound_PlayerNotFound_Enable && DefaultValue.Sound_Enable) {
                                        ((Player) sender).playSound(((Player) sender).getLocation(), DefaultValue.Sound_PlayerNotFound, 3, 1);
                                    }
                                }
                            } else player.sendMessage(DefaultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui give")
                                    .replace("[perm]", "commandgui.command.give"));
                        } else Help.Help(sender);
                        break;

                    */
                }
            }
        } else sender.sendMessage(Select_msg.NoPermissionForCommand.replace("[cmd]", "/commandguiadmin").replace("[perm]", "commandgui.admin"));
        return false;
    }


    //TabCompleter
    private static HashMap<String, String> arg1 = new HashMap<String, String>() {{
        put("reload", "commandgui.admin");
        put("rl", "commandgui.admin");
        put("createdefaultgui", "commandgui.admin");
        //  put("give", "commandgui.giveitem.other");
    }};

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
            /*if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
                if (sender.hasPermission("commandgui.giveitem.other")) {
                    Iterator var6 = Bukkit.getOnlinePlayers().iterator();

                    while (var6.hasNext()) {
                        Player player1 = (Player) var6.next();
                        list.add(player1.getName());
                    }
                }
                return list;
            }

             */
        }
        return list;
    }

    public static boolean hasPermission(Player player, String permission) {
        if (player.isOp()) {
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

