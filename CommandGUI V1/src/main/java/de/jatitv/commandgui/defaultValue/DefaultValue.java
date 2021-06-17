// This claas was created by JaTiTV

// -----------------------------
//    _____ _____ _    _ _____
//   / ____/ ____| |  | |_   _|
//  | |   | |  __| |  | | | |
//  | |   | | |_ | |  | | | |
//  | |___| |__| | |__| |_| |_
//   \_____\_____|\____/|_____|
// -----------------------------

package de.jatitv.commandgui.defaultValue;

import org.bukkit.Sound;

public class DefaultValue {

    // Config

    public static boolean Debug = false;
    public static Boolean UpdateCheckOnJoin = true;
    public static String language = "en_EN";

    public static String Currency = "$";

    public static Integer DefaultGUI = 1;


    // Messages
    public static String PrefixHC = "§8[§4C§9GUI§8] ";
    public static String Prefix = "§8[§4C§9GUI§8]";

    // EN
    public static String NoPermission = PrefixHC + "§cYou do not have permission for §4Command§9GUI!";
    public static String NoPermissionForCommand = PrefixHC + "§cFor §b[cmd] §cyou lack the permission §6[perm]§c!";
    public static String NoPermissionForItem = PrefixHC + "§cFor §b[item] §cyou lack the permission §6[perm]§c!";
    public static String VaultNotSetUp = PrefixHC + "§4Vault / Economy not set up!";
    public static String SoundNotFound = PrefixHC + "§4The sound §6[sound] §4could not be found! Please check your settings.";
    public static String ReloadStart = "§6Plugin reload...";
    public static String ReloadEnd = "§2Plugin successfully reloaded.";

    public static String HelpCgui        = "§8'§b/commandgui §8| §b/cgui§8' §eOpen the Default GUI §7(§r[gui]§7)§e.";
    public static String HelpHelp        = "§8'§b/commandgui help§8' §eOpens this help.";
    public static String HelpInfo        = "§8'§b/commandgui info§8' §eCall the info about §4Command§9GUI§e.";
    public static String HelpOpen        = "§8'§b/commandgui open [gui]§8' §eOpen the GUI: §6[guiname]§e.";
    public static String HelpGive        = "§8'§b/commandgui give §7<player> <gui>§8' §eGive a player a GUI Item.";
    public static String HelpReload      = "§8'§b/commandgui reload§8' §eReloads the Plugin.";

    public static String Buy_msg = PrefixHC + "§2You bought [itemname] §2for §6[price]§2.";
    public static String No_money = PrefixHC + "§cYou do not have enough money!";
    public static String NoInventorySpace = PrefixHC + "&cNo free inventory space!";

    public static String GUIisDisable = PrefixHC + "§cThe GUI [gui] §cis currently disabled!";

    public static String give = PrefixHC + "§2You gave §6[player] §2a [item]§2!";
    public static String giveReceived = PrefixHC + "§2You have received a [item] §2from §6[sender]§2!";
    public static String PlayerNotFound = PrefixHC + "§cThe player §6[player] §cwas not found or is not online!";
    public static String PlayerNoInventorySpace = PrefixHC + "§6[player] §chas no free inventory space available!";

    // DE
    public static String DE_NoPermission = PrefixHC + "§cDu hast keine Permission f[ue]r §4Command§9GUI!";
    public static String DE_NoPermissionForCommand = PrefixHC + "§cF[ue]r §b[cmd] §cfehlt dir die Permission §6[perm]§c!";
    public static String DE_NoPermissionForItem = PrefixHC + "§cF[ue]r §b[item] §cfehlt dir die Permission §6[perm]§c!";
    public static String DE_VaultNotSetUp = PrefixHC + "§4Vault / Economy nicht eingerichtet!";
    public static String DE_SoundNotFound = PrefixHC + "§4Der Sound §6[sound] §4wurde nicht gefunden! Bitte überprüfe die Einstellungen.";
    public static String DE_ReloadStart = "§6Plugin wird neu geladen...";
    public static String DE_ReloadEnd = "§2Plugin erfolgreich neu geladen.";

    public static String DE_HelpCgui        = "§8'§b/commandgui §8| §b/cgui§8' §e[OE]ffne die default GUI §7(§r[gui]§7)§e.";
    public static String DE_HelpHelp        = "§8'§b/commandgui help§8' §e[OE]ffne diese help.";
    public static String DE_HelpInfo        = "§8'§b/commandgui info§8' §eRufe die Infos von §4Command§9GUI §eauf.";
    public static String DE_HelpOpen        = "§8'§b/commandgui open [gui]§8' §e[OE]ffne die GUI: §6[guiname]§e.";
    public static String DE_HelpGive        = "§8'§b/commandgui give §7<player> <gui>§8' &eGebe einem Spieler ein GUI Item.";
    public static String DE_HelpReload      = "§8'§b/commandgui reload§8' &eLade das Plugin neu.";

    public static String DE_Buy_msg = PrefixHC + "&2Du hast dir [itemname] &2f[ue]r &6[price] &2gekauft.";
    public static String DE_No_money = PrefixHC + "&cDu hast nicht gen[ue]gend Geld!";
    public static String DE_NoInventorySpace = PrefixHC + "§cDu hast keinen Platz in deinem Inventar!";

    public static String DE_GUIisDisable = PrefixHC + "&cDie GUI [gui] &cist derzeit Deaktiviert!";

