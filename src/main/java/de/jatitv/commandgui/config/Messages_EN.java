// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defaultValue.DefaultValue;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages_EN {

    public static void messagesCreate(String version) {

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4EN_Messages.yml load...");

        File messagesENYML = new File(Main.thisp().getDataFolder().getPath(), "languages/en_EN_Messages.yml");
        YamlConfiguration yamlConfiguration_ENmsg = YamlConfiguration.loadConfiguration(messagesENYML);

        if (!yamlConfiguration_ENmsg.contains("Do_not_remove_or_change.Created"))
            yamlConfiguration_ENmsg.set("Do_not_remove_or_change.Created", "This file was created with version " + version);
        yamlConfiguration_ENmsg.set("Do_not_remove_or_change.Version", version);
        yamlConfiguration_ENmsg.set("Do_not_remove_or_change.Autor", Main.Autor);
        yamlConfiguration_ENmsg.set("Do_not_remove_or_change.Spigot", Main.Spigot);
        yamlConfiguration_ENmsg.set("Do_not_remove_or_change.Discord", Main.DiscordMSG);

        if (!yamlConfiguration_ENmsg.contains("Plugin.NoPermission")) {
            yamlConfiguration_ENmsg.set("Plugin.NoPermission", DefaultValue.NoPermission.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermission §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Plugin.NoPermissionForCommand")) {
            yamlConfiguration_ENmsg.set("Plugin.NoPermissionForCommand", DefaultValue.NoPermissionForCommand.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermissionForCommand §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Plugin.NoPermissionForItem")) {
            yamlConfiguration_ENmsg.set("Plugin.NoPermissionForItem", DefaultValue.NoPermissionForItem.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermissionForItem §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Plugin.VaultNotSetUp")) {
            yamlConfiguration_ENmsg.set("Plugin.VaultNotSetUp", DefaultValue.VaultNotSetUp.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6VaultNotSetUp §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Plugin.SoundNotFound")) {
            yamlConfiguration_ENmsg.set("Plugin.SoundNotFound", DefaultValue.SoundNotFound.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6SoundNotFound §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Plugin.Reload.Start")) {
            yamlConfiguration_ENmsg.set("Plugin.Reload.Start", DefaultValue.ReloadStart.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Reload Start §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Plugin.Reload.End")) {
            yamlConfiguration_ENmsg.set("Plugin.Reload.End", DefaultValue.ReloadEnd.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Reload End §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Help.CGUI")) {
            yamlConfiguration_ENmsg.set("Help.CGUI", DefaultValue.HelpCgui.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + DefaultValue.HelpCgui.replace("§8[§6C§9GUI§8]", "[prefix]").replace("§", "&"));
        }
        if (!yamlConfiguration_ENmsg.contains("Help.Help")) {
            yamlConfiguration_ENmsg.set("Help.Help", DefaultValue.HelpHelp.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Help §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Help.Info")) {
            yamlConfiguration_ENmsg.set("Help.Info", DefaultValue.HelpInfo.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Info §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Help.Open")) {
            yamlConfiguration_ENmsg.set("Help.Open", DefaultValue.HelpOpen.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Open §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Help.Give")) {
            yamlConfiguration_ENmsg.set("Help.Give", DefaultValue.HelpGive.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Give §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Help.Reload")) {
            yamlConfiguration_ENmsg.set("Help.Reload", DefaultValue.HelpReload.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Reload §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Cost.Buy_msg")) {
            yamlConfiguration_ENmsg.set("Cost.Buy_msg", DefaultValue.Buy_msg.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Buy_msg §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Cost.No_money")) {
            yamlConfiguration_ENmsg.set("Cost.No_money", DefaultValue.No_money.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6No_money §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Cost.NoInventorySpace")) {
            yamlConfiguration_ENmsg.set("Cost.NoInventorySpace", DefaultValue.NoInventorySpace.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoInventorySpace §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("GUI.IsDisabled")) {
            yamlConfiguration_ENmsg.set("GUI.IsDisabled", DefaultValue.GUIisDisable.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6GUI IsDisabled §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Give.Sender")) {
            yamlConfiguration_ENmsg.set("Give.Sender", DefaultValue.give.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give Sender §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Give.Receiver")) {
            yamlConfiguration_ENmsg.set("Give.Receiver", DefaultValue.giveReceived.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give Receiver §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Give.PlayerNotFond")) {
            yamlConfiguration_ENmsg.set("Give.PlayerNotFond", DefaultValue.PlayerNotFound.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give PlayerNotFond §4was added to §9EN_Messages.yml§4!");
        }
        if (!yamlConfiguration_ENmsg.contains("Give.PlayerNoInventorySpace")) {
            yamlConfiguration_ENmsg.set("Give.PlayerNoInventorySpace", DefaultValue.PlayerNoInventorySpace.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesENYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give PlayerNoInventorySpace §4was added to §9EN_Messages.yml§4!");
        }
        try {
            yamlConfiguration_ENmsg.save(messagesENYML);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2EN_Messages.yml loaded successfully.");

    }

}
