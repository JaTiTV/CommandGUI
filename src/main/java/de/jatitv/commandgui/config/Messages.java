// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages {

    public static void messagesCreate(){


        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Messages.yml load...");


        File messagesYML = new File(Main.thisp().getDataFolder().getPath(), "Messages.yml");
        YamlConfiguration yamlConfiguration_msg = YamlConfiguration.loadConfiguration(messagesYML);


        if (!yamlConfiguration_msg.contains("Do_not_remove_or_change.Created")) {
            yamlConfiguration_msg.set("Do_not_remove_or_change.Created", "This file was created with version " + Main.getPlugin().getDescription().getVersion());
        }

        yamlConfiguration_msg.set("Do_not_remove_or_change.Version", Main.getPlugin().getDescription().getVersion());

        yamlConfiguration_msg.set("Do_not_remove_or_change.Autor", Main.Autor);

        yamlConfiguration_msg.set("Do_not_remove_or_change.Spigot", Main.Spigot);

        yamlConfiguration_msg.set("Do_not_remove_or_change.Discord", Main.DiscordMSG);


        if (yamlConfiguration_msg.contains("Plugin.NoPermissionForCommand")) {
            DefultValue.NoPermissionForCommand = replace(yamlConfiguration_msg.getString("Plugin.NoPermissionForCommand"));
        } else {
            yamlConfiguration_msg.set("Plugin.NoPermissionForCommand", "[prefix] &cFor &b[cmd] &cyou lack the permission &6[perm]&c!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6NoPermissionForCommand §4was added to §9Messages.yml§4!");
        }
        if (yamlConfiguration_msg.contains("Plugin.NoPermission")) {
            DefultValue.NoPermission = replace(yamlConfiguration_msg.getString("Plugin.NoPermission"));
        } else {
            yamlConfiguration_msg.set("Plugin.NoPermission", "[prefix] &cYou do not have permission for &6Command&9GUI!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6NoPermission §4was added to §9Messages.yml§4!");
        }


        if (yamlConfiguration_msg.contains("Plugin.VaultNotSetUp")) {
            DefultValue.VaultNotSetUp = replace(yamlConfiguration_msg.getString("Plugin.VaultNotSetUp"));
        } else {
            yamlConfiguration_msg.set("Plugin.VaultNotSetUp", "[prefix] &4Vault / Economy not set up!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6VaultNotSetUp §4was added to §9Messages.yml§4!");
        }

        if (yamlConfiguration_msg.contains("Plugin.SoundNotFound")) {
            DefultValue.SoundNotFound = replace(yamlConfiguration_msg.getString("Plugin.SoundNotFound"));
        } else {
            yamlConfiguration_msg.set("Plugin.SoundNotFound", "[prefix] &4The sound &6[sound] &4could not be found! Please check your settings.");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6SoundNotFound §4was added to §9Messages.yml§4!");
        }

        if (yamlConfiguration_msg.contains("Plugin.Reload.Start")) {
            DefultValue.ReloadStart = replace(yamlConfiguration_msg.getString("Plugin.Reload.Start"));
        } else {
            yamlConfiguration_msg.set("Plugin.Reload.Start", "&6Plugin reload...");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Reload Start §4was added to §9Messages.yml§4!");
        }
        if (yamlConfiguration_msg.contains("Plugin.Reload.End")) {
            DefultValue.ReloadEnd = replace(yamlConfiguration_msg.getString("Plugin.Reload.End"));
        } else {
            yamlConfiguration_msg.set("Plugin.Reload.End", "&2Plugin successfully reloaded.");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Reload End §4was added to §9Messages.yml§4!");
        }



        if (yamlConfiguration_msg.contains("Help.CGUI")) {
            DefultValue.HelpHelp = replace(yamlConfiguration_msg.getString("Help.CGUI"));
        } else {
            yamlConfiguration_msg.set("Help.CGUI", "&8'&b/commandgui &8| &b/cgui&8' &eOpen the Default GUI &7(&r[gui]&7)&e.");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Help CGUI §4was added to §9Messages.yml§4!");
        }
        if (yamlConfiguration_msg.contains("Help.Help")) {
            DefultValue.HelpHelp = replace(yamlConfiguration_msg.getString("Help.Help"));
        } else {
            yamlConfiguration_msg.set("Help.Help", "&8'&b/commandgui help&8' &eOpens this help.");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Help Help §4was added to §9Messages.yml§4!");
        }
        if (yamlConfiguration_msg.contains("Help.Info")) {
            DefultValue.HelpHelp = replace(yamlConfiguration_msg.getString("Help.Info"));
        } else {
            yamlConfiguration_msg.set("Help.Info", "&8'&b/commandgui info&8' &eCall the info about &6Command&9GUI&e.");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Help Info §4was added to §9Messages.yml§4!");
        }
        if (yamlConfiguration_msg.contains("Help.GUI")) {
            DefultValue.HelpHelp = replace(yamlConfiguration_msg.getString("Help.GUI"));
        } else {
            yamlConfiguration_msg.set("Help.GUI", "&8'&b/commandgui [gui]&8' &eOpen the GUI: &6[guiname]&e.");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Help GUI §4was added to §9Messages.yml§4!");
        }
        if (yamlConfiguration_msg.contains("Help.Give")) {
            DefultValue.HelpHelp = replace(yamlConfiguration_msg.getString("Help.Give"));
        } else {
            yamlConfiguration_msg.set("Help.Give", "&8'&b/commandgui give &7<player> <gui>&8' &eGive a player a GUI Item.");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Help Give §4was added to §9Messages.yml§4!");
        }
        if (yamlConfiguration_msg.contains("Help.Reload")) {
            DefultValue.HelpHelp = replace(yamlConfiguration_msg.getString("Help.Reload"));
        } else {
            yamlConfiguration_msg.set("Help.Reload", "&8'&b/commandgui reload&8' &eReloads the Plugin.");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Help Reload §4was added to §9Messages.yml§4!");
        }



        if (yamlConfiguration_msg.contains("Cost.No_money")) {
            DefultValue.No_money = replace(yamlConfiguration_msg.getString("Cost.No_money"));
        } else {
            yamlConfiguration_msg.set("Cost.No_money", "[prefix] &cYou do not have enough money!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6No_money §4was added to §9Messages.yml§4!");
        }

        if (yamlConfiguration_msg.contains("Cost.NoInventorySpace")) {
            DefultValue.NoInventorySpace = replace(yamlConfiguration_msg.getString("Cost.NoInventorySpace"));
        } else {
            yamlConfiguration_msg.set("Cost.NoInventorySpace", "[prefix] &cNo free inventory space!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6NoInventorySpace §4was added to §9Messages.yml§4!");
        }

        if (yamlConfiguration_msg.contains("Cost.Buy_msg")) {
            DefultValue.Buy_msg = replace(yamlConfiguration_msg.getString("Cost.Buy_msg"));
        } else {
            yamlConfiguration_msg.set("Cost.Buy_msg", "[prefix] &2You bought [itemname] for &6[price]&2.");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Buy_msg §4was added to §9Messages.yml§4!");
        }

        if (yamlConfiguration_msg.contains("GUI.IsDisabled")) {
            DefultValue.GUIisDisable = replace(yamlConfiguration_msg.getString("GUI.IsDisabled"));
        } else {
            yamlConfiguration_msg.set("GUI.IsDisabled", "[prefix] &cThe GUI [gui] &cis currently disabled!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6GUI IsDisabled §4was added to §9Messages.yml§4!");
        }

        if (yamlConfiguration_msg.contains("Give.Sender")) {
            DefultValue.give = replace(yamlConfiguration_msg.getString("Give.Sender"));
        } else {
            yamlConfiguration_msg.set("Give.Sender", "[prefix] &2You gave &6[player] &2a [wonderbag]&2!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Give Sender §4was added to §9Messages.yml§4!");
        }

        if (yamlConfiguration_msg.contains("Give.Receiver")) {
            DefultValue.giveReceived = replace(yamlConfiguration_msg.getString("Give.Receiver"));
        } else {
            yamlConfiguration_msg.set("Give.Receiver", "[prefix] &2You have received a [wonderbag] &2from &6[sender]&2!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Give Receiver §4was added to §9Messages.yml§4!");
        }

        if (yamlConfiguration_msg.contains("Give.PlayerNotFond")) {
            DefultValue.PlayerNotFound = replace(yamlConfiguration_msg.getString("Give.PlayerNotFond"));
        } else {
            yamlConfiguration_msg.set("Give.PlayerNotFond", "[prefix] &cThe player &6[player] &cwas not found or is not online!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Give PlayerNotFond §4was added to §9Messages.yml§4!");
        }

        if (yamlConfiguration_msg.contains("Give.PlayerNoInventorySpace")) {
            DefultValue.PlayerNoInventorySpace = replace(yamlConfiguration_msg.getString("Give.PlayerNoInventorySpace"));
        } else {
            yamlConfiguration_msg.set("Give.PlayerNoInventorySpace", "[prefix] &6[player] &chas no free inventory space available!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Give PlayerNoInventorySpace §4was added to §9Messages.yml§4!");
        }

        try {
            yamlConfiguration_msg.save(messagesYML);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String replace(String Text) {

        return Text.replace("[prefix]", DefultValue.Prefix).replace("&", "§").replace("[ue]", "ü")
                .replace("[UE]", "Ü").replace("[oe]", "Ö").replace("[OE]", "Ö")
                .replace("[ae]", "ä").replace("[AE]", "Ä");
    }
}