    public static String DE_give = PrefixHC + "&2Du hast &6[player] &2ein [item] &2gegeben!";
    public static String DE_giveReceived = PrefixHC + "&2Du hast von &6[sender] &2, [item] &2bekommen!";
    public static String DE_PlayerNotFound = PrefixHC + "&cDer Spieler &6[player] &cwurde nicht gefunden oder ist nicht Online!";
    public static String DE_PlayerNoInventorySpace = PrefixHC + "&6[player] &chat keinen freien Platz in seinem Inventar!";

    // FR
    public static String FR_NoPermission = PrefixHC + "§cVous n'avez pas la permission pour §4Command§9GUI!";
    public static String FR_NoPermissionForCommand = PrefixHC + "§cPour §b[cmd] §cil vous manque la permission §6[perm]§c!";
    public static String FR_NoPermissionForItem = PrefixHC + "§cPour §b[item] §cil vous manque la permission §6[perm]§c!";
    public static String FR_VaultNotSetUp = PrefixHC + "§4Vault / Economie non mis en place!";
    public static String FR_SoundNotFound = PrefixHC + "§4Le son §6[sound] §4n'a pas pu être trouvé ! Vérifiez votre configuration.";
    public static String FR_ReloadStart = "§6Le plugin recharge...";
    public static String FR_ReloadEnd = "§2Le plugin est rechargé.";

    public static String FR_HelpCgui        = "§8'§b/commandgui §8| §b/cgui§8' §eOuvre l'interface par défaut §7(§r[gui]§7)§e.";
    public static String FR_HelpHelp        = "§8'§b/commandgui help§8' §eOuvre cette aide.";
    public static String FR_HelpInfo        = "§8'§b/commandgui info§8' §eDonne les infos à propos de §4Command§9GUI§e.";
    public static String FR_HelpOpen        = "§8'§b/commandgui open [gui]§8' §eOuvre l'inteface: §6[guiname]§e.";
    public static String FR_HelpGive        = "§8'§b/commandgui give §7<player> <gui>§8' §eDonne à un joueur un item pour une interface.";
    public static String FR_HelpReload      = "§8'§b/commandgui reload§8' §eRecharge le plugin.";

    public static String FR_Buy_msg = PrefixHC + "§2Vous avez acheté [itemname] §2pour §6[price]§2.";
    public static String FR_No_money = PrefixHC + "§cVous n'avez pas assez d'argent!";
    public static String FR_NoInventorySpace = PrefixHC + "§cVous n'avez pas de place dans l'inventaire!";

    public static String FR_GUIisDisable = PrefixHC + "§cL'interface [gui] §cest actuellement désactivée!";

    public static String FR_give = PrefixHC + "§2Vous avez donné à §6[player] §2un [item]§2!";
    public static String FR_giveReceived = PrefixHC + "§2Vous avez reçu un [item] §2de §6[sender]§2!";
    public static String FR_PlayerNotFound = PrefixHC + "§cLe joueur §6[player] §cn'a pas pu être trouvé ou n'est pas connecté!";
    public static String FR_PlayerNoInventorySpace = PrefixHC + "§6[player] §cn'a pas d'espace libre dans son inventaire!";

    // NO
    public static String NO_NoPermission = PrefixHC + "§cDu har ikke tillatelse for §4Command§9GUI!";
    public static String NO_NoPermissionForCommand = PrefixHC + "§cDu mangler §6[perm] §vfor §b[cmd]§c!";
    public static String NO_NoPermissionForItem = PrefixHC + "§cDu mangler §6[perm] §cfor §b[item]§c!";
    public static String NO_VaultNotSetUp = PrefixHC + "§4Vault / Økonomi er ikke satt opp!";
    public static String NO_SoundNotFound = PrefixHC + "§4Lydeffekten §6[sound] §4ble ikke funnet! Sjekk instillingene dine.";
    public static String NO_ReloadStart = "§6Plugin restarter...";
    public static String NO_ReloadEnd = "§2Plugin restartet.";

    public static String NO_HelpCgui        = "§8'§b/commandgui §8| §b/cgui§8' §eÅpner Default GUI §7(§r[gui]§7)§e.";
    public static String NO_HelpHelp        = "§8'§b/commandgui help§8' §eÅpner hjelp.";
    public static String NO_HelpInfo        = "§8'§b/commandgui info§8' §eViser info om §4Command§9GUI§e.";
    public static String NO_HelpOpen        = "§8'§b/commandgui open [gui]§8' §eÅpner GUI: §6[guiname]§e.";
    public static String NO_HelpGive        = "§8'§b/commandgui give §7<player> <gui>§8' §eGir en spiller et GUI Item.";
    public static String NO_HelpReload      = "§8'§b/commandgui reload§8' §eRestarter pluginen.";

    public static String NO_Buy_msg = PrefixHC + "§2Du kjøpte [itemname] §2for §6[price]§2.";
    public static String NO_No_money = PrefixHC + "§cDu har ikke nok penger!";
    public static String NO_NoInventorySpace = PrefixHC + "§cDu har ikke nok ledig plass!";

    public static String NO_GUIisDisable = PrefixHC + "§cGUI [gui] §cer avskrudd!";

    public static String NO_give = PrefixHC + "§2Du gav §6[player] §2[item]§2!";
    public static String NO_giveReceived = PrefixHC + "§2Du har mottatt [item] §2fa §6[sender]§2!";
    public static String NO_PlayerNotFound = PrefixHC + "§cSpilleren §6[player] §cble ikke funnet!";
    public static String NO_PlayerNoInventorySpace = PrefixHC + "&6[player] §char ikke nok ledig plass!";


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
    public static String Sound_Give_input;

    public static Boolean Sound_PlayerNotFound_Enable = true;
    public static Sound Sound_PlayerNotFound;
    public static String Sound_PlayerNotFound_input;

}
