// This claas was created by JaTiTV


package de.jatitv.commandgui.commands.cmdManagement;

import de.jatitv.commandgui.commands.CGUI;
import de.jatitv.commandgui.DefultValue;
import de.jatitv.commandgui.Main;
import de.jatitv.commandgui.commands.Reload;
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
                        CGUI.openCGUI(player);
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
                            sender.sendMessage(DefultValue.PrefixHC + "§2Support-Discord: §ehttps://discord.gg/vRyXFFterJ");
                            sender.sendMessage(DefultValue.PrefixHC + "§2Spigot: §ehttps://www.spigotmc.org/resources/...");  // ToDo
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
                                Reload.reloadConfirmPlayer(player);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui reload")
                                    .replace("[perm]", "commandgui.command.reload"));
                        }
                        break;

                    case "test":
                        sender.sendMessage(DefultValue.Test);
                        break;

                    case "help":
                    default:
                        DefultValue.Help(sender);
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
                        sender.sendMessage(DefultValue.PrefixHC + "§2Support-Discord: §ehttps://discord.gg/vRyXFFterJ");
                        sender.sendMessage(DefultValue.PrefixHC + "§2Spigot: §ehttps://www.spigotmc.org/resources/..."); // ToDo
                        sender.sendMessage(DefultValue.PrefixHC + "§2");
                        sender.sendMessage(DefultValue.PrefixHC + "§2Version: §6" + Main.getPlugin().getDescription().getVersion());
                        sender.sendMessage(DefultValue.PrefixHC + "§8-----------------------------");
                        break;
                    default:
                        DefultValue.Help(sender);
                        break;
                    case "rl":
                    case "reload":
                        try {
                            Reload.reloadConfirmConsole();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        }
        return false;
    }
}
