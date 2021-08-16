package de.jatitv.commandguiv2.Spigot.system.config.languages;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.Replace;
import de.jatitv.commandguiv2.Spigot.system.config.config.SelectConfig;
import de.jatitv.commandguiv2.Spigot.system.send;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class SelectMessages {

    public static String selectMSG;

    public static String VaultNotSetUp;
    public static String SoundNotFound;
    public static String OnlyForPlayer;
    public static String DefaultGUIcreate;
    public static String ReloadStart;
    public static String ReloadEnd;

    public static String NoPermission;
    public static String NoPermissionForCommand;
    public static String NoPermissionForUseItem;
    public static String NoPermissionForItem;

    public static String ItemON;
    public static String ItemOFF;
    public static String ItemSlot;
    public static String ItemSlotNotEmpty;
    public static String ItemSlotAlreadySet;
    public static String ItemSlot_wrongValue;

    public static String Buy_msg;
    public static String No_money;
    public static String NoInventorySpace;

    public static String onServerChange;

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
    public static String GUIItemHelp_Slot;

    public static void onSelect(String Prefix) {

        send.debug(Main.plugin, "§4Select language...");
        Long long_ = Long.valueOf(System.currentTimeMillis());

        File msg;

        msg = new File(Main.getPath(), "languages/" + SelectConfig.language + "_messages.yml");
        if (!msg.isFile()) {
            send.console(Prefix);
            send.console(Prefix + " §4!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            send.console(Prefix + " §4The selected §c" + SelectConfig.language + " §4language file was not found.");
            send.console(Prefix + " §6The default language §eEnglish §6is used!");
            send.console(Prefix + " §4!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            send.console(Prefix);
            msg = new File(Main.getPath(), "languages/" + "english_messages.yml");
            selectMSG = "english";
        } else selectMSG = SelectConfig.language;
        YamlConfiguration yamlConfiguration_msg = YamlConfiguration.loadConfiguration(msg);

        VaultNotSetUp = select("Plugin.VaultNotSetUp", yamlConfiguration_msg);
        SoundNotFound = select("Plugin.SoundNotFound", yamlConfiguration_msg);
        OnlyForPlayer = select("Plugin.OnlyForPlayer", yamlConfiguration_msg);
        DefaultGUIcreate = select("Plugin.DefaultGUI.create", yamlConfiguration_msg);
        ReloadStart = select("Plugin.Reload.Start", yamlConfiguration_msg);
        ReloadEnd = select("Plugin.Reload.End", yamlConfiguration_msg);

        NoPermission = select("NoPermission.ForCommandGUI", yamlConfiguration_msg);
        NoPermissionForCommand = select("NoPermission.ForCommand", yamlConfiguration_msg);
        NoPermissionForUseItem = select("NoPermission.ForUseItem", yamlConfiguration_msg);
        NoPermissionForItem = select("NoPermission.ForItem", yamlConfiguration_msg);

        ItemON = select("UseItem.UseItem_ON", yamlConfiguration_msg);
        ItemOFF = select("UseItem.UseItem_OFF", yamlConfiguration_msg);
        ItemSlot = select("UseItem.Change_Slot", yamlConfiguration_msg);
        ItemSlotNotEmpty = select("UseItem.SlotNotEmpty", yamlConfiguration_msg);
        ItemSlotAlreadySet = select("UseItem.SlotAlreadySet", yamlConfiguration_msg);
        ItemSlot_wrongValue = select("UseItem.ItemSlot_wrongValue", yamlConfiguration_msg);

        Buy_msg = select("Cost.Buy_msg", yamlConfiguration_msg);
        No_money = select("Cost.No_money", yamlConfiguration_msg);
        NoInventorySpace = select("Cost.NoInventorySpace", yamlConfiguration_msg);

        onServerChange = select("ServerChange.onServerChange", yamlConfiguration_msg);

        GUInotFound = select("GUI.GUInotFound", yamlConfiguration_msg);
        GUIIsDisabled = select("GUI.GUIisDisabled", yamlConfiguration_msg);

        Give_Sender = select("Give.Sender", yamlConfiguration_msg);
        Give_Receiver = select("Give.Receiver", yamlConfiguration_msg);

        PlayerNotFond = select("Player.PlayerNotFond", yamlConfiguration_msg);
        PlayerNoInventorySpace = select("Player.PlayerNoInventorySpace", yamlConfiguration_msg);

        HelpCgui = select("Help.CGUI", yamlConfiguration_msg);
        HelpHelp = select("Help.Help", yamlConfiguration_msg);
        HelpInfo = select("Help.Info", yamlConfiguration_msg);
        HelpOpen = select("Help.Open", yamlConfiguration_msg);
        HelpGive = select("Help.Give", yamlConfiguration_msg);
        HelpCreateDefaultGUI = select("Help.CreateDefaultGUI", yamlConfiguration_msg);
        HelpReload = select("Help.Reload", yamlConfiguration_msg);
        GUIItemHelp_on = select("Help.UseItem_On", yamlConfiguration_msg);
        GUIItemHelp_off = select("Help.UseItem_Off", yamlConfiguration_msg);
        GUIItemHelp_Slot = select("Help.UseItem_Slot", yamlConfiguration_msg);


        send.console(Prefix + " §2Language successfully selected to: §6" + selectMSG  + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
    }

    private static String select(String path, YamlConfiguration yamlConfiguration){
        return Replace.replace(yamlConfiguration.getString(path));
    }
}
