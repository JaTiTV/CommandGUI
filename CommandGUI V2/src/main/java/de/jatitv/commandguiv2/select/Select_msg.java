package de.jatitv.commandguiv2.select;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.Replace;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Select_msg {

    public static String selectMSG;

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

    public static void onSelect(String Prefix) {

        Bukkit.getConsoleSender().sendMessage(Prefix + " §4Select language...");

        File msg;

        msg = new File(Main.getPath(), "languages/" + Select_config.language + "_messages.yml");
        if (!msg.isFile()) {
            Bukkit.getConsoleSender().sendMessage(Prefix);
            Bukkit.getConsoleSender().sendMessage(Prefix + " §4!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Bukkit.getConsoleSender().sendMessage(Prefix + " §4The selected §c" + Select_config.language + " §4language file was not found.");
            Bukkit.getConsoleSender().sendMessage(Prefix + " §6The default language §eEnglish §6is used!");
            Bukkit.getConsoleSender().sendMessage(Prefix + " §4!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Bukkit.getConsoleSender().sendMessage(Prefix);
            msg = new File(Main.getPath(), "languages/" + "german_messages.yml"); //ToDo
            selectMSG = "english";
        } else selectMSG = Select_config.language;
        YamlConfiguration yamlConfiguration_msg = YamlConfiguration.loadConfiguration(msg);

        VaultNotSetUp = Replace.replace(yamlConfiguration_msg.getString("Plugin.VaultNotSetUp"));
        SoundNotFound = Replace.replace(yamlConfiguration_msg.getString("Plugin.SoundNotFound"));
        OnlyForPlayer = Replace.replace(yamlConfiguration_msg.getString("Plugin.OnlyForPlayer"));
        ReloadStart = Replace.replace(yamlConfiguration_msg.getString("Plugin.Reload.Start"));
        ReloadEnd = Replace.replace(yamlConfiguration_msg.getString("Plugin.Reload.End"));

        NoPermissionForCommand = Replace.replace(yamlConfiguration_msg.getString("NoPermission.ForCommand"));
        NoPermissionForUseItem = Replace.replace(yamlConfiguration_msg.getString("NoPermission.ForUseItem"));
        NoPermissionForItem = Replace.replace(yamlConfiguration_msg.getString("NoPermission.ForItem"));

        Buy_msg = Replace.replace(yamlConfiguration_msg.getString("Cost.Buy_msg"));
        No_money = Replace.replace(yamlConfiguration_msg.getString("Cost.No_money"));
        NoInventorySpace = Replace.replace(yamlConfiguration_msg.getString("Cost.NoInventorySpace"));

        GUInotFound = Replace.replace(yamlConfiguration_msg.getString("GUI.GUInotFound"));
        GUIIsDisabled = Replace.replace(yamlConfiguration_msg.getString("GUI.GUIisDisabled"));

        Give_Sender = Replace.replace(yamlConfiguration_msg.getString("Give.Sender"));
        Give_Receiver = Replace.replace(yamlConfiguration_msg.getString("Give.Receiver"));

        PlayerNotFond = Replace.replace(yamlConfiguration_msg.getString("Player.PlayerNotFond"));
        PlayerNoInventorySpace = Replace.replace(yamlConfiguration_msg.getString("Player.PlayerNoInventorySpace"));

        HelpCgui = Replace.replace(yamlConfiguration_msg.getString("Help.CGUI"));
        HelpHelp = Replace.replace(yamlConfiguration_msg.getString("Help.Help"));
        HelpInfo = Replace.replace(yamlConfiguration_msg.getString("Help.Info"));
        HelpOpen = Replace.replace(yamlConfiguration_msg.getString("Help.Open"));
        HelpGive = Replace.replace(yamlConfiguration_msg.getString("Help.Give"));
        HelpReload = Replace.replace(yamlConfiguration_msg.getString("Help.Reload"));

        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Language successfully selected to: §6" + selectMSG);
    }
}
