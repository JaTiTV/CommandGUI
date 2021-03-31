// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defaultValue.DefaultValue;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages_NO {

    public static void messagesCreate(String version) {

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4NO_Messages.yml load...");

        File messagesNOYML = new File(Main.thisp().getDataFolder().getPath(), "languages/no_NO_Messages.yml");
        YamlConfiguration yamlConfiguration_NOmsg = YamlConfiguration.loadConfiguration(messagesNOYML);

        if (!yamlConfiguration_NOmsg.contains("Do_not_remove_or_change.Created"))
            yamlConfiguration_NOmsg.set("Do_not_remove_or_change.Created", "This file was created with version " + version);
        yamlConfiguration_NOmsg.set("Do_not_remove_or_change.Version", version);
        yamlConfiguration_NOmsg.set("Do_not_remove_or_change.Autor", Main.Autor);
        yamlConfiguration_NOmsg.set("Do_not_remove_or_change.Spigot", Main.Spigot);
        yamlConfiguration_NOmsg.set("Do_not_remove_or_change.Discord", Main.DiscordMSG);

        if (!yamlConfiguration_NOmsg.contains("Plugin.NoPermission")) {
            yamlConfiguration_NOmsg.set("Plugin.NoPermission", DefaultValue.NO_NoPermission.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermission §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Plugin.NoPermissionForCommand")) {
            yamlConfiguration_NOmsg.set("Plugin.NoPermissionForCommand", DefaultValue.NO_NoPermissionForCommand.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermissionForCommand §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Plugin.NoPermissionForItem")) {
            yamlConfiguration_NOmsg.set("Plugin.NoPermissionForItem", DefaultValue.NO_NoPermissionForItem.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermissionForItem §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Plugin.VaultNotSetUp")) {
            yamlConfiguration_NOmsg.set("Plugin.VaultNotSetUp", DefaultValue.NO_VaultNotSetUp.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6VaultNotSetUp §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Plugin.SoundNotFound")) {
            yamlConfiguration_NOmsg.set("Plugin.SoundNotFound", DefaultValue.NO_SoundNotFound.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6SoundNotFound §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Plugin.Reload.Start")) {
            yamlConfiguration_NOmsg.set("Plugin.Reload.Start", DefaultValue.NO_ReloadStart.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Reload Start §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Plugin.Reload.End")) {
            yamlConfiguration_NOmsg.set("Plugin.Reload.End", DefaultValue.NO_ReloadEnd.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Reload End §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Help.CGUI")) {
            yamlConfiguration_NOmsg.set("Help.CGUI", DefaultValue.NO_HelpCgui.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + DefaultValue.HelpCgui.replace("§8[§6C§9GUI§8]", "[prefix]").replace("§", "&"));
        }
        if (!yamlConfiguration_NOmsg.contains("Help.Help")) {
            yamlConfiguration_NOmsg.set("Help.Help", DefaultValue.NO_HelpHelp.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Help §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Help.Info")) {
            yamlConfiguration_NOmsg.set("Help.Info", DefaultValue.NO_HelpInfo.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Info §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Help.Open")) {
            yamlConfiguration_NOmsg.set("Help.Open", DefaultValue.NO_HelpOpen.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Open §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Help.Give")) {
            yamlConfiguration_NOmsg.set("Help.Give", DefaultValue.NO_HelpGive.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Give §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Help.Reload")) {
            yamlConfiguration_NOmsg.set("Help.Reload", DefaultValue.NO_HelpReload.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Reload §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Cost.Buy_msg")) {
            yamlConfiguration_NOmsg.set("Cost.Buy_msg", DefaultValue.NO_Buy_msg.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Buy_msg §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Cost.No_money")) {
            yamlConfiguration_NOmsg.set("Cost.No_money", DefaultValue.NO_No_money.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6No_money §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Cost.NoInventorySpace")) {
            yamlConfiguration_NOmsg.set("Cost.NoInventorySpace", DefaultValue.NO_NoInventorySpace.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoInventorySpace §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("GUI.IsDisabled")) {
            yamlConfiguration_NOmsg.set("GUI.IsDisabled", DefaultValue.NO_GUIisDisable.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6GUI IsDisabled §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Give.Sender")) {
            yamlConfiguration_NOmsg.set("Give.Sender", DefaultValue.NO_give.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give Sender §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Give.Receiver")) {
            yamlConfiguration_NOmsg.set("Give.Receiver", DefaultValue.NO_giveReceived.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give Receiver §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Give.PlayerNotFond")) {
            yamlConfiguration_NOmsg.set("Give.PlayerNotFond", DefaultValue.NO_PlayerNotFound.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give PlayerNotFond §4was added to §9NO_Messages.yml§4!");
        }
        if (!yamlConfiguration_NOmsg.contains("Give.PlayerNoInventorySpace")) {
            yamlConfiguration_NOmsg.set("Give.PlayerNoInventorySpace", DefaultValue.NO_PlayerNoInventorySpace.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesNOYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give PlayerNoInventorySpace §4was added to §9NO_Messages.yml§4!");
        }
        try {
            yamlConfiguration_NOmsg.save(messagesNOYML);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2NO_Messages.yml loaded successfully.");

    }
}
