package de.jatitv.commandguiv2.Spigot.system.config.languages;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.send;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class LanguagesCreate {
    private static Plugin plugin = Main.plugin;

    public static void langCreate() {
        send.debug(plugin,"§4Language files are created / updated...");
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
        set("Plugin.DefaultGUI.create", MSG.EN_DefaultGUI, yamlConfigurationEN);
        set("Plugin.Reload.Start", MSG.EN_ReloadStart, yamlConfigurationEN);
        set("Plugin.Reload.End", MSG.EN_ReloadEnd, yamlConfigurationEN);
        set("Plugin.Reload.Warning", MSG.EN_ReloadWarning, yamlConfigurationEN);

        set("NoPermission.ForCommandGUI", MSG.EN_NoPermission, yamlConfigurationEN);
        set("NoPermission.ForCommand", MSG.EN_NoPermissionForCommand, yamlConfigurationEN);
        set("NoPermission.ForUseItem", MSG.EN_NoPermissionForUseItem, yamlConfigurationEN);
        set("NoPermission.ForItem", MSG.EN_NoPermissionForItem, yamlConfigurationEN);

        set("UseItem.UseItem_ON", MSG.EN_ItemON, yamlConfigurationEN);
        set("UseItem.UseItem_OFF", MSG.EN_ItemOFF, yamlConfigurationEN);
        set("UseItem.Change_Slot", MSG.EN_ItemSlot, yamlConfigurationEN);
        set("UseItem.SlotNotEmpty", MSG.EN_ItemSlotNotEmpty, yamlConfigurationEN);
        set("UseItem.SlotAlreadySet", MSG.EN_ItemSlotAlreadySet, yamlConfigurationEN);
        set("UseItem.ItemSlot_wrongValue", MSG.EN_ItemSlot_wrongValue, yamlConfigurationEN);

        set("Cost.Buy_msg", MSG.EN_Buy_msg, yamlConfigurationEN);
        set("Cost.No_money", MSG.EN_No_money, yamlConfigurationEN);
        set("Cost.NoInventorySpace", MSG.EN_NoInventorySpace, yamlConfigurationEN);

        set("ServerChange.onServerChange", MSG.EN_onServerChange, yamlConfigurationEN);

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
        set("Help.Give", MSG.EN_Help_Give, yamlConfigurationEN);
        set("Help.CreateDefaultGUI", MSG.EN_Help_CreateDefaultGUI, yamlConfigurationEN);
        set("Help.Reload", MSG.EN_Help_Reload, yamlConfigurationEN);
        set("Help.UseItem_On", MSG.EN_GUIItemHelp_on, yamlConfigurationEN);
        set("Help.UseItem_Off", MSG.EN_GUIItemHelp_off, yamlConfigurationEN);
        set("Help.UseItem_Slot", MSG.EN_GUIItemHelp_Slot, yamlConfigurationEN);

        try {
            yamlConfigurationEN.save(messagesEN);
        } catch (IOException e) {
            send.warning(plugin,e.getMessage());
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
        set("Plugin.DefaultGUI.create", MSG.DE_DefaultGUI, yamlConfigurationDE);
        set("Plugin.Reload.Start", MSG.DE_ReloadStart, yamlConfigurationDE);
        set("Plugin.Reload.End", MSG.DE_ReloadEnd, yamlConfigurationDE);
        set("Plugin.Reload.Warning", MSG.DE_ReloadWarning, yamlConfigurationDE);

        set("NoPermission.ForCommandGUI", MSG.DE_NoPermission, yamlConfigurationDE);
        set("NoPermission.ForCommand", MSG.DE_NoPermissionForCommand, yamlConfigurationDE);
        set("NoPermission.ForUseItem", MSG.DE_NoPermissionForUseItem, yamlConfigurationDE);
        set("NoPermission.ForItem", MSG.DE_NoPermissionForItem, yamlConfigurationDE);

        set("UseItem.UseItem_ON", MSG.DE_ItemON, yamlConfigurationDE);
        set("UseItem.UseItem_OFF", MSG.DE_ItemOFF, yamlConfigurationDE);
        set("UseItem.Change_Slot", MSG.DE_ItemSlot, yamlConfigurationDE);
        set("UseItem.SlotNotEmpty", MSG.DE_ItemSlotNotEmpty, yamlConfigurationDE);
        set("UseItem.SlotAlreadySet", MSG.DE_ItemSlotAlreadySet, yamlConfigurationDE);
        set("UseItem.ItemSlot_wrongValue", MSG.DE_ItemSlot_wrongValue, yamlConfigurationDE);

        set("Cost.Buy_msg", MSG.DE_Buy_msg, yamlConfigurationDE);
        set("Cost.No_money", MSG.DE_No_money, yamlConfigurationDE);
        set("Cost.NoInventorySpace", MSG.DE_NoInventorySpace, yamlConfigurationDE);

        set("ServerChange.onServerChange", MSG.DE_onServerChange, yamlConfigurationDE);

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
        set("Help.UseItem_On", MSG.DE_GUIItemHelp_on, yamlConfigurationDE);
        set("Help.UseItem_Off", MSG.DE_GUIItemHelp_off, yamlConfigurationDE);
        set("Help.UseItem_Slot", MSG.DE_GUIItemHelp_Slot, yamlConfigurationDE);

        try {
            yamlConfigurationDE.save(messagesDE);
        } catch (IOException e) {
            send.warning(plugin,e.getMessage());
            e.printStackTrace();
        }


        /**
         *
         * norwegian
         *
         */


        File messagesNO = new File(Main.getPath(), "languages/norwegian_messages.yml");
        YamlConfiguration yamlConfigurationNO = YamlConfiguration.loadConfiguration(messagesNO);

        set("Plugin.VaultNotSetUp", MSG.NO_VaultNotSetUp, yamlConfigurationNO);
        set("Plugin.SoundNotFound", MSG.NO_SoundNotFound, yamlConfigurationNO);
        set("Plugin.OnlyForPlayer", MSG.NO_OnlyForPlayer, yamlConfigurationNO);
        set("Plugin.DefaultGUI.create", MSG.NO_DefaultGUI, yamlConfigurationNO);
        set("Plugin.Reload.Start", MSG.NO_ReloadStart, yamlConfigurationNO);
        set("Plugin.Reload.End", MSG.NO_ReloadEnd, yamlConfigurationNO);
        set("Plugin.Reload.Warning", MSG.NO_ReloadWarning, yamlConfigurationNO);

        set("NoPermission.ForCommandGUI", MSG.NO_NoPermission, yamlConfigurationNO);
        set("NoPermission.ForCommand", MSG.NO_NoPermissionForCommand, yamlConfigurationNO);
        set("NoPermission.ForUseItem", MSG.NO_NoPermissionForUseItem, yamlConfigurationNO);
        set("NoPermission.ForItem", MSG.NO_NoPermissionForItem, yamlConfigurationNO);

        set("UseItem.UseItem_ON", MSG.NO_ItemON, yamlConfigurationNO);
        set("UseItem.UseItem_OFF", MSG.NO_ItemOFF, yamlConfigurationNO);
        set("UseItem.Change_Slot", MSG.NO_ItemSlot, yamlConfigurationNO);
        set("UseItem.SlotNotEmpty", MSG.NO_ItemSlotNotEmpty, yamlConfigurationNO);
        set("UseItem.SlotAlreadySet", MSG.NO_ItemSlotAlreadySet, yamlConfigurationNO);
        set("UseItem.ItemSlot_wrongValue", MSG.NO_ItemSlot_wrongValue, yamlConfigurationNO);

        set("Cost.Buy_msg", MSG.NO_Buy_msg, yamlConfigurationNO);
        set("Cost.No_money", MSG.NO_No_money, yamlConfigurationNO);
        set("Cost.NoInventorySpace", MSG.NO_NoInventorySpace, yamlConfigurationNO);

        set("ServerChange.onServerChange", MSG.NO_onServerChange, yamlConfigurationNO);

        set("GUI.GUInotFound", MSG.NO_GUInotFound, yamlConfigurationNO);
        set("GUI.GUIisDisabled", MSG.NO_GUIisDisabled, yamlConfigurationNO);

        set("Give.Sender", MSG.NO_GiveSender, yamlConfigurationNO);
        set("Give.Receiver", MSG.NO_GiveReceiver, yamlConfigurationNO);

        set("Player.PlayerNotFond", MSG.NO_PlayerNotFond, yamlConfigurationNO);
        set("Player.PlayerNoInventorySpace", MSG.NO_PlayerNoInventorySpace, yamlConfigurationNO);

        set("Help.CGUI", MSG.NO_Help_CGUI, yamlConfigurationNO);
        set("Help.Help", MSG.NO_Help_Help, yamlConfigurationNO);
        set("Help.Info", MSG.NO_Help_Info, yamlConfigurationNO);
        set("Help.Open", MSG.NO_Help_Open, yamlConfigurationNO);
        set("Help.Give", MSG.NO_Help_Give, yamlConfigurationNO);
        set("Help.CreateDefaultGUI", MSG.NO_Help_CreateDefaultGUI, yamlConfigurationNO);
        set("Help.Reload", MSG.NO_Help_Reload, yamlConfigurationNO);
        set("Help.UseItem_On", MSG.NO_GUIItemHelp_on, yamlConfigurationNO);
        set("Help.UseItem_Off", MSG.NO_GUIItemHelp_off, yamlConfigurationNO);
        set("Help.UseItem_Slot", MSG.NO_GUIItemHelp_Slot, yamlConfigurationNO);

        try {
            yamlConfigurationNO.save(messagesNO);
        } catch (IOException e) {
            send.warning(plugin,e.getMessage());
            e.printStackTrace();
        }


        send.console(Main.Prefix + " §2Language files were successfully created / updated." + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
    }

    private static void set(String path, String value, YamlConfiguration config) {
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }
}
