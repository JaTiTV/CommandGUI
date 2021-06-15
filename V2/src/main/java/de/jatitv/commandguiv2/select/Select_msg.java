package de.jatitv.commandguiv2.select;

import de.jatitv.commandguiv2.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Select_msg {

    public static String selectMSG;
    public static String sel;

    public static String VaultNotSetUp;
    public static String SoundNotFound;
    public static String OnlyForPlayer;
    public static String ReloadStart;
    public static String ReloadEnd;

    public static String NoPermissionForCommand;
    public static String NoPermissionForUseItem;
    public static String NoPermissionForItem;

    public static String Buy_msg;
    public static String No_money;
    public static String NoInventorySpace;

    public static String GUInotFound;
    public static String GUIIsDisabled;

    public static String Give_Sender;
    public static String Give_Receiver;

    public static String PlayerNotFond;
    public static String PlayerNoInventorySpace;

    public static String HelpCgui;
    public static String HelpHelp;
    public static String HelpInfo;
    public static String HelpOpen;
    public static String HelpGive;
    public static String HelpReload;

    public static void onSelect() {

        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4Select language...");

        File msg;

        msg = new File(Main.getPath(), "languages/" + Select_config.language + "_messages.yml");
        if (!msg.isFile()) {
            Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4The selected language §c" + Select_config.language + "§4 file was not found.");
            Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§6The default language §eEnglish §6is used!");
            msg = new File(Main.getPath(), "languages/" + "de_DE_messages.yml"); //ToDo
        }
        YamlConfiguration yamlConfiguration_msg = YamlConfiguration.loadConfiguration(msg);

        VaultNotSetUp = Main.replace(yamlConfiguration_msg.getString("Plugin.VaultNotSetUp"));
        SoundNotFound = Main.replace(yamlConfiguration_msg.getString("Plugin.SoundNotFound"));
        OnlyForPlayer = Main.replace(yamlConfiguration_msg.getString("Plugin.OnlyForPlayer"));
        ReloadStart = Main.replace(yamlConfiguration_msg.getString("Plugin.Reload.Start"));
        ReloadEnd = Main.replace(yamlConfiguration_msg.getString("Plugin.Reload.End"));

        NoPermissionForCommand = Main.replace(yamlConfiguration_msg.getString("NoPermission.ForCommand"));
        NoPermissionForUseItem = Main.replace(yamlConfiguration_msg.getString("NoPermission.ForUseItem"));
        NoPermissionForItem = Main.replace(yamlConfiguration_msg.getString("NoPermission.ForItem"));

        Buy_msg = Main.replace(yamlConfiguration_msg.getString("Cost.Buy_msg"));
        No_money = Main.replace(yamlConfiguration_msg.getString("Cost.No_money"));
        NoInventorySpace = Main.replace(yamlConfiguration_msg.getString("Cost.NoInventorySpace"));

        GUInotFound = Main.replace(yamlConfiguration_msg.getString("GUI.GUInotFound"));
        GUIIsDisabled = Main.replace(yamlConfiguration_msg.getString("GUI.GUIisDisabled"));

        Give_Sender = Main.replace(yamlConfiguration_msg.getString("Give.Sender"));
        Give_Receiver = Main.replace(yamlConfiguration_msg.getString("Give.Receiver"));

        PlayerNotFond = Main.replace(yamlConfiguration_msg.getString("Player.PlayerNotFond"));
        PlayerNoInventorySpace = Main.replace(yamlConfiguration_msg.getString("Player.PlayerNoInventorySpace"));

        HelpCgui = Main.replace(yamlConfiguration_msg.getString("Help.CGUI"));
        HelpHelp = Main.replace(yamlConfiguration_msg.getString("Help.Help"));
        HelpInfo = Main.replace(yamlConfiguration_msg.getString("Help.Info"));
        HelpOpen = Main.replace(yamlConfiguration_msg.getString("Help.Open"));
        HelpGive = Main.replace(yamlConfiguration_msg.getString("Help.Give"));
        HelpReload = Main.replace(yamlConfiguration_msg.getString("Help.Reload"));
    }
}
