// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defultValue.DefaultValue;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages_DE {

    public static void messagesCreate() {

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4DE_Messages.yml load...");

        File messagesDEYML = new File(Main.thisp().getDataFolder().getPath(), "languages/DE_Messages.yml");
        YamlConfiguration yamlConfiguration_DEmsg = YamlConfiguration.loadConfiguration(messagesDEYML);

        if (!yamlConfiguration_DEmsg.contains("Do_not_remove_or_change.Created")) yamlConfiguration_DEmsg.set("Do_not_remove_or_change.Created", "This file was created with version " + Main.getPlugin().getDescription().getVersion());
        yamlConfiguration_DEmsg.set("Do_not_remove_or_change.Version", Main.getPlugin().getDescription().getVersion());
        yamlConfiguration_DEmsg.set("Do_not_remove_or_change.Autor", Main.Autor);
        yamlConfiguration_DEmsg.set("Do_not_remove_or_change.Spigot", Main.Spigot);
        yamlConfiguration_DEmsg.set("Do_not_remove_or_change.Discord", Main.DiscordMSG);

        if (!yamlConfiguration_DEmsg.contains("Plugin.NoPermission")) {
            yamlConfiguration_DEmsg.set("Plugin.NoPermission", DefaultValue.DE_NoPermission.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermission §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Plugin.NoPermissionForCommand")) {
            yamlConfiguration_DEmsg.set("Plugin.NoPermissionForCommand", DefaultValue.DE_NoPermissionForCommand.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermissionForCommand §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Plugin.NoPermissionForItem")) {
            yamlConfiguration_DEmsg.set("Plugin.NoPermissionForItem", DefaultValue.DE_NoPermissionForItem.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoPermissionForItem §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Plugin.VaultNotSetUp")) {
            yamlConfiguration_DEmsg.set("Plugin.VaultNotSetUp", DefaultValue.DE_VaultNotSetUp.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6VaultNotSetUp §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Plugin.SoundNotFound")) {
            yamlConfiguration_DEmsg.set("Plugin.SoundNotFound", DefaultValue.DE_SoundNotFound.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6SoundNotFound §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Plugin.Reload.Start")) {
            yamlConfiguration_DEmsg.set("Plugin.Reload.Start", DefaultValue.DE_ReloadStart.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Reload Start §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Plugin.Reload.End")) {
            yamlConfiguration_DEmsg.set("Plugin.Reload.End", DefaultValue.DE_ReloadEnd.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Reload End §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Help.CGUI")) {
            yamlConfiguration_DEmsg.set("Help.CGUI", DefaultValue.DE_HelpCgui.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + DefaultValue.HelpCgui.replace("§8[§6C§9GUI§8]", "[prefix]").replace("§", "&"));
        }
        if (!yamlConfiguration_DEmsg.contains("Help.Help")) {
            yamlConfiguration_DEmsg.set("Help.Help", DefaultValue.DE_HelpHelp.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Help §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Help.Info")) {
            yamlConfiguration_DEmsg.set("Help.Info", DefaultValue.DE_HelpInfo.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Info §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Help.Open")) {
            yamlConfiguration_DEmsg.set("Help.Open", DefaultValue.DE_HelpOpen.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Open §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Help.Give")) {
            yamlConfiguration_DEmsg.set("Help.Give", DefaultValue.DE_HelpGive.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Give §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Help.Reload")) {
            yamlConfiguration_DEmsg.set("Help.Reload", DefaultValue.DE_HelpReload.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Help Reload §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Cost.Buy_msg")) {
            yamlConfiguration_DEmsg.set("Cost.Buy_msg", DefaultValue.DE_Buy_msg.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Buy_msg §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Cost.No_money")) {
            yamlConfiguration_DEmsg.set("Cost.No_money", DefaultValue.DE_No_money.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6No_money §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Cost.NoInventorySpace")) {
            yamlConfiguration_DEmsg.set("Cost.NoInventorySpace", DefaultValue.DE_NoInventorySpace.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6NoInventorySpace §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("GUI.IsDisabled")) {
            yamlConfiguration_DEmsg.set("GUI.IsDisabled", DefaultValue.DE_GUIisDisable.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6GUI IsDisabled §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Give.Sender")) {
            yamlConfiguration_DEmsg.set("Give.Sender", DefaultValue.DE_give.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give Sender §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Give.Receiver")) {
            yamlConfiguration_DEmsg.set("Give.Receiver", DefaultValue.DE_giveReceived.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give Receiver §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Give.PlayerNotFond")) {
            yamlConfiguration_DEmsg.set("Give.PlayerNotFond", DefaultValue.DE_PlayerNotFound.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give PlayerNotFond §4was added to §9DE_Messages.yml§4!");
        }
        if (!yamlConfiguration_DEmsg.contains("Give.PlayerNoInventorySpace")) {
            yamlConfiguration_DEmsg.set("Give.PlayerNoInventorySpace", DefaultValue.DE_PlayerNoInventorySpace.replace(DefaultValue.Prefix, "[prefix]").replace("§", "&"));
            if (messagesDEYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Message §6Give PlayerNoInventorySpace §4was added to §9DE_Messages.yml§4!");
        }
        try {
            yamlConfiguration_DEmsg.save(messagesDEYML);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2DE_Messages.yml loaded successfully.");

    }
}
