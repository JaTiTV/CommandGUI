package de.jatitv.commandguiv2.system.config.select;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.Replace;
import de.jatitv.commandguiv2.system.send;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Select_msg {

    public static String selectMSG;

    public static String VaultNotSetUp;
    public static String SoundNotFound;
    public static String OnlyForPlayer;
    public static String DefaultGUIcreate;
    public static String ReloadStart;
    public static String ReloadEnd;
    public static String ReloadWarning;

    public static String NoPermission;
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
    public static String HelpCreateDefaultGUI;
    public static String HelpReload;
    public static String GUIItemHelp_on;
    public static String GUIItemHelp_off;

    public static void onSelect(String Prefix) {

        send.debug("§4Select language...");
        Long long_ = Long.valueOf(System.currentTimeMillis());

        File msg;

        msg = new File(Main.getPath(), "languages/" + Select_config.language + "_messages.yml");
        if (!msg.isFile()) {
            send.console(Prefix);
            send.console(Prefix + " §4!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            send.console(Prefix + " §4The selected §c" + Select_config.language + " §4language file was not found.");
            send.console(Prefix + " §6The default language §eEnglish §6is used!");
            send.console(Prefix + " §4!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            send.console(Prefix);
            msg = new File(Main.getPath(), "languages/" + "english_messages.yml");
            selectMSG = "english";
        } else selectMSG = Select_config.language;
        YamlConfiguration yamlConfiguration_msg = YamlConfiguration.loadConfiguration(msg);

        VaultNotSetUp = Replace.replace(yamlConfiguration_msg.getString("Plugin.VaultNotSetUp"));
        SoundNotFound = Replace.replace(yamlConfiguration_msg.getString("Plugin.SoundNotFound"));
        OnlyForPlayer = Replace.replace(yamlConfiguration_msg.getString("Plugin.OnlyForPlayer"));
        DefaultGUIcreate = Replace.replace(yamlConfiguration_msg.getString("Plugin.DefaultGUI.create"));
        ReloadStart = Replace.replace(yamlConfiguration_msg.getString("Plugin.Reload.Start"));
        ReloadEnd = Replace.replace(yamlConfiguration_msg.getString("Plugin.Reload.End"));
        ReloadWarning = Replace.replace(yamlConfiguration_msg.getString("Plugin.Reload.Warning"));

        NoPermission = Replace.replace(yamlConfiguration_msg.getString("NoPermission.ForCommandGUI"));
        NoPermissionForCommand = Replace.replace(yamlConfiguration_msg.getString("NoPermission.ForCommand"));
        NoPermissionForUseItem = Replace.replace(yamlConfiguration_msg.getString("NoPermission.ForUseItem"));
        NoPermissionForItem = Replace.replace(yamlConfiguration_msg.getString("NoPermission.ForItem"));

        Buy_msg = Replace.replace(yamlConfiguration_msg.getString("Cost.Buy_msg"));
        No_money = Replace.replace(yamlConfiguration_msg.getString("Cost.No_money"));
        NoInventorySpace = Replace.replace(yamlConfiguration_msg.getString("Cost.NoInventorySpace"));

        GUInotFound = Replace.replace(yamlConfiguration_msg.getString("GUI.GUInotFound"));
        GUIIsDisabled = Replace.replace(yamlConfiguration_msg.getString("GUI.GUIisDisabled"));

       // Give_Sender = Replace.replace(yamlConfiguration_msg.getString("Give.Sender"));
       // Give_Receiver = Replace.replace(yamlConfiguration_msg.getString("Give.Receiver"));

       // PlayerNotFond = Replace.replace(yamlConfiguration_msg.getString("Player.PlayerNotFond"));
       // PlayerNoInventorySpace = Replace.replace(yamlConfiguration_msg.getString("Player.PlayerNoInventorySpace"));

        HelpCgui = Replace.replace(yamlConfiguration_msg.getString("Help.CGUI"));
        HelpHelp = Replace.replace(yamlConfiguration_msg.getString("Help.Help"));
        HelpInfo = Replace.replace(yamlConfiguration_msg.getString("Help.Info"));
        HelpOpen = Replace.replace(yamlConfiguration_msg.getString("Help.Open"));
       // HelpGive = Replace.replace(yamlConfiguration_msg.getString("Help.Give"));
        HelpCreateDefaultGUI = Replace.replace(yamlConfiguration_msg.getString("Help.CreateDefaultGUI"));
        HelpReload = Replace.replace(yamlConfiguration_msg.getString("Help.Reload"));
        GUIItemHelp_on = Replace.replace(yamlConfiguration_msg.getString("Help.UseItem_On"));
        GUIItemHelp_off = Replace.replace(yamlConfiguration_msg.getString("Help.UseItem_Off"));

        send.console(Prefix + " §2Language successfully selected to: §6" + selectMSG  + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
    }
}
