package de.jatitv.commandguiv2.system.config.languages;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.send;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LanguagesCreate {

    public static void langCreate() {
        send.Console(Main.Prefix + " §4Language files are created / updated...");

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
        set("Help.Give", MSG.DE_Help_Give, yamlConfigurationDE);
        set("Help.CreateDefaultGUI", MSG.DE_Help_CreateDefaultGUI, yamlConfigurationDE);
        set("Help.Reload", MSG.DE_Help_Reload, yamlConfigurationDE);
        set("Help.UseItem.On", MSG.DE_GUIItemHelp_on, yamlConfigurationDE);
        set("Help.UseItem.Off", MSG.DE_GUIItemHelp_off, yamlConfigurationDE);

        try {
            yamlConfigurationDE.save(messagesDE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        send.Console(Main.Prefix + " §2Language files were successfully created / updated.");
    }

    private static void set(String path, String value, YamlConfiguration config){
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }
}
