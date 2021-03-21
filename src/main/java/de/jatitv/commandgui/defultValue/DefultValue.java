// This claas was created by JaTiTV

// -----------------------------
//    _____ _____ _    _ _____
//   / ____/ ____| |  | |_   _|
//  | |   | |  __| |  | | | |
//  | |   | | |_ | |  | | | |
//  | |___| |__| | |__| |_| |_
//   \_____\_____|\____/|_____|
// -----------------------------

package de.jatitv.commandgui.defultValue;

import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DefultValue {

    // Config

    public static boolean Debug = false;
    public static int DebugStage = 1;
    public static Boolean UpdateCheckOnJoin = true;

    public static String Currency = "$";

    public static Integer DefaultGUI = 1;


    // Messages

    public static String PrefixHC = "§8[§6C§9GUI§8] ";
    public static String Prefix = "§8[§6C§9GUI§8]";

    public static String ReloadStart = "§6Plugin reload...";
    public static String ReloadEnd = "§2Plugin successfully reloaded.";

    public static String NoPermissionForCommand = "§8[§6C§9GUI§8] §cFor §b[cmd] §cyou lack the permission §6[perm]§c!";
    public static String NoPermission = "§8[§6C§9GUI§8] §cYou do not have permission for §6Command§9GUI!";
    public static String NoPermissionForItem = "§8[§6C§9GUI§8] §cFor §b[item] §cyou lack the permission §6[perm]§c!";

    public static String Buy_msg = "§8[§6C§9GUI§8] §2You bought [itemname] for §6[price]§2.";
    public static String No_money = "§8[§6C§9GUI§8] §cYou do not have enough money!";

    public static String give = "§8[§6C§9GUI§8] §2You gave §6[player] §2a [item]§2!";
    public static String giveReceived = "§8[§6C§9GUI§8] §2You have received a [item] §2from §6[sender]§2!";
    public static String PlayerNotFound = "§8[§6C§9GUI§8] §cThe player §6[player] §cwas not found or is not online!";
    public static String GUIisDisable = "§8[§6C§9GUI§8] §cThe GUI [gui] §cis currently disabled!";

    public static String VaultNotSetUp = "§8[§6C§9GUI§8] §4Vault / Economy not set up!";
    public static String SoundNotFound = "§8[§6C§9GUI§8] §4The sound §6[sound] §4could not be found! Please check your settings.";


    // Sound

    public static Boolean Sound_Enable = true;

    public static Boolean Sound_Click_Enable = true;
    public static Sound Sound_Click;
    public static String Sound_Click_input;

    public static Boolean Sound_NoMoney_Enable = true;
    public static Sound Sound_NoMoney;
    public static String Sound_NoMoney_input;




    // Help

    public static String HelpCgui        = "§8'§b/commandgui §8| §b/cgui§8' §eOpen the Default GUI §7(§r[gui]§7)§e.";
    public static String HelpHelp        = "§8'§b/commandgui help§8' §eOpens this help.";
    public static String HelpInfo        = "§8'§b/commandgui info§8' §eCall the info about §6Command§9GUI§e.";
    public static String HelpGUI         = "§8'§b/commandgui [gui]§8' §eOpen the GUI: §6[guiname]§e.";

    public static String HelpGive        = "§8'§b/commandgui give §7<player> <gui>§8' §eGive a player a GUI Item.";

    public static String HelpReload      = "§8'§b/commandgui reload§8' §eReloads the Plugin.";

}
