// This claas was created by JaTiTV


package de.jatitv.commandgui.commands.cmdManagement;

import de.jatitv.commandgui.commands.*;
import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_1;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_2;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_3;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CmdExecuter implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("commandgui.command") || player.hasPermission("commandgui.admin") || player.isOp()) {

                    if (DefultValue.DefaultGUI == 1) {
                        GUI_1.openCGUI(player);
                    } else if (DefultValue.DefaultGUI == 2) {
                        GUI_2.openCGUI(player);
                    } else if (DefultValue.DefaultGUI == 3) {
                        GUI_3.openCGUI(player);
                    }

                } else {
                    player.sendMessage(DefultValue.NoPermission.replace("[cmd]", "/commandgui").replace("[perm]", "commandgui.command"));
                }
            } else {
                switch (args[0].toLowerCase()) {
                    case "info":
                    case "plugin":
                    case "pl":
                    case "version":
                    case "ver":
                        if (player.hasPermission("commandgui.command.info") || player.hasPermission("commandgui.admin") || player.isOp()) {
                            sender.sendMessage(DefultValue.PrefixHC + "§8-------- §4Plugin-Info §8--------");
                            sender.sendMessage(DefultValue.PrefixHC + "§2This plugin was developed by §9JaTiTV");
                            sender.sendMessage(DefultValue.PrefixHC + "§2");
                            sender.sendMessage(DefultValue.PrefixHC + "§2Twitch: §ehttps://www.twitch.tv/jatitv");
                            sender.sendMessage(DefultValue.PrefixHC + "§2Support-Discord: §e" + Main.DiscordLink);
                            sender.sendMessage(DefultValue.PrefixHC + "§2Spigot: §e" + Main.Spigot);
                            sender.sendMessage(DefultValue.PrefixHC + "§2");
                            sender.sendMessage(DefultValue.PrefixHC + "§2Version: §6" + Main.getPlugin().getDescription().getVersion());
                            sender.sendMessage(DefultValue.PrefixHC + "§8-----------------------------");

                            if (Bukkit.getPluginManager().getPlugin("NBTAPI") == null) {
                                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4\n" + DefultValue.PrefixHC + "§4NBTAPI could not be connected / found! " +
                                        "§9Please download it here: §6https://www.spigotmc.org/resources/nbt-api.7939/§4\n" + DefultValue.PrefixHC);
                                player.sendMessage(DefultValue.PrefixHC + "§4\n" + DefultValue.PrefixHC + "§4NBTAPI could not be connected / found! §9Please download it here: " +
                                        "§6https://www.spigotmc.org/resources/nbt-api.7939/§4\n" + DefultValue.PrefixHC);
                            }
                            if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
                                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4\n" + DefultValue.PrefixHC + "§4Vault could not be connected / found! " +
                                        "§9Please download it here: §6https://www.spigotmc.org/resources/vault.34315/§4\n" + DefultValue.PrefixHC);
                                player.sendMessage(DefultValue.PrefixHC + "§4\n" + DefultValue.PrefixHC + "§4NBTAPI could not be connected / found! §9Please download it here: " +
                                        "§6https://www.spigotmc.org/resources/nbt-api.7939/§4\n" + DefultValue.PrefixHC);
                            }

                        } else {
                            player.sendMessage(DefultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui info")
                                    .replace("[perm]", "commandgui.command.info"));
                        }
                        break;

                    case "reload":
                    case "rl":
                        if (player.hasPermission("commandgui.command.reload") || player.hasPermission("commandgui.admin") || player.isOp()) {
                            try {
                                Reload.reload(sender);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui reload")
                                    .replace("[perm]", "commandgui.command.reload"));
                        }
                        break;

                    case "open":
                        if (args.length == 2) {
                            if (args[1].equals(DefultValue_GUI_1.Command)) {
                                if (!DefultValue_GUI_1.Command_Permission_Enable || player.hasPermission("commandgui.command.gui1") || player.hasPermission("commandgui.admin") || player.isOp()) {
                                    if (DefultValue_GUI_1.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                                        GUI_1.openCGUI(player);
                                    } else {
                                        player.sendMessage(DefultValue.GUIisDisable.replace("[gui]", DefultValue_GUI_1.GUIName));
                                    }
                                } else player.sendMessage(DefultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui " + DefultValue_GUI_1.Command)
                                        .replace("[perm]", "commandgui.command.gui1"));
                            } else if (args[1].equals(DefultValue_GUI_2.Command)) {
                                if (!DefultValue_GUI_2.Command_Permission_Enable || player.hasPermission("commandgui.command.gui2") || player.hasPermission("commandgui.admin") || player.isOp()) {
                                    if (DefultValue_GUI_2.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                                        GUI_2.openCGUI(player);
                                    } else {
                                        player.sendMessage(DefultValue.GUIisDisable.replace("[gui]", DefultValue_GUI_2.GUIName));
                                    }
                                } else player.sendMessage(DefultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui " + DefultValue_GUI_2.Command)
                                        .replace("[perm]", "commandgui.command.gui2"));
                            } else if (args[1].equals(DefultValue_GUI_3.Command)) {
                                if (!DefultValue_GUI_3.Command_Permission_Enable || player.hasPermission("commandgui.command.gui3") || player.hasPermission("commandgui.admin") || player.isOp()) {
                                    if (DefultValue_GUI_3.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                                        GUI_3.openCGUI(player);
                                    } else {
                                        player.sendMessage(DefultValue.GUIisDisable.replace("[gui]", DefultValue_GUI_3.GUIName));
                                    }
                                } else player.sendMessage(DefultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui " + DefultValue_GUI_3.Command)
                                        .replace("[perm]", "commandgui.command.gui3"));
                            } else {
                                Help.Help(sender);
                            }
                        } else {
                            Help.Help(sender);
                        }
                        break;

                    case "give":
                        if (args.length == 3) {
                            if (Bukkit.getPlayer(args[1]) != null) {
                                if (player.hasPermission("commandgui.command.give") || player.hasPermission("commandgui.admin") || player.isOp()) {
                                    Give.giveCommand(sender, args[1], args[2]);
                                }
                            } else {
                                sender.sendMessage(DefultValue.PlayerNotFound.replace("[player]", args[1]));
                                if (DefultValue.Sound_PlayerNotFound_Enable && DefultValue.Sound_Enable){
                                    ((Player) sender).playSound(((Player) sender).getLocation(), DefultValue.Sound_PlayerNotFound, 3, 1);
                                }
                            }
                        } else {
                            Help.Help(sender);
                        }
                        break;

                    case "help":
                    default:
                        Help.Help(sender);
                        break;
                }
            }

        } else {
            if (args.length == 1 || args.length == 2 || args.length == 3) {
                switch (args[0].toLowerCase()) {
                    case "info":
                    case "plugin":
                    case "pl":
                    case "version":
                    case "ver":
                        sender.sendMessage(DefultValue.PrefixHC + "§8-------- §4Plugin-Info §8--------");
                        sender.sendMessage(DefultValue.PrefixHC + "§2This plugin was developed by §9JaTiTV");
                        sender.sendMessage(DefultValue.PrefixHC + "§2");
                        sender.sendMessage(DefultValue.PrefixHC + "§2Twitch: §ehttps://www.twitch.tv/jatitv");
                        sender.sendMessage(DefultValue.PrefixHC + "§2Support-Discord: §e" + Main.DiscordLink);
                        sender.sendMessage(DefultValue.PrefixHC + "§2Spigot: §e" + Main.Spigot);
                        sender.sendMessage(DefultValue.PrefixHC + "§2");
                        sender.sendMessage(DefultValue.PrefixHC + "§2Version: §6" + Main.getPlugin().getDescription().getVersion());
                        sender.sendMessage(DefultValue.PrefixHC + "§8-----------------------------");
                        break;
                    default:
                        Help.Help(sender);
                        break;
                    case "rl":
                    case "reload":
                        try {
                            Reload.reload(sender);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;

                    case "give":
                        if (args.length == 3) {
                            if (Bukkit.getPlayer(args[1]) != null) {
                                Give.giveCommand(sender, args[1], args[2]);
                            } else {
                                sender.sendMessage(DefultValue.PlayerNotFound.replace("[player]", args[1]));
                                if (sender instanceof Player){
                                    if (DefultValue.Sound_PlayerNotFound_Enable && DefultValue.Sound_Enable){
                                        ((Player) sender).playSound(((Player) sender).getLocation(), DefultValue.Sound_PlayerNotFound, 3, 1);
                                    }
                                }
                            }
                        } else {
                            Help.Help(sender);
                        }
                        break;
                }
            } else {
                sender.sendMessage("§8[§6Command§9GUI§8] §cThis command is only for players!");
            }
        }
        return false;
    }
}
