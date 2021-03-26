// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defultValue.DefaultValue;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Messages_Select {

    public static void selectCreate() {

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Select language...");

        String selectMSG;
        String sel;

        if (DefaultValue.language.equals("DE")) {
            selectMSG = "German";
            sel = "DE";
        } else if (DefaultValue.language.equals("EN")) {
            selectMSG = "English";
            sel = "EN";
        } else {
            selectMSG = "English";
            sel = "EN";
        }

        File messagesDEYML = new File(Main.thisp().getDataFolder().getPath(), "languages/" + sel + "_Messages.yml");
        YamlConfiguration yamlConfiguration_DEmsg = YamlConfiguration.loadConfiguration(messagesDEYML);
        DefaultValue.NoPermission = replace(yamlConfiguration_DEmsg.getString("Plugin.NoPermission"));
        DefaultValue.NoPermissionForCommand = replace(yamlConfiguration_DEmsg.getString("Plugin.NoPermissionForCommand"));
        DefaultValue.NoPermissionForItem = replace(yamlConfiguration_DEmsg.getString("Plugin.NoPermissionForItem"));
        DefaultValue.VaultNotSetUp = replace(yamlConfiguration_DEmsg.getString("Plugin.VaultNotSetUp"));
        DefaultValue.SoundNotFound = replace(yamlConfiguration_DEmsg.getString("Plugin.SoundNotFound"));
        DefaultValue.ReloadStart = replace(yamlConfiguration_DEmsg.getString("Plugin.Reload.Start"));
        DefaultValue.ReloadEnd = replace(yamlConfiguration_DEmsg.getString("Plugin.Reload.End"));
        DefaultValue.HelpCgui = replace(yamlConfiguration_DEmsg.getString("Help.CGUI"));
        DefaultValue.HelpHelp = replace(yamlConfiguration_DEmsg.getString("Help.Help"));
        DefaultValue.HelpInfo = replace(yamlConfiguration_DEmsg.getString("Help.Info"));
        DefaultValue.HelpOpen = replace(yamlConfiguration_DEmsg.getString("Help.Open"));
        DefaultValue.HelpGive = replace(yamlConfiguration_DEmsg.getString("Help.Give"));
        DefaultValue.HelpReload = replace(yamlConfiguration_DEmsg.getString("Help.Reload"));
        DefaultValue.No_money = replace(yamlConfiguration_DEmsg.getString("Cost.No_money"));
        DefaultValue.NoInventorySpace = replace(yamlConfiguration_DEmsg.getString("Cost.NoInventorySpace"));
        DefaultValue.Buy_msg = replace(yamlConfiguration_DEmsg.getString("Cost.Buy_msg"));
        DefaultValue.GUIisDisable = replace(yamlConfiguration_DEmsg.getString("GUI.IsDisabled"));
        DefaultValue.give = replace(yamlConfiguration_DEmsg.getString("Give.Sender"));
        DefaultValue.giveReceived = replace(yamlConfiguration_DEmsg.getString("Give.Receiver"));
        DefaultValue.PlayerNotFound = replace(yamlConfiguration_DEmsg.getString("Give.PlayerNotFond"));
        DefaultValue.PlayerNoInventorySpace = replace(yamlConfiguration_DEmsg.getString("Give.PlayerNoInventorySpace"));

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Language successfully selected to: §6" + selectMSG);
    }

    private static String replace(String Text) {
        return Text.replace("[prefix]", DefaultValue.PrefixHC).replace("&", "§").replace("[ue]", "ü")
                .replace("[UE]", "Ü").replace("[oe]", "Ö").replace("[OE]", "Ö")
                .replace("[ae]", "ä").replace("[AE]", "Ä");
    }
}
