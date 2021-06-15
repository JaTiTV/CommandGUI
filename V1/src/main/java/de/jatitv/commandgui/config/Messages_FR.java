// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defaultValue.DefaultValue;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages_FR {

    public static void messagesCreate(String version) {

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4FR_Messages.yml load...");

        File messagesFRYML = new File(Main.thisp().getDataFolder().getPath(), "languages/fr_FR_Messages.yml");
        YamlConfiguration yamlConfiguration_FRmsg = YamlConfiguration.loadConfiguration(messagesFRYML);

        if (!yamlConfiguration_FRmsg.contains("Do_not_remove_or_change.Created"))
            yamlConfiguration_FRmsg.set("Do_not_remove_or_change.Created", "This file was created with version " + version);
        yamlConfiguration_FRmsg.set("Do_not_remove_or_change.Version", version);
        yamlConfiguration_FRmsg.set("Do_not_remove_or_change.Autor", Main.Autor);
        yamlConfiguration_FRmsg.set("Do_not_remove_or_change.Spigot", Main.Spigot);
        yamlConfiguration_FRmsg.set("Do_not_remove_or_change.Discord", Main.DiscordMSG);

        if (!yamlConfiguration_FRmsg.contains("Plugin.NoPermission")) {
            yamlConfiguration_FRmsg.set("Plugin.NoPermission", DefaultValue.FR_NoPermission.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermission §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Plugin.NoPermissionForCommand")) {
            yamlConfiguration_FRmsg.set("Plugin.NoPermissionForCommand", DefaultValue.FR_NoPermissionForCommand.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermissionForCommand §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Plugin.NoPermissionForItem")) {
            yamlConfiguration_FRmsg.set("Plugin.NoPermissionForItem", DefaultValue.FR_NoPermissionForItem.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermissionForItem §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Plugin.VaultNotSetUp")) {
            yamlConfiguration_FRmsg.set("Plugin.VaultNotSetUp", DefaultValue.FR_VaultNotSetUp.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6VaultNotSetUp §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Plugin.SoundNotFound")) {
            yamlConfiguration_FRmsg.set("Plugin.SoundNotFound", DefaultValue.FR_SoundNotFound.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6SoundNotFound §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Plugin.Reload.Start")) {
            yamlConfiguration_FRmsg.set("Plugin.Reload.Start", DefaultValue.FR_ReloadStart.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Reload Start §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Plugin.Reload.End")) {
            yamlConfiguration_FRmsg.set("Plugin.Reload.End", DefaultValue.FR_ReloadEnd.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Reload End §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Help.CGUI")) {
            yamlConfiguration_FRmsg.set("Help.CGUI", DefaultValue.FR_HelpCgui.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + DefaultValue.HelpCgui.replace("§8[§6C§9GUI§8]", "[prefix]").replace("§", "&"));
        }
        if (!yamlConfiguration_FRmsg.contains("Help.Help")) {
            yamlConfiguration_FRmsg.set("Help.Help", DefaultValue.FR_HelpHelp.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Help §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Help.Info")) {
            yamlConfiguration_FRmsg.set("Help.Info", DefaultValue.FR_HelpInfo.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Info §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Help.Open")) {
            yamlConfiguration_FRmsg.set("Help.Open", DefaultValue.FR_HelpOpen.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Open §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Help.Give")) {
            yamlConfiguration_FRmsg.set("Help.Give", DefaultValue.FR_HelpGive.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Give §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Help.Reload")) {
            yamlConfiguration_FRmsg.set("Help.Reload", DefaultValue.FR_HelpReload.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Reload §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Cost.Buy_msg")) {
            yamlConfiguration_FRmsg.set("Cost.Buy_msg", DefaultValue.FR_Buy_msg.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Buy_msg §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Cost.No_money")) {
            yamlConfiguration_FRmsg.set("Cost.No_money", DefaultValue.FR_No_money.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6No_money §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Cost.NoInventorySpace")) {
            yamlConfiguration_FRmsg.set("Cost.NoInventorySpace", DefaultValue.FR_NoInventorySpace.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoInventorySpace §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("GUI.IsDisabled")) {
            yamlConfiguration_FRmsg.set("GUI.IsDisabled", DefaultValue.FR_GUIisDisable.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6GUI IsDisabled §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Give.Sender")) {
            yamlConfiguration_FRmsg.set("Give.Sender", DefaultValue.FR_give.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give Sender §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Give.Receiver")) {
            yamlConfiguration_FRmsg.set("Give.Receiver", DefaultValue.FR_giveReceived.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give Receiver §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Give.PlayerNotFond")) {
            yamlConfiguration_FRmsg.set("Give.PlayerNotFond", DefaultValue.FR_PlayerNotFound.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give PlayerNotFond §4was added to §9FR_Messages.yml§4!");
        }
        if (!yamlConfiguration_FRmsg.contains("Give.PlayerNoInventorySpace")) {
            yamlConfiguration_FRmsg.set("Give.PlayerNoInventorySpace", DefaultValue.FR_PlayerNoInventorySpace.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesFRYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give PlayerNoInventorySpace §4was added to §9FR_Messages.yml§4!");
        }
        try {
            yamlConfiguration_FRmsg.save(messagesFRYML);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2FR_Messages.yml loaded successfully.");

    }
}
