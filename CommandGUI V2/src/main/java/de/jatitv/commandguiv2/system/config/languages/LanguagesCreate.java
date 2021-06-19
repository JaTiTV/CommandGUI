package de.jatitv.commandguiv2.system.config.languages;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.config.select.Select_config;
import de.jatitv.commandguiv2.system.send;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LanguagesCreate {

    public static void langCreate() {
        send.debug(Main.Prefix + " §4Language files are created / updated...");
        Long long_ = Long.valueOf(System.currentTimeMillis());

        /**
         *
         * ENGLISH
         *
         */

        File messagesEN = new File(Main.getPath(), "languages/english_messages.yml");
        YamlConfiguration yamlConfigurationEN = YamlConfiguration.loadConfiguration(messagesEN);

        set("Plugin.VaultNotSetUp", MSG.EN_VaultNotSetUp, yamlConfigurationEN);
        set("Plugin.SoundNotFound", MSG.EN_SoundNotFound, yamlConfigurationEN);
        set("Plugin.OnlyForPlayer", MSG.EN_OnlyForPlayer, yamlConfigurationEN);
        set("Plugin.Reload.Start", MSG.EN_ReloadStart, yamlConfigurationEN);
        set("Plugin.Reload.End", MSG.EN_ReloadEnd, yamlConfigurationEN);
        set("NoPermission.ForCommandGUI", MSG.EN_NoPermission, yamlConfigurationEN);
        set("NoPermission.ForCommand", MSG.EN_NoPermissionForCommand, yamlConfigurationEN);
        set("NoPermission.ForUseItem", MSG.EN_NoPermissionForUseItem, yamlConfigurationEN);
        set("NoPermission.ForItem", MSG.EN_NoPermissionForItem, yamlConfigurationEN);
        set("Cost.Buy_msg", MSG.EN_Buy_msg, yamlConfigurationEN);
        set("Cost.No_money", MSG.EN_No_money, yamlConfigurationEN);
        set("Cost.NoInventorySpace", MSG.EN_NoInventorySpace, yamlConfigurationEN);
        set("GUI.GUInotFound", MSG.EN_GUInotFound, yamlConfigurationEN);
        set("GUI.GUIisDisabled", MSG.EN_GUIisDisabled, yamlConfigurationEN);
        set("Give.Sender", MSG.EN_GiveSender, yamlConfigurationEN);
        set("Give.Receiver", MSG.EN_GiveReceiver, yamlConfigurationEN);
        set("Player.PlayerNotFond", MSG.EN_PlayerNotFond, yamlConfigurationEN);
        set("Player.PlayerNoInventorySpace", MSG.EN_PlayerNoInventorySpace, yamlConfigurationEN);
        set("Help.CGUI", MSG.EN_Help_CGUI, yamlConfigurationEN);
        set("Help.Help", MSG.EN_Help_Help, yamlConfigurationEN);
        set("Help.Info", MSG.EN_Help_Info, yamlConfigurationEN);
        set("Help.Open", MSG.EN_Help_Open, yamlConfigurationEN);
        // set("Help.Give", MSG.EN_Help_Give, yamlConfigurationEN);
        set("Help.CreateDefaultGUI", MSG.EN_Help_CreateDefaultGUI, yamlConfigurationEN);
        set("Help.Reload", MSG.EN_Help_Reload, yamlConfigurationEN);
        set("Help.UseItem.On", MSG.EN_GUIItemHelp_on, yamlConfigurationEN);
        set("Help.UseItem.Off", MSG.EN_GUIItemHelp_off, yamlConfigurationEN);

        try {
            yamlConfigurationEN.save(messagesEN);
        } catch (IOException e) {
            send.warning(e.getMessage());
            e.printStackTrace();
        }

        /**
        *
        * GERMAN
        *
        */


        File messagesDE = new File(Main.getPath(), "languages/german_messages.yml");
        YamlConfiguration yamlConfigurationDE = YamlConfiguration.loadConfiguration(messagesDE);

        set("Plugin.VaultNotSetUp", MSG.DE_VaultNotSetUp, yamlConfigurationDE);
        set("Plugin.SoundNotFound", MSG.DE_SoundNotFound, yamlConfigurationDE);
        set("Plugin.OnlyForPlayer", MSG.DE_OnlyForPlayer, yamlConfigurationDE);
        set("Plugin.Reload.Start", MSG.DE_ReloadStart, yamlConfigurationDE);
        set("Plugin.Reload.End", MSG.DE_ReloadEnd, yamlConfigurationDE);
        set("NoPermission.ForCommandGUI", MSG.DE_NoPermission, yamlConfigurationDE);
        set("NoPermission.ForCommand", MSG.DE_NoPermissionForCommand, yamlConfigurationDE);
        set("NoPermission.ForUseItem", MSG.DE_NoPermissionForUseItem, yamlConfigurationDE);
        set("NoPermission.ForItem", MSG.DE_NoPermissionForItem, yamlConfigurationDE);
        set("Cost.Buy_msg", MSG.DE_Buy_msg, yamlConfigurationDE);
        set("Cost.No_money", MSG.DE_No_money, yamlConfigurationDE);
        set("Cost.NoInventorySpace", MSG.DE_NoInventorySpace, yamlConfigurationDE);
        set("GUI.GUInotFound", MSG.DE_GUInotFound, yamlConfigurationDE);
        set("GUI.GUIisDisabled", MSG.DE_GUIisDisabled, yamlConfigurationDE);
        set("Give.Sender", MSG.DE_GiveSender, yamlConfigurationDE);
        set("Give.Receiver", MSG.DE_GiveReceiver, yamlConfigurationDE);
        set("Player.PlayerNotFond", MSG.DE_PlayerNotFond, yamlConfigurationDE);
        set("Player.PlayerNoInventorySpace", MSG.DE_PlayerNoInventorySpace, yamlConfigurationDE);
        set("Help.CGUI", MSG.DE_Help_CGUI, yamlConfigurationDE);
        set("Help.Help", MSG.DE_Help_Help, yamlConfigurationDE);
        set("Help.Info", MSG.DE_Help_Info, yamlConfigurationDE);
        set("Help.Open", MSG.DE_Help_Open, yamlConfigurationDE);
       // set("Help.Give", MSG.DE_Help_Give, yamlConfigurationDE);
        set("Help.CreateDefaultGUI", MSG.DE_Help_CreateDefaultGUI, yamlConfigurationDE);
        set("Help.Reload", MSG.DE_Help_Reload, yamlConfigurationDE);
        set("Help.UseItem.On", MSG.DE_GUIItemHelp_on, yamlConfigurationDE);
        set("Help.UseItem.Off", MSG.DE_GUIItemHelp_off, yamlConfigurationDE);

        try {
            yamlConfigurationDE.save(messagesDE);
        } catch (IOException e) {
            send.warning(e.getMessage());
            e.printStackTrace();
        }


        send.console(Main.Prefix + " §2Language files were successfully created / updated." + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
    }

    private static void set(String path, String value, YamlConfiguration config){
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }
}
