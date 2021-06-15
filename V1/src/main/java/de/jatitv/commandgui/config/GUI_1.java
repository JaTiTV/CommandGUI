// This claas was created by JaTiTV

package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defaultValue.DefaultValue;
import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_1;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUI_1 {

    public static void configCreate(String version) throws InterruptedException {
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4GUI_1.yml load...");

        File GUI1YML = new File(Main.thisp().getDataFolder().getPath(), "GUIs/" + "GUI_1.yml");
        YamlConfiguration yamlConfiguration_GUI1 = YamlConfiguration.loadConfiguration(GUI1YML);

        if (!yamlConfiguration_GUI1.contains("Do_not_remove_or_change.Created"))
            yamlConfiguration_GUI1.set("Do_not_remove_or_change.Created", "This file was created with version " + version);
        yamlConfiguration_GUI1.set("Do_not_remove_or_change.Version", version);
        yamlConfiguration_GUI1.set("Do_not_remove_or_change.Autor", Main.Autor);
        yamlConfiguration_GUI1.set("Do_not_remove_or_change.Spigot", Main.Spigot);
        yamlConfiguration_GUI1.set("Do_not_remove_or_change.Discord", Main.DiscordMSG);


        if (yamlConfiguration_GUI1.contains("GUI.Enable")) {
            DefaultValue_GUI_1.GUI_Enable = (yamlConfiguration_GUI1.getBoolean("GUI.Enable"));
        } else {
            yamlConfiguration_GUI1.set("GUI.Enable", DefaultValue_GUI_1.GUI_Enable);
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6GUI Enable §4was added to §9GUI_1.yml§4!");
        }

        if (yamlConfiguration_GUI1.contains("GUI.Name")) {
            DefaultValue_GUI_1.GUIName = replace(yamlConfiguration_GUI1.getString("GUI.Name"));
        } else {
            yamlConfiguration_GUI1.set("GUI.Name", DefaultValue_GUI_1.GUIName.replace("§", "&"));
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6GUI Name §4was added to §9GUI_1.yml§4!");
        }
        if (Main.minecraft1_13){
            de.jatitv.commandgui.commands.GUI_1.GUI_NAME = DefaultValue_GUI_1.GUIName;
        } else de.jatitv.commandgui.commands.GUI_1.GUI_NAME = "§6§8§9§r" + DefaultValue_GUI_1.GUIName;

        if (yamlConfiguration_GUI1.contains("GUI.FillItem.Enable")) {
            DefaultValue_GUI_1.FillItem_Enable = (yamlConfiguration_GUI1.getBoolean("GUI.FillItem.Enable"));
        } else {
            yamlConfiguration_GUI1.set("GUI.FillItem.Enable", DefaultValue_GUI_1.FillItem_Enable);
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6GUI FillItem Enable §4was added to §9GUI_1.yml§4!");
        }

        if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            if (yamlConfiguration_GUI1.contains("GUI.FillItem.GlassPaneCollor")) {
                DefaultValue_GUI_1.FillItem_1_8 = ((short)yamlConfiguration_GUI1.getInt("GUI.FillItem.GlassPaneCollor"));
            } else {
                yamlConfiguration_GUI1.set("GUI.FillItem.GlassPaneCollor", DefaultValue_GUI_1.FillItem_1_8);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6GUI FillItem GlassPaneCollor §4was added to §9GUI_1.yml§4!");
            }
        } else {
            if (yamlConfiguration_GUI1.contains("GUI.FillItem.Item")) {
                DefaultValue_GUI_1.FillItem = replace(yamlConfiguration_GUI1.getString("GUI.FillItem.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("GUI.FillItem.Item", DefaultValue_GUI_1.FillItem);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6GUI FillItem Item §4was added to §9GUI_1.yml§4!");
            }
        }



        if (yamlConfiguration_GUI1.contains("GUI.Lines")) {
            DefaultValue_GUI_1.GUILines = Integer.valueOf(yamlConfiguration_GUI1.getString("GUI.Lines"));
        } else {
            yamlConfiguration_GUI1.set("GUI.Lines", 1);
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6GUI Lines §4was added to §9GUI_1.yml§4!");
        }
        if (yamlConfiguration_GUI1.getInt("GUI.Lines") > 6) {
            yamlConfiguration_GUI1.set("GUI.Lines", 6);
        }
        if (yamlConfiguration_GUI1.getInt("GUI.Lines") < 1) {
            yamlConfiguration_GUI1.set("GUI.Lines", 1);
        }

        if (yamlConfiguration_GUI1.contains("UseItem.GiveUseItemOnFirstJoin.Enable")) {
            DefaultValue_GUI_1.GiveUseItemOnFirstJoin = yamlConfiguration_GUI1.getBoolean("UseItem.GiveUseItemOnFirstJoin.Enable");
        } else {
            yamlConfiguration_GUI1.set("UseItem.GiveUseItemOnFirstJoin.Enable", DefaultValue_GUI_1.GiveUseItemOnFirstJoin);
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6UseItem GiveUseItemOnFirstJoin Enable §4was added to §9GUI_1.yml§4!");
        }

        if (yamlConfiguration_GUI1.contains("UseItem.GiveUseItemOnFirstJoin.Permission.Enable")) {
            DefaultValue_GUI_1.GiveUseItemOnFirstJoin_Permission_Enable = yamlConfiguration_GUI1.getBoolean("UseItem.GiveUseItemOnFirstJoin.Permission.Enable");
        } else {
            yamlConfiguration_GUI1.set("UseItem.GiveUseItemOnFirstJoin.Permission.Enable", DefaultValue_GUI_1.GiveUseItemOnFirstJoin_Permission_Enable);
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6UseItem GiveUseItemOnFirstJoin Permission Enable §4was added to §9GUI_1.yml§4!");
        }

        if (yamlConfiguration_GUI1.contains("UseItem.Item")) {
            DefaultValue_GUI_1.UseItem_Item = replace(yamlConfiguration_GUI1.getString("UseItem.Item").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_GUI1.set("UseItem.Item", DefaultValue_GUI_1.UseItem_Item);
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6UseItem Item §4was added to §9GUI_1.yml§4!");
        }

        if (yamlConfiguration_GUI1.contains("UseItem.Name")) {
            DefaultValue_GUI_1.UseItem_Name = replace(yamlConfiguration_GUI1.getString("UseItem.Name"));
        } else {
            yamlConfiguration_GUI1.set("UseItem.Name", DefaultValue_GUI_1.UseItem_Name.replace("§", "&"));
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6UseItem Name §4was added to §9GUI_1.yml§4!");
        }

        if (yamlConfiguration_GUI1.contains("UseItem.Lore")) {
            DefaultValue_GUI_1.UseItem_Lore = yamlConfiguration_GUI1.getList("UseItem.Lore");
        } else {
            List<String> lore = new ArrayList<>();
            yamlConfiguration_GUI1.set("UseItem.Lore", lore);
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6UseItem Lore §4was added to §9GUI_1.yml§4!");
        }

        if (yamlConfiguration_GUI1.contains("UseItem.Permission.Enable")) {
            DefaultValue_GUI_1.Permission_Enable = yamlConfiguration_GUI1.getBoolean("UseItem.Permission.Enable");
        } else {
            yamlConfiguration_GUI1.set("UseItem.Permission.Enable", DefaultValue_GUI_1.Permission_Enable);
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6UseItem Permission Enable §4was added to §9GUI_1.yml§4!");
        }

        if (yamlConfiguration_GUI1.contains("Command.Command")) {
            DefaultValue_GUI_1.Command = yamlConfiguration_GUI1.getString("Command.Command");
        } else {
            yamlConfiguration_GUI1.set("Command.Command", DefaultValue_GUI_1.Command);
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Command §4was added to §9GUI_1.yml§4!");
        }

        if (yamlConfiguration_GUI1.contains("Command.Permission")) {
            DefaultValue_GUI_1.Command_Permission_Enable = (yamlConfiguration_GUI1.getBoolean("Command.Permission"));
        } else {
            yamlConfiguration_GUI1.set("Command.Permission", DefaultValue_GUI_1.Command_Permission_Enable);
            if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Command Permission §4was added to §9GUI_1.yml§4!");
        }


        if (DefaultValue_GUI_1.GUILines == 1 || DefaultValue_GUI_1.GUILines > 1) {
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Enable")) {
                DefaultValue_GUI_1.L1_S1_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_1.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Enable", DefaultValue_GUI_1.L1_S1_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (!Main.minecraft1_8 || !Main.minecraft1_9 || !Main.minecraft1_10 || !Main.minecraft1_11 || !Main.minecraft1_12) {
                if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Playerhead")) {
                    DefaultValue_GUI_1.L1_S1_Playerhead = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_1.Playerhead");
                } else {
                    yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Playerhead", DefaultValue_GUI_1.L1_S1_Playerhead);
                    if (GUI1YML.isFile())
                        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Playerhead §4was added to §9GUI_1.yml§4!");
                }
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Item.Item")) {
                DefaultValue_GUI_1.L1_S1_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Item.Item", DefaultValue_GUI_1.L1_S1_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Item.Name")) {
                DefaultValue_GUI_1.L1_S1_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_1.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Item.Name", DefaultValue_GUI_1.L1_S1_Name.replace("§", "&"));
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Item.Lore")) {
                DefaultValue_GUI_1.L1_S1_Lore = yamlConfiguration_GUI1.getList("Functions.Line_1.Slot_1.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                lore.add("&8-----------------");
                lore.add("&bPlayer: &6%player_name%");
                lore.add("");
                lore.add("&eGamemode: &6%player_gamemode%");
                lore.add("&eHealth: &6%player_health_scale%");
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Cost.Enable")) {
                DefaultValue_GUI_1.L1_S1_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_1.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Cost.Enable", DefaultValue_GUI_1.L1_S1_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Cost.Price")) {
                DefaultValue_GUI_1.L1_S1_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_1.Slot_1.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Cost.Price", DefaultValue_GUI_1.L1_S1_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Command.Enable")) {
                DefaultValue_GUI_1.L1_S1_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_1.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Command.Enable", DefaultValue_GUI_1.L1_S1_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L1_S1_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_1.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Command.CommandAsConsole", DefaultValue_GUI_1.L1_S1_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Command.Command")) {
                DefaultValue_GUI_1.L1_S1_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_1.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Command.Command", DefaultValue_GUI_1.L1_S1_Command.replace("§", "&"));
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Message.Enable")) {
                DefaultValue_GUI_1.L1_S1_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_1.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Message.Enable", DefaultValue_GUI_1.L1_S1_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Message.Message")) {
                DefaultValue_GUI_1.L1_S1_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_1.Slot_1.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_1.Permission.Enable")) {
                DefaultValue_GUI_1.L1_S1_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_1.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_1.Permission.Enable", DefaultValue_GUI_1.L1_S1_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_1 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Enable")) {
                DefaultValue_GUI_1.L1_S2_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_2.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Enable", DefaultValue_GUI_1.L1_S2_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Item.Item")) {
                DefaultValue_GUI_1.L1_S2_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Item.Item", DefaultValue_GUI_1.L1_S2_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Item.Name")) {
                DefaultValue_GUI_1.L1_S2_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_2.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Item.Name", DefaultValue_GUI_1.L1_S2_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Item.Lore")) {
                DefaultValue_GUI_1.L1_S2_Lore = yamlConfiguration_GUI1.getList("Functions.Line_1.Slot_2.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Cost.Enable")) {
                DefaultValue_GUI_1.L1_S2_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_2.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Cost.Enable", DefaultValue_GUI_1.L1_S2_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Cost.Price")) {
                DefaultValue_GUI_1.L1_S2_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_1.Slot_2.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Cost.Price", DefaultValue_GUI_1.L1_S2_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Command.Enable")) {
                DefaultValue_GUI_1.L1_S2_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_2.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Command.Enable", DefaultValue_GUI_1.L1_S2_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L1_S2_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_2.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Command.CommandAsConsole", DefaultValue_GUI_1.L1_S2_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Command.Command")) {
                DefaultValue_GUI_1.L1_S2_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_2.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Command.Command", DefaultValue_GUI_1.L1_S2_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Message.Enable")) {
                DefaultValue_GUI_1.L1_S2_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_2.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Message.Enable", DefaultValue_GUI_1.L1_S2_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Message.Message")) {
                DefaultValue_GUI_1.L1_S2_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_1.Slot_2.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_2.Permission.Enable")) {
                DefaultValue_GUI_1.L1_S2_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_2.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_2.Permission.Enable", DefaultValue_GUI_1.L1_S2_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_2 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Enable")) {
                DefaultValue_GUI_1.L1_S3_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_3.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Enable", DefaultValue_GUI_1.L1_S3_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Item.Item")) {
                DefaultValue_GUI_1.L1_S3_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Item.Item", DefaultValue_GUI_1.L1_S3_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Item.Name")) {
                DefaultValue_GUI_1.L1_S3_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_3.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Item.Name", DefaultValue_GUI_1.L1_S3_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Item.Lore")) {
                DefaultValue_GUI_1.L1_S3_Lore = yamlConfiguration_GUI1.getList("Functions.Line_1.Slot_3.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Cost.Enable")) {
                DefaultValue_GUI_1.L1_S3_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_3.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Cost.Enable", DefaultValue_GUI_1.L1_S3_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Cost.Price")) {
                DefaultValue_GUI_1.L1_S3_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_1.Slot_3.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Cost.Price", DefaultValue_GUI_1.L1_S3_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Command.Enable")) {
                DefaultValue_GUI_1.L1_S3_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_3.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Command.Enable", DefaultValue_GUI_1.L1_S3_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L1_S3_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_3.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Command.CommandAsConsole", DefaultValue_GUI_1.L1_S3_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Command.Command")) {
                DefaultValue_GUI_1.L1_S3_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_3.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Command.Command", DefaultValue_GUI_1.L1_S3_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Message.Enable")) {
                DefaultValue_GUI_1.L1_S3_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_3.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Message.Enable", DefaultValue_GUI_1.L1_S3_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Message.Message")) {
                DefaultValue_GUI_1.L1_S3_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_1.Slot_3.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_3.Permission.Enable")) {
                DefaultValue_GUI_1.L1_S3_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_3.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_3.Permission.Enable", DefaultValue_GUI_1.L1_S3_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_3 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Enable")) {
                DefaultValue_GUI_1.L1_S4_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_4.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Enable", DefaultValue_GUI_1.L1_S4_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Item.Item")) {
                DefaultValue_GUI_1.L1_S4_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Item.Item", DefaultValue_GUI_1.L1_S4_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Item.Name")) {
                DefaultValue_GUI_1.L1_S4_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_4.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Item.Name", DefaultValue_GUI_1.L1_S4_Name.replace("§", "&"));
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Item.Lore")) {
                DefaultValue_GUI_1.L1_S4_Lore = yamlConfiguration_GUI1.getList("Functions.Line_1.Slot_4.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Cost.Enable")) {
                DefaultValue_GUI_1.L1_S4_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_4.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Cost.Enable", DefaultValue_GUI_1.L1_S4_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Cost.Price")) {
                DefaultValue_GUI_1.L1_S4_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_1.Slot_4.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Cost.Price", DefaultValue_GUI_1.L1_S4_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Command.Enable")) {
                DefaultValue_GUI_1.L1_S4_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_4.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Command.Enable", DefaultValue_GUI_1.L1_S4_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L1_S4_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_4.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Command.CommandAsConsole", DefaultValue_GUI_1.L1_S4_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Command.Command")) {
                DefaultValue_GUI_1.L1_S4_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_4.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Command.Command", DefaultValue_GUI_1.L1_S4_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Message.Enable")) {
                DefaultValue_GUI_1.L1_S4_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_4.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Message.Enable", DefaultValue_GUI_1.L1_S4_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Message.Message")) {
                DefaultValue_GUI_1.L1_S4_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_1.Slot_4.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                msg.add("[prefix] &cThe settings can be edited in the GUI_1.yml.");
                msg.add("[prefix] ");
                msg.add("[prefix] &bIn the GUI, placeholders can be used for the item names and lores.");
                msg.add("[prefix] &bIt is adjustable how many lines the GUI should have.");
                msg.add("[prefix] &aIt is possible to make functions chargeable &c(requires Vault and an Economy plugin)&a.");
                msg.add("[prefix] &bYou can send messages to the executing player.");
                msg.add("[prefix] &aYou can execute commands.");
                msg.add("[prefix] ");
                msg.add("[prefix] &2If you have further questions, please come to my Discord: &6" + Main.DiscordLink);
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_4.Permission.Enable")) {
                DefaultValue_GUI_1.L1_S4_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_4.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_4.Permission.Enable", DefaultValue_GUI_1.L1_S4_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_4 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Enable")) {
                DefaultValue_GUI_1.L1_S5_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_5.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Enable", DefaultValue_GUI_1.L1_S5_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Item.Item")) {
                DefaultValue_GUI_1.L1_S5_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Item.Item", DefaultValue_GUI_1.L1_S5_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Item.Name")) {
                DefaultValue_GUI_1.L1_S5_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_5.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Item.Name", DefaultValue_GUI_1.L1_S5_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Item.Lore")) {
                DefaultValue_GUI_1.L1_S5_Lore = yamlConfiguration_GUI1.getList("Functions.Line_1.Slot_5.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Cost.Enable")) {
                DefaultValue_GUI_1.L1_S5_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_5.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Cost.Enable", DefaultValue_GUI_1.L1_S5_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Cost.Price")) {
                DefaultValue_GUI_1.L1_S5_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_1.Slot_5.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Cost.Price", DefaultValue_GUI_1.L1_S5_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Command.Enable")) {
                DefaultValue_GUI_1.L1_S5_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_5.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Command.Enable", DefaultValue_GUI_1.L1_S5_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L1_S5_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_5.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Command.CommandAsConsole", DefaultValue_GUI_1.L1_S5_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Command.Command")) {
                DefaultValue_GUI_1.L1_S5_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_5.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Command.Command", DefaultValue_GUI_1.L1_S5_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Message.Enable")) {
                DefaultValue_GUI_1.L1_S5_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_5.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Message.Enable", DefaultValue_GUI_1.L1_S5_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Message.Message")) {
                DefaultValue_GUI_1.L1_S5_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_1.Slot_5.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_5.Permission.Enable")) {
                DefaultValue_GUI_1.L1_S5_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_5.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_5.Permission.Enable", DefaultValue_GUI_1.L1_S5_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_5 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Enable")) {
                DefaultValue_GUI_1.L1_S6_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_6.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Enable", DefaultValue_GUI_1.L1_S6_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Item.Item")) {
                DefaultValue_GUI_1.L1_S6_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Item.Item", DefaultValue_GUI_1.L1_S6_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Item.Name")) {
                DefaultValue_GUI_1.L1_S6_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_6.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Item.Name", DefaultValue_GUI_1.L1_S6_Name.replace("§", "&"));
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Item.Lore")) {
                DefaultValue_GUI_1.L1_S6_Lore = yamlConfiguration_GUI1.getList("Functions.Line_1.Slot_6.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Cost.Enable")) {
                DefaultValue_GUI_1.L1_S6_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_6.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Cost.Enable", DefaultValue_GUI_1.L1_S6_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Cost.Price")) {
                DefaultValue_GUI_1.L1_S6_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_1.Slot_6.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Cost.Price", DefaultValue_GUI_1.L1_S6_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Command.Enable")) {
                DefaultValue_GUI_1.L1_S6_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_6.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Command.Enable", DefaultValue_GUI_1.L1_S6_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L1_S6_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_6.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Command.CommandAsConsole", DefaultValue_GUI_1.L1_S6_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Command.Command")) {
                DefaultValue_GUI_1.L1_S6_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_6.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Command.Command", DefaultValue_GUI_1.L1_S6_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Message.Enable")) {
                DefaultValue_GUI_1.L1_S6_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_6.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Message.Enable", DefaultValue_GUI_1.L1_S6_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Message.Message")) {
                DefaultValue_GUI_1.L1_S6_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_1.Slot_6.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                msg.add("[prefix] &8------ &6More plugins from JaTiTV &8------");
                msg.add("[prefix]");
                msg.add("[prefix] &2Wonder&6Bag&9Shop &§7-> &bhttps://www.spigotmc.org/resources/wonderbagshop.89234/");
                msg.add("[prefix] &5PaPi&6Test &7-> &bhttps://www.spigotmc.org/resources/papitest-placeholderapi-tester.90439/");
                msg.add("[prefix]");
                msg.add("[prefix] &2All plugins from JaTiTV:");
                msg.add("[prefix] &bhttps://www.spigotmc.org/resources/authors/jatitv.1022547/");
                msg.add("[prefix] &8----------------------------------");

                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_6.Permission.Enable")) {
                DefaultValue_GUI_1.L1_S6_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_6.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_6.Permission.Enable", DefaultValue_GUI_1.L1_S6_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_6 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Enable")) {
                DefaultValue_GUI_1.L1_S7_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_7.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Enable", DefaultValue_GUI_1.L1_S7_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Item.Item")) {
                DefaultValue_GUI_1.L1_S7_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Item.Item", DefaultValue_GUI_1.L1_S7_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Item.Name")) {
                DefaultValue_GUI_1.L1_S7_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_7.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Item.Name", DefaultValue_GUI_1.L1_S7_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Item.Lore")) {
                DefaultValue_GUI_1.L1_S7_Lore = yamlConfiguration_GUI1.getList("Functions.Line_1.Slot_7.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Cost.Enable")) {
                DefaultValue_GUI_1.L1_S7_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_7.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Cost.Enable", DefaultValue_GUI_1.L1_S7_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Cost.Price")) {
                DefaultValue_GUI_1.L1_S7_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_1.Slot_7.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Cost.Price", DefaultValue_GUI_1.L1_S7_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Command.Enable")) {
                DefaultValue_GUI_1.L1_S7_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_7.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Command.Enable", DefaultValue_GUI_1.L1_S7_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L1_S7_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_7.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Command.CommandAsConsole", DefaultValue_GUI_1.L1_S7_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Command.Command")) {
                DefaultValue_GUI_1.L1_S7_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_7.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Command.Command", DefaultValue_GUI_1.L1_S7_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Message.Enable")) {
                DefaultValue_GUI_1.L1_S7_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_7.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Message.Enable", DefaultValue_GUI_1.L1_S7_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Message.Message")) {
                DefaultValue_GUI_1.L1_S7_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_1.Slot_7.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_7.Permission.Enable")) {
                DefaultValue_GUI_1.L1_S7_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_7.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_7.Permission.Enable", DefaultValue_GUI_1.L1_S7_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_7 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Enable")) {
                DefaultValue_GUI_1.L1_S8_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_8.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Enable", DefaultValue_GUI_1.L1_S8_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Item.Item")) {
                DefaultValue_GUI_1.L1_S8_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Item.Item", DefaultValue_GUI_1.L1_S8_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Item.Name")) {
                DefaultValue_GUI_1.L1_S8_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_8.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Item.Name", DefaultValue_GUI_1.L1_S8_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Item.Lore")) {
                DefaultValue_GUI_1.L1_S8_Lore = yamlConfiguration_GUI1.getList("Functions.Line_1.Slot_8.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Cost.Enable")) {
                DefaultValue_GUI_1.L1_S8_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_8.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Cost.Enable", DefaultValue_GUI_1.L1_S8_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Cost.Price")) {
                DefaultValue_GUI_1.L1_S8_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_1.Slot_8.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Cost.Price", DefaultValue_GUI_1.L1_S8_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Command.Enable")) {
                DefaultValue_GUI_1.L1_S8_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_8.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Command.Enable", DefaultValue_GUI_1.L1_S8_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L1_S8_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_8.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Command.CommandAsConsole", DefaultValue_GUI_1.L1_S8_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Command.Command")) {
                DefaultValue_GUI_1.L1_S8_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_8.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Command.Command", DefaultValue_GUI_1.L1_S8_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Message.Enable")) {
                DefaultValue_GUI_1.L1_S8_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_8.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Message.Enable", DefaultValue_GUI_1.L1_S8_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Message.Message")) {
                DefaultValue_GUI_1.L1_S8_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_1.Slot_8.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_8.Permission.Enable")) {
                DefaultValue_GUI_1.L1_S8_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_8.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_8.Permission.Enable", DefaultValue_GUI_1.L1_S8_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_8 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Enable")) {
                DefaultValue_GUI_1.L1_S9_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_9.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Enable", DefaultValue_GUI_1.L1_S9_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Item.Item")) {
                DefaultValue_GUI_1.L1_S9_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Item.Item", DefaultValue_GUI_1.L1_S9_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Item.Name")) {
                DefaultValue_GUI_1.L1_S9_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_9.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Item.Name", DefaultValue_GUI_1.L1_S9_Name.replace("§", "&"));
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Item.Lore")) {
                DefaultValue_GUI_1.L1_S9_Lore = yamlConfiguration_GUI1.getList("Functions.Line_1.Slot_9.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                lore.add("&8-----------------");
                lore.add("&65 minutes");
                lore.add("&5[price]");
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Cost.Enable")) {
                DefaultValue_GUI_1.L1_S9_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_9.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Cost.Enable", DefaultValue_GUI_1.L1_S9_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Cost.Price")) {
                DefaultValue_GUI_1.L1_S9_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_1.Slot_9.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Cost.Price", DefaultValue_GUI_1.L1_S9_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Command.Enable")) {
                DefaultValue_GUI_1.L1_S9_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_9.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Command.Enable", DefaultValue_GUI_1.L1_S9_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L1_S9_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_9.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Command.CommandAsConsole", DefaultValue_GUI_1.L1_S9_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Command.Command")) {
                DefaultValue_GUI_1.L1_S9_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_1.Slot_9.Command.Command"));
            } else {
                if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12){
                    DefaultValue_GUI_1.L1_S9_Command = "effect [player] night_vision 300 1 true";
                    yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Command.Command", DefaultValue_GUI_1.L1_S9_Command);
                } else {
                    DefaultValue_GUI_1.L1_S9_Command = "effect give [player] night_vision 300 1 true";
                    yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Command.Command", DefaultValue_GUI_1.L1_S9_Command);
                }

                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Message.Enable")) {
                DefaultValue_GUI_1.L1_S9_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_9.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Message.Enable", DefaultValue_GUI_1.L1_S9_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Message.Message")) {
                DefaultValue_GUI_1.L1_S9_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_1.Slot_9.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_1.Slot_9.Permission.Enable")) {
                DefaultValue_GUI_1.L1_S9_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_1.Slot_9.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_1.Slot_9.Permission.Enable", DefaultValue_GUI_1.L1_S9_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_1 Slot_9 Permission Enable §4was added to §9GUI_1.yml§4!");
            }
            Thread.sleep(500);
        }




        if (DefaultValue_GUI_1.GUILines == 2 || DefaultValue_GUI_1.GUILines > 2) {
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Enable")) {
                DefaultValue_GUI_1.L2_S1_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_1.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Enable", DefaultValue_GUI_1.L2_S1_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Item.Item")) {
                DefaultValue_GUI_1.L2_S1_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Item.Item", DefaultValue_GUI_1.L2_S1_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Item.Name")) {
                DefaultValue_GUI_1.L2_S1_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_1.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Item.Name", DefaultValue_GUI_1.L2_S1_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Item.Lore")) {
                DefaultValue_GUI_1.L2_S1_Lore = yamlConfiguration_GUI1.getList("Functions.Line_2.Slot_1.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Cost.Enable")) {
                DefaultValue_GUI_1.L2_S1_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_1.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Cost.Enable", DefaultValue_GUI_1.L2_S1_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Cost.Price")) {
                DefaultValue_GUI_1.L2_S1_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_2.Slot_1.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Cost.Price", DefaultValue_GUI_1.L2_S1_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Command.Enable")) {
                DefaultValue_GUI_1.L2_S1_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_1.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Command.Enable", DefaultValue_GUI_1.L2_S1_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L2_S1_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_1.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Command.CommandAsConsole", DefaultValue_GUI_1.L2_S1_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Command.Command")) {
                DefaultValue_GUI_1.L2_S1_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_1.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Command.Command", DefaultValue_GUI_1.L2_S1_Command.replace("§", "&"));
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Message.Enable")) {
                DefaultValue_GUI_1.L2_S1_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_1.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Message.Enable", DefaultValue_GUI_1.L2_S1_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Message.Message")) {
                DefaultValue_GUI_1.L2_S1_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_2.Slot_1.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_1.Permission.Enable")) {
                DefaultValue_GUI_1.L2_S1_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_1.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_1.Permission.Enable", DefaultValue_GUI_1.L2_S1_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_1 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Enable")) {
                DefaultValue_GUI_1.L2_S2_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_2.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Enable", DefaultValue_GUI_1.L2_S2_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Item.Item")) {
                DefaultValue_GUI_1.L2_S2_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Item.Item", DefaultValue_GUI_1.L2_S2_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Item.Name")) {
                DefaultValue_GUI_1.L2_S2_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_2.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Item.Name", DefaultValue_GUI_1.L2_S2_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Item.Lore")) {
                DefaultValue_GUI_1.L2_S2_Lore = yamlConfiguration_GUI1.getList("Functions.Line_2.Slot_2.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Cost.Enable")) {
                DefaultValue_GUI_1.L2_S2_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_2.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Cost.Enable", DefaultValue_GUI_1.L2_S2_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Cost.Price")) {
                DefaultValue_GUI_1.L2_S2_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_2.Slot_2.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Cost.Price", DefaultValue_GUI_1.L2_S2_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Command.Enable")) {
                DefaultValue_GUI_1.L2_S2_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_2.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Command.Enable", DefaultValue_GUI_1.L2_S2_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L2_S2_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_2.Command.L2_S9_CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Command.CommandAsConsole", DefaultValue_GUI_1.L2_S2_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Command.Command")) {
                DefaultValue_GUI_1.L2_S2_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_2.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Command.Command", DefaultValue_GUI_1.L2_S2_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Message.Enable")) {
                DefaultValue_GUI_1.L2_S2_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_2.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Message.Enable", DefaultValue_GUI_1.L2_S2_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Message.Message")) {
                DefaultValue_GUI_1.L2_S2_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_2.Slot_2.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_2.Permission.Enable")) {
                DefaultValue_GUI_1.L2_S2_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_2.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_2.Permission.Enable", DefaultValue_GUI_1.L2_S2_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_2 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Enable")) {
                DefaultValue_GUI_1.L2_S3_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_3.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Enable", DefaultValue_GUI_1.L2_S3_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Item.Item")) {
                DefaultValue_GUI_1.L2_S3_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Item.Item", DefaultValue_GUI_1.L2_S3_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Item.Name")) {
                DefaultValue_GUI_1.L2_S3_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_3.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Item.Name", DefaultValue_GUI_1.L2_S3_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Item.Lore")) {
                DefaultValue_GUI_1.L2_S3_Lore = yamlConfiguration_GUI1.getList("Functions.Line_2.Slot_3.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Cost.Enable")) {
                DefaultValue_GUI_1.L2_S3_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_3.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Cost.Enable", DefaultValue_GUI_1.L2_S3_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Cost.Price")) {
                DefaultValue_GUI_1.L2_S3_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_2.Slot_3.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Cost.Price", DefaultValue_GUI_1.L2_S3_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Command.Enable")) {
                DefaultValue_GUI_1.L2_S3_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_3.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Command.Enable", DefaultValue_GUI_1.L2_S3_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L2_S3_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_3.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Command.CommandAsConsole", DefaultValue_GUI_1.L2_S3_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Command.Command")) {
                DefaultValue_GUI_1.L2_S3_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_3.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Command.Command", DefaultValue_GUI_1.L2_S3_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Message.Enable")) {
                DefaultValue_GUI_1.L2_S3_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_3.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Message.Enable", DefaultValue_GUI_1.L2_S3_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Message.Message")) {
                DefaultValue_GUI_1.L2_S3_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_2.Slot_3.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_3.Permission.Enable")) {
                DefaultValue_GUI_1.L2_S3_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_3.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_3.Permission.Enable", DefaultValue_GUI_1.L2_S3_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_3 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Enable")) {
                DefaultValue_GUI_1.L2_S4_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_4.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Enable", DefaultValue_GUI_1.L2_S4_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Item.Item")) {
                DefaultValue_GUI_1.L2_S4_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Item.Item", DefaultValue_GUI_1.L2_S4_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Item.Name")) {
                DefaultValue_GUI_1.L2_S4_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_4.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Item.Name", DefaultValue_GUI_1.L2_S4_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Item.Lore")) {
                DefaultValue_GUI_1.L2_S4_Lore = yamlConfiguration_GUI1.getList("Functions.Line_2.Slot_4.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Cost.Enable")) {
                DefaultValue_GUI_1.L2_S4_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_4.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Cost.Enable", DefaultValue_GUI_1.L2_S4_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Cost.Price")) {
                DefaultValue_GUI_1.L2_S4_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_2.Slot_4.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Cost.Price", DefaultValue_GUI_1.L2_S4_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Command.Enable")) {
                DefaultValue_GUI_1.L2_S4_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_4.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Command.Enable", DefaultValue_GUI_1.L2_S4_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L2_S4_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_4.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Command.CommandAsConsole", DefaultValue_GUI_1.L2_S4_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Command.Command")) {
                DefaultValue_GUI_1.L2_S4_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_4.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Command.Command", DefaultValue_GUI_1.L2_S4_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Message.Enable")) {
                DefaultValue_GUI_1.L2_S4_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_4.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Message.Enable", DefaultValue_GUI_1.L2_S4_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Message.Message")) {
                DefaultValue_GUI_1.L2_S4_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_2.Slot_4.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_4.Permission.Enable")) {
                DefaultValue_GUI_1.L2_S4_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_4.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_4.Permission.Enable", DefaultValue_GUI_1.L2_S4_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_4 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Enable")) {
                DefaultValue_GUI_1.L2_S5_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_5.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Enable", DefaultValue_GUI_1.L2_S5_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Item.Item")) {
                DefaultValue_GUI_1.L2_S5_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Item.Item", DefaultValue_GUI_1.L2_S5_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Item.Name")) {
                DefaultValue_GUI_1.L2_S5_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_5.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Item.Name", DefaultValue_GUI_1.L2_S5_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Item.Lore")) {
                DefaultValue_GUI_1.L2_S5_Lore = yamlConfiguration_GUI1.getList("Functions.Line_2.Slot_5.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Cost.Enable")) {
                DefaultValue_GUI_1.L2_S5_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_5.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Cost.Enable", DefaultValue_GUI_1.L2_S5_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Cost.Price")) {
                DefaultValue_GUI_1.L2_S5_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_2.Slot_5.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Cost.Price", DefaultValue_GUI_1.L2_S5_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Command.Enable")) {
                DefaultValue_GUI_1.L2_S5_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_5.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Command.Enable", DefaultValue_GUI_1.L2_S5_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L2_S5_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_5.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Command.CommandAsConsole", DefaultValue_GUI_1.L2_S5_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Command.Command")) {
                DefaultValue_GUI_1.L2_S5_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_5.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Command.Command", DefaultValue_GUI_1.L2_S5_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Message.Enable")) {
                DefaultValue_GUI_1.L2_S5_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_5.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Message.Enable", DefaultValue_GUI_1.L2_S5_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Message.Message")) {
                DefaultValue_GUI_1.L2_S5_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_2.Slot_5.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_5.Permission.Enable")) {
                DefaultValue_GUI_1.L2_S5_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_5.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_5.Permission.Enable", DefaultValue_GUI_1.L2_S5_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_5 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Enable")) {
                DefaultValue_GUI_1.L2_S6_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_6.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Enable", DefaultValue_GUI_1.L2_S6_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Item.Item")) {
                DefaultValue_GUI_1.L2_S6_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Item.Item", DefaultValue_GUI_1.L2_S6_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Item.Name")) {
                DefaultValue_GUI_1.L2_S6_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_6.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Item.Name", DefaultValue_GUI_1.L2_S6_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Item.Lore")) {
                DefaultValue_GUI_1.L2_S6_Lore = yamlConfiguration_GUI1.getList("Functions.Line_2.Slot_6.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Cost.Enable")) {
                DefaultValue_GUI_1.L2_S6_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_6.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Cost.Enable", DefaultValue_GUI_1.L2_S6_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Cost.Price")) {
                DefaultValue_GUI_1.L2_S6_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_2.Slot_6.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Cost.Price", DefaultValue_GUI_1.L2_S6_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Command.Enable")) {
                DefaultValue_GUI_1.L2_S6_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_6.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Command.Enable", DefaultValue_GUI_1.L2_S6_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L2_S6_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_6.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Command.CommandAsConsole", DefaultValue_GUI_1.L2_S6_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Command.Command")) {
                DefaultValue_GUI_1.L2_S6_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_6.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Command.Command", DefaultValue_GUI_1.L2_S6_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Message.Enable")) {
                DefaultValue_GUI_1.L2_S6_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_6.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Message.Enable", DefaultValue_GUI_1.L2_S6_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Message.Message")) {
                DefaultValue_GUI_1.L2_S6_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_2.Slot_6.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_6.Permission.Enable")) {
                DefaultValue_GUI_1.L2_S6_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_6.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_6.Permission.Enable", DefaultValue_GUI_1.L2_S6_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_6 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Enable")) {
                DefaultValue_GUI_1.L2_S7_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_7.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Enable", DefaultValue_GUI_1.L2_S7_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Item.Item")) {
                DefaultValue_GUI_1.L2_S7_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Item.Item", DefaultValue_GUI_1.L2_S7_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Item.Name")) {
                DefaultValue_GUI_1.L2_S7_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_7.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Item.Name", DefaultValue_GUI_1.L2_S7_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Item.Lore")) {
                DefaultValue_GUI_1.L2_S7_Lore = yamlConfiguration_GUI1.getList("Functions.Line_2.Slot_7.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Cost.Enable")) {
                DefaultValue_GUI_1.L2_S7_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_7.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Cost.Enable", DefaultValue_GUI_1.L2_S7_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Cost.Price")) {
                DefaultValue_GUI_1.L2_S7_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_2.Slot_7.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Cost.Price", DefaultValue_GUI_1.L2_S7_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Command.Enable")) {
                DefaultValue_GUI_1.L2_S7_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_7.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Command.Enable", DefaultValue_GUI_1.L2_S7_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L2_S7_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_7.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Command.CommandAsConsole", DefaultValue_GUI_1.L2_S7_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Command.Command")) {
                DefaultValue_GUI_1.L2_S7_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_7.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Command.Command", DefaultValue_GUI_1.L2_S7_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Message.Enable")) {
                DefaultValue_GUI_1.L2_S7_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_7.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Message.Enable", DefaultValue_GUI_1.L2_S7_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Message.Message")) {
                DefaultValue_GUI_1.L2_S7_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_2.Slot_7.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_7.Permission.Enable")) {
                DefaultValue_GUI_1.L2_S7_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_7.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_7.Permission.Enable", DefaultValue_GUI_1.L2_S7_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_7 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Enable")) {
                DefaultValue_GUI_1.L2_S8_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_8.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Enable", DefaultValue_GUI_1.L2_S8_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Item.Item")) {
                DefaultValue_GUI_1.L2_S8_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Item.Item", DefaultValue_GUI_1.L2_S8_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Item.Name")) {
                DefaultValue_GUI_1.L2_S8_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_8.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Item.Name", DefaultValue_GUI_1.L2_S8_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Item.Lore")) {
                DefaultValue_GUI_1.L2_S8_Lore = yamlConfiguration_GUI1.getList("Functions.Line_2.Slot_8.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Cost.Enable")) {
                DefaultValue_GUI_1.L2_S8_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_8.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Cost.Enable", DefaultValue_GUI_1.L2_S8_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Cost.Price")) {
                DefaultValue_GUI_1.L2_S8_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_2.Slot_8.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Cost.Price", DefaultValue_GUI_1.L2_S8_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Command.Enable")) {
                DefaultValue_GUI_1.L2_S8_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_8.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Command.Enable", DefaultValue_GUI_1.L2_S8_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L2_S8_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_8.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Command.CommandAsConsole", DefaultValue_GUI_1.L2_S8_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Command.Command")) {
                DefaultValue_GUI_1.L2_S8_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_8.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Command.Command", DefaultValue_GUI_1.L2_S8_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Message.Enable")) {
                DefaultValue_GUI_1.L2_S8_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_8.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Message.Enable", DefaultValue_GUI_1.L2_S8_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Message.Message")) {
                DefaultValue_GUI_1.L2_S8_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_2.Slot_8.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_8.Permission.Enable")) {
                DefaultValue_GUI_1.L2_S8_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_8.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_8.Permission.Enable", DefaultValue_GUI_1.L2_S8_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_8 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Enable")) {
                DefaultValue_GUI_1.L2_S9_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_9.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Enable", DefaultValue_GUI_1.L2_S9_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Item.Item")) {
                DefaultValue_GUI_1.L2_S9_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Item.Item", DefaultValue_GUI_1.L2_S9_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Item.Name")) {
                DefaultValue_GUI_1.L2_S9_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_9.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Item.Name", DefaultValue_GUI_1.L2_S9_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Item.Lore")) {
                DefaultValue_GUI_1.L2_S9_Lore = yamlConfiguration_GUI1.getList("Functions.Line_2.Slot_9.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Cost.Enable")) {
                DefaultValue_GUI_1.L2_S9_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_9.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Cost.Enable", DefaultValue_GUI_1.L2_S9_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Cost.Price")) {
                DefaultValue_GUI_1.L2_S9_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_2.Slot_9.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Cost.Price", DefaultValue_GUI_1.L2_S9_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Command.Enable")) {
                DefaultValue_GUI_1.L2_S9_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_9.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Command.Enable", DefaultValue_GUI_1.L2_S9_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L2_S9_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_9.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Command.CommandAsConsole", DefaultValue_GUI_1.L2_S9_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Command.Command")) {
                DefaultValue_GUI_1.L2_S9_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_2.Slot_9.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Command.Command", DefaultValue_GUI_1.L2_S9_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Message.Enable")) {
                DefaultValue_GUI_1.L2_S9_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_9.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Message.Enable", DefaultValue_GUI_1.L2_S9_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Message.Message")) {
                DefaultValue_GUI_1.L2_S9_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_2.Slot_9.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_2.Slot_9.Permission.Enable")) {
                DefaultValue_GUI_1.L2_S9_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_2.Slot_9.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_2.Slot_9.Permission.Enable", DefaultValue_GUI_1.L2_S9_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_2 Slot_9 Permission Enable §4was added to §9GUI_1.yml§4!");
            }
            Thread.sleep(500);
        }



        if (DefaultValue_GUI_1.GUILines == 3 || DefaultValue_GUI_1.GUILines > 3) {
            Bukkit.getConsoleSender().sendMessage("§5----------------------------------------------------------");
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Enable")) {
                DefaultValue_GUI_1.L3_S1_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_1.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Enable", DefaultValue_GUI_1.L3_S1_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Item.Item")) {
                DefaultValue_GUI_1.L3_S1_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Item.Item", DefaultValue_GUI_1.L3_S1_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Item.Name")) {
                DefaultValue_GUI_1.L3_S1_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_1.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Item.Name", DefaultValue_GUI_1.L3_S1_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Item.Lore")) {
                DefaultValue_GUI_1.L3_S1_Lore = yamlConfiguration_GUI1.getList("Functions.Line_3.Slot_1.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Cost.Enable")) {
                DefaultValue_GUI_1.L3_S1_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_1.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Cost.Enable", DefaultValue_GUI_1.L3_S1_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Cost.Price")) {
                DefaultValue_GUI_1.L3_S1_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_3.Slot_1.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Cost.Price", DefaultValue_GUI_1.L3_S1_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Command.Enable")) {
                DefaultValue_GUI_1.L3_S1_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_1.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Command.Enable", DefaultValue_GUI_1.L3_S1_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L3_S1_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_1.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Command.CommandAsConsole", DefaultValue_GUI_1.L3_S1_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Command.Command")) {
                DefaultValue_GUI_1.L3_S1_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_1.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Command.Command", DefaultValue_GUI_1.L3_S1_Command.replace("§", "&"));
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Message.Enable")) {
                DefaultValue_GUI_1.L3_S1_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_1.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Message.Enable", DefaultValue_GUI_1.L3_S1_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Message.Message")) {
                DefaultValue_GUI_1.L3_S1_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_3.Slot_1.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_1.Permission.Enable")) {
                DefaultValue_GUI_1.L3_S1_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_1.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_1.Permission.Enable", DefaultValue_GUI_1.L3_S1_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_1 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Enable")) {
                DefaultValue_GUI_1.L3_S2_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_2.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Enable", DefaultValue_GUI_1.L3_S2_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Item.Item")) {
                DefaultValue_GUI_1.L3_S2_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Item.Item", DefaultValue_GUI_1.L3_S2_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Item.Name")) {
                DefaultValue_GUI_1.L3_S2_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_2.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Item.Name", DefaultValue_GUI_1.L3_S2_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Item.Lore")) {
                DefaultValue_GUI_1.L3_S2_Lore = yamlConfiguration_GUI1.getList("Functions.Line_3.Slot_2.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Cost.Enable")) {
                DefaultValue_GUI_1.L3_S2_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_2.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Cost.Enable", DefaultValue_GUI_1.L3_S2_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Cost.Price")) {
                DefaultValue_GUI_1.L3_S2_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_3.Slot_2.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Cost.Price", DefaultValue_GUI_1.L3_S2_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Command.Enable")) {
                DefaultValue_GUI_1.L3_S2_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_2.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Command.Enable", DefaultValue_GUI_1.L3_S2_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L3_S2_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_2.Command.L3_S9_CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Command.CommandAsConsole", DefaultValue_GUI_1.L3_S2_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Command.Command")) {
                DefaultValue_GUI_1.L3_S2_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_2.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Command.Command", DefaultValue_GUI_1.L3_S2_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Message.Enable")) {
                DefaultValue_GUI_1.L3_S2_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_2.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Message.Enable", DefaultValue_GUI_1.L3_S2_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Message.Message")) {
                DefaultValue_GUI_1.L3_S2_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_3.Slot_2.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_2.Permission.Enable")) {
                DefaultValue_GUI_1.L3_S2_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_2.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_2.Permission.Enable", DefaultValue_GUI_1.L3_S2_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_2 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Enable")) {
                DefaultValue_GUI_1.L3_S3_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_3.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Enable", DefaultValue_GUI_1.L3_S3_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Item.Item")) {
                DefaultValue_GUI_1.L3_S3_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Item.Item", DefaultValue_GUI_1.L3_S3_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Item.Name")) {
                DefaultValue_GUI_1.L3_S3_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_3.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Item.Name", DefaultValue_GUI_1.L3_S3_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Item.Lore")) {
                DefaultValue_GUI_1.L3_S3_Lore = yamlConfiguration_GUI1.getList("Functions.Line_3.Slot_3.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Cost.Enable")) {
                DefaultValue_GUI_1.L3_S3_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_3.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Cost.Enable", DefaultValue_GUI_1.L3_S3_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Cost.Price")) {
                DefaultValue_GUI_1.L3_S3_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_3.Slot_3.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Cost.Price", DefaultValue_GUI_1.L3_S3_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Command.Enable")) {
                DefaultValue_GUI_1.L3_S3_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_3.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Command.Enable", DefaultValue_GUI_1.L3_S3_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L3_S3_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_3.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Command.CommandAsConsole", DefaultValue_GUI_1.L3_S3_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Command.Command")) {
                DefaultValue_GUI_1.L3_S3_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_3.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Command.Command", DefaultValue_GUI_1.L3_S3_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Message.Enable")) {
                DefaultValue_GUI_1.L3_S3_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_3.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Message.Enable", DefaultValue_GUI_1.L3_S3_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Message.Message")) {
                DefaultValue_GUI_1.L3_S3_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_3.Slot_3.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_3.Permission.Enable")) {
                DefaultValue_GUI_1.L3_S3_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_3.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_3.Permission.Enable", DefaultValue_GUI_1.L3_S3_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_3 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Enable")) {
                DefaultValue_GUI_1.L3_S4_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_4.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Enable", DefaultValue_GUI_1.L3_S4_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Item.Item")) {
                DefaultValue_GUI_1.L3_S4_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Item.Item", DefaultValue_GUI_1.L3_S4_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Item.Name")) {
                DefaultValue_GUI_1.L3_S4_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_4.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Item.Name", DefaultValue_GUI_1.L3_S4_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Item.Lore")) {
                DefaultValue_GUI_1.L3_S4_Lore = yamlConfiguration_GUI1.getList("Functions.Line_3.Slot_4.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Cost.Enable")) {
                DefaultValue_GUI_1.L3_S4_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_4.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Cost.Enable", DefaultValue_GUI_1.L3_S4_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Cost.Price")) {
                DefaultValue_GUI_1.L3_S4_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_3.Slot_4.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Cost.Price", DefaultValue_GUI_1.L3_S4_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Command.Enable")) {
                DefaultValue_GUI_1.L3_S4_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_4.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Command.Enable", DefaultValue_GUI_1.L3_S4_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L3_S4_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_4.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Command.CommandAsConsole", DefaultValue_GUI_1.L3_S4_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Command.Command")) {
                DefaultValue_GUI_1.L3_S4_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_4.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Command.Command", DefaultValue_GUI_1.L3_S4_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Message.Enable")) {
                DefaultValue_GUI_1.L3_S4_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_4.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Message.Enable", DefaultValue_GUI_1.L3_S4_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Message.Message")) {
                DefaultValue_GUI_1.L3_S4_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_3.Slot_4.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_4.Permission.Enable")) {
                DefaultValue_GUI_1.L3_S4_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_4.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_4.Permission.Enable", DefaultValue_GUI_1.L3_S4_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_4 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Enable")) {
                DefaultValue_GUI_1.L3_S5_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_5.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Enable", DefaultValue_GUI_1.L3_S5_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Item.Item")) {
                DefaultValue_GUI_1.L3_S5_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Item.Item", DefaultValue_GUI_1.L3_S5_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Item.Name")) {
                DefaultValue_GUI_1.L3_S5_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_5.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Item.Name", DefaultValue_GUI_1.L3_S5_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Item.Lore")) {
                DefaultValue_GUI_1.L3_S5_Lore = yamlConfiguration_GUI1.getList("Functions.Line_3.Slot_5.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Cost.Enable")) {
                DefaultValue_GUI_1.L3_S5_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_5.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Cost.Enable", DefaultValue_GUI_1.L3_S5_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Cost.Price")) {
                DefaultValue_GUI_1.L3_S5_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_3.Slot_5.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Cost.Price", DefaultValue_GUI_1.L3_S5_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Command.Enable")) {
                DefaultValue_GUI_1.L3_S5_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_5.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Command.Enable", DefaultValue_GUI_1.L3_S5_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L3_S5_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_5.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Command.CommandAsConsole", DefaultValue_GUI_1.L3_S5_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Command.Command")) {
                DefaultValue_GUI_1.L3_S5_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_5.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Command.Command", DefaultValue_GUI_1.L3_S5_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Message.Enable")) {
                DefaultValue_GUI_1.L3_S5_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_5.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Message.Enable", DefaultValue_GUI_1.L3_S5_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Message.Message")) {
                DefaultValue_GUI_1.L3_S5_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_3.Slot_5.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_5.Permission.Enable")) {
                DefaultValue_GUI_1.L3_S5_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_5.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_5.Permission.Enable", DefaultValue_GUI_1.L3_S5_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_5 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Enable")) {
                DefaultValue_GUI_1.L3_S6_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_6.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Enable", DefaultValue_GUI_1.L3_S6_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Item.Item")) {
                DefaultValue_GUI_1.L3_S6_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Item.Item", DefaultValue_GUI_1.L3_S6_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Item.Name")) {
                DefaultValue_GUI_1.L3_S6_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_6.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Item.Name", DefaultValue_GUI_1.L3_S6_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Item.Lore")) {
                DefaultValue_GUI_1.L3_S6_Lore = yamlConfiguration_GUI1.getList("Functions.Line_3.Slot_6.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Cost.Enable")) {
                DefaultValue_GUI_1.L3_S6_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_6.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Cost.Enable", DefaultValue_GUI_1.L3_S6_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Cost.Price")) {
                DefaultValue_GUI_1.L3_S6_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_3.Slot_6.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Cost.Price", DefaultValue_GUI_1.L3_S6_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Command.Enable")) {
                DefaultValue_GUI_1.L3_S6_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_6.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Command.Enable", DefaultValue_GUI_1.L3_S6_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L3_S6_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_6.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Command.CommandAsConsole", DefaultValue_GUI_1.L3_S6_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Command.Command")) {
                DefaultValue_GUI_1.L3_S6_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_6.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Command.Command", DefaultValue_GUI_1.L3_S6_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Message.Enable")) {
                DefaultValue_GUI_1.L3_S6_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_6.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Message.Enable", DefaultValue_GUI_1.L3_S6_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Message.Message")) {
                DefaultValue_GUI_1.L3_S6_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_3.Slot_6.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_6.Permission.Enable")) {
                DefaultValue_GUI_1.L3_S6_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_6.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_6.Permission.Enable", DefaultValue_GUI_1.L3_S6_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_6 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Enable")) {
                DefaultValue_GUI_1.L3_S7_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_7.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Enable", DefaultValue_GUI_1.L3_S7_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Item.Item")) {
                DefaultValue_GUI_1.L3_S7_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Item.Item", DefaultValue_GUI_1.L3_S7_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Item.Name")) {
                DefaultValue_GUI_1.L3_S7_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_7.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Item.Name", DefaultValue_GUI_1.L3_S7_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Item.Lore")) {
                DefaultValue_GUI_1.L3_S7_Lore = yamlConfiguration_GUI1.getList("Functions.Line_3.Slot_7.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Cost.Enable")) {
                DefaultValue_GUI_1.L3_S7_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_7.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Cost.Enable", DefaultValue_GUI_1.L3_S7_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Cost.Price")) {
                DefaultValue_GUI_1.L3_S7_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_3.Slot_7.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Cost.Price", DefaultValue_GUI_1.L3_S7_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Command.Enable")) {
                DefaultValue_GUI_1.L3_S7_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_7.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Command.Enable", DefaultValue_GUI_1.L3_S7_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L3_S7_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_7.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Command.CommandAsConsole", DefaultValue_GUI_1.L3_S7_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Command.Command")) {
                DefaultValue_GUI_1.L3_S7_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_7.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Command.Command", DefaultValue_GUI_1.L3_S7_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Message.Enable")) {
                DefaultValue_GUI_1.L3_S7_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_7.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Message.Enable", DefaultValue_GUI_1.L3_S7_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Message.Message")) {
                DefaultValue_GUI_1.L3_S7_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_3.Slot_7.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_7.Permission.Enable")) {
                DefaultValue_GUI_1.L3_S7_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_7.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_7.Permission.Enable", DefaultValue_GUI_1.L3_S7_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_7 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Enable")) {
                DefaultValue_GUI_1.L3_S8_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_8.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Enable", DefaultValue_GUI_1.L3_S8_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Item.Item")) {
                DefaultValue_GUI_1.L3_S8_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Item.Item", DefaultValue_GUI_1.L3_S8_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Item.Name")) {
                DefaultValue_GUI_1.L3_S8_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_8.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Item.Name", DefaultValue_GUI_1.L3_S8_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Item.Lore")) {
                DefaultValue_GUI_1.L3_S8_Lore = yamlConfiguration_GUI1.getList("Functions.Line_3.Slot_8.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Cost.Enable")) {
                DefaultValue_GUI_1.L3_S8_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_8.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Cost.Enable", DefaultValue_GUI_1.L3_S8_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Cost.Price")) {
                DefaultValue_GUI_1.L3_S8_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_3.Slot_8.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Cost.Price", DefaultValue_GUI_1.L3_S8_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Command.Enable")) {
                DefaultValue_GUI_1.L3_S8_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_8.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Command.Enable", DefaultValue_GUI_1.L3_S8_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L3_S8_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_8.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Command.CommandAsConsole", DefaultValue_GUI_1.L3_S8_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Command.Command")) {
                DefaultValue_GUI_1.L3_S8_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_8.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Command.Command", DefaultValue_GUI_1.L3_S8_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Message.Enable")) {
                DefaultValue_GUI_1.L3_S8_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_8.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Message.Enable", DefaultValue_GUI_1.L3_S8_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Message.Message")) {
                DefaultValue_GUI_1.L3_S8_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_3.Slot_8.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_8.Permission.Enable")) {
                DefaultValue_GUI_1.L3_S8_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_8.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_8.Permission.Enable", DefaultValue_GUI_1.L3_S8_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_8 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Enable")) {
                DefaultValue_GUI_1.L3_S9_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_9.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Enable", DefaultValue_GUI_1.L3_S9_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Item.Item")) {
                DefaultValue_GUI_1.L3_S9_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Item.Item", DefaultValue_GUI_1.L3_S9_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Item.Name")) {
                DefaultValue_GUI_1.L3_S9_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_9.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Item.Name", DefaultValue_GUI_1.L3_S9_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Item.Lore")) {
                DefaultValue_GUI_1.L3_S9_Lore = yamlConfiguration_GUI1.getList("Functions.Line_3.Slot_9.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Cost.Enable")) {
                DefaultValue_GUI_1.L3_S9_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_9.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Cost.Enable", DefaultValue_GUI_1.L3_S9_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Cost.Price")) {
                DefaultValue_GUI_1.L3_S9_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_3.Slot_9.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Cost.Price", DefaultValue_GUI_1.L3_S9_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Command.Enable")) {
                DefaultValue_GUI_1.L3_S9_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_9.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Command.Enable", DefaultValue_GUI_1.L3_S9_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L3_S9_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_9.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Command.CommandAsConsole", DefaultValue_GUI_1.L3_S9_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Command.Command")) {
                DefaultValue_GUI_1.L3_S9_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_3.Slot_9.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Command.Command", DefaultValue_GUI_1.L3_S9_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Message.Enable")) {
                DefaultValue_GUI_1.L3_S9_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_9.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Message.Enable", DefaultValue_GUI_1.L3_S9_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Message.Message")) {
                DefaultValue_GUI_1.L3_S9_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_3.Slot_9.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_3.Slot_9.Permission.Enable")) {
                DefaultValue_GUI_1.L3_S9_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_3.Slot_9.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_3.Slot_9.Permission.Enable", DefaultValue_GUI_1.L3_S9_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_3 Slot_9 Permission Enable §4was added to §9GUI_1.yml§4!");
            }
            Thread.sleep(500);
        }



        if (DefaultValue_GUI_1.GUILines == 4 || DefaultValue_GUI_1.GUILines > 4) {
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Enable")) {
                DefaultValue_GUI_1.L4_S1_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_1.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Enable", DefaultValue_GUI_1.L4_S1_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Item.Item")) {
                DefaultValue_GUI_1.L4_S1_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Item.Item", DefaultValue_GUI_1.L4_S1_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Item.Name")) {
                DefaultValue_GUI_1.L4_S1_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_1.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Item.Name", DefaultValue_GUI_1.L4_S1_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Item.Lore")) {
                DefaultValue_GUI_1.L4_S1_Lore = yamlConfiguration_GUI1.getList("Functions.Line_4.Slot_1.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Cost.Enable")) {
                DefaultValue_GUI_1.L4_S1_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_1.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Cost.Enable", DefaultValue_GUI_1.L4_S1_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Cost.Price")) {
                DefaultValue_GUI_1.L4_S1_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_4.Slot_1.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Cost.Price", DefaultValue_GUI_1.L4_S1_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Command.Enable")) {
                DefaultValue_GUI_1.L4_S1_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_1.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Command.Enable", DefaultValue_GUI_1.L4_S1_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L4_S1_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_1.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Command.CommandAsConsole", DefaultValue_GUI_1.L4_S1_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Command.Command")) {
                DefaultValue_GUI_1.L4_S1_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_1.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Command.Command", DefaultValue_GUI_1.L4_S1_Command.replace("§", "&"));
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Message.Enable")) {
                DefaultValue_GUI_1.L4_S1_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_1.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Message.Enable", DefaultValue_GUI_1.L4_S1_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Message.Message")) {
                DefaultValue_GUI_1.L4_S1_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_4.Slot_1.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_1.Permission.Enable")) {
                DefaultValue_GUI_1.L4_S1_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_1.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_1.Permission.Enable", DefaultValue_GUI_1.L4_S1_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_1 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Enable")) {
                DefaultValue_GUI_1.L4_S2_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_2.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Enable", DefaultValue_GUI_1.L4_S2_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Item.Item")) {
                DefaultValue_GUI_1.L4_S2_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Item.Item", DefaultValue_GUI_1.L4_S2_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Item.Name")) {
                DefaultValue_GUI_1.L4_S2_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_2.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Item.Name", DefaultValue_GUI_1.L4_S2_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Item.Lore")) {
                DefaultValue_GUI_1.L4_S2_Lore = yamlConfiguration_GUI1.getList("Functions.Line_4.Slot_2.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Cost.Enable")) {
                DefaultValue_GUI_1.L4_S2_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_2.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Cost.Enable", DefaultValue_GUI_1.L4_S2_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Cost.Price")) {
                DefaultValue_GUI_1.L4_S2_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_4.Slot_2.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Cost.Price", DefaultValue_GUI_1.L4_S2_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Command.Enable")) {
                DefaultValue_GUI_1.L4_S2_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_2.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Command.Enable", DefaultValue_GUI_1.L4_S2_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L4_S2_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_2.Command.L4_S9_CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Command.CommandAsConsole", DefaultValue_GUI_1.L4_S2_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Command.Command")) {
                DefaultValue_GUI_1.L4_S2_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_2.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Command.Command", DefaultValue_GUI_1.L4_S2_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Message.Enable")) {
                DefaultValue_GUI_1.L4_S2_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_2.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Message.Enable", DefaultValue_GUI_1.L4_S2_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Message.Message")) {
                DefaultValue_GUI_1.L4_S2_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_4.Slot_2.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_2.Permission.Enable")) {
                DefaultValue_GUI_1.L4_S2_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_2.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_2.Permission.Enable", DefaultValue_GUI_1.L4_S2_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_2 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Enable")) {
                DefaultValue_GUI_1.L4_S3_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_3.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Enable", DefaultValue_GUI_1.L4_S3_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Item.Item")) {
                DefaultValue_GUI_1.L4_S3_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Item.Item", DefaultValue_GUI_1.L4_S3_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Item.Name")) {
                DefaultValue_GUI_1.L4_S3_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_3.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Item.Name", DefaultValue_GUI_1.L4_S3_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Item.Lore")) {
                DefaultValue_GUI_1.L4_S3_Lore = yamlConfiguration_GUI1.getList("Functions.Line_4.Slot_3.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Cost.Enable")) {
                DefaultValue_GUI_1.L4_S3_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_3.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Cost.Enable", DefaultValue_GUI_1.L4_S3_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Cost.Price")) {
                DefaultValue_GUI_1.L4_S3_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_4.Slot_3.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Cost.Price", DefaultValue_GUI_1.L4_S3_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Command.Enable")) {
                DefaultValue_GUI_1.L4_S3_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_3.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Command.Enable", DefaultValue_GUI_1.L4_S3_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L4_S3_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_3.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Command.CommandAsConsole", DefaultValue_GUI_1.L4_S3_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Command.Command")) {
                DefaultValue_GUI_1.L4_S3_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_3.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Command.Command", DefaultValue_GUI_1.L4_S3_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Message.Enable")) {
                DefaultValue_GUI_1.L4_S3_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_3.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Message.Enable", DefaultValue_GUI_1.L4_S3_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Message.Message")) {
                DefaultValue_GUI_1.L4_S3_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_4.Slot_3.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_3.Permission.Enable")) {
                DefaultValue_GUI_1.L4_S3_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_3.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_3.Permission.Enable", DefaultValue_GUI_1.L4_S3_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_3 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Enable")) {
                DefaultValue_GUI_1.L4_S4_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_4.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Enable", DefaultValue_GUI_1.L4_S4_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Item.Item")) {
                DefaultValue_GUI_1.L4_S4_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Item.Item", DefaultValue_GUI_1.L4_S4_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Item.Name")) {
                DefaultValue_GUI_1.L4_S4_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_4.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Item.Name", DefaultValue_GUI_1.L4_S4_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Item.Lore")) {
                DefaultValue_GUI_1.L4_S4_Lore = yamlConfiguration_GUI1.getList("Functions.Line_4.Slot_4.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Cost.Enable")) {
                DefaultValue_GUI_1.L4_S4_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_4.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Cost.Enable", DefaultValue_GUI_1.L4_S4_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Cost.Price")) {
                DefaultValue_GUI_1.L4_S4_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_4.Slot_4.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Cost.Price", DefaultValue_GUI_1.L4_S4_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Command.Enable")) {
                DefaultValue_GUI_1.L4_S4_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_4.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Command.Enable", DefaultValue_GUI_1.L4_S4_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L4_S4_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_4.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Command.CommandAsConsole", DefaultValue_GUI_1.L4_S4_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Command.Command")) {
                DefaultValue_GUI_1.L4_S4_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_4.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Command.Command", DefaultValue_GUI_1.L4_S4_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Message.Enable")) {
                DefaultValue_GUI_1.L4_S4_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_4.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Message.Enable", DefaultValue_GUI_1.L4_S4_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Message.Message")) {
                DefaultValue_GUI_1.L4_S4_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_4.Slot_4.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_4.Permission.Enable")) {
                DefaultValue_GUI_1.L4_S4_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_4.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_4.Permission.Enable", DefaultValue_GUI_1.L4_S4_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_4 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Enable")) {
                DefaultValue_GUI_1.L4_S5_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_5.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Enable", DefaultValue_GUI_1.L4_S5_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Item.Item")) {
                DefaultValue_GUI_1.L4_S5_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Item.Item", DefaultValue_GUI_1.L4_S5_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Item.Name")) {
                DefaultValue_GUI_1.L4_S5_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_5.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Item.Name", DefaultValue_GUI_1.L4_S5_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Item.Lore")) {
                DefaultValue_GUI_1.L4_S5_Lore = yamlConfiguration_GUI1.getList("Functions.Line_4.Slot_5.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Cost.Enable")) {
                DefaultValue_GUI_1.L4_S5_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_5.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Cost.Enable", DefaultValue_GUI_1.L4_S5_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Cost.Price")) {
                DefaultValue_GUI_1.L4_S5_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_4.Slot_5.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Cost.Price", DefaultValue_GUI_1.L4_S5_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Command.Enable")) {
                DefaultValue_GUI_1.L4_S5_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_5.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Command.Enable", DefaultValue_GUI_1.L4_S5_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L4_S5_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_5.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Command.CommandAsConsole", DefaultValue_GUI_1.L4_S5_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Command.Command")) {
                DefaultValue_GUI_1.L4_S5_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_5.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Command.Command", DefaultValue_GUI_1.L4_S5_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Message.Enable")) {
                DefaultValue_GUI_1.L4_S5_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_5.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Message.Enable", DefaultValue_GUI_1.L4_S5_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Message.Message")) {
                DefaultValue_GUI_1.L4_S5_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_4.Slot_5.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_5.Permission.Enable")) {
                DefaultValue_GUI_1.L4_S5_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_5.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_5.Permission.Enable", DefaultValue_GUI_1.L4_S5_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_5 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Enable")) {
                DefaultValue_GUI_1.L4_S6_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_6.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Enable", DefaultValue_GUI_1.L4_S6_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Item.Item")) {
                DefaultValue_GUI_1.L4_S6_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Item.Item", DefaultValue_GUI_1.L4_S6_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Item.Name")) {
                DefaultValue_GUI_1.L4_S6_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_6.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Item.Name", DefaultValue_GUI_1.L4_S6_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Item.Lore")) {
                DefaultValue_GUI_1.L4_S6_Lore = yamlConfiguration_GUI1.getList("Functions.Line_4.Slot_6.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Cost.Enable")) {
                DefaultValue_GUI_1.L4_S6_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_6.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Cost.Enable", DefaultValue_GUI_1.L4_S6_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Cost.Price")) {
                DefaultValue_GUI_1.L4_S6_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_4.Slot_6.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Cost.Price", DefaultValue_GUI_1.L4_S6_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Command.Enable")) {
                DefaultValue_GUI_1.L4_S6_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_6.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Command.Enable", DefaultValue_GUI_1.L4_S6_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L4_S6_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_6.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Command.CommandAsConsole", DefaultValue_GUI_1.L4_S6_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Command.Command")) {
                DefaultValue_GUI_1.L4_S6_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_6.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Command.Command", DefaultValue_GUI_1.L4_S6_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Message.Enable")) {
                DefaultValue_GUI_1.L4_S6_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_6.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Message.Enable", DefaultValue_GUI_1.L4_S6_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Message.Message")) {
                DefaultValue_GUI_1.L4_S6_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_4.Slot_6.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_6.Permission.Enable")) {
                DefaultValue_GUI_1.L4_S6_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_6.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_6.Permission.Enable", DefaultValue_GUI_1.L4_S6_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_6 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Enable")) {
                DefaultValue_GUI_1.L4_S7_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_7.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Enable", DefaultValue_GUI_1.L4_S7_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Item.Item")) {
                DefaultValue_GUI_1.L4_S7_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Item.Item", DefaultValue_GUI_1.L4_S7_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Item.Name")) {
                DefaultValue_GUI_1.L4_S7_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_7.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Item.Name", DefaultValue_GUI_1.L4_S7_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Item.Lore")) {
                DefaultValue_GUI_1.L4_S7_Lore = yamlConfiguration_GUI1.getList("Functions.Line_4.Slot_7.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Cost.Enable")) {
                DefaultValue_GUI_1.L4_S7_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_7.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Cost.Enable", DefaultValue_GUI_1.L4_S7_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Cost.Price")) {
                DefaultValue_GUI_1.L4_S7_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_4.Slot_7.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Cost.Price", DefaultValue_GUI_1.L4_S7_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Command.Enable")) {
                DefaultValue_GUI_1.L4_S7_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_7.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Command.Enable", DefaultValue_GUI_1.L4_S7_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L4_S7_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_7.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Command.CommandAsConsole", DefaultValue_GUI_1.L4_S7_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Command.Command")) {
                DefaultValue_GUI_1.L4_S7_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_7.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Command.Command", DefaultValue_GUI_1.L4_S7_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Message.Enable")) {
                DefaultValue_GUI_1.L4_S7_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_7.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Message.Enable", DefaultValue_GUI_1.L4_S7_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Message.Message")) {
                DefaultValue_GUI_1.L4_S7_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_4.Slot_7.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_7.Permission.Enable")) {
                DefaultValue_GUI_1.L4_S7_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_7.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_7.Permission.Enable", DefaultValue_GUI_1.L4_S7_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_7 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Enable")) {
                DefaultValue_GUI_1.L4_S8_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_8.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Enable", DefaultValue_GUI_1.L4_S8_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Item.Item")) {
                DefaultValue_GUI_1.L4_S8_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Item.Item", DefaultValue_GUI_1.L4_S8_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Item.Name")) {
                DefaultValue_GUI_1.L4_S8_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_8.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Item.Name", DefaultValue_GUI_1.L4_S8_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Item.Lore")) {
                DefaultValue_GUI_1.L4_S8_Lore = yamlConfiguration_GUI1.getList("Functions.Line_4.Slot_8.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Cost.Enable")) {
                DefaultValue_GUI_1.L4_S8_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_8.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Cost.Enable", DefaultValue_GUI_1.L4_S8_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Cost.Price")) {
                DefaultValue_GUI_1.L4_S8_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_4.Slot_8.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Cost.Price", DefaultValue_GUI_1.L4_S8_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Command.Enable")) {
                DefaultValue_GUI_1.L4_S8_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_8.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Command.Enable", DefaultValue_GUI_1.L4_S8_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L4_S8_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_8.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Command.CommandAsConsole", DefaultValue_GUI_1.L4_S8_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Command.Command")) {
                DefaultValue_GUI_1.L4_S8_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_8.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Command.Command", DefaultValue_GUI_1.L4_S8_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Message.Enable")) {
                DefaultValue_GUI_1.L4_S8_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_8.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Message.Enable", DefaultValue_GUI_1.L4_S8_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Message.Message")) {
                DefaultValue_GUI_1.L4_S8_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_4.Slot_8.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_8.Permission.Enable")) {
                DefaultValue_GUI_1.L4_S8_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_8.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_8.Permission.Enable", DefaultValue_GUI_1.L4_S8_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_8 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Enable")) {
                DefaultValue_GUI_1.L4_S9_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_9.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Enable", DefaultValue_GUI_1.L4_S9_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Item.Item")) {
                DefaultValue_GUI_1.L4_S9_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Item.Item", DefaultValue_GUI_1.L4_S9_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Item.Name")) {
                DefaultValue_GUI_1.L4_S9_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_9.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Item.Name", DefaultValue_GUI_1.L4_S9_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Item.Lore")) {
                DefaultValue_GUI_1.L4_S9_Lore = yamlConfiguration_GUI1.getList("Functions.Line_4.Slot_9.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Cost.Enable")) {
                DefaultValue_GUI_1.L4_S9_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_9.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Cost.Enable", DefaultValue_GUI_1.L4_S9_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Cost.Price")) {
                DefaultValue_GUI_1.L4_S9_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_4.Slot_9.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Cost.Price", DefaultValue_GUI_1.L4_S9_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Command.Enable")) {
                DefaultValue_GUI_1.L4_S9_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_9.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Command.Enable", DefaultValue_GUI_1.L4_S9_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L4_S9_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_9.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Command.CommandAsConsole", DefaultValue_GUI_1.L4_S9_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Command.Command")) {
                DefaultValue_GUI_1.L4_S9_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_4.Slot_9.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Command.Command", DefaultValue_GUI_1.L4_S9_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Message.Enable")) {
                DefaultValue_GUI_1.L4_S9_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_9.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Message.Enable", DefaultValue_GUI_1.L4_S9_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Message.Message")) {
                DefaultValue_GUI_1.L4_S9_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_4.Slot_9.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_4.Slot_9.Permission.Enable")) {
                DefaultValue_GUI_1.L4_S9_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_4.Slot_9.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_4.Slot_9.Permission.Enable", DefaultValue_GUI_1.L4_S9_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_4 Slot_9 Permission Enable §4was added to §9GUI_1.yml§4!");
            }
            Thread.sleep(500);
        }



        if (DefaultValue_GUI_1.GUILines == 5 || DefaultValue_GUI_1.GUILines > 5) {
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Enable")) {
                DefaultValue_GUI_1.L5_S1_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_1.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Enable", DefaultValue_GUI_1.L5_S1_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Item.Item")) {
                DefaultValue_GUI_1.L5_S1_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Item.Item", DefaultValue_GUI_1.L5_S1_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Item.Name")) {
                DefaultValue_GUI_1.L5_S1_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_1.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Item.Name", DefaultValue_GUI_1.L5_S1_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Item.Lore")) {
                DefaultValue_GUI_1.L5_S1_Lore = yamlConfiguration_GUI1.getList("Functions.Line_5.Slot_1.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Cost.Enable")) {
                DefaultValue_GUI_1.L5_S1_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_1.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Cost.Enable", DefaultValue_GUI_1.L5_S1_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Cost.Price")) {
                DefaultValue_GUI_1.L5_S1_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_5.Slot_1.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Cost.Price", DefaultValue_GUI_1.L5_S1_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Command.Enable")) {
                DefaultValue_GUI_1.L5_S1_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_1.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Command.Enable", DefaultValue_GUI_1.L5_S1_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L5_S1_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_1.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Command.CommandAsConsole", DefaultValue_GUI_1.L5_S1_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Command.Command")) {
                DefaultValue_GUI_1.L5_S1_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_1.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Command.Command", DefaultValue_GUI_1.L5_S1_Command.replace("§", "&"));
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Message.Enable")) {
                DefaultValue_GUI_1.L5_S1_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_1.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Message.Enable", DefaultValue_GUI_1.L5_S1_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Message.Message")) {
                DefaultValue_GUI_1.L5_S1_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_5.Slot_1.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_1.Permission.Enable")) {
                DefaultValue_GUI_1.L5_S1_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_1.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_1.Permission.Enable", DefaultValue_GUI_1.L5_S1_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_1 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Enable")) {
                DefaultValue_GUI_1.L5_S2_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_2.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Enable", DefaultValue_GUI_1.L5_S2_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Item.Item")) {
                DefaultValue_GUI_1.L5_S2_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Item.Item", DefaultValue_GUI_1.L5_S2_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Item.Name")) {
                DefaultValue_GUI_1.L5_S2_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_2.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Item.Name", DefaultValue_GUI_1.L5_S2_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Item.Lore")) {
                DefaultValue_GUI_1.L5_S2_Lore = yamlConfiguration_GUI1.getList("Functions.Line_5.Slot_2.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Cost.Enable")) {
                DefaultValue_GUI_1.L5_S2_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_2.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Cost.Enable", DefaultValue_GUI_1.L5_S2_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Cost.Price")) {
                DefaultValue_GUI_1.L5_S2_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_5.Slot_2.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Cost.Price", DefaultValue_GUI_1.L5_S2_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Command.Enable")) {
                DefaultValue_GUI_1.L5_S2_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_2.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Command.Enable", DefaultValue_GUI_1.L5_S2_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L5_S2_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_2.Command.L5_S9_CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Command.CommandAsConsole", DefaultValue_GUI_1.L5_S2_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Command.Command")) {
                DefaultValue_GUI_1.L5_S2_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_2.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Command.Command", DefaultValue_GUI_1.L5_S2_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Message.Enable")) {
                DefaultValue_GUI_1.L5_S2_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_2.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Message.Enable", DefaultValue_GUI_1.L5_S2_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Message.Message")) {
                DefaultValue_GUI_1.L5_S2_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_5.Slot_2.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_2.Permission.Enable")) {
                DefaultValue_GUI_1.L5_S2_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_2.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_2.Permission.Enable", DefaultValue_GUI_1.L5_S2_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_2 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Enable")) {
                DefaultValue_GUI_1.L5_S3_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_3.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Enable", DefaultValue_GUI_1.L5_S3_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Item.Item")) {
                DefaultValue_GUI_1.L5_S3_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Item.Item", DefaultValue_GUI_1.L5_S3_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Item.Name")) {
                DefaultValue_GUI_1.L5_S3_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_3.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Item.Name", DefaultValue_GUI_1.L5_S3_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Item.Lore")) {
                DefaultValue_GUI_1.L5_S3_Lore = yamlConfiguration_GUI1.getList("Functions.Line_5.Slot_3.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Cost.Enable")) {
                DefaultValue_GUI_1.L5_S3_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_3.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Cost.Enable", DefaultValue_GUI_1.L5_S3_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Cost.Price")) {
                DefaultValue_GUI_1.L5_S3_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_5.Slot_3.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Cost.Price", DefaultValue_GUI_1.L5_S3_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Command.Enable")) {
                DefaultValue_GUI_1.L5_S3_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_3.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Command.Enable", DefaultValue_GUI_1.L5_S3_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L5_S3_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_3.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Command.CommandAsConsole", DefaultValue_GUI_1.L5_S3_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Command.Command")) {
                DefaultValue_GUI_1.L5_S3_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_3.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Command.Command", DefaultValue_GUI_1.L5_S3_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Message.Enable")) {
                DefaultValue_GUI_1.L5_S3_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_3.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Message.Enable", DefaultValue_GUI_1.L5_S3_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Message.Message")) {
                DefaultValue_GUI_1.L5_S3_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_5.Slot_3.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_3.Permission.Enable")) {
                DefaultValue_GUI_1.L5_S3_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_3.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_3.Permission.Enable", DefaultValue_GUI_1.L5_S3_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_3 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Enable")) {
                DefaultValue_GUI_1.L5_S4_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_4.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Enable", DefaultValue_GUI_1.L5_S4_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Item.Item")) {
                DefaultValue_GUI_1.L5_S4_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Item.Item", DefaultValue_GUI_1.L5_S4_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Item.Name")) {
                DefaultValue_GUI_1.L5_S4_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_4.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Item.Name", DefaultValue_GUI_1.L5_S4_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Item.Lore")) {
                DefaultValue_GUI_1.L5_S4_Lore = yamlConfiguration_GUI1.getList("Functions.Line_5.Slot_4.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Cost.Enable")) {
                DefaultValue_GUI_1.L5_S4_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_4.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Cost.Enable", DefaultValue_GUI_1.L5_S4_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Cost.Price")) {
                DefaultValue_GUI_1.L5_S4_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_5.Slot_4.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Cost.Price", DefaultValue_GUI_1.L5_S4_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Command.Enable")) {
                DefaultValue_GUI_1.L5_S4_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_4.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Command.Enable", DefaultValue_GUI_1.L5_S4_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L5_S4_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_4.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Command.CommandAsConsole", DefaultValue_GUI_1.L5_S4_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Command.Command")) {
                DefaultValue_GUI_1.L5_S4_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_4.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Command.Command", DefaultValue_GUI_1.L5_S4_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Message.Enable")) {
                DefaultValue_GUI_1.L5_S4_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_4.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Message.Enable", DefaultValue_GUI_1.L5_S4_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Message.Message")) {
                DefaultValue_GUI_1.L5_S4_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_5.Slot_4.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_4.Permission.Enable")) {
                DefaultValue_GUI_1.L5_S4_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_4.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_4.Permission.Enable", DefaultValue_GUI_1.L5_S4_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_4 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Enable")) {
                DefaultValue_GUI_1.L5_S5_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_5.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Enable", DefaultValue_GUI_1.L5_S5_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Item.Item")) {
                DefaultValue_GUI_1.L5_S5_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Item.Item", DefaultValue_GUI_1.L5_S5_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Item.Name")) {
                DefaultValue_GUI_1.L5_S5_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_5.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Item.Name", DefaultValue_GUI_1.L5_S5_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Item.Lore")) {
                DefaultValue_GUI_1.L5_S5_Lore = yamlConfiguration_GUI1.getList("Functions.Line_5.Slot_5.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Cost.Enable")) {
                DefaultValue_GUI_1.L5_S5_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_5.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Cost.Enable", DefaultValue_GUI_1.L5_S5_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Cost.Price")) {
                DefaultValue_GUI_1.L5_S5_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_5.Slot_5.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Cost.Price", DefaultValue_GUI_1.L5_S5_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Command.Enable")) {
                DefaultValue_GUI_1.L5_S5_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_5.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Command.Enable", DefaultValue_GUI_1.L5_S5_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L5_S5_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_5.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Command.CommandAsConsole", DefaultValue_GUI_1.L5_S5_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Command.Command")) {
                DefaultValue_GUI_1.L5_S5_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_5.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Command.Command", DefaultValue_GUI_1.L5_S5_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Message.Enable")) {
                DefaultValue_GUI_1.L5_S5_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_5.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Message.Enable", DefaultValue_GUI_1.L5_S5_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Message.Message")) {
                DefaultValue_GUI_1.L5_S5_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_5.Slot_5.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_5.Permission.Enable")) {
                DefaultValue_GUI_1.L5_S5_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_5.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_5.Permission.Enable", DefaultValue_GUI_1.L5_S5_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_5 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Enable")) {
                DefaultValue_GUI_1.L5_S6_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_6.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Enable", DefaultValue_GUI_1.L5_S6_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Item.Item")) {
                DefaultValue_GUI_1.L5_S6_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Item.Item", DefaultValue_GUI_1.L5_S6_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Item.Name")) {
                DefaultValue_GUI_1.L5_S6_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_6.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Item.Name", DefaultValue_GUI_1.L5_S6_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Item.Lore")) {
                DefaultValue_GUI_1.L5_S6_Lore = yamlConfiguration_GUI1.getList("Functions.Line_5.Slot_6.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Cost.Enable")) {
                DefaultValue_GUI_1.L5_S6_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_6.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Cost.Enable", DefaultValue_GUI_1.L5_S6_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Cost.Price")) {
                DefaultValue_GUI_1.L5_S6_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_5.Slot_6.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Cost.Price", DefaultValue_GUI_1.L5_S6_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Command.Enable")) {
                DefaultValue_GUI_1.L5_S6_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_6.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Command.Enable", DefaultValue_GUI_1.L5_S6_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L5_S6_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_6.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Command.CommandAsConsole", DefaultValue_GUI_1.L5_S6_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Command.Command")) {
                DefaultValue_GUI_1.L5_S6_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_6.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Command.Command", DefaultValue_GUI_1.L5_S6_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Message.Enable")) {
                DefaultValue_GUI_1.L5_S6_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_6.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Message.Enable", DefaultValue_GUI_1.L5_S6_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Message.Message")) {
                DefaultValue_GUI_1.L5_S6_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_5.Slot_6.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_6.Permission.Enable")) {
                DefaultValue_GUI_1.L5_S6_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_6.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_6.Permission.Enable", DefaultValue_GUI_1.L5_S6_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_6 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Enable")) {
                DefaultValue_GUI_1.L5_S7_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_7.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Enable", DefaultValue_GUI_1.L5_S7_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Item.Item")) {
                DefaultValue_GUI_1.L5_S7_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Item.Item", DefaultValue_GUI_1.L5_S7_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Item.Name")) {
                DefaultValue_GUI_1.L5_S7_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_7.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Item.Name", DefaultValue_GUI_1.L5_S7_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Item.Lore")) {
                DefaultValue_GUI_1.L5_S7_Lore = yamlConfiguration_GUI1.getList("Functions.Line_5.Slot_7.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Cost.Enable")) {
                DefaultValue_GUI_1.L5_S7_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_7.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Cost.Enable", DefaultValue_GUI_1.L5_S7_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Cost.Price")) {
                DefaultValue_GUI_1.L5_S7_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_5.Slot_7.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Cost.Price", DefaultValue_GUI_1.L5_S7_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Command.Enable")) {
                DefaultValue_GUI_1.L5_S7_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_7.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Command.Enable", DefaultValue_GUI_1.L5_S7_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L5_S7_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_7.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Command.CommandAsConsole", DefaultValue_GUI_1.L5_S7_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Command.Command")) {
                DefaultValue_GUI_1.L5_S7_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_7.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Command.Command", DefaultValue_GUI_1.L5_S7_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Message.Enable")) {
                DefaultValue_GUI_1.L5_S7_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_7.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Message.Enable", DefaultValue_GUI_1.L5_S7_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Message.Message")) {
                DefaultValue_GUI_1.L5_S7_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_5.Slot_7.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_7.Permission.Enable")) {
                DefaultValue_GUI_1.L5_S7_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_7.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_7.Permission.Enable", DefaultValue_GUI_1.L5_S7_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_7 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Enable")) {
                DefaultValue_GUI_1.L5_S8_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_8.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Enable", DefaultValue_GUI_1.L5_S8_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Item.Item")) {
                DefaultValue_GUI_1.L5_S8_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Item.Item", DefaultValue_GUI_1.L5_S8_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Item.Name")) {
                DefaultValue_GUI_1.L5_S8_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_8.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Item.Name", DefaultValue_GUI_1.L5_S8_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Item.Lore")) {
                DefaultValue_GUI_1.L5_S8_Lore = yamlConfiguration_GUI1.getList("Functions.Line_5.Slot_8.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Cost.Enable")) {
                DefaultValue_GUI_1.L5_S8_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_8.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Cost.Enable", DefaultValue_GUI_1.L5_S8_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Cost.Price")) {
                DefaultValue_GUI_1.L5_S8_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_5.Slot_8.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Cost.Price", DefaultValue_GUI_1.L5_S8_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Command.Enable")) {
                DefaultValue_GUI_1.L5_S8_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_8.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Command.Enable", DefaultValue_GUI_1.L5_S8_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L5_S8_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_8.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Command.CommandAsConsole", DefaultValue_GUI_1.L5_S8_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Command.Command")) {
                DefaultValue_GUI_1.L5_S8_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_8.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Command.Command", DefaultValue_GUI_1.L5_S8_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Message.Enable")) {
                DefaultValue_GUI_1.L5_S8_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_8.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Message.Enable", DefaultValue_GUI_1.L5_S8_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Message.Message")) {
                DefaultValue_GUI_1.L5_S8_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_5.Slot_8.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_8.Permission.Enable")) {
                DefaultValue_GUI_1.L5_S8_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_8.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_8.Permission.Enable", DefaultValue_GUI_1.L5_S8_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_8 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Enable")) {
                DefaultValue_GUI_1.L5_S9_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_9.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Enable", DefaultValue_GUI_1.L5_S9_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Item.Item")) {
                DefaultValue_GUI_1.L5_S9_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Item.Item", DefaultValue_GUI_1.L5_S9_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Item.Name")) {
                DefaultValue_GUI_1.L5_S9_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_9.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Item.Name", DefaultValue_GUI_1.L5_S9_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Item.Lore")) {
                DefaultValue_GUI_1.L5_S9_Lore = yamlConfiguration_GUI1.getList("Functions.Line_5.Slot_9.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Cost.Enable")) {
                DefaultValue_GUI_1.L5_S9_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_9.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Cost.Enable", DefaultValue_GUI_1.L5_S9_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Cost.Price")) {
                DefaultValue_GUI_1.L5_S9_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_5.Slot_9.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Cost.Price", DefaultValue_GUI_1.L5_S9_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Command.Enable")) {
                DefaultValue_GUI_1.L5_S9_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_9.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Command.Enable", DefaultValue_GUI_1.L5_S9_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L5_S9_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_9.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Command.CommandAsConsole", DefaultValue_GUI_1.L5_S9_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Command.Command")) {
                DefaultValue_GUI_1.L5_S9_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_5.Slot_9.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Command.Command", DefaultValue_GUI_1.L5_S9_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Message.Enable")) {
                DefaultValue_GUI_1.L5_S9_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_9.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Message.Enable", DefaultValue_GUI_1.L5_S9_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Message.Message")) {
                DefaultValue_GUI_1.L5_S9_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_5.Slot_9.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_5.Slot_9.Permission.Enable")) {
                DefaultValue_GUI_1.L5_S9_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_5.Slot_9.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_5.Slot_9.Permission.Enable", DefaultValue_GUI_1.L5_S9_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_5 Slot_9 Permission Enable §4was added to §9GUI_1.yml§4!");
            }
            Thread.sleep(500);
        }



        if (DefaultValue_GUI_1.GUILines == 6 || DefaultValue_GUI_1.GUILines > 6) {
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Enable")) {
                DefaultValue_GUI_1.L6_S1_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_1.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Enable", DefaultValue_GUI_1.L6_S1_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Item.Item")) {
                DefaultValue_GUI_1.L6_S1_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_1.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Item.Item", DefaultValue_GUI_1.L6_S1_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Item.Name")) {
                DefaultValue_GUI_1.L6_S1_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_1.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Item.Name", DefaultValue_GUI_1.L6_S1_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Item.Lore")) {
                DefaultValue_GUI_1.L6_S1_Lore = yamlConfiguration_GUI1.getList("Functions.Line_6.Slot_1.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Cost.Enable")) {
                DefaultValue_GUI_1.L6_S1_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_1.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Cost.Enable", DefaultValue_GUI_1.L6_S1_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Cost.Price")) {
                DefaultValue_GUI_1.L6_S1_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_6.Slot_1.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Cost.Price", DefaultValue_GUI_1.L6_S1_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Command.Enable")) {
                DefaultValue_GUI_1.L6_S1_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_1.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Command.Enable", DefaultValue_GUI_1.L6_S1_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L6_S1_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_1.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Command.CommandAsConsole", DefaultValue_GUI_1.L6_S1_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Command.Command")) {
                DefaultValue_GUI_1.L6_S1_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_1.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Command.Command", DefaultValue_GUI_1.L6_S1_Command.replace("§", "&"));
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Message.Enable")) {
                DefaultValue_GUI_1.L6_S1_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_1.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Message.Enable", DefaultValue_GUI_1.L6_S1_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Message.Message")) {
                DefaultValue_GUI_1.L6_S1_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_6.Slot_1.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_1.Permission.Enable")) {
                DefaultValue_GUI_1.L6_S1_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_1.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_1.Permission.Enable", DefaultValue_GUI_1.L6_S1_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_1 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Enable")) {
                DefaultValue_GUI_1.L6_S2_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_2.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Enable", DefaultValue_GUI_1.L6_S2_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Item.Item")) {
                DefaultValue_GUI_1.L6_S2_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_2.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Item.Item", DefaultValue_GUI_1.L6_S2_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Item.Name")) {
                DefaultValue_GUI_1.L6_S2_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_2.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Item.Name", DefaultValue_GUI_1.L6_S2_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Item.Lore")) {
                DefaultValue_GUI_1.L6_S2_Lore = yamlConfiguration_GUI1.getList("Functions.Line_6.Slot_2.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Cost.Enable")) {
                DefaultValue_GUI_1.L6_S2_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_2.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Cost.Enable", DefaultValue_GUI_1.L6_S2_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Cost.Price")) {
                DefaultValue_GUI_1.L6_S2_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_6.Slot_2.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Cost.Price", DefaultValue_GUI_1.L6_S2_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Command.Enable")) {
                DefaultValue_GUI_1.L6_S2_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_2.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Command.Enable", DefaultValue_GUI_1.L6_S2_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L6_S2_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_2.Command.L6_S9_CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Command.CommandAsConsole", DefaultValue_GUI_1.L6_S2_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Command.Command")) {
                DefaultValue_GUI_1.L6_S2_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_2.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Command.Command", DefaultValue_GUI_1.L6_S2_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Message.Enable")) {
                DefaultValue_GUI_1.L6_S2_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_2.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Message.Enable", DefaultValue_GUI_1.L6_S2_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Message.Message")) {
                DefaultValue_GUI_1.L6_S2_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_6.Slot_2.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_2.Permission.Enable")) {
                DefaultValue_GUI_1.L6_S2_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_2.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_2.Permission.Enable", DefaultValue_GUI_1.L6_S2_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_2 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Enable")) {
                DefaultValue_GUI_1.L6_S3_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_3.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Enable", DefaultValue_GUI_1.L6_S3_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Item.Item")) {
                DefaultValue_GUI_1.L6_S3_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_3.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Item.Item", DefaultValue_GUI_1.L6_S3_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Item.Name")) {
                DefaultValue_GUI_1.L6_S3_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_3.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Item.Name", DefaultValue_GUI_1.L6_S3_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Item.Lore")) {
                DefaultValue_GUI_1.L6_S3_Lore = yamlConfiguration_GUI1.getList("Functions.Line_6.Slot_3.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Cost.Enable")) {
                DefaultValue_GUI_1.L6_S3_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_3.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Cost.Enable", DefaultValue_GUI_1.L6_S3_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Cost.Price")) {
                DefaultValue_GUI_1.L6_S3_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_6.Slot_3.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Cost.Price", DefaultValue_GUI_1.L6_S3_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Command.Enable")) {
                DefaultValue_GUI_1.L6_S3_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_3.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Command.Enable", DefaultValue_GUI_1.L6_S3_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L6_S3_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_3.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Command.CommandAsConsole", DefaultValue_GUI_1.L6_S3_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Command.Command")) {
                DefaultValue_GUI_1.L6_S3_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_3.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Command.Command", DefaultValue_GUI_1.L6_S3_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Message.Enable")) {
                DefaultValue_GUI_1.L6_S3_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_3.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Message.Enable", DefaultValue_GUI_1.L6_S3_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Message.Message")) {
                DefaultValue_GUI_1.L6_S3_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_6.Slot_3.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_3.Permission.Enable")) {
                DefaultValue_GUI_1.L6_S3_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_3.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_3.Permission.Enable", DefaultValue_GUI_1.L6_S3_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_3 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Enable")) {
                DefaultValue_GUI_1.L6_S4_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_4.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Enable", DefaultValue_GUI_1.L6_S4_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Item.Item")) {
                DefaultValue_GUI_1.L6_S4_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_4.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Item.Item", DefaultValue_GUI_1.L6_S4_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Item.Name")) {
                DefaultValue_GUI_1.L6_S4_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_4.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Item.Name", DefaultValue_GUI_1.L6_S4_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Item.Lore")) {
                DefaultValue_GUI_1.L6_S4_Lore = yamlConfiguration_GUI1.getList("Functions.Line_6.Slot_4.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Cost.Enable")) {
                DefaultValue_GUI_1.L6_S4_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_4.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Cost.Enable", DefaultValue_GUI_1.L6_S4_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Cost.Price")) {
                DefaultValue_GUI_1.L6_S4_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_6.Slot_4.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Cost.Price", DefaultValue_GUI_1.L6_S4_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Command.Enable")) {
                DefaultValue_GUI_1.L6_S4_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_4.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Command.Enable", DefaultValue_GUI_1.L6_S4_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L6_S4_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_4.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Command.CommandAsConsole", DefaultValue_GUI_1.L6_S4_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Command.Command")) {
                DefaultValue_GUI_1.L6_S4_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_4.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Command.Command", DefaultValue_GUI_1.L6_S4_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Message.Enable")) {
                DefaultValue_GUI_1.L6_S4_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_4.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Message.Enable", DefaultValue_GUI_1.L6_S4_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Message.Message")) {
                DefaultValue_GUI_1.L6_S4_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_6.Slot_4.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_4.Permission.Enable")) {
                DefaultValue_GUI_1.L6_S4_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_4.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_4.Permission.Enable", DefaultValue_GUI_1.L6_S4_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_4 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Enable")) {
                DefaultValue_GUI_1.L6_S5_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_5.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Enable", DefaultValue_GUI_1.L6_S5_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Item.Item")) {
                DefaultValue_GUI_1.L6_S5_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_5.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Item.Item", DefaultValue_GUI_1.L6_S5_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Item.Name")) {
                DefaultValue_GUI_1.L6_S5_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_5.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Item.Name", DefaultValue_GUI_1.L6_S5_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Item.Lore")) {
                DefaultValue_GUI_1.L6_S5_Lore = yamlConfiguration_GUI1.getList("Functions.Line_6.Slot_5.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Cost.Enable")) {
                DefaultValue_GUI_1.L6_S5_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_5.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Cost.Enable", DefaultValue_GUI_1.L6_S5_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Cost.Price")) {
                DefaultValue_GUI_1.L6_S5_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_6.Slot_5.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Cost.Price", DefaultValue_GUI_1.L6_S5_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Command.Enable")) {
                DefaultValue_GUI_1.L6_S5_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_5.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Command.Enable", DefaultValue_GUI_1.L6_S5_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L6_S5_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_5.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Command.CommandAsConsole", DefaultValue_GUI_1.L6_S5_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Command.Command")) {
                DefaultValue_GUI_1.L6_S5_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_5.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Command.Command", DefaultValue_GUI_1.L6_S5_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Message.Enable")) {
                DefaultValue_GUI_1.L6_S5_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_5.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Message.Enable", DefaultValue_GUI_1.L6_S5_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Message.Message")) {
                DefaultValue_GUI_1.L6_S5_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_6.Slot_5.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_5.Permission.Enable")) {
                DefaultValue_GUI_1.L6_S5_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_5.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_5.Permission.Enable", DefaultValue_GUI_1.L6_S5_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_5 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Enable")) {
                DefaultValue_GUI_1.L6_S6_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_6.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Enable", DefaultValue_GUI_1.L6_S6_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Item.Item")) {
                DefaultValue_GUI_1.L6_S6_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_6.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Item.Item", DefaultValue_GUI_1.L6_S6_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Item.Name")) {
                DefaultValue_GUI_1.L6_S6_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_6.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Item.Name", DefaultValue_GUI_1.L6_S6_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Item.Lore")) {
                DefaultValue_GUI_1.L6_S6_Lore = yamlConfiguration_GUI1.getList("Functions.Line_6.Slot_6.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Cost.Enable")) {
                DefaultValue_GUI_1.L6_S6_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_6.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Cost.Enable", DefaultValue_GUI_1.L6_S6_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Cost.Price")) {
                DefaultValue_GUI_1.L6_S6_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_6.Slot_6.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Cost.Price", DefaultValue_GUI_1.L6_S6_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Command.Enable")) {
                DefaultValue_GUI_1.L6_S6_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_6.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Command.Enable", DefaultValue_GUI_1.L6_S6_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L6_S6_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_6.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Command.CommandAsConsole", DefaultValue_GUI_1.L6_S6_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Command.Command")) {
                DefaultValue_GUI_1.L6_S6_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_6.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Command.Command", DefaultValue_GUI_1.L6_S6_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Message.Enable")) {
                DefaultValue_GUI_1.L6_S6_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_6.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Message.Enable", DefaultValue_GUI_1.L6_S6_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Message.Message")) {
                DefaultValue_GUI_1.L6_S6_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_6.Slot_6.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_6.Permission.Enable")) {
                DefaultValue_GUI_1.L6_S6_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_6.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_6.Permission.Enable", DefaultValue_GUI_1.L6_S6_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_6 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Enable")) {
                DefaultValue_GUI_1.L6_S7_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_7.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Enable", DefaultValue_GUI_1.L6_S7_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Item.Item")) {
                DefaultValue_GUI_1.L6_S7_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_7.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Item.Item", DefaultValue_GUI_1.L6_S7_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Item.Name")) {
                DefaultValue_GUI_1.L6_S7_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_7.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Item.Name", DefaultValue_GUI_1.L6_S7_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Item.Lore")) {
                DefaultValue_GUI_1.L6_S7_Lore = yamlConfiguration_GUI1.getList("Functions.Line_6.Slot_7.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Cost.Enable")) {
                DefaultValue_GUI_1.L6_S7_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_7.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Cost.Enable", DefaultValue_GUI_1.L6_S7_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Cost.Price")) {
                DefaultValue_GUI_1.L6_S7_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_6.Slot_7.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Cost.Price", DefaultValue_GUI_1.L6_S7_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Command.Enable")) {
                DefaultValue_GUI_1.L6_S7_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_7.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Command.Enable", DefaultValue_GUI_1.L6_S7_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L6_S7_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_7.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Command.CommandAsConsole", DefaultValue_GUI_1.L6_S7_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Command.Command")) {
                DefaultValue_GUI_1.L6_S7_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_7.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Command.Command", DefaultValue_GUI_1.L6_S7_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Message.Enable")) {
                DefaultValue_GUI_1.L6_S7_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_7.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Message.Enable", DefaultValue_GUI_1.L6_S7_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Message.Message")) {
                DefaultValue_GUI_1.L6_S7_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_6.Slot_7.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_7.Permission.Enable")) {
                DefaultValue_GUI_1.L6_S7_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_7.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_7.Permission.Enable", DefaultValue_GUI_1.L6_S7_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_7 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Enable")) {
                DefaultValue_GUI_1.L6_S8_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_8.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Enable", DefaultValue_GUI_1.L6_S8_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Item.Item")) {
                DefaultValue_GUI_1.L6_S8_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_8.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Item.Item", DefaultValue_GUI_1.L6_S8_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Item.Name")) {
                DefaultValue_GUI_1.L6_S8_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_8.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Item.Name", DefaultValue_GUI_1.L6_S8_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Item.Lore")) {
                DefaultValue_GUI_1.L6_S8_Lore = yamlConfiguration_GUI1.getList("Functions.Line_6.Slot_8.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Cost.Enable")) {
                DefaultValue_GUI_1.L6_S8_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_8.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Cost.Enable", DefaultValue_GUI_1.L6_S8_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Cost.Price")) {
                DefaultValue_GUI_1.L6_S8_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_6.Slot_8.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Cost.Price", DefaultValue_GUI_1.L6_S8_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Command.Enable")) {
                DefaultValue_GUI_1.L6_S8_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_8.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Command.Enable", DefaultValue_GUI_1.L6_S8_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L6_S8_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_8.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Command.CommandAsConsole", DefaultValue_GUI_1.L6_S8_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Command.Command")) {
                DefaultValue_GUI_1.L6_S8_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_8.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Command.Command", DefaultValue_GUI_1.L6_S8_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Message.Enable")) {
                DefaultValue_GUI_1.L6_S8_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_8.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Message.Enable", DefaultValue_GUI_1.L6_S8_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Message.Message")) {
                DefaultValue_GUI_1.L6_S8_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_6.Slot_8.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_8.Permission.Enable")) {
                DefaultValue_GUI_1.L6_S8_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_8.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_8.Permission.Enable", DefaultValue_GUI_1.L6_S8_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_8 Permission Enable §4was added to §9GUI_1.yml§4!");
            }

            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Enable")) {
                DefaultValue_GUI_1.L6_S9_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_9.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Enable", DefaultValue_GUI_1.L6_S9_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Item.Item")) {
                DefaultValue_GUI_1.L6_S9_Item = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_9.Item.Item").toUpperCase().replace(".", "_"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Item.Item", DefaultValue_GUI_1.L6_S9_Item);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Item §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Item.Name")) {
                DefaultValue_GUI_1.L6_S9_Name = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_9.Item.Name"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Item.Name", DefaultValue_GUI_1.L6_S9_Name);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Name §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Item.Lore")) {
                DefaultValue_GUI_1.L6_S9_Lore = yamlConfiguration_GUI1.getList("Functions.Line_6.Slot_9.Item.Lore");
            } else {
                List<String> lore = new ArrayList<>();
                //lore.add("§51");
                //lore.add("§52");
                //lore.add("§53");
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Item.Lore", lore);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Lore §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Cost.Enable")) {
                DefaultValue_GUI_1.L6_S9_Cost_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_9.Cost.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Cost.Enable", DefaultValue_GUI_1.L6_S9_Cost_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Cost Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Cost.Price")) {
                DefaultValue_GUI_1.L6_S9_Price = (yamlConfiguration_GUI1.getDouble("Functions.Line_6.Slot_9.Cost.Price"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Cost.Price", DefaultValue_GUI_1.L6_S9_Price);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Cost Price §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Command.Enable")) {
                DefaultValue_GUI_1.L6_S9_Command_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_9.Command.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Command.Enable", DefaultValue_GUI_1.L6_S9_Command_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Command Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Command.CommandAsConsole")) {
                DefaultValue_GUI_1.L6_S9_CommandAsConsole = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_9.Command.CommandAsConsole");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Command.CommandAsConsole", DefaultValue_GUI_1.L6_S9_CommandAsConsole);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Command CommandAsConsole §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Command.Command")) {
                DefaultValue_GUI_1.L6_S9_Command = replace(yamlConfiguration_GUI1.getString("Functions.Line_6.Slot_9.Command.Command"));
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Command.Command", DefaultValue_GUI_1.L6_S9_Command);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Command Command §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Message.Enable")) {
                DefaultValue_GUI_1.L6_S9_Message_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_9.Message.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Message.Enable", DefaultValue_GUI_1.L6_S9_Message_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Message Enable §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Message.Message")) {
                DefaultValue_GUI_1.L6_S9_Message = yamlConfiguration_GUI1.getStringList("Functions.Line_6.Slot_9.Message.Message");
            } else {
                List<String> msg = new ArrayList<>();
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Message.Message", msg);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Message §4was added to §9GUI_1.yml§4!");
            }
            if (yamlConfiguration_GUI1.contains("Functions.Line_6.Slot_9.Permission.Enable")) {
                DefaultValue_GUI_1.L6_S9_Permission_Enable = yamlConfiguration_GUI1.getBoolean("Functions.Line_6.Slot_9.Permission.Enable");
            } else {
                yamlConfiguration_GUI1.set("Functions.Line_6.Slot_9.Permission.Enable", DefaultValue_GUI_1.L6_S9_Permission_Enable);
                if (GUI1YML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Line_6 Slot_9 Permission Enable §4was added to §9GUI_1.yml§4!");
            }
        }


        try {
            yamlConfiguration_GUI1.save(GUI1YML);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2GUI_1.yml loaded successfully.");
    }

    private static String replace(String Text) {
        return Text.replace("[prefix]", DefaultValue.Prefix).replace("&", "§").replace("[ue]", "ü")
                .replace("[UE]", "Ü").replace("[oe]", "Ö").replace("[OE]", "Ö")
                .replace("[ae]", "ä").replace("[AE]", "Ä");
    }
}
