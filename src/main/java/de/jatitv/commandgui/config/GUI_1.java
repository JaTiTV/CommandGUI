// This claas was created by JaTiTV

package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_1;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUI_1 {

    public static void configCreate() {

        File gui1YML = new File(Main.thisp().getDataFolder().getPath(), "GUIs/" + "GUI_1.yml");
        YamlConfiguration yamlConfiguration_gui1 = YamlConfiguration.loadConfiguration(gui1YML);

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Config.yml load...");

        if (!yamlConfiguration_gui1.contains("Do_not_remove_or_change.Created")) {
            yamlConfiguration_gui1.set("Do_not_remove_or_change.Created", "This file was created with version " + Main.getPlugin().getDescription().getVersion());
        }

        yamlConfiguration_gui1.set("Do_not_remove_or_change.Version", Main.getPlugin().getDescription().getVersion());

        yamlConfiguration_gui1.set("Do_not_remove_or_change.Autor", Main.Autor);

        yamlConfiguration_gui1.set("Do_not_remove_or_change.Spigot", Main.Spigot);

        yamlConfiguration_gui1.set("Do_not_remove_or_change.Discord", Main.DiscordMSG);


        if (yamlConfiguration_gui1.contains("GUI.Enable")) {
            DefultValue_GUI_1.GUI_Enable = (yamlConfiguration_gui1.getBoolean("GUI.Enable"));
        } else {
            yamlConfiguration_gui1.set("GUI.Enable", true);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6GUI Enable §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_gui1.contains("GUI.Name")) {
            DefultValue_GUI_1.GUIName = replace(yamlConfiguration_gui1.getString("GUI.Name"));
        } else {
            yamlConfiguration_gui1.set("GUI.Name", "&9GUI &51");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6GUI Name §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_gui1.contains("GUI.FillItem.Enable")) {
            DefultValue_GUI_1.FillItem_Enable = (yamlConfiguration_gui1.getBoolean("GUI.FillItem.Enable"));
        } else {
            yamlConfiguration_gui1.set("GUI.FillItem.Enable", true);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6GUI FillItem Enable §4was added to §9First_GUI.yml§4!");
        }
        if (yamlConfiguration_gui1.contains("GUI.FillItem.Item")) {
            DefultValue_GUI_1.FillItem = replace(yamlConfiguration_gui1.getString("GUI.FillItem.Item").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_gui1.set("GUI.FillItem.Item", DefultValue_GUI_1.FillItem);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6GUI FillItem Item §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_gui1.contains("GUI.Lines")) {
            DefultValue_GUI_1.GUILines = Integer.valueOf(yamlConfiguration_gui1.getString("GUI.Lines"));
        } else {
            yamlConfiguration_gui1.set("GUI.Lines", DefultValue_GUI_1.GUILines);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6GUI Lines §4was added to §9First_GUI.yml§4!");
        }
        if (yamlConfiguration_gui1.getInt("GUI.Lines") > 6) {
            yamlConfiguration_gui1.set("GUI.Lines", 6);
        }
        if (yamlConfiguration_gui1.getInt("GUI.Lines") < 1) {
            yamlConfiguration_gui1.set("GUI.Lines", 1);
        }

        if (yamlConfiguration_gui1.contains("UseItem.GiveUseItemOnFirstJoin")) {
            DefultValue_GUI_1.GiveUseItemOnFirstJoin = yamlConfiguration_gui1.getBoolean("UseItem.GiveUseItemOnFirstJoin");
        } else {
            yamlConfiguration_gui1.set("UseItem.GiveUseItemOnFirstJoin", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6UseItem GiveUseItemOnFirstJoin §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_gui1.contains("UseItem.GiveUseItemOnFirstJoin.Permission.Enable")) {
            DefultValue_GUI_1.GiveUseItemOnFirstJoin_Permission_Enable = yamlConfiguration_gui1.getBoolean("UseItem.GiveUseItemOnFirstJoin.Permission.Enable");
        } else {
            yamlConfiguration_gui1.set("UseItem.GiveUseItemOnFirstJoin.Permission.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6UseItem GiveUseItemOnFirstJoin Permission Enable §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_gui1.contains("UseItem.Item")) {
            DefultValue_GUI_1.UseItem_Item = replace(yamlConfiguration_gui1.getString("UseItem.Item").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_gui1.set("UseItem.Item", DefultValue_GUI_1.UseItem_Item);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6UseItem Item §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_gui1.contains("UseItem.Name")) {
            DefultValue_GUI_1.UseItem_Name = replace(yamlConfiguration_gui1.getString("UseItem.Name"));
        } else {
            yamlConfiguration_gui1.set("UseItem.Name", "&7Open the: [guiname]");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6UseItem Name §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_gui1.contains("UseItem.Lore")) {
            DefultValue_GUI_1.UseItem_Lore = yamlConfiguration_gui1.getList("UseItem.Lore");
        } else {
            List<String> lore = new ArrayList<>();
            yamlConfiguration_gui1.set("UseItem.Lore", lore);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6UseItem Lore §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_gui1.contains("UseItem.Permission.Enable")) {
            DefultValue_GUI_1.Permission_Enable = yamlConfiguration_gui1.getBoolean("UseItem.Permission.Enable");
        } else {
            yamlConfiguration_gui1.set("UseItem.Permission.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6UseItem Permission Enable §4was added to §9First_GUI.yml§4!");
        }


        if (yamlConfiguration_gui1.contains("Command.Command")) {
            DefultValue_GUI_1.Command = yamlConfiguration_gui1.getString("Command.Command");
        } else {
            yamlConfiguration_gui1.set("Command.Command", "GUI1");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Command §4was added to §9First_GUI.yml§4!");
        }

        if (yamlConfiguration_gui1.contains("Command.Permission")) {
            DefultValue_GUI_1.Command_Permission_Enable = (yamlConfiguration_gui1.getBoolean("Command.Permission"));
        } else {
            yamlConfiguration_gui1.set("Command.Permission", true);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Command Permission §4was added to §9First_GUI.yml§4!");
        }





        if (!gui1YML.isFile() || !yamlConfiguration_gui1.contains("Functions")) {
            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Item.Item", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Item §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Item.Name", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Name §4was added to §9First_GUI.yml§4!");

            List<String> lore = new ArrayList<>();
            //lore.add("§51");
            //lore.add("§52");
            //lore.add("§53");
            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Item.Lore", lore);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Lore §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Cost.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Cost Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Cost.Price", DefultValue_GUI_1.L1_S1_Price);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Cost Price §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Command.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Command Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Command.Command", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Command Command §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Message.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Message Enable §4was added to §9First_GUI.yml§4!");

            List<String> msg = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Message.Message", msg);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Message §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_1.Slot_1.Permission.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Permission Enable §4was added to §9First_GUI.yml§4!");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Enable")) {
            DefultValue_GUI_1.L1_S1_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_1.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Item.Item")) {
            DefultValue_GUI_1.L1_S1_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Item.Name")) {
            DefultValue_GUI_1.L1_S1_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_1.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Item.Lore")) {
            DefultValue_GUI_1.L1_S1_Lore = yamlConfiguration_gui1.getList("Functions.Line_1.Slot_1.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Cost.Enable")) {
            DefultValue_GUI_1.L1_S1_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_1.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Cost.Price")) {
            DefultValue_GUI_1.L1_S1_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_1.Slot_1.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Command.Enable")) {
            DefultValue_GUI_1.L1_S1_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_1.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Command.Command")) {
            DefultValue_GUI_1.L1_S1_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_1.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Message.Enable")) {
            DefultValue_GUI_1.L1_S1_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_1.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Message.Message")) {
            DefultValue_GUI_1.L1_S1_Message = yamlConfiguration_gui1.getStringList("Functions.Line_1.Slot_1.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_1.Permission.Enable")) {
            DefultValue_GUI_1.L1_S1_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_1.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Enable")) {
            DefultValue_GUI_1.L1_S2_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_2.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Item.Item")) {
            DefultValue_GUI_1.L1_S2_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Item.Name")) {
            DefultValue_GUI_1.L1_S2_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_2.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Item.Lore")) {
            DefultValue_GUI_1.L1_S2_Lore = yamlConfiguration_gui1.getList("Functions.Line_1.Slot_2.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Cost.Enable")) {
            DefultValue_GUI_1.L1_S2_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_2.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Cost.Price")) {
            DefultValue_GUI_1.L1_S2_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_1.Slot_2.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Command.Enable")) {
            DefultValue_GUI_1.L1_S2_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_2.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Command.Command")) {
            DefultValue_GUI_1.L1_S2_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_2.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Message.Enable")) {
            DefultValue_GUI_1.L1_S2_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_2.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Message.Message")) {
            DefultValue_GUI_1.L1_S2_Message = yamlConfiguration_gui1.getStringList("Functions.Line_1.Slot_2.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_2.Permission.Enable")) {
            DefultValue_GUI_1.L1_S2_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_2.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Enable")) {
            DefultValue_GUI_1.L1_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L1_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L1_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L1_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_1.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L1_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L1_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_1.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L1_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L1_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L1_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L1_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_1.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L1_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Enable")) {
            DefultValue_GUI_1.L1_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L1_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L1_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L1_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_1.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L1_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L1_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_1.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L1_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L1_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L1_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L1_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_1.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L1_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Enable")) {
            DefultValue_GUI_1.L1_S4_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_4.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Item.Item")) {
            DefultValue_GUI_1.L1_S4_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Item.Name")) {
            DefultValue_GUI_1.L1_S4_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_4.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Item.Lore")) {
            DefultValue_GUI_1.L1_S4_Lore = yamlConfiguration_gui1.getList("Functions.Line_1.Slot_4.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Cost.Enable")) {
            DefultValue_GUI_1.L1_S4_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_4.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Cost.Price")) {
            DefultValue_GUI_1.L1_S4_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_1.Slot_4.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Command.Enable")) {
            DefultValue_GUI_1.L1_S4_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_4.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Command.Command")) {
            DefultValue_GUI_1.L1_S4_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_4.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Message.Enable")) {
            DefultValue_GUI_1.L1_S4_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_4.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Message.Message")) {
            DefultValue_GUI_1.L1_S4_Message = yamlConfiguration_gui1.getStringList("Functions.Line_1.Slot_4.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_4.Permission.Enable")) {
            DefultValue_GUI_1.L1_S4_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_4.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Enable")) {
            DefultValue_GUI_1.L1_S5_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_5.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Item.Item")) {
            DefultValue_GUI_1.L1_S5_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Item.Name")) {
            DefultValue_GUI_1.L1_S5_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_5.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Item.Lore")) {
            DefultValue_GUI_1.L1_S5_Lore = yamlConfiguration_gui1.getList("Functions.Line_1.Slot_5.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Cost.Enable")) {
            DefultValue_GUI_1.L1_S5_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_5.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Cost.Price")) {
            DefultValue_GUI_1.L1_S5_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_1.Slot_5.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Command.Enable")) {
            DefultValue_GUI_1.L1_S5_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_5.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Command.Command")) {
            DefultValue_GUI_1.L1_S5_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_5.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Message.Enable")) {
            DefultValue_GUI_1.L1_S5_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_5.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Message.Message")) {
            DefultValue_GUI_1.L1_S5_Message = yamlConfiguration_gui1.getStringList("Functions.Line_1.Slot_5.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_5.Permission.Enable")) {
            DefultValue_GUI_1.L1_S5_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_5.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Enable")) {
            DefultValue_GUI_1.L1_S6_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_6.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Item.Item")) {
            DefultValue_GUI_1.L1_S6_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Item.Name")) {
            DefultValue_GUI_1.L1_S6_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_6.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Item.Lore")) {
            DefultValue_GUI_1.L1_S6_Lore = yamlConfiguration_gui1.getList("Functions.Line_1.Slot_6.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Cost.Enable")) {
            DefultValue_GUI_1.L1_S6_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_6.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Cost.Price")) {
            DefultValue_GUI_1.L1_S6_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_1.Slot_6.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Command.Enable")) {
            DefultValue_GUI_1.L1_S6_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_6.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Command.Command")) {
            DefultValue_GUI_1.L1_S6_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_6.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Message.Enable")) {
            DefultValue_GUI_1.L1_S6_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_6.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Message.Message")) {
            DefultValue_GUI_1.L1_S6_Message = yamlConfiguration_gui1.getStringList("Functions.Line_1.Slot_6.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_6.Permission.Enable")) {
            DefultValue_GUI_1.L1_S6_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_6.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Enable")) {
            DefultValue_GUI_1.L1_S7_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_7.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Item.Item")) {
            DefultValue_GUI_1.L1_S7_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Item.Name")) {
            DefultValue_GUI_1.L1_S7_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_7.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Item.Lore")) {
            DefultValue_GUI_1.L1_S7_Lore = yamlConfiguration_gui1.getList("Functions.Line_1.Slot_7.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Cost.Enable")) {
            DefultValue_GUI_1.L1_S7_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_7.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Cost.Price")) {
            DefultValue_GUI_1.L1_S7_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_1.Slot_7.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Command.Enable")) {
            DefultValue_GUI_1.L1_S7_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_7.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Command.Command")) {
            DefultValue_GUI_1.L1_S7_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_7.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Message.Enable")) {
            DefultValue_GUI_1.L1_S7_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_7.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Message.Message")) {
            DefultValue_GUI_1.L1_S7_Message = yamlConfiguration_gui1.getStringList("Functions.Line_1.Slot_7.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_7.Permission.Enable")) {
            DefultValue_GUI_1.L1_S7_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_7.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Enable")) {
            DefultValue_GUI_1.L1_S8_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_8.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Item.Item")) {
            DefultValue_GUI_1.L1_S8_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Item.Name")) {
            DefultValue_GUI_1.L1_S8_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_8.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Item.Lore")) {
            DefultValue_GUI_1.L1_S8_Lore = yamlConfiguration_gui1.getList("Functions.Line_1.Slot_8.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Cost.Enable")) {
            DefultValue_GUI_1.L1_S8_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_8.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Cost.Price")) {
            DefultValue_GUI_1.L1_S8_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_1.Slot_8.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Command.Enable")) {
            DefultValue_GUI_1.L1_S8_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_8.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Command.Command")) {
            DefultValue_GUI_1.L1_S8_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_8.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Message.Enable")) {
            DefultValue_GUI_1.L1_S8_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_8.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Message.Message")) {
            DefultValue_GUI_1.L1_S8_Message = yamlConfiguration_gui1.getStringList("Functions.Line_1.Slot_8.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_8.Permission.Enable")) {
            DefultValue_GUI_1.L1_S8_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_8.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Enable")) {
            DefultValue_GUI_1.L1_S9_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_9.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Item.Item")) {
            DefultValue_GUI_1.L1_S9_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Item.Name")) {
            DefultValue_GUI_1.L1_S9_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_9.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Item.Lore")) {
            DefultValue_GUI_1.L1_S9_Lore = yamlConfiguration_gui1.getList("Functions.Line_1.Slot_9.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Cost.Enable")) {
            DefultValue_GUI_1.L1_S9_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_9.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Cost.Price")) {
            DefultValue_GUI_1.L1_S9_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_1.Slot_9.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Command.Enable")) {
            DefultValue_GUI_1.L1_S9_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_9.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Command.Command")) {
            DefultValue_GUI_1.L1_S9_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_1.Slot_9.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Message.Enable")) {
            DefultValue_GUI_1.L1_S9_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_9.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Message.Message")) {
            DefultValue_GUI_1.L1_S9_Message = yamlConfiguration_gui1.getStringList("Functions.Line_1.Slot_9.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_1.Slot_9.Permission.Enable")) {
            DefultValue_GUI_1.L1_S9_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_1.Slot_9.Permission.Enable");
        }



        if (!gui1YML.isFile() || !yamlConfiguration_gui1.contains("Functions")) {
            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Item.Item", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Item §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Item.Name", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Name §4was added to §9First_GUI.yml§4!");

            List<String> lore = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Item.Lore", lore);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Lore §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Cost.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Cost Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Cost.Price", DefultValue_GUI_1.L2_S1_Price);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Cost Price §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Command.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Command Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Command.Command", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Command Command §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Message.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Message Enable §4was added to §9First_GUI.yml§4!");

            List<String> msg = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Message.Message", msg);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Message §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_2.Slot_1.Permission.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Permission Enable §4was added to §9First_GUI.yml§4!");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Enable")) {
            DefultValue_GUI_1.L2_S1_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_1.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Item.Item")) {
            DefultValue_GUI_1.L2_S1_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Item.Name")) {
            DefultValue_GUI_1.L2_S1_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_1.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Item.Lore")) {
            DefultValue_GUI_1.L2_S1_Lore = yamlConfiguration_gui1.getList("Functions.Line_2.Slot_1.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Cost.Enable")) {
            DefultValue_GUI_1.L2_S1_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_1.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Cost.Price")) {
            DefultValue_GUI_1.L2_S1_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_2.Slot_1.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Command.Enable")) {
            DefultValue_GUI_1.L2_S1_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_1.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Command.Command")) {
            DefultValue_GUI_1.L2_S1_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_1.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Message.Enable")) {
            DefultValue_GUI_1.L2_S1_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_1.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Message.Message")) {
            DefultValue_GUI_1.L2_S1_Message = yamlConfiguration_gui1.getStringList("Functions.Line_2.Slot_1.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_1.Permission.Enable")) {
            DefultValue_GUI_1.L2_S1_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_1.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Enable")) {
            DefultValue_GUI_1.L2_S2_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_2.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Item.Item")) {
            DefultValue_GUI_1.L2_S2_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Item.Name")) {
            DefultValue_GUI_1.L2_S2_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_2.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Item.Lore")) {
            DefultValue_GUI_1.L2_S2_Lore = yamlConfiguration_gui1.getList("Functions.Line_2.Slot_2.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Cost.Enable")) {
            DefultValue_GUI_1.L2_S2_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_2.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Cost.Price")) {
            DefultValue_GUI_1.L2_S2_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_2.Slot_2.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Command.Enable")) {
            DefultValue_GUI_1.L2_S2_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_2.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Command.Command")) {
            DefultValue_GUI_1.L2_S2_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_2.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Message.Enable")) {
            DefultValue_GUI_1.L2_S2_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_2.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Message.Message")) {
            DefultValue_GUI_1.L2_S2_Message = yamlConfiguration_gui1.getStringList("Functions.Line_2.Slot_2.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_2.Permission.Enable")) {
            DefultValue_GUI_1.L2_S2_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_2.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Enable")) {
            DefultValue_GUI_1.L2_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L2_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L2_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L2_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_2.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L2_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L2_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_2.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L2_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L2_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L2_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L2_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_2.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L2_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Enable")) {
            DefultValue_GUI_1.L2_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L2_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L2_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L2_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_2.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L2_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L2_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_2.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L2_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L2_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L2_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L2_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_2.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L2_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Enable")) {
            DefultValue_GUI_1.L2_S4_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_4.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Item.Item")) {
            DefultValue_GUI_1.L2_S4_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Item.Name")) {
            DefultValue_GUI_1.L2_S4_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_4.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Item.Lore")) {
            DefultValue_GUI_1.L2_S4_Lore = yamlConfiguration_gui1.getList("Functions.Line_2.Slot_4.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Cost.Enable")) {
            DefultValue_GUI_1.L2_S4_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_4.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Cost.Price")) {
            DefultValue_GUI_1.L2_S4_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_2.Slot_4.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Command.Enable")) {
            DefultValue_GUI_1.L2_S4_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_4.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Command.Command")) {
            DefultValue_GUI_1.L2_S4_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_4.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Message.Enable")) {
            DefultValue_GUI_1.L2_S4_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_4.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Message.Message")) {
            DefultValue_GUI_1.L2_S4_Message = yamlConfiguration_gui1.getStringList("Functions.Line_2.Slot_4.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_4.Permission.Enable")) {
            DefultValue_GUI_1.L2_S4_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_4.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Enable")) {
            DefultValue_GUI_1.L2_S5_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_5.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Item.Item")) {
            DefultValue_GUI_1.L2_S5_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Item.Name")) {
            DefultValue_GUI_1.L2_S5_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_5.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Item.Lore")) {
            DefultValue_GUI_1.L2_S5_Lore = yamlConfiguration_gui1.getList("Functions.Line_2.Slot_5.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Cost.Enable")) {
            DefultValue_GUI_1.L2_S5_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_5.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Cost.Price")) {
            DefultValue_GUI_1.L2_S5_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_2.Slot_5.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Command.Enable")) {
            DefultValue_GUI_1.L2_S5_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_5.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Command.Command")) {
            DefultValue_GUI_1.L2_S5_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_5.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Message.Enable")) {
            DefultValue_GUI_1.L2_S5_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_5.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Message.Message")) {
            DefultValue_GUI_1.L2_S5_Message = yamlConfiguration_gui1.getStringList("Functions.Line_2.Slot_5.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_5.Permission.Enable")) {
            DefultValue_GUI_1.L2_S5_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_5.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Enable")) {
            DefultValue_GUI_1.L2_S6_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_6.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Item.Item")) {
            DefultValue_GUI_1.L2_S6_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Item.Name")) {
            DefultValue_GUI_1.L2_S6_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_6.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Item.Lore")) {
            DefultValue_GUI_1.L2_S6_Lore = yamlConfiguration_gui1.getList("Functions.Line_2.Slot_6.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Cost.Enable")) {
            DefultValue_GUI_1.L2_S6_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_6.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Cost.Price")) {
            DefultValue_GUI_1.L2_S6_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_2.Slot_6.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Command.Enable")) {
            DefultValue_GUI_1.L2_S6_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_6.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Command.Command")) {
            DefultValue_GUI_1.L2_S6_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_6.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Message.Enable")) {
            DefultValue_GUI_1.L2_S6_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_6.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Message.Message")) {
            DefultValue_GUI_1.L2_S6_Message = yamlConfiguration_gui1.getStringList("Functions.Line_2.Slot_6.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_6.Permission.Enable")) {
            DefultValue_GUI_1.L2_S6_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_6.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Enable")) {
            DefultValue_GUI_1.L2_S7_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_7.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Item.Item")) {
            DefultValue_GUI_1.L2_S7_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Item.Name")) {
            DefultValue_GUI_1.L2_S7_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_7.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Item.Lore")) {
            DefultValue_GUI_1.L2_S7_Lore = yamlConfiguration_gui1.getList("Functions.Line_2.Slot_7.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Cost.Enable")) {
            DefultValue_GUI_1.L2_S7_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_7.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Cost.Price")) {
            DefultValue_GUI_1.L2_S7_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_2.Slot_7.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Command.Enable")) {
            DefultValue_GUI_1.L2_S7_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_7.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Command.Command")) {
            DefultValue_GUI_1.L2_S7_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_7.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Message.Enable")) {
            DefultValue_GUI_1.L2_S7_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_7.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Message.Message")) {
            DefultValue_GUI_1.L2_S7_Message = yamlConfiguration_gui1.getStringList("Functions.Line_2.Slot_7.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_7.Permission.Enable")) {
            DefultValue_GUI_1.L2_S7_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_7.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Enable")) {
            DefultValue_GUI_1.L2_S8_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_8.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Item.Item")) {
            DefultValue_GUI_1.L2_S8_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Item.Name")) {
            DefultValue_GUI_1.L2_S8_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_8.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Item.Lore")) {
            DefultValue_GUI_1.L2_S8_Lore = yamlConfiguration_gui1.getList("Functions.Line_2.Slot_8.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Cost.Enable")) {
            DefultValue_GUI_1.L2_S8_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_8.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Cost.Price")) {
            DefultValue_GUI_1.L2_S8_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_2.Slot_8.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Command.Enable")) {
            DefultValue_GUI_1.L2_S8_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_8.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Command.Command")) {
            DefultValue_GUI_1.L2_S8_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_8.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Message.Enable")) {
            DefultValue_GUI_1.L2_S8_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_8.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Message.Message")) {
            DefultValue_GUI_1.L2_S8_Message = yamlConfiguration_gui1.getStringList("Functions.Line_2.Slot_8.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_8.Permission.Enable")) {
            DefultValue_GUI_1.L2_S8_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_8.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Enable")) {
            DefultValue_GUI_1.L2_S9_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_9.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Item.Item")) {
            DefultValue_GUI_1.L2_S9_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Item.Name")) {
            DefultValue_GUI_1.L2_S9_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_9.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Item.Lore")) {
            DefultValue_GUI_1.L2_S9_Lore = yamlConfiguration_gui1.getList("Functions.Line_2.Slot_9.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Cost.Enable")) {
            DefultValue_GUI_1.L2_S9_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_9.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Cost.Price")) {
            DefultValue_GUI_1.L2_S9_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_2.Slot_9.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Command.Enable")) {
            DefultValue_GUI_1.L2_S9_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_9.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Command.Command")) {
            DefultValue_GUI_1.L2_S9_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_2.Slot_9.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Message.Enable")) {
            DefultValue_GUI_1.L2_S9_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_9.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Message.Message")) {
            DefultValue_GUI_1.L2_S9_Message = yamlConfiguration_gui1.getStringList("Functions.Line_2.Slot_9.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_2.Slot_9.Permission.Enable")) {
            DefultValue_GUI_1.L2_S9_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_2.Slot_9.Permission.Enable");
        }



        if (!gui1YML.isFile() || !yamlConfiguration_gui1.contains("Functions")) {
            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Item.Item", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Item §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Item.Name", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Name §4was added to §9First_GUI.yml§4!");

            List<String> lore = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Item.Lore", lore);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Lore §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Cost.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Cost Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Cost.Price", DefultValue_GUI_1.L3_S1_Price);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Cost Price §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Command.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Command Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Command.Command", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Command Command §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Message.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Message Enable §4was added to §9First_GUI.yml§4!");

            List<String> msg = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Message.Message", msg);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Message §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_3.Slot_1.Permission.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Permission Enable §4was added to §9First_GUI.yml§4!");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Enable")) {
            DefultValue_GUI_1.L3_S1_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_1.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Item.Item")) {
            DefultValue_GUI_1.L3_S1_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Item.Name")) {
            DefultValue_GUI_1.L3_S1_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_1.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Item.Lore")) {
            DefultValue_GUI_1.L3_S1_Lore = yamlConfiguration_gui1.getList("Functions.Line_3.Slot_1.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Cost.Enable")) {
            DefultValue_GUI_1.L3_S1_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_1.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Cost.Price")) {
            DefultValue_GUI_1.L3_S1_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_3.Slot_1.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Command.Enable")) {
            DefultValue_GUI_1.L3_S1_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_1.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Command.Command")) {
            DefultValue_GUI_1.L3_S1_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_1.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Message.Enable")) {
            DefultValue_GUI_1.L3_S1_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_1.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Message.Message")) {
            DefultValue_GUI_1.L3_S1_Message = yamlConfiguration_gui1.getStringList("Functions.Line_3.Slot_1.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_1.Permission.Enable")) {
            DefultValue_GUI_1.L3_S1_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_1.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Enable")) {
            DefultValue_GUI_1.L3_S2_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_2.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Item.Item")) {
            DefultValue_GUI_1.L3_S2_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Item.Name")) {
            DefultValue_GUI_1.L3_S2_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_2.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Item.Lore")) {
            DefultValue_GUI_1.L3_S2_Lore = yamlConfiguration_gui1.getList("Functions.Line_3.Slot_2.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Cost.Enable")) {
            DefultValue_GUI_1.L3_S2_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_2.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Cost.Price")) {
            DefultValue_GUI_1.L3_S2_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_3.Slot_2.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Command.Enable")) {
            DefultValue_GUI_1.L3_S2_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_2.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Command.Command")) {
            DefultValue_GUI_1.L3_S2_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_2.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Message.Enable")) {
            DefultValue_GUI_1.L3_S2_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_2.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Message.Message")) {
            DefultValue_GUI_1.L3_S2_Message = yamlConfiguration_gui1.getStringList("Functions.Line_3.Slot_2.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_2.Permission.Enable")) {
            DefultValue_GUI_1.L3_S2_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_2.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Enable")) {
            DefultValue_GUI_1.L3_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L3_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L3_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L3_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_3.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L3_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L3_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_3.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L3_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L3_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L3_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L3_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_3.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L3_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Enable")) {
            DefultValue_GUI_1.L3_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L3_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L3_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L3_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_3.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L3_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L3_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_3.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L3_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L3_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L3_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L3_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_3.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L3_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Enable")) {
            DefultValue_GUI_1.L3_S4_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_4.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Item.Item")) {
            DefultValue_GUI_1.L3_S4_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Item.Name")) {
            DefultValue_GUI_1.L3_S4_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_4.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Item.Lore")) {
            DefultValue_GUI_1.L3_S4_Lore = yamlConfiguration_gui1.getList("Functions.Line_3.Slot_4.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Cost.Enable")) {
            DefultValue_GUI_1.L3_S4_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_4.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Cost.Price")) {
            DefultValue_GUI_1.L3_S4_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_3.Slot_4.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Command.Enable")) {
            DefultValue_GUI_1.L3_S4_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_4.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Command.Command")) {
            DefultValue_GUI_1.L3_S4_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_4.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Message.Enable")) {
            DefultValue_GUI_1.L3_S4_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_4.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Message.Message")) {
            DefultValue_GUI_1.L3_S4_Message = yamlConfiguration_gui1.getStringList("Functions.Line_3.Slot_4.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_4.Permission.Enable")) {
            DefultValue_GUI_1.L3_S4_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_4.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Enable")) {
            DefultValue_GUI_1.L3_S5_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_5.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Item.Item")) {
            DefultValue_GUI_1.L3_S5_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Item.Name")) {
            DefultValue_GUI_1.L3_S5_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_5.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Item.Lore")) {
            DefultValue_GUI_1.L3_S5_Lore = yamlConfiguration_gui1.getList("Functions.Line_3.Slot_5.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Cost.Enable")) {
            DefultValue_GUI_1.L3_S5_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_5.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Cost.Price")) {
            DefultValue_GUI_1.L3_S5_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_3.Slot_5.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Command.Enable")) {
            DefultValue_GUI_1.L3_S5_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_5.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Command.Command")) {
            DefultValue_GUI_1.L3_S5_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_5.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Message.Enable")) {
            DefultValue_GUI_1.L3_S5_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_5.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Message.Message")) {
            DefultValue_GUI_1.L3_S5_Message = yamlConfiguration_gui1.getStringList("Functions.Line_3.Slot_5.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_5.Permission.Enable")) {
            DefultValue_GUI_1.L3_S5_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_5.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Enable")) {
            DefultValue_GUI_1.L3_S6_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_6.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Item.Item")) {
            DefultValue_GUI_1.L3_S6_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Item.Name")) {
            DefultValue_GUI_1.L3_S6_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_6.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Item.Lore")) {
            DefultValue_GUI_1.L3_S6_Lore = yamlConfiguration_gui1.getList("Functions.Line_3.Slot_6.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Cost.Enable")) {
            DefultValue_GUI_1.L3_S6_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_6.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Cost.Price")) {
            DefultValue_GUI_1.L3_S6_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_3.Slot_6.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Command.Enable")) {
            DefultValue_GUI_1.L3_S6_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_6.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Command.Command")) {
            DefultValue_GUI_1.L3_S6_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_6.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Message.Enable")) {
            DefultValue_GUI_1.L3_S6_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_6.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Message.Message")) {
            DefultValue_GUI_1.L3_S6_Message = yamlConfiguration_gui1.getStringList("Functions.Line_3.Slot_6.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_6.Permission.Enable")) {
            DefultValue_GUI_1.L3_S6_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_6.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Enable")) {
            DefultValue_GUI_1.L3_S7_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_7.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Item.Item")) {
            DefultValue_GUI_1.L3_S7_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Item.Name")) {
            DefultValue_GUI_1.L3_S7_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_7.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Item.Lore")) {
            DefultValue_GUI_1.L3_S7_Lore = yamlConfiguration_gui1.getList("Functions.Line_3.Slot_7.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Cost.Enable")) {
            DefultValue_GUI_1.L3_S7_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_7.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Cost.Price")) {
            DefultValue_GUI_1.L3_S7_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_3.Slot_7.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Command.Enable")) {
            DefultValue_GUI_1.L3_S7_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_7.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Command.Command")) {
            DefultValue_GUI_1.L3_S7_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_7.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Message.Enable")) {
            DefultValue_GUI_1.L3_S7_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_7.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Message.Message")) {
            DefultValue_GUI_1.L3_S7_Message = yamlConfiguration_gui1.getStringList("Functions.Line_3.Slot_7.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_7.Permission.Enable")) {
            DefultValue_GUI_1.L3_S7_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_7.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Enable")) {
            DefultValue_GUI_1.L3_S8_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_8.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Item.Item")) {
            DefultValue_GUI_1.L3_S8_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Item.Name")) {
            DefultValue_GUI_1.L3_S8_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_8.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Item.Lore")) {
            DefultValue_GUI_1.L3_S8_Lore = yamlConfiguration_gui1.getList("Functions.Line_3.Slot_8.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Cost.Enable")) {
            DefultValue_GUI_1.L3_S8_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_8.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Cost.Price")) {
            DefultValue_GUI_1.L3_S8_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_3.Slot_8.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Command.Enable")) {
            DefultValue_GUI_1.L3_S8_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_8.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Command.Command")) {
            DefultValue_GUI_1.L3_S8_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_8.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Message.Enable")) {
            DefultValue_GUI_1.L3_S8_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_8.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Message.Message")) {
            DefultValue_GUI_1.L3_S8_Message = yamlConfiguration_gui1.getStringList("Functions.Line_3.Slot_8.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_8.Permission.Enable")) {
            DefultValue_GUI_1.L3_S8_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_8.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Enable")) {
            DefultValue_GUI_1.L3_S9_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_9.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Item.Item")) {
            DefultValue_GUI_1.L3_S9_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Item.Name")) {
            DefultValue_GUI_1.L3_S9_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_9.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Item.Lore")) {
            DefultValue_GUI_1.L3_S9_Lore = yamlConfiguration_gui1.getList("Functions.Line_3.Slot_9.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Cost.Enable")) {
            DefultValue_GUI_1.L3_S9_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_9.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Cost.Price")) {
            DefultValue_GUI_1.L3_S9_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_3.Slot_9.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Command.Enable")) {
            DefultValue_GUI_1.L3_S9_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_9.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Command.Command")) {
            DefultValue_GUI_1.L3_S9_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_3.Slot_9.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Message.Enable")) {
            DefultValue_GUI_1.L3_S9_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_9.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Message.Message")) {
            DefultValue_GUI_1.L3_S9_Message = yamlConfiguration_gui1.getStringList("Functions.Line_3.Slot_9.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_3.Slot_9.Permission.Enable")) {
            DefultValue_GUI_1.L3_S9_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_3.Slot_9.Permission.Enable");
        }



        if (!gui1YML.isFile() || !yamlConfiguration_gui1.contains("Functions")) {
            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Item.Item", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Item §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Item.Name", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Name §4was added to §9First_GUI.yml§4!");

            List<String> lore = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Item.Lore", lore);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Lore §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Cost.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Cost Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Cost.Price", DefultValue_GUI_1.L4_S1_Price);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Cost Price §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Command.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Command Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Command.Command", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Command Command §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Message.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Message Enable §4was added to §9First_GUI.yml§4!");

            List<String> msg = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Message.Message", msg);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Message §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_4.Slot_1.Permission.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Permission Enable §4was added to §9First_GUI.yml§4!");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Enable")) {
            DefultValue_GUI_1.L4_S1_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_1.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Item.Item")) {
            DefultValue_GUI_1.L4_S1_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Item.Name")) {
            DefultValue_GUI_1.L4_S1_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_1.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Item.Lore")) {
            DefultValue_GUI_1.L4_S1_Lore = yamlConfiguration_gui1.getList("Functions.Line_4.Slot_1.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Cost.Enable")) {
            DefultValue_GUI_1.L4_S1_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_1.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Cost.Price")) {
            DefultValue_GUI_1.L4_S1_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_4.Slot_1.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Command.Enable")) {
            DefultValue_GUI_1.L4_S1_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_1.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Command.Command")) {
            DefultValue_GUI_1.L4_S1_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_1.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Message.Enable")) {
            DefultValue_GUI_1.L4_S1_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_1.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Message.Message")) {
            DefultValue_GUI_1.L4_S1_Message = yamlConfiguration_gui1.getStringList("Functions.Line_4.Slot_1.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_1.Permission.Enable")) {
            DefultValue_GUI_1.L4_S1_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_1.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Enable")) {
            DefultValue_GUI_1.L4_S2_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_2.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Item.Item")) {
            DefultValue_GUI_1.L4_S2_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Item.Name")) {
            DefultValue_GUI_1.L4_S2_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_2.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Item.Lore")) {
            DefultValue_GUI_1.L4_S2_Lore = yamlConfiguration_gui1.getList("Functions.Line_4.Slot_2.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Cost.Enable")) {
            DefultValue_GUI_1.L4_S2_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_2.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Cost.Price")) {
            DefultValue_GUI_1.L4_S2_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_4.Slot_2.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Command.Enable")) {
            DefultValue_GUI_1.L4_S2_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_2.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Command.Command")) {
            DefultValue_GUI_1.L4_S2_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_2.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Message.Enable")) {
            DefultValue_GUI_1.L4_S2_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_2.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Message.Message")) {
            DefultValue_GUI_1.L4_S2_Message = yamlConfiguration_gui1.getStringList("Functions.Line_4.Slot_2.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_2.Permission.Enable")) {
            DefultValue_GUI_1.L4_S2_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_2.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Enable")) {
            DefultValue_GUI_1.L4_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L4_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L4_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L4_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_4.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L4_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L4_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_4.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L4_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L4_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L4_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L4_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_4.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L4_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Enable")) {
            DefultValue_GUI_1.L4_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L4_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L4_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L4_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_4.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L4_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L4_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_4.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L4_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L4_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L4_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L4_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_4.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L4_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Enable")) {
            DefultValue_GUI_1.L4_S4_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_4.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Item.Item")) {
            DefultValue_GUI_1.L4_S4_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Item.Name")) {
            DefultValue_GUI_1.L4_S4_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_4.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Item.Lore")) {
            DefultValue_GUI_1.L4_S4_Lore = yamlConfiguration_gui1.getList("Functions.Line_4.Slot_4.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Cost.Enable")) {
            DefultValue_GUI_1.L4_S4_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_4.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Cost.Price")) {
            DefultValue_GUI_1.L4_S4_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_4.Slot_4.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Command.Enable")) {
            DefultValue_GUI_1.L4_S4_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_4.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Command.Command")) {
            DefultValue_GUI_1.L4_S4_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_4.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Message.Enable")) {
            DefultValue_GUI_1.L4_S4_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_4.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Message.Message")) {
            DefultValue_GUI_1.L4_S4_Message = yamlConfiguration_gui1.getStringList("Functions.Line_4.Slot_4.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_4.Permission.Enable")) {
            DefultValue_GUI_1.L4_S4_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_4.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Enable")) {
            DefultValue_GUI_1.L4_S5_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_5.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Item.Item")) {
            DefultValue_GUI_1.L4_S5_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Item.Name")) {
            DefultValue_GUI_1.L4_S5_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_5.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Item.Lore")) {
            DefultValue_GUI_1.L4_S5_Lore = yamlConfiguration_gui1.getList("Functions.Line_4.Slot_5.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Cost.Enable")) {
            DefultValue_GUI_1.L4_S5_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_5.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Cost.Price")) {
            DefultValue_GUI_1.L4_S5_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_4.Slot_5.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Command.Enable")) {
            DefultValue_GUI_1.L4_S5_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_5.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Command.Command")) {
            DefultValue_GUI_1.L4_S5_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_5.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Message.Enable")) {
            DefultValue_GUI_1.L4_S5_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_5.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Message.Message")) {
            DefultValue_GUI_1.L4_S5_Message = yamlConfiguration_gui1.getStringList("Functions.Line_4.Slot_5.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_5.Permission.Enable")) {
            DefultValue_GUI_1.L4_S5_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_5.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Enable")) {
            DefultValue_GUI_1.L4_S6_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_6.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Item.Item")) {
            DefultValue_GUI_1.L4_S6_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Item.Name")) {
            DefultValue_GUI_1.L4_S6_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_6.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Item.Lore")) {
            DefultValue_GUI_1.L4_S6_Lore = yamlConfiguration_gui1.getList("Functions.Line_4.Slot_6.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Cost.Enable")) {
            DefultValue_GUI_1.L4_S6_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_6.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Cost.Price")) {
            DefultValue_GUI_1.L4_S6_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_4.Slot_6.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Command.Enable")) {
            DefultValue_GUI_1.L4_S6_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_6.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Command.Command")) {
            DefultValue_GUI_1.L4_S6_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_6.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Message.Enable")) {
            DefultValue_GUI_1.L4_S6_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_6.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Message.Message")) {
            DefultValue_GUI_1.L4_S6_Message = yamlConfiguration_gui1.getStringList("Functions.Line_4.Slot_6.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_6.Permission.Enable")) {
            DefultValue_GUI_1.L4_S6_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_6.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Enable")) {
            DefultValue_GUI_1.L4_S7_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_7.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Item.Item")) {
            DefultValue_GUI_1.L4_S7_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Item.Name")) {
            DefultValue_GUI_1.L4_S7_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_7.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Item.Lore")) {
            DefultValue_GUI_1.L4_S7_Lore = yamlConfiguration_gui1.getList("Functions.Line_4.Slot_7.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Cost.Enable")) {
            DefultValue_GUI_1.L4_S7_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_7.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Cost.Price")) {
            DefultValue_GUI_1.L4_S7_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_4.Slot_7.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Command.Enable")) {
            DefultValue_GUI_1.L4_S7_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_7.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Command.Command")) {
            DefultValue_GUI_1.L4_S7_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_7.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Message.Enable")) {
            DefultValue_GUI_1.L4_S7_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_7.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Message.Message")) {
            DefultValue_GUI_1.L4_S7_Message = yamlConfiguration_gui1.getStringList("Functions.Line_4.Slot_7.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_7.Permission.Enable")) {
            DefultValue_GUI_1.L4_S7_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_7.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Enable")) {
            DefultValue_GUI_1.L4_S8_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_8.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Item.Item")) {
            DefultValue_GUI_1.L4_S8_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Item.Name")) {
            DefultValue_GUI_1.L4_S8_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_8.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Item.Lore")) {
            DefultValue_GUI_1.L4_S8_Lore = yamlConfiguration_gui1.getList("Functions.Line_4.Slot_8.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Cost.Enable")) {
            DefultValue_GUI_1.L4_S8_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_8.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Cost.Price")) {
            DefultValue_GUI_1.L4_S8_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_4.Slot_8.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Command.Enable")) {
            DefultValue_GUI_1.L4_S8_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_8.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Command.Command")) {
            DefultValue_GUI_1.L4_S8_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_8.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Message.Enable")) {
            DefultValue_GUI_1.L4_S8_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_8.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Message.Message")) {
            DefultValue_GUI_1.L4_S8_Message = yamlConfiguration_gui1.getStringList("Functions.Line_4.Slot_8.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_8.Permission.Enable")) {
            DefultValue_GUI_1.L4_S8_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_8.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Enable")) {
            DefultValue_GUI_1.L4_S9_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_9.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Item.Item")) {
            DefultValue_GUI_1.L4_S9_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Item.Name")) {
            DefultValue_GUI_1.L4_S9_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_9.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Item.Lore")) {
            DefultValue_GUI_1.L4_S9_Lore = yamlConfiguration_gui1.getList("Functions.Line_4.Slot_9.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Cost.Enable")) {
            DefultValue_GUI_1.L4_S9_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_9.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Cost.Price")) {
            DefultValue_GUI_1.L4_S9_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_4.Slot_9.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Command.Enable")) {
            DefultValue_GUI_1.L4_S9_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_9.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Command.Command")) {
            DefultValue_GUI_1.L4_S9_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_4.Slot_9.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Message.Enable")) {
            DefultValue_GUI_1.L4_S9_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_9.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Message.Message")) {
            DefultValue_GUI_1.L4_S9_Message = yamlConfiguration_gui1.getStringList("Functions.Line_4.Slot_9.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_4.Slot_9.Permission.Enable")) {
            DefultValue_GUI_1.L4_S9_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_4.Slot_9.Permission.Enable");
        }



        if (!gui1YML.isFile() || !yamlConfiguration_gui1.contains("Functions")) {
            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Item.Item", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Item §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Item.Name", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Name §4was added to §9First_GUI.yml§4!");

            List<String> lore = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Item.Lore", lore);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Lore §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Cost.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Cost Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Cost.Price", DefultValue_GUI_1.L5_S1_Price);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Cost Price §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Command.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Command Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Command.Command", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Command Command §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Message.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Message Enable §4was added to §9First_GUI.yml§4!");

            List<String> msg = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Message.Message", msg);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Message §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_5.Slot_1.Permission.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Permission Enable §4was added to §9First_GUI.yml§4!");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Enable")) {
            DefultValue_GUI_1.L5_S1_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_1.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Item.Item")) {
            DefultValue_GUI_1.L5_S1_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Item.Name")) {
            DefultValue_GUI_1.L5_S1_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_1.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Item.Lore")) {
            DefultValue_GUI_1.L5_S1_Lore = yamlConfiguration_gui1.getList("Functions.Line_5.Slot_1.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Cost.Enable")) {
            DefultValue_GUI_1.L5_S1_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_1.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Cost.Price")) {
            DefultValue_GUI_1.L5_S1_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_5.Slot_1.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Command.Enable")) {
            DefultValue_GUI_1.L5_S1_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_1.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Command.Command")) {
            DefultValue_GUI_1.L5_S1_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_1.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Message.Enable")) {
            DefultValue_GUI_1.L5_S1_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_1.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Message.Message")) {
            DefultValue_GUI_1.L5_S1_Message = yamlConfiguration_gui1.getStringList("Functions.Line_5.Slot_1.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_1.Permission.Enable")) {
            DefultValue_GUI_1.L5_S1_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_1.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Enable")) {
            DefultValue_GUI_1.L5_S2_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_2.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Item.Item")) {
            DefultValue_GUI_1.L5_S2_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Item.Name")) {
            DefultValue_GUI_1.L5_S2_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_2.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Item.Lore")) {
            DefultValue_GUI_1.L5_S2_Lore = yamlConfiguration_gui1.getList("Functions.Line_5.Slot_2.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Cost.Enable")) {
            DefultValue_GUI_1.L5_S2_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_2.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Cost.Price")) {
            DefultValue_GUI_1.L5_S2_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_5.Slot_2.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Command.Enable")) {
            DefultValue_GUI_1.L5_S2_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_2.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Command.Command")) {
            DefultValue_GUI_1.L5_S2_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_2.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Message.Enable")) {
            DefultValue_GUI_1.L5_S2_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_2.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Message.Message")) {
            DefultValue_GUI_1.L5_S2_Message = yamlConfiguration_gui1.getStringList("Functions.Line_5.Slot_2.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_2.Permission.Enable")) {
            DefultValue_GUI_1.L5_S2_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_2.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Enable")) {
            DefultValue_GUI_1.L5_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L5_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L5_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L5_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_5.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L5_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L5_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_5.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L5_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L5_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L5_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L5_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_5.Slot_3.Message.Message");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Enable")) {
            DefultValue_GUI_1.L5_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L5_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L5_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L5_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_5.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L5_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L5_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_5.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L5_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L5_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L5_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L5_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_5.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L5_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Enable")) {
            DefultValue_GUI_1.L5_S4_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_4.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Item.Item")) {
            DefultValue_GUI_1.L5_S4_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Item.Name")) {
            DefultValue_GUI_1.L5_S4_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_4.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Item.Lore")) {
            DefultValue_GUI_1.L5_S4_Lore = yamlConfiguration_gui1.getList("Functions.Line_5.Slot_4.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Cost.Enable")) {
            DefultValue_GUI_1.L5_S4_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_4.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Cost.Price")) {
            DefultValue_GUI_1.L5_S4_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_5.Slot_4.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Command.Enable")) {
            DefultValue_GUI_1.L5_S4_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_4.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Command.Command")) {
            DefultValue_GUI_1.L5_S4_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_4.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Message.Enable")) {
            DefultValue_GUI_1.L5_S4_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_4.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Message.Message")) {
            DefultValue_GUI_1.L5_S4_Message = yamlConfiguration_gui1.getStringList("Functions.Line_5.Slot_4.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_4.Permission.Enable")) {
            DefultValue_GUI_1.L5_S4_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_4.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Enable")) {
            DefultValue_GUI_1.L5_S5_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_5.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Item.Item")) {
            DefultValue_GUI_1.L5_S5_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Item.Name")) {
            DefultValue_GUI_1.L5_S5_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_5.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Item.Lore")) {
            DefultValue_GUI_1.L5_S5_Lore = yamlConfiguration_gui1.getList("Functions.Line_5.Slot_5.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Cost.Enable")) {
            DefultValue_GUI_1.L5_S5_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_5.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Cost.Price")) {
            DefultValue_GUI_1.L5_S5_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_5.Slot_5.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Command.Enable")) {
            DefultValue_GUI_1.L5_S5_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_5.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Command.Command")) {
            DefultValue_GUI_1.L5_S5_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_5.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Message.Enable")) {
            DefultValue_GUI_1.L5_S5_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_5.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Message.Message")) {
            DefultValue_GUI_1.L5_S5_Message = yamlConfiguration_gui1.getStringList("Functions.Line_5.Slot_5.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_5.Permission.Enable")) {
            DefultValue_GUI_1.L5_S5_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_5.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Enable")) {
            DefultValue_GUI_1.L5_S6_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_6.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Item.Item")) {
            DefultValue_GUI_1.L5_S6_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Item.Name")) {
            DefultValue_GUI_1.L5_S6_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_6.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Item.Lore")) {
            DefultValue_GUI_1.L5_S6_Lore = yamlConfiguration_gui1.getList("Functions.Line_5.Slot_6.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Cost.Enable")) {
            DefultValue_GUI_1.L5_S6_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_6.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Cost.Price")) {
            DefultValue_GUI_1.L5_S6_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_5.Slot_6.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Command.Enable")) {
            DefultValue_GUI_1.L5_S6_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_6.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Command.Command")) {
            DefultValue_GUI_1.L5_S6_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_6.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Message.Enable")) {
            DefultValue_GUI_1.L5_S6_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_6.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Message.Message")) {
            DefultValue_GUI_1.L5_S6_Message = yamlConfiguration_gui1.getStringList("Functions.Line_5.Slot_6.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_6.Permission.Enable")) {
            DefultValue_GUI_1.L5_S6_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_6.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Enable")) {
            DefultValue_GUI_1.L5_S7_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_7.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Item.Item")) {
            DefultValue_GUI_1.L5_S7_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Item.Name")) {
            DefultValue_GUI_1.L5_S7_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_7.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Item.Lore")) {
            DefultValue_GUI_1.L5_S7_Lore = yamlConfiguration_gui1.getList("Functions.Line_5.Slot_7.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Cost.Enable")) {
            DefultValue_GUI_1.L5_S7_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_7.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Cost.Price")) {
            DefultValue_GUI_1.L5_S7_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_5.Slot_7.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Command.Enable")) {
            DefultValue_GUI_1.L5_S7_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_7.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Command.Command")) {
            DefultValue_GUI_1.L5_S7_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_7.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Message.Enable")) {
            DefultValue_GUI_1.L5_S7_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_7.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Message.Message")) {
            DefultValue_GUI_1.L5_S7_Message = yamlConfiguration_gui1.getStringList("Functions.Line_5.Slot_7.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_7.Permission.Enable")) {
            DefultValue_GUI_1.L5_S7_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_7.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Enable")) {
            DefultValue_GUI_1.L5_S8_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_8.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Item.Item")) {
            DefultValue_GUI_1.L5_S8_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Item.Name")) {
            DefultValue_GUI_1.L5_S8_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_8.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Item.Lore")) {
            DefultValue_GUI_1.L5_S8_Lore = yamlConfiguration_gui1.getList("Functions.Line_5.Slot_8.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Cost.Enable")) {
            DefultValue_GUI_1.L5_S8_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_8.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Cost.Price")) {
            DefultValue_GUI_1.L5_S8_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_5.Slot_8.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Command.Enable")) {
            DefultValue_GUI_1.L5_S8_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_8.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Command.Command")) {
            DefultValue_GUI_1.L5_S8_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_8.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Message.Enable")) {
            DefultValue_GUI_1.L5_S8_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_8.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Message.Message")) {
            DefultValue_GUI_1.L5_S8_Message = yamlConfiguration_gui1.getStringList("Functions.Line_5.Slot_8.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_8.Permission.Enable")) {
            DefultValue_GUI_1.L5_S8_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_8.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Enable")) {
            DefultValue_GUI_1.L5_S9_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_9.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Item.Item")) {
            DefultValue_GUI_1.L5_S9_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Item.Name")) {
            DefultValue_GUI_1.L5_S9_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_9.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Item.Lore")) {
            DefultValue_GUI_1.L5_S9_Lore = yamlConfiguration_gui1.getList("Functions.Line_5.Slot_9.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Cost.Enable")) {
            DefultValue_GUI_1.L5_S9_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_9.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Cost.Price")) {
            DefultValue_GUI_1.L5_S9_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_5.Slot_9.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Command.Enable")) {
            DefultValue_GUI_1.L5_S9_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_9.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Command.Command")) {
            DefultValue_GUI_1.L5_S9_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_5.Slot_9.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Message.Enable")) {
            DefultValue_GUI_1.L5_S9_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_9.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Message.Message")) {
            DefultValue_GUI_1.L5_S9_Message = yamlConfiguration_gui1.getStringList("Functions.Line_5.Slot_9.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_5.Slot_9.Permission.Enable")) {
            DefultValue_GUI_1.L5_S9_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_5.Slot_9.Permission.Enable");
        }



        if (!gui1YML.isFile() || !yamlConfiguration_gui1.contains("Functions")) {
            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Item.Item", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Item §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Item.Name", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Name §4was added to §9First_GUI.yml§4!");

            List<String> lore = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Item.Lore", lore);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Lore §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Cost.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Cost Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Cost.Price", DefultValue_GUI_1.L6_S1_Price);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Cost Price §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Command.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Command Enable §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Command.Command", "");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Command Command §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Message.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Message Enable §4was added to §9First_GUI.yml§4!");

            List<String> msg = new ArrayList<>();
            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Message.Message", msg);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Message §4was added to §9First_GUI.yml§4!");

            yamlConfiguration_gui1.set("Functions.Line_6.Slot_1.Permission.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Permission Enable §4was added to §9First_GUI.yml§4!");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Enable")) {
            DefultValue_GUI_1.L6_S1_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_1.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Item.Item")) {
            DefultValue_GUI_1.L6_S1_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Item.Name")) {
            DefultValue_GUI_1.L6_S1_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_1.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Item.Lore")) {
            DefultValue_GUI_1.L6_S1_Lore = yamlConfiguration_gui1.getList("Functions.Line_6.Slot_1.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Cost.Enable")) {
            DefultValue_GUI_1.L6_S1_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_1.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Cost.Price")) {
            DefultValue_GUI_1.L6_S1_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_6.Slot_1.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Command.Enable")) {
            DefultValue_GUI_1.L6_S1_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_1.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Command.Command")) {
            DefultValue_GUI_1.L6_S1_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_1.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Message.Enable")) {
            DefultValue_GUI_1.L6_S1_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_1.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Message.Message")) {
            DefultValue_GUI_1.L6_S1_Message = yamlConfiguration_gui1.getStringList("Functions.Line_6.Slot_1.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_1.Permission.Enable")) {
            DefultValue_GUI_1.L6_S1_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_1.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Enable")) {
            DefultValue_GUI_1.L6_S2_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_2.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Item.Item")) {
            DefultValue_GUI_1.L6_S2_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Item.Name")) {
            DefultValue_GUI_1.L6_S2_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_2.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Item.Lore")) {
            DefultValue_GUI_1.L6_S2_Lore = yamlConfiguration_gui1.getList("Functions.Line_6.Slot_2.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Cost.Enable")) {
            DefultValue_GUI_1.L6_S2_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_2.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Cost.Price")) {
            DefultValue_GUI_1.L6_S2_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_6.Slot_2.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Command.Enable")) {
            DefultValue_GUI_1.L6_S2_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_2.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Command.Command")) {
            DefultValue_GUI_1.L6_S2_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_2.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Message.Enable")) {
            DefultValue_GUI_1.L6_S2_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_2.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Message.Message")) {
            DefultValue_GUI_1.L6_S2_Message = yamlConfiguration_gui1.getStringList("Functions.Line_6.Slot_2.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_2.Permission.Enable")) {
            DefultValue_GUI_1.L6_S2_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_2.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Enable")) {
            DefultValue_GUI_1.L6_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L6_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L6_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L6_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_6.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L6_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L6_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_6.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L6_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L6_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L6_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L6_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_6.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L6_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Enable")) {
            DefultValue_GUI_1.L6_S3_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_3.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Item.Item")) {
            DefultValue_GUI_1.L6_S3_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Item.Name")) {
            DefultValue_GUI_1.L6_S3_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_3.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Item.Lore")) {
            DefultValue_GUI_1.L6_S3_Lore = yamlConfiguration_gui1.getList("Functions.Line_6.Slot_3.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Cost.Enable")) {
            DefultValue_GUI_1.L6_S3_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_3.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Cost.Price")) {
            DefultValue_GUI_1.L6_S3_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_6.Slot_3.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Command.Enable")) {
            DefultValue_GUI_1.L6_S3_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_3.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Command.Command")) {
            DefultValue_GUI_1.L6_S3_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_3.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Message.Enable")) {
            DefultValue_GUI_1.L6_S3_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_3.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Message.Message")) {
            DefultValue_GUI_1.L6_S3_Message = yamlConfiguration_gui1.getStringList("Functions.Line_6.Slot_3.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_3.Permission.Enable")) {
            DefultValue_GUI_1.L6_S3_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_3.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Enable")) {
            DefultValue_GUI_1.L6_S4_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_4.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Item.Item")) {
            DefultValue_GUI_1.L6_S4_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Item.Name")) {
            DefultValue_GUI_1.L6_S4_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_4.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Item.Lore")) {
            DefultValue_GUI_1.L6_S4_Lore = yamlConfiguration_gui1.getList("Functions.Line_6.Slot_4.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Cost.Enable")) {
            DefultValue_GUI_1.L6_S4_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_4.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Cost.Price")) {
            DefultValue_GUI_1.L6_S4_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_6.Slot_4.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Command.Enable")) {
            DefultValue_GUI_1.L6_S4_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_4.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Command.Command")) {
            DefultValue_GUI_1.L6_S4_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_4.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Message.Enable")) {
            DefultValue_GUI_1.L6_S4_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_4.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Message.Message")) {
            DefultValue_GUI_1.L6_S4_Message = yamlConfiguration_gui1.getStringList("Functions.Line_6.Slot_4.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_4.Permission.Enable")) {
            DefultValue_GUI_1.L6_S4_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_4.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Enable")) {
            DefultValue_GUI_1.L6_S5_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_5.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Item.Item")) {
            DefultValue_GUI_1.L6_S5_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Item.Name")) {
            DefultValue_GUI_1.L6_S5_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_5.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Item.Lore")) {
            DefultValue_GUI_1.L6_S5_Lore = yamlConfiguration_gui1.getList("Functions.Line_6.Slot_5.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Cost.Enable")) {
            DefultValue_GUI_1.L6_S5_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_5.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Cost.Price")) {
            DefultValue_GUI_1.L6_S5_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_6.Slot_5.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Command.Enable")) {
            DefultValue_GUI_1.L6_S5_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_5.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Command.Command")) {
            DefultValue_GUI_1.L6_S5_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_5.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Message.Enable")) {
            DefultValue_GUI_1.L6_S5_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_5.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Message.Message")) {
            DefultValue_GUI_1.L6_S5_Message = yamlConfiguration_gui1.getStringList("Functions.Line_6.Slot_5.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_5.Permission.Enable")) {
            DefultValue_GUI_1.L6_S5_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_5.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Enable")) {
            DefultValue_GUI_1.L6_S6_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_6.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Item.Item")) {
            DefultValue_GUI_1.L6_S6_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Item.Name")) {
            DefultValue_GUI_1.L6_S6_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_6.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Item.Lore")) {
            DefultValue_GUI_1.L6_S6_Lore = yamlConfiguration_gui1.getList("Functions.Line_6.Slot_6.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Cost.Enable")) {
            DefultValue_GUI_1.L6_S6_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_6.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Cost.Price")) {
            DefultValue_GUI_1.L6_S6_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_6.Slot_6.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Command.Enable")) {
            DefultValue_GUI_1.L6_S6_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_6.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Command.Command")) {
            DefultValue_GUI_1.L6_S6_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_6.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Message.Enable")) {
            DefultValue_GUI_1.L6_S6_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_6.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Message.Message")) {
            DefultValue_GUI_1.L6_S6_Message = yamlConfiguration_gui1.getStringList("Functions.Line_6.Slot_6.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_6.Permission.Enable")) {
            DefultValue_GUI_1.L6_S6_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_6.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Enable")) {
            DefultValue_GUI_1.L6_S7_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_7.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Item.Item")) {
            DefultValue_GUI_1.L6_S7_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Item.Name")) {
            DefultValue_GUI_1.L6_S7_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_7.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Item.Lore")) {
            DefultValue_GUI_1.L6_S7_Lore = yamlConfiguration_gui1.getList("Functions.Line_6.Slot_7.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Cost.Enable")) {
            DefultValue_GUI_1.L6_S7_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_7.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Cost.Price")) {
            DefultValue_GUI_1.L6_S7_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_6.Slot_7.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Command.Enable")) {
            DefultValue_GUI_1.L6_S7_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_7.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Command.Command")) {
            DefultValue_GUI_1.L6_S7_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_7.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Message.Enable")) {
            DefultValue_GUI_1.L6_S7_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_7.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Message.Message")) {
            DefultValue_GUI_1.L6_S7_Message = yamlConfiguration_gui1.getStringList("Functions.Line_6.Slot_7.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_7.Permission.Enable")) {
            DefultValue_GUI_1.L6_S7_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_7.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Enable")) {
            DefultValue_GUI_1.L6_S8_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_8.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Item.Item")) {
            DefultValue_GUI_1.L6_S8_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Item.Name")) {
            DefultValue_GUI_1.L6_S8_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_8.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Item.Lore")) {
            DefultValue_GUI_1.L6_S8_Lore = yamlConfiguration_gui1.getList("Functions.Line_6.Slot_8.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Cost.Enable")) {
            DefultValue_GUI_1.L6_S8_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_8.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Cost.Price")) {
            DefultValue_GUI_1.L6_S8_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_6.Slot_8.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Command.Enable")) {
            DefultValue_GUI_1.L6_S8_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_8.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Command.Command")) {
            DefultValue_GUI_1.L6_S8_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_8.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Message.Enable")) {
            DefultValue_GUI_1.L6_S8_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_8.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Message.Message")) {
            DefultValue_GUI_1.L6_S8_Message = yamlConfiguration_gui1.getStringList("Functions.Line_6.Slot_8.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_8.Permission.Enable")) {
            DefultValue_GUI_1.L6_S8_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_8.Permission.Enable");
        }


        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Enable")) {
            DefultValue_GUI_1.L6_S9_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_9.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Item.Item")) {
            DefultValue_GUI_1.L6_S9_Item = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Item.Name")) {
            DefultValue_GUI_1.L6_S9_Name = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_9.Item.Name"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Item.Lore")) {
            DefultValue_GUI_1.L6_S9_Lore = yamlConfiguration_gui1.getList("Functions.Line_6.Slot_9.Item.Lore");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Cost.Enable")) {
            DefultValue_GUI_1.L6_S9_Cost_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_9.Cost.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Cost.Price")) {
            DefultValue_GUI_1.L6_S9_Price = (yamlConfiguration_gui1.getDouble("Functions.Line_6.Slot_9.Cost.Price"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Command.Enable")) {
            DefultValue_GUI_1.L6_S9_Command_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_9.Command.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Command.Command")) {
            DefultValue_GUI_1.L6_S9_Command = replace(yamlConfiguration_gui1.getString("Functions.Line_6.Slot_9.Command.Command"));
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Message.Enable")) {
            DefultValue_GUI_1.L6_S9_Message_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_9.Message.Enable");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Message.Message")) {
            DefultValue_GUI_1.L6_S9_Message = yamlConfiguration_gui1.getStringList("Functions.Line_6.Slot_9.Message.Message");
        }
        if (yamlConfiguration_gui1.contains("Functions.Line_6.Slot_9.Permission.Enable")) {
            DefultValue_GUI_1.L6_S9_Permission_Enable = yamlConfiguration_gui1.getBoolean("Functions.Line_6.Slot_9.Permission.Enable");
        }


        try {
            yamlConfiguration_gui1.save(gui1YML);
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
