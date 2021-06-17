package de.jatitv.commandguiv2.languages;

import de.jatitv.commandguiv2.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LanguagesCreate {

    public static void langCreate(String version) {
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + " §4messages.yml(s) load...");

        File messagesDE = new File(Main.getPath(), "languages/german_messages.yml");
        YamlConfiguration yamlConfigurationDE = YamlConfiguration.loadConfiguration(messagesDE);

        if (!yamlConfigurationDE.contains("Plugin.VaultNotSetUp")) {
            yamlConfigurationDE.set("Plugin.VaultNotSetUp", DefaultValue.DE_VaultNotSetUp);
        }
        if (!yamlConfigurationDE.contains("Plugin.SoundNotFound")) {
            yamlConfigurationDE.set("Plugin.SoundNotFound", DefaultValue.DE_SoundNotFound);
        }
        if (!yamlConfigurationDE.contains("Plugin.OnlyForPlayer")) {
            yamlConfigurationDE.set("Plugin.OnlyForPlayer", DefaultValue.DE_OnlyForPlayer);
        }
        if (!yamlConfigurationDE.contains("Plugin.Reload.Start")) {
            yamlConfigurationDE.set("Plugin.Reload.Start", DefaultValue.DE_ReloadStart);
        }
        if (!yamlConfigurationDE.contains("Plugin.Reload.End")) {
            yamlConfigurationDE.set("Plugin.Reload.End", DefaultValue.DE_ReloadEnd);
        }

        if (!yamlConfigurationDE.contains("NoPermission.ForCommand")) {
            yamlConfigurationDE.set("NoPermission.ForCommand", DefaultValue.DE_NoPermissionForCommand);
        }
        if (!yamlConfigurationDE.contains("NoPermission.ForUseItem")) {
            yamlConfigurationDE.set("NoPermission.ForUseItem", DefaultValue.DE_NoPermissionForUseItem);
        }
        if (!yamlConfigurationDE.contains("NoPermission.ForItem")) {
            yamlConfigurationDE.set("NoPermission.ForItem", DefaultValue.DE_NoPermissionForItem);
        }

        if (!yamlConfigurationDE.contains("Cost.Buy_msg")) {
            yamlConfigurationDE.set("Cost.Buy_msg", DefaultValue.DE_Buy_msg);
        }
        if (!yamlConfigurationDE.contains("Cost.No_money")) {
            yamlConfigurationDE.set("Cost.No_money", DefaultValue.DE_No_money);
        }
        if (!yamlConfigurationDE.contains("Cost.NoInventorySpace")) {
            yamlConfigurationDE.set("Cost.NoInventorySpace", DefaultValue.DE_NoInventorySpace);
        }

        if (!yamlConfigurationDE.contains("GUI.GUInotFound")) {
            yamlConfigurationDE.set("GUI.GUInotFound", DefaultValue.DE_GUInotFound);
        }
        if (!yamlConfigurationDE.contains("GUI.GUIisDisabled")) {
            yamlConfigurationDE.set("GUI.GUIisDisabled", DefaultValue.DE_GUIisDisabled);
        }

        if (!yamlConfigurationDE.contains("Give.Sender")) {
            yamlConfigurationDE.set("Give.Sender", DefaultValue.DE_GiveSender);
        }
        if (!yamlConfigurationDE.contains("Give.Receiver")) {
            yamlConfigurationDE.set("Give.Receiver", DefaultValue.DE_GiveReceiver);
        }

        if (!yamlConfigurationDE.contains("Player.PlayerNotFond")) {
            yamlConfigurationDE.set("Player.PlayerNotFond", DefaultValue.DE_PlayerNotFond);
        }
        if (!yamlConfigurationDE.contains("Player.PlayerNoInventorySpace")) {
            yamlConfigurationDE.set("Player.PlayerNoInventorySpace", DefaultValue.DE_PlayerNoInventorySpace);
        }

        if (!yamlConfigurationDE.contains("Help.CGUI")) {
            yamlConfigurationDE.set("Help.CGUI", DefaultValue.DE_Help_CGUI);
        }
        if (!yamlConfigurationDE.contains("Help.Help")) {
            yamlConfigurationDE.set("Help.Help", DefaultValue.DE_Help_Help);
        }
        if (!yamlConfigurationDE.contains("Help.Info")) {
            yamlConfigurationDE.set("Help.Info", DefaultValue.DE_Help_Info);
        }
        if (!yamlConfigurationDE.contains("Help.Open")) {
            yamlConfigurationDE.set("Help.Open", DefaultValue.DE_Help_Open);
        }
        if (!yamlConfigurationDE.contains("Help.Give")) {
            yamlConfigurationDE.set("Help.Give", DefaultValue.DE_Help_Give);
        }
        if (!yamlConfigurationDE.contains("Help.Reload")) {
            yamlConfigurationDE.set("Help.Reload", DefaultValue.DE_Help_Reload);
        }

        try {
            yamlConfigurationDE.save(messagesDE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(Main.Prefix + " §2messages.yml(s) loaded successfully.");


    }
}
