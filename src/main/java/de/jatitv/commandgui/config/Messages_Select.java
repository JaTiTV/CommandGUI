// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defultValue.DefaultValue;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Messages_Select {

    public static String selectMSG;
    public static String sel;

    public static void selectCreate() {

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Select language...");


        switch (DefaultValue.language) {
            case "de_DE":
                selectMSG = "German";
                sel = "de_DE";
                break;
            case "fr_FR":
                selectMSG = "French";
                sel = "fr_FR";
                break;
            case "no_NO":
                selectMSG = "Norwegian";
                sel = "no_NO";
                break;
            default:
                selectMSG = "English";
                sel = "en_EN";
                break;
        }

        File messagesYML = new File(Main.thisp().getDataFolder().getPath(), "languages/" + sel + "_Messages.yml");
        YamlConfiguration yamlConfiguration_msg = YamlConfiguration.loadConfiguration(messagesYML);
        DefaultValue.NoPermission = replace(yamlConfiguration_msg.getString("Plugin.NoPermission"));
        DefaultValue.NoPermissionForCommand = replace(yamlConfiguration_msg.getString("Plugin.NoPermissionForCommand"));
        DefaultValue.NoPermissionForItem = replace(yamlConfiguration_msg.getString("Plugin.NoPermissionForItem"));
        DefaultValue.VaultNotSetUp = replace(yamlConfiguration_msg.getString("Plugin.VaultNotSetUp"));
        DefaultValue.SoundNotFound = replace(yamlConfiguration_msg.getString("Plugin.SoundNotFound"));
        DefaultValue.ReloadStart = replace(yamlConfiguration_msg.getString("Plugin.Reload.Start"));
        DefaultValue.ReloadEnd = replace(yamlConfiguration_msg.getString("Plugin.Reload.End"));
        DefaultValue.HelpCgui = replace(yamlConfiguration_msg.getString("Help.CGUI"));
        DefaultValue.HelpHelp = replace(yamlConfiguration_msg.getString("Help.Help"));
        DefaultValue.HelpInfo = replace(yamlConfiguration_msg.getString("Help.Info"));
        DefaultValue.HelpOpen = replace(yamlConfiguration_msg.getString("Help.Open"));
        DefaultValue.HelpGive = replace(yamlConfiguration_msg.getString("Help.Give"));
        DefaultValue.HelpReload = replace(yamlConfiguration_msg.getString("Help.Reload"));
        DefaultValue.No_money = replace(yamlConfiguration_msg.getString("Cost.No_money"));
        DefaultValue.NoInventorySpace = replace(yamlConfiguration_msg.getString("Cost.NoInventorySpace"));
        DefaultValue.Buy_msg = replace(yamlConfiguration_msg.getString("Cost.Buy_msg"));
        DefaultValue.GUIisDisable = replace(yamlConfiguration_msg.getString("GUI.IsDisabled"));
        DefaultValue.give = replace(yamlConfiguration_msg.getString("Give.Sender"));
        DefaultValue.giveReceived = replace(yamlConfiguration_msg.getString("Give.Receiver"));
        DefaultValue.PlayerNotFound = replace(yamlConfiguration_msg.getString("Give.PlayerNotFond"));
        DefaultValue.PlayerNoInventorySpace = replace(yamlConfiguration_msg.getString("Give.PlayerNoInventorySpace"));

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Language successfully selected to: §6" + selectMSG);
    }

    private static String replace(String Text) {
        return Text.replace("[prefix]", DefaultValue.PrefixHC).replace("&", "§").replace("[ue]", "ü")
                .replace("[UE]", "Ü").replace("[oe]", "Ö").replace("[OE]", "Ö")
                .replace("[ae]", "ä").replace("[AE]", "Ä");
    }
}
