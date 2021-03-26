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

public class DefaultValue {

    // Config

    public static boolean Debug = false;
    public static Boolean UpdateCheckOnJoin = true;
    public static String language = "EN";

    public static String Currency = "$";

    public static Integer DefaultGUI = 1;


    // Messages
    public static String PrefixHC = "§8[§6C§9GUI§8] ";
    public static String Prefix = "§8[§6C§9GUI§8]";

    // EN
    public static String NoPermission = PrefixHC + "§cYou do not have permission for §6Command§9GUI!";
    public static String NoPermissionForCommand = PrefixHC + "§cFor §b[cmd] §cyou lack the permission §6[perm]§c!";
    public static String NoPermissionForItem = PrefixHC + "§cFor §b[item] §cyou lack the permission §6[perm]§c!";
    public static String VaultNotSetUp = PrefixHC + "§4Vault / Economy not set up!";
    public static String SoundNotFound = PrefixHC + "§4The sound §6[sound] §4could not be found! Please check your settings.";
    public static String ReloadStart = "§6Plugin reload...";
    public static String ReloadEnd = "§2Plugin successfully reloaded.";

    public static String HelpCgui        = "§8'§b/commandgui §8| §b/cgui§8' §eOpen the Default GUI §7(§r[gui]§7)§e.";
    public static String HelpHelp        = "§8'§b/commandgui help§8' §eOpens this help.";
    public static String HelpInfo        = "§8'§b/commandgui info§8' §eCall the info about §6Command§9GUI§e.";
    public static String HelpOpen         = "§8'§b/commandgui open [gui]§8' §eOpen the GUI: §6[guiname]§e.";
    public static String HelpGive        = "§8'§b/commandgui give §7<player> <gui>§8' §eGive a player a GUI Item.";
    public static String HelpReload      = "§8'§b/commandgui reload§8' §eReloads the Plugin.";

    public static String Buy_msg = PrefixHC + "§2You bought [itemname] §2for §6[price]§2.";
    public static String No_money = PrefixHC + "§cYou do not have enough money!";
    public static String NoInventorySpace = PrefixHC + "&cDu hast keinen Platz in deinem Inventar!";

    public static String GUIisDisable = PrefixHC + "§cThe GUI [gui] §cis currently disabled!";

    public static String give = PrefixHC + "§2You gave §6[player] §2a [item]§2!";
    public static String giveReceived = PrefixHC + "§2You have received a [item] §2from §6[sender]§2!";
    public static String PlayerNotFound = PrefixHC + "§cThe player §6[player] §cwas not found or is not online!";
    public static String PlayerNoInventorySpace = PrefixHC + "§6[player] §chas no free inventory space available!";

    // DE
    public static String DE_NoPermission = PrefixHC + "§cDu hast keine Permission f[ue]r §6Command§9GUI!";
    public static String DE_NoPermissionForCommand = PrefixHC + "§cF[ue]r §b[cmd] §cfehlt dir die Permission §6[perm]§c!";
    public static String DE_NoPermissionForItem = PrefixHC + "§cF[ue]r §b[item] §cfehlt dir die Permission §6[perm]§c!";
    public static String DE_VaultNotSetUp = PrefixHC + "§4Vault / Economy nicht eingerichtet!";
    public static String DE_SoundNotFound = PrefixHC + "§4Der Sound §6[sound] §4wurde nicht gefunden! Bitte überprüfe die Einstellungen.";
    public static String DE_ReloadStart = "§6Plugin wird neu geladen...";
    public static String DE_ReloadEnd = "§2Plugin erfolgreich neu geladen.";

    public static String DE_HelpCgui        = "§8'§b/commandgui §8| §b/cgui§8' §e[OE]ffne die default GUI §7(§r[gui]§7)§e.";
    public static String DE_HelpHelp        = "§8'§b/commandgui help§8' §e[OE]ffne diese help.";
    public static String DE_HelpInfo        = "§8'§b/commandgui info§8' §eRufe die Infos von §6Command§9GUI §eauf.";
    public static String DE_HelpOpen         = "§8'§b/commandgui open [gui]§8' §e[OE]ffne die GUI: §6[guiname]§e.";
    public static String DE_HelpGive        = "§8'§b/commandgui give §7<player> <gui>§8' &eGebe einem Spieler ein GUI Item.";
    public static String DE_HelpReload      = "§8'§b/commandgui reload§8' &eLade das Plugin neu.";

    public static String DE_Buy_msg = PrefixHC + "&2Du hast dir [itemname] &2f[ue]r &6[price] &2gekauft.";
    public static String DE_No_money = PrefixHC + "&cDu hast nicht gen[ue]gend Geld!";
    public static String DE_NoInventorySpace = PrefixHC + "§cNo free inventory space!";

    public static String DE_GUIisDisable = PrefixHC + "&cDie GUI [gui] &cist derzeit Deaktiviert!";

    public static String DE_give = PrefixHC + "&2Du hast &6[player] &2ein [item] &2gegeben!";
    public static String DE_giveReceived = PrefixHC + "&2Du hast von &6[sender] &2, [item] &2bekommen!";
    public static String DE_PlayerNotFound = PrefixHC + "&cDer Spieler &6[player] &cwurde nicht gefunden oder ist nicht Online!";
    public static String DE_PlayerNoInventorySpace = PrefixHC + "&6[player] &chat keinen freien Platz in seinem Inventar!";


    // Sound

    public static Boolean Sound_Enable = true;

    public static Boolean Sound_Click_Enable = true;
    public static Sound Sound_Click;
    public static String Sound_Click_input;

    public static Boolean Sound_NoMoney_Enable = true;
    public static Sound Sound_NoMoney;
    public static String Sound_NoMoney_input;

    public static Boolean Sound_NoInventorySpace_Enable = true;
    public static Sound Sound_NoInventorySpace;
    public static String Sound_NoInventorySpace_input;

    public static Boolean Sound_Give_Enable = true;
    public static Sound Sound_Give;
    public static String Sound_Give_input;   // = "ENTITY_PLAYER_LEVELUP"

    public static Boolean Sound_PlayerNotFound_Enable = true;
    public static Sound Sound_PlayerNotFound;
    public static String Sound_PlayerNotFound_input;  // = "BLOCK_NOTE_BLOCK_HARP";






}
