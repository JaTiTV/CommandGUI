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

        yamlConfiguration_msg.set("Do_not_remove_or_change.Discord", Main.Discord);


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

        if (yamlConfiguration_msg.contains("Shop.No_money")) {
            DefultValue.No_money = replace(yamlConfiguration_msg.getString("Shop.No_money"));
        } else {
            yamlConfiguration_msg.set("Shop.No_money", "[prefix] &cYou do not have enough money!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6No_money §4was added to §9Messages.yml§4!");
        }

        if (yamlConfiguration_msg.contains("Shop.Buy_msg")) {
            DefultValue.Buy_msg = replace(yamlConfiguration_msg.getString("Shop.Buy_msg"));
        } else {
            yamlConfiguration_msg.set("Shop.Buy_msg", "[prefix] §2You bought [itemname] for §6[price]&2.");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Message §6Buy_msg §4was added to §9Messages.yml§4!");
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
