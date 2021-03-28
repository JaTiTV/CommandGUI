// This claas was created by JaTiTV


package de.jatitv.commandgui.commands.cmdManagement;

import de.jatitv.commandgui.commands.*;
import de.jatitv.commandgui.config.Messages_Select;
import de.jatitv.commandgui.defultValue.DefaultValue;
import de.jatitv.commandgui.defultValue.DefaultValue_GUI_1;
import de.jatitv.commandgui.defultValue.DefaultValue_GUI_2;
import de.jatitv.commandgui.defultValue.DefaultValue_GUI_3;
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


                if (DefaultValue.DefaultGUI == 1) {
                    if (!DefaultValue_GUI_1.Command_Permission_Enable || player.hasPermission("commandgui.command") || player.hasPermission("commandgui.admin") || player.isOp()) {
                        if (DefaultValue_GUI_1.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                            GUI_1.openCGUI(player);
                        } else player.sendMessage(DefaultValue.GUIisDisable.replace("[gui]", DefaultValue_GUI_1.GUIName));
                    } else player.sendMessage(DefaultValue.NoPermission.replace("[cmd]", "/commandgui").replace("[perm]", "commandgui.command"));
                } else if (DefaultValue.DefaultGUI == 2) {
                    if (!DefaultValue_GUI_2.Command_Permission_Enable || player.hasPermission("commandgui.command") || player.hasPermission("commandgui.admin") || player.isOp()) {
                        if (DefaultValue_GUI_2.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                            GUI_2.openCGUI(player);
                        } else player.sendMessage(DefaultValue.GUIisDisable.replace("[gui]", DefaultValue_GUI_2.GUIName));
                    } else player.sendMessage(DefaultValue.NoPermission.replace("[cmd]", "/commandgui").replace("[perm]", "commandgui.command"));
                } else if (DefaultValue.DefaultGUI == 3) {
                    if (!DefaultValue_GUI_3.Command_Permission_Enable || player.hasPermission("commandgui.command") || player.hasPermission("commandgui.admin") || player.isOp()) {
                        if (DefaultValue_GUI_3.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                            GUI_3.openCGUI(player);
                        } else player.sendMessage(DefaultValue.GUIisDisable.replace("[gui]", DefaultValue_GUI_3.GUIName));
                    } else player.sendMessage(DefaultValue.NoPermission.replace("[cmd]", "/commandgui").replace("[perm]", "commandgui.command"));
                }


            } else {
                switch (args[0].toLowerCase()) {
                    case "lang":
                        sender.sendMessage(DefaultValue.language);
                        sender.sendMessage(Messages_Select.sel);
                        break;
                    case "test":
                        sender.sendMessage(DefaultValue_GUI_1.FillItem);
                        break;
                    case "info":
                    case "plugin":
                    case "pl":
                    case "version":
                    case "ver":
                        if (player.hasPermission("commandgui.command.info") || player.hasPermission("commandgui.admin") || player.isOp()) {
                            sender.sendMessage(DefaultValue.PrefixHC + "§8-------- §4Plugin-Info §8--------");
                            sender.sendMessage(DefaultValue.PrefixHC + "§2This plugin was developed by §9JaTiTV");
                            sender.sendMessage(DefaultValue.PrefixHC + "§2");
                            sender.sendMessage(DefaultValue.PrefixHC + "§2Twitch: §ehttps://www.twitch.tv/jatitv");
                            sender.sendMessage(DefaultValue.PrefixHC + "§2Support-Discord: §e" + Main.DiscordLink);
                            sender.sendMessage(DefaultValue.PrefixHC + "§2Spigot: §e" + Main.Spigot);
                            sender.sendMessage(DefaultValue.PrefixHC + "§2");
                            sender.sendMessage(DefaultValue.PrefixHC + "§2Version: §6" + Main.getPlugin().getDescription().getVersion());
                            sender.sendMessage(DefaultValue.PrefixHC + "§8-----------------------------");

                            if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
                                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4\n" + DefaultValue.PrefixHC + "§4Vault could not be connected / found! " +
                                        "§9Please download it here: §6https://www.spigotmc.org/resources/vault.34315/§4\n" + DefaultValue.PrefixHC);
                                player.sendMessage(DefaultValue.PrefixHC + "§4\n" + DefaultValue.PrefixHC + "§4Vault could not be connected / found! " +
                                        "§9Please download it here: §6https://www.spigotmc.org/resources/vault.34315/§4\n" + DefaultValue.PrefixHC);
                            }

                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui info")
                                    .replace("[perm]", "commandgui.command.info"));
                        }
                        break;

                    case "open":
                        if (args.length == 2) {
                            if (args[1].equals(DefaultValue_GUI_1.Command)) {
                                if (!DefaultValue_GUI_1.Command_Permission_Enable || player.hasPermission("commandgui.command.gui1") || player.hasPermission("commandgui.admin")
                                        || player.isOp()) {
                                    if (DefaultValue_GUI_1.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                                        GUI_1.openCGUI(player);
                                    } else {
                                        player.sendMessage(DefaultValue.GUIisDisable.replace("[gui]", DefaultValue_GUI_1.GUIName));
                                    }
                                } else player.sendMessage(DefaultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui " + DefaultValue_GUI_1.Command)
                                        .replace("[perm]", "commandgui.command.gui1"));


                            } else if (args[1].equals(DefaultValue_GUI_2.Command)) {
                                if (!DefaultValue_GUI_2.Command_Permission_Enable || player.hasPermission("commandgui.command.gui2") || player.hasPermission("commandgui.admin")
                                        || player.isOp()) {
                                    if (DefaultValue_GUI_2.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                                        GUI_2.openCGUI(player);
                                    } else {
                                        player.sendMessage(DefaultValue.GUIisDisable.replace("[gui]", DefaultValue_GUI_2.GUIName));
                                    }
                                } else player.sendMessage(DefaultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui " + DefaultValue_GUI_2.Command)
                                        .replace("[perm]", "commandgui.command.gui2"));


                            } else if (args[1].equals(DefaultValue_GUI_3.Command)) {
                                if (!DefaultValue_GUI_3.Command_Permission_Enable || player.hasPermission("commandgui.command.gui3") || player.hasPermission("commandgui.admin")
                                        || player.isOp()) {
                                    if (DefaultValue_GUI_3.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                                        GUI_3.openCGUI(player);
                                    } else {
                                        player.sendMessage(DefaultValue.GUIisDisable.replace("[gui]", DefaultValue_GUI_3.GUIName));
                                    }
                                } else player.sendMessage(DefaultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui " + DefaultValue_GUI_3.Command)
                                        .replace("[perm]", "commandgui.command.gui3"));
                            } else Help.Help(sender);
                        } else Help.Help(sender);
                        break;

                    case "give":
                        if (args.length == 3) {
                            if (player.hasPermission("commandgui.command.give") || player.hasPermission("commandgui.admin") || player.isOp()) {
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

                    case "reload":
                    case "rl":
                        if (player.hasPermission("commandgui.command.reload") || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (sender instanceof Player) sender.sendMessage(DefaultValue.PrefixHC + DefaultValue.ReloadStart);
                            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
                            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§6Plugin reload...");
                            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");

                            Bukkit.getServer().getPluginManager().getPlugin(Main.plugin.getName()).onEnable();

                            if (sender instanceof Player) sender.sendMessage(DefaultValue.PrefixHC + DefaultValue.ReloadEnd);
                            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
                            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Plugin successfully reloaded.");
                            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui reload")
                                    .replace("[perm]", "commandgui.command.reload"));
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
                        sender.sendMessage(DefaultValue.PrefixHC + "§8-------- §4Plugin-Info §8--------");
                        sender.sendMessage(DefaultValue.PrefixHC + "§2This plugin was developed by §9JaTiTV");
                        sender.sendMessage(DefaultValue.PrefixHC + "§2");
                        sender.sendMessage(DefaultValue.PrefixHC + "§2Twitch: §ehttps://www.twitch.tv/jatitv");
                        sender.sendMessage(DefaultValue.PrefixHC + "§2Support-Discord: §e" + Main.DiscordLink);
                        sender.sendMessage(DefaultValue.PrefixHC + "§2Spigot: §e" + Main.Spigot);
                        sender.sendMessage(DefaultValue.PrefixHC + "§2");
                        sender.sendMessage(DefaultValue.PrefixHC + "§2Version: §6" + Main.getPlugin().getDescription().getVersion());
                        sender.sendMessage(DefaultValue.PrefixHC + "§8-----------------------------");

                        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
                            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4\n" + DefaultValue.PrefixHC + "§4Vault could not be connected / found! " +
                                    "§9Please download it here: §6https://www.spigotmc.org/resources/vault.34315/§4\n" + DefaultValue.PrefixHC);
                        }
                        break;
                    default:
                        Help.Help(sender);
                        break;
                    case "rl":
                    case "reload":
                        if (sender instanceof Player) sender.sendMessage(DefaultValue.PrefixHC + DefaultValue.ReloadStart);
                        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
                        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§6Plugin reload...");
                        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");

                        Bukkit.getServer().getPluginManager().disablePlugin(Main.getPlugin());

                        Bukkit.getPluginManager().getPlugin(Main.plugin.getName()).getPluginLoader().enablePlugin(Main.getPlugin());
                        if (sender instanceof Player) sender.sendMessage(DefaultValue.PrefixHC + DefaultValue.ReloadEnd);
                        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
                        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Plugin successfully reloaded.");
                        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
                        break;

                    case "give":
                        if (args.length == 3) {
                            if (Bukkit.getPlayer(args[1]) != null) {
                                Give.giveCommand(sender, args[1], args[2]);
                            } else {
                                sender.sendMessage(DefaultValue.PlayerNotFound.replace("[player]", args[1]));
                                if (sender instanceof Player) {
                                    if (DefaultValue.Sound_PlayerNotFound_Enable && DefaultValue.Sound_Enable) {
                                        ((Player) sender).playSound(((Player) sender).getLocation(), DefaultValue.Sound_PlayerNotFound, 3, 1);
                                    }
                                }
                            }
                        } else Help.Help(sender);
                        break;
                }
            } else {
                sender.sendMessage("§8[§6Command§9GUI§8] §cThis command is only for players!");
            }
        }
        return false;
    }
}
