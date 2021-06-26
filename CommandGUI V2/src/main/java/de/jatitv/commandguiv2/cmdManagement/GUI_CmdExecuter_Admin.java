package de.jatitv.commandguiv2.cmdManagement;

import de.jatitv.commandguiv2.system.Debug;
import de.jatitv.commandguiv2.system.config.DefaultGUICreate;
import de.jatitv.commandguiv2.system.config.select.Select_msg;
import de.jatitv.commandguiv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GUI_CmdExecuter_Admin implements CommandExecutor, TabCompleter {
    String Prefix;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Prefix = Main.Prefix;

        if (args.length == 0) {
            Help.sendHelp(sender, Prefix);
        } else {
            switch (args[0].toLowerCase()) {
                case "info":
                    if (sender.hasPermission("commandgui.command.info")) {
                        Commands.info(sender);
                    } else sender.sendMessage(Select_msg.NoPermissionForCommand
                            .replace("[cmd]", "/commandguiadmin").replace("[perm]", "commandgui.command.info"));

                    break;
                case "reload":
                case "rl":
                    if (sender.hasPermission("commandgui.admin")) {
                        Commands.reload(sender);
                    } else sender.sendMessage(Select_msg.NoPermissionForCommand
                            .replace("[cmd]", "/commandguiadmin").replace("[perm]", "commandgui.admin"));
                    break;
                case "createdefaultgui":
                    if (sender.hasPermission("commandgui.admin")) {
                        DefaultGUICreate.configCreate();
                        sender.sendMessage(Select_msg.DefaultGUIcreate.replace("[directory]", Main.getPath() + "\\GUIs\\default.yml"));
                    } else sender.sendMessage(Select_msg.NoPermissionForCommand
                            .replace("[cmd]", "/commandguiadmin").replace("[perm]", "commandgui.admin"));
                    break;
                case "debug":
                    if (sender.hasPermission("commandgui.admin")) {
                        Debug.onDebugFile(sender);
                        /*if (args.length == 2) {
                            if (args[1].equals("config")) {
                                Debug.debugmsg();
                            }
                            if (args[1].equals("2")) {
                                send.debug("2");
                            }
                            break;

                        } else Debug.debugmsg();

                         */
                    } else sender.sendMessage(Select_msg.NoPermissionForCommand.replace("[cmd]", "/commandguiadmin").replace("[perm]", "commandgui.admin"));
                    break;

                case "give":
                    if (args.length == 2) {
                        if (sender.hasPermission("commandgui.giveitem.other")) {
                            Player target = Bukkit.getPlayer(args[1]);
                            Commands.give(sender, target);
                        } else sender.sendMessage(Select_msg.NoPermissionForCommand.replace("[cmd]", "/commandgui give")
                                .replace("[perm]", "commandgui.command.give"));
                    } else Help.sendHelp(sender, Prefix);
                    break;
                case "help":
                default:
                    Help.sendHelp(sender, Prefix);
                    break;

            }
        }

        return false;
    }


    //TabCompleter
    private static HashMap<String, String> arg1 = new HashMap<String, String>() {{
        put("reload", "commandgui.admin");
        put("rl", "commandgui.admin");
        put("createdefaultgui", "commandgui.admin");
        put("give", "commandgui.giveitem.other");
        put("info", "commandgui.command.info");
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

            if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
                if (sender.hasPermission("commandgui.giveitem.other")) {
                    Iterator var6 = Bukkit.getOnlinePlayers().iterator();

                    while (var6.hasNext()) {
                        Player player1 = (Player) var6.next();
                        list.add(player1.getName());
                    }
                }
                return list;
            }
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

