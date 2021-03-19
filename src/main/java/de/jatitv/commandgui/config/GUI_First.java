// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_First;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GUI_First {

    public static void configCreate() {

        File guiFirstYML = new File(Main.thisp().getDataFolder().getPath(), "First_GUI.yml");
        YamlConfiguration yamlConfiguration_guifirst = YamlConfiguration.loadConfiguration(guiFirstYML);

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Config.yml load...");

        if (!yamlConfiguration_guifirst.contains("Do_not_remove_or_change.Created")) {
            yamlConfiguration_guifirst.set("Do_not_remove_or_change.Created", "This file was created with version " + Main.getPlugin().getDescription().getVersion());
        }

        yamlConfiguration_guifirst.set("Do_not_remove_or_change.Version", Main.getPlugin().getDescription().getVersion());

        yamlConfiguration_guifirst.set("Do_not_remove_or_change.Autor", Main.Autor);

        yamlConfiguration_guifirst.set("Do_not_remove_or_change.Spigot", Main.Spigot);

        yamlConfiguration_guifirst.set("Do_not_remove_or_change.Discord", Main.Discord);

        if (yamlConfiguration_guifirst.contains("UseItem.Enable")) {
            DefultValue_GUI_First.UseItem = yamlConfiguration_guifirst.getBoolean("UseItem.Enable");
        } else {
            yamlConfiguration_guifirst.set("UseItem.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6UseItem Enable §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("UseItem.Name")) {
            DefultValue_GUI_First.UseItem_Name = replace(yamlConfiguration_guifirst.getString("UseItem.Name"));
        } else {
            yamlConfiguration_guifirst.set("UseItem.Name", "&7Open the: [guiname]");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6UseItem Name §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("UseItem.Item")) {
            DefultValue_GUI_First.UseItem_Item = replace(yamlConfiguration_guifirst.getString("UseItem.Item").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_guifirst.set("UseItem.Item", DefultValue_GUI_First.UseItem_Item);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6UseItem Item §4was added to §9First_GUI.yml§4!");
        }


        if (yamlConfiguration_guifirst.contains("GUI.Name")) {
            DefultValue_GUI_First.FirstGUIName = replace(yamlConfiguration_guifirst.getString("GUI.Name"));
        } else {
            yamlConfiguration_guifirst.set("GUI.Name", "&6First GUI");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6GUI Name §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("GUI.FillItem")) {
            DefultValue_GUI_First.FillItem = replace(yamlConfiguration_guifirst.getString("GUI.FillItem").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_guifirst.set("GUI.FillItem", DefultValue_GUI_First.FillItem);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6GUI FillItem §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("GUI.Lines")) {
            DefultValue_GUI_First.GUILines = Integer.valueOf(yamlConfiguration_guifirst.getString("GUI.Lines"));
        } else {
            yamlConfiguration_guifirst.set("GUI.Lines", DefultValue_GUI_First.GUILines);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6GUI Lines §4was added to §9First_GUI.yml§4!");
        }
        if (yamlConfiguration_guifirst.getInt("GUI.Lines") > 6) {
            yamlConfiguration_guifirst.set("GUI.Lines", 6);
        }
        if (yamlConfiguration_guifirst.getInt("GUI.Lines") < 1) {
            yamlConfiguration_guifirst.set("GUI.Lines", 1);
        }

        if (yamlConfiguration_guifirst.contains("Permission.Enable")) {
            DefultValue_GUI_First.Permission_Enable = yamlConfiguration_guifirst.getBoolean("Permission.Enable");
        } else {
            yamlConfiguration_guifirst.set("Permission.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Permission Enable §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Permission.Permission")) {
            DefultValue_GUI_First.Permission = replace(yamlConfiguration_guifirst.getString("Permission.Permission"));
        } else {
            yamlConfiguration_guifirst.set("Permission.Permission", "commandgui.use.firstgui");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Permission §4was added to §9First_GUI.yml§4!");
        }



        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Enable")) {
            DefultValue_GUI_First.L1_S1_Enable = yamlConfiguration_guifirst.getBoolean("Line_1.Slot_1.Enable");
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Enable §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Item.Item")) {
            DefultValue_GUI_First.L1_S1_Item = replace(yamlConfiguration_guifirst.getString("Line_1.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Item.Item", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Item §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Item.Name")) {
            DefultValue_GUI_First.L1_S1_Name = replace(yamlConfiguration_guifirst.getString("Line_1.Slot_1.Item.Name"));
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Item.Name", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Name §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Item.Lore")) {
            //DefultValue_GUI_First.Slot_1_Lore = yamlConfiguration_guifirst.getList("Line_1.Slot_1.Item.Lore");
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Item.Lore", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Lore §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Cost.Enable")) {
            DefultValue_GUI_First.L1_S1_Cost_Enable = yamlConfiguration_guifirst.getBoolean("Line_1.Slot_1.Cost.Enable");
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Cost.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Cost Enable §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Cost.Price")) {
            DefultValue_GUI_First.L1_S1_Price = (yamlConfiguration_guifirst.getDouble("Line_1.Slot_1.Cost.Price"));
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Cost.Price", DefultValue_GUI_First.L1_S1_Price);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Cost Price §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Command.Enable")) {
            DefultValue_GUI_First.L1_S1_Command_Enable = yamlConfiguration_guifirst.getBoolean("Line_1.Slot_1.Command.Enable");
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Command.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Command Enable §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Command.Command")) {
            DefultValue_GUI_First.L1_S1_Command = replace(yamlConfiguration_guifirst.getString("Line_1.Slot_1.Command.Command"));
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Command.Command", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Command Command §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Message.Enable")) {
            DefultValue_GUI_First.L1_S1_Message_Enable = yamlConfiguration_guifirst.getBoolean("Line_1.Slot_1.Message.Enable");
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Message.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Message Enable §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Message.Message")) {
            DefultValue_GUI_First.L1_S1_Message = replace(yamlConfiguration_guifirst.getString("Line_1.Slot_1.Message.Message"));
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Message.Message", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Message §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Permission.Enable")) {
            DefultValue_GUI_First.L1_S1_Permission_Enable = yamlConfiguration_guifirst.getBoolean("Line_1.Slot_1.Permission.Enable");
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Permission.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Permission Enable §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_guifirst.contains("Line_1.Slot_1.Permission.Permission")) {
            DefultValue_GUI_First.L1_S1_Permission = replace(yamlConfiguration_guifirst.getString("Line_1.Slot_1.Permission.Permission"));
        } else {
            yamlConfiguration_guifirst.set("Line_1.Slot_1.Permission.Permission", "commandgui.use.firstgui.line1.slot1");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Permission §4was added to §9First_GUI.yml§4!");
        }


        try {
            yamlConfiguration_guifirst.save(guiFirstYML);
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
