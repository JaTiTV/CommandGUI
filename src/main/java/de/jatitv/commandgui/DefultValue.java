// This claas was created by JaTiTV

// -----------------------------
//    _____ _____ _    _ _____
//   / ____/ ____| |  | |_   _|
//  | |   | |  __| |  | | | |
//  | |   | | |_ | |  | | | |
//  | |___| |__| | |__| |_| |_
//   \_____\_____|\____/|_____|
// -----------------------------

package de.jatitv.commandgui;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DefultValue {

    // Config

    public static boolean Debug = false;
    public static int DebugStage = 1;
    public static Boolean UpdateCheckOnJoin = true;


    // Messages

    public static String PrefixHC = "§8[§6C§9GUI§8] ";
    public static String Prefix = "§8[§6C§9GUI§8]";

    public static String NoPermissionForCommand = "§8[§6C§9GUI§8] §cFor §b[cmd] §cyou lack the permission §6[perm]§c!";
    public static String NoPermission = "§8[§6C§9GUI§8] §cYou do not have permission for CommandGUI!";

    public static String Test = "§8[§6C§9GUI§8] §6Command§9GUI";






    public static void Help(CommandSender sender) {
        if (sender.hasPermission("commandgui.command")
                || sender.hasPermission("commandgui.command.info")
                || sender.hasPermission("commandgui.admin")
                || sender.isOp()) {
            sender.sendMessage(PrefixHC + " §8----- §2Wonder§6Bag§9Shop §chelp §8-----");
            sender.sendMessage(PrefixHC);
            if (sender.hasPermission("commandgui.command") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                sender.sendMessage(PrefixHC + " " + HelpHelp);
                sender.sendMessage(PrefixHC + " " + HelpShop);
            }
            if (sender.hasPermission("commandgui.command.info") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                sender.sendMessage(PrefixHC + " " + HelpInfo);
            }
            if (sender.hasPermission("commandgui.command.gift") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                sender.sendMessage(PrefixHC + " " + HelpGift);
            }
            if (sender instanceof Player) {
                if (sender.hasPermission("commandgui.command.give") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    sender.sendMessage(PrefixHC + " " + HelpGive);
                }
                if (sender.hasPermission("commandgui.command.giveall") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    sender.sendMessage(PrefixHC + " " + HelpGiveAll);
                }
            } else {
                if (sender.hasPermission("commandgui.command.give") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    sender.sendMessage(PrefixHC + " " + HelpGive);
                    sender.sendMessage(PrefixHC + " " + HelpGiveConsole);
                }
                if (sender.hasPermission("commandgui.command.giveall") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    sender.sendMessage(PrefixHC + " " + HelpGiveAll);
                    sender.sendMessage(PrefixHC + " " + HelpGiveAllConsole);
                }
            }
            if (sender.hasPermission("commandgui.admin") || sender.isOp()) {
                sender.sendMessage(PrefixHC + " " + HelpSettings);
            }
            if (sender.hasPermission("wonderbagshop.admin") || sender.isOp()) {
                sender.sendMessage(PrefixHC + " " + HelpReload);
            }
            sender.sendMessage(PrefixHC);
            sender.sendMessage(PrefixHC + " §8----------------------------");
        } else {
            sender.sendMessage(DefultValue.NoPermission);
        }
    }

    public static String HelpHelp        = "§8'§b/commandgui help§8' §eOpens this help.";
    public static String HelpShop        = "§8'§b/commandgui§8' §eOpens the shop GUI.";
    public static String HelpInfo        = "§8'§b/commandgui info§8' §eCall the info about §2W§6B§9S§e.";
    public static String HelpGift        = "§8'§b/commandgui gift §7<player>§8' §eOpens the gift GUI and Give away a WonderBag.";

    public static String HelpGive        = "§8'§b/commandgui give §7<player>§8' §eOpens the give GUI and Give a player a WonderBag.";
    public static String HelpGiveAll     = "§8'§b/commandgui giveall§8' §eOpens the give GUI and Give all player a WonderBag.";
    public static String HelpGiveConsole = "§8'§b/commandgui give §7<player> <ChestSmall | ChestMedium | ChestLarge | ItemSmall | ItemMedium | ItemLarge>§8'" +
            " §eGive a player a WonderBag. §4Only for the console!";
    public static String HelpGiveAllConsole = "§8'§b/commandgui giveall §7<ChestSmall | ChestMedium | ChestLarge | ItemSmall | ItemMedium | ItemLarge>§8'\" +\n" +
            "            \" §eGive all player a WonderBag. §4Only for the console!";
    public static String HelpSettings    = "§8'§b/commandgui settings§8' §eEdit the Settings.";
    public static String HelpReload      = "§8'§b/commandgui reload§8' §eReloads the Plugin.";

}
