// This claas was created by JaTiTV


package de.jatitv.commandgui.system;

import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_1;
import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_2;
import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_3;
import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class Permissions extends JavaPlugin {

    public static void addPermission(){

        if (DefaultValue_GUI_1.Command_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.command.gui1"));
        if (DefaultValue_GUI_2.Command_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.command.gui2"));
        if (DefaultValue_GUI_3.Command_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.command.gui3"));

        if (DefaultValue_GUI_1.GiveUseItemOnFirstJoin_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.giveuseitemonfirstjoin.gui1"));
        if (DefaultValue_GUI_2.GiveUseItemOnFirstJoin_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.giveuseitemonfirstjoin.gui2"));
        if (DefaultValue_GUI_3.GiveUseItemOnFirstJoin_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.giveuseitemonfirstjoin.gui3"));

        if (DefaultValue_GUI_1.Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1"));
        if (DefaultValue_GUI_2.Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2"));
        if (DefaultValue_GUI_3.Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3"));

        if (DefaultValue_GUI_1.L1_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line1.slot1"));
        if (DefaultValue_GUI_1.L1_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line1.slot2"));
        if (DefaultValue_GUI_1.L1_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line1.slot3"));
        if (DefaultValue_GUI_1.L1_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line1.slot4"));
        if (DefaultValue_GUI_1.L1_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line1.slot5"));
        if (DefaultValue_GUI_1.L1_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line1.slot6"));
        if (DefaultValue_GUI_1.L1_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line1.slot7"));
        if (DefaultValue_GUI_1.L1_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line1.slot8"));
        if (DefaultValue_GUI_1.L1_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line1.slot9"));

        if (DefaultValue_GUI_1.L2_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line2.slot1"));
        if (DefaultValue_GUI_1.L2_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line2.slot2"));
        if (DefaultValue_GUI_1.L2_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line2.slot3"));
        if (DefaultValue_GUI_1.L2_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line2.slot4"));
        if (DefaultValue_GUI_1.L2_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line2.slot5"));
        if (DefaultValue_GUI_1.L2_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line2.slot6"));
        if (DefaultValue_GUI_1.L2_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line2.slot7"));
        if (DefaultValue_GUI_1.L2_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line2.slot8"));
        if (DefaultValue_GUI_1.L2_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line2.slot9"));

        if (DefaultValue_GUI_1.L3_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line3.slot1"));
        if (DefaultValue_GUI_1.L3_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line3.slot2"));
        if (DefaultValue_GUI_1.L3_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line3.slot3"));
        if (DefaultValue_GUI_1.L3_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line3.slot4"));
        if (DefaultValue_GUI_1.L3_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line3.slot5"));
        if (DefaultValue_GUI_1.L3_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line3.slot6"));
        if (DefaultValue_GUI_1.L3_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line3.slot7"));
        if (DefaultValue_GUI_1.L3_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line3.slot8"));
        if (DefaultValue_GUI_1.L3_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line3.slot9"));

        if (DefaultValue_GUI_1.L4_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line4.slot1"));
        if (DefaultValue_GUI_1.L4_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line4.slot2"));
        if (DefaultValue_GUI_1.L4_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line4.slot3"));
        if (DefaultValue_GUI_1.L4_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line4.slot4"));
        if (DefaultValue_GUI_1.L4_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line4.slot5"));
        if (DefaultValue_GUI_1.L4_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line4.slot6"));
        if (DefaultValue_GUI_1.L4_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line4.slot7"));
        if (DefaultValue_GUI_1.L4_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line4.slot8"));
        if (DefaultValue_GUI_1.L4_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line4.slot9"));

        if (DefaultValue_GUI_1.L5_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line5.slot1"));
        if (DefaultValue_GUI_1.L5_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line5.slot2"));
        if (DefaultValue_GUI_1.L5_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line5.slot3"));
        if (DefaultValue_GUI_1.L5_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line5.slot4"));
        if (DefaultValue_GUI_1.L5_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line5.slot5"));
        if (DefaultValue_GUI_1.L5_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line5.slot6"));
        if (DefaultValue_GUI_1.L5_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line5.slot7"));
        if (DefaultValue_GUI_1.L5_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line5.slot8"));
        if (DefaultValue_GUI_1.L5_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line5.slot9"));

        if (DefaultValue_GUI_1.L6_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line6.slot1"));
        if (DefaultValue_GUI_1.L6_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line6.slot2"));
        if (DefaultValue_GUI_1.L6_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line6.slot3"));
        if (DefaultValue_GUI_1.L6_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line6.slot4"));
        if (DefaultValue_GUI_1.L6_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line6.slot5"));
        if (DefaultValue_GUI_1.L6_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line6.slot6"));
        if (DefaultValue_GUI_1.L6_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line6.slot7"));
        if (DefaultValue_GUI_1.L6_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line6.slot8"));
        if (DefaultValue_GUI_1.L6_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui1.line6.slot9"));


        /**
         * GUI2
         */

        if (DefaultValue_GUI_2.L1_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line1.slot1"));
        if (DefaultValue_GUI_2.L1_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line1.slot2"));
        if (DefaultValue_GUI_2.L1_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line1.slot3"));
        if (DefaultValue_GUI_2.L1_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line1.slot4"));
        if (DefaultValue_GUI_2.L1_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line1.slot5"));
        if (DefaultValue_GUI_2.L1_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line1.slot6"));
        if (DefaultValue_GUI_2.L1_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line1.slot7"));
        if (DefaultValue_GUI_2.L1_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line1.slot8"));
        if (DefaultValue_GUI_2.L1_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line1.slot9"));

        if (DefaultValue_GUI_2.L2_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line2.slot1"));
        if (DefaultValue_GUI_2.L2_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line2.slot2"));
        if (DefaultValue_GUI_2.L2_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line2.slot3"));
        if (DefaultValue_GUI_2.L2_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line2.slot4"));
        if (DefaultValue_GUI_2.L2_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line2.slot5"));
        if (DefaultValue_GUI_2.L2_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line2.slot6"));
        if (DefaultValue_GUI_2.L2_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line2.slot7"));
        if (DefaultValue_GUI_2.L2_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line2.slot8"));
        if (DefaultValue_GUI_2.L2_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line2.slot9"));

        if (DefaultValue_GUI_2.L3_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line3.slot1"));
        if (DefaultValue_GUI_2.L3_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line3.slot2"));
        if (DefaultValue_GUI_2.L3_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line3.slot3"));
        if (DefaultValue_GUI_2.L3_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line3.slot4"));
        if (DefaultValue_GUI_2.L3_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line3.slot5"));
        if (DefaultValue_GUI_2.L3_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line3.slot6"));
        if (DefaultValue_GUI_2.L3_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line3.slot7"));
        if (DefaultValue_GUI_2.L3_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line3.slot8"));
        if (DefaultValue_GUI_2.L3_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line3.slot9"));

        if (DefaultValue_GUI_2.L4_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line4.slot1"));
        if (DefaultValue_GUI_2.L4_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line4.slot2"));
        if (DefaultValue_GUI_2.L4_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line4.slot3"));
        if (DefaultValue_GUI_2.L4_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line4.slot4"));
        if (DefaultValue_GUI_2.L4_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line4.slot5"));
        if (DefaultValue_GUI_2.L4_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line4.slot6"));
        if (DefaultValue_GUI_2.L4_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line4.slot7"));
        if (DefaultValue_GUI_2.L4_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line4.slot8"));
        if (DefaultValue_GUI_2.L4_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line4.slot9"));

        if (DefaultValue_GUI_2.L5_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line5.slot1"));
        if (DefaultValue_GUI_2.L5_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line5.slot2"));
        if (DefaultValue_GUI_2.L5_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line5.slot3"));
        if (DefaultValue_GUI_2.L5_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line5.slot4"));
        if (DefaultValue_GUI_2.L5_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line5.slot5"));
        if (DefaultValue_GUI_2.L5_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line5.slot6"));
        if (DefaultValue_GUI_2.L5_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line5.slot7"));
        if (DefaultValue_GUI_2.L5_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line5.slot8"));
        if (DefaultValue_GUI_2.L5_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line5.slot9"));

        if (DefaultValue_GUI_2.L6_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line6.slot1"));
        if (DefaultValue_GUI_2.L6_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line6.slot2"));
        if (DefaultValue_GUI_2.L6_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line6.slot3"));
        if (DefaultValue_GUI_2.L6_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line6.slot4"));
        if (DefaultValue_GUI_2.L6_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line6.slot5"));
        if (DefaultValue_GUI_2.L6_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line6.slot6"));
        if (DefaultValue_GUI_2.L6_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line6.slot7"));
        if (DefaultValue_GUI_2.L6_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line6.slot8"));
        if (DefaultValue_GUI_2.L6_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui2.line6.slot9"));


        /**
         * GUI3
         */

        if (DefaultValue_GUI_3.L1_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line1.slot1"));
        if (DefaultValue_GUI_3.L1_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line1.slot2"));
        if (DefaultValue_GUI_3.L1_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line1.slot3"));
        if (DefaultValue_GUI_3.L1_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line1.slot4"));
        if (DefaultValue_GUI_3.L1_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line1.slot5"));
        if (DefaultValue_GUI_3.L1_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line1.slot6"));
        if (DefaultValue_GUI_3.L1_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line1.slot7"));
        if (DefaultValue_GUI_3.L1_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line1.slot8"));
        if (DefaultValue_GUI_3.L1_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line1.slot9"));

        if (DefaultValue_GUI_3.L2_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line2.slot1"));
        if (DefaultValue_GUI_3.L2_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line2.slot2"));
        if (DefaultValue_GUI_3.L2_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line2.slot3"));
        if (DefaultValue_GUI_3.L2_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line2.slot4"));
        if (DefaultValue_GUI_3.L2_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line2.slot5"));
        if (DefaultValue_GUI_3.L2_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line2.slot6"));
        if (DefaultValue_GUI_3.L2_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line2.slot7"));
        if (DefaultValue_GUI_3.L2_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line2.slot8"));
        if (DefaultValue_GUI_3.L2_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line2.slot9"));

        if (DefaultValue_GUI_3.L3_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line3.slot1"));
        if (DefaultValue_GUI_3.L3_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line3.slot2"));
        if (DefaultValue_GUI_3.L3_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line3.slot3"));
        if (DefaultValue_GUI_3.L3_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line3.slot4"));
        if (DefaultValue_GUI_3.L3_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line3.slot5"));
        if (DefaultValue_GUI_3.L3_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line3.slot6"));
        if (DefaultValue_GUI_3.L3_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line3.slot7"));
        if (DefaultValue_GUI_3.L3_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line3.slot8"));
        if (DefaultValue_GUI_3.L3_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line3.slot9"));

        if (DefaultValue_GUI_3.L4_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line4.slot1"));
        if (DefaultValue_GUI_3.L4_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line4.slot2"));
        if (DefaultValue_GUI_3.L4_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line4.slot3"));
        if (DefaultValue_GUI_3.L4_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line4.slot4"));
        if (DefaultValue_GUI_3.L4_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line4.slot5"));
        if (DefaultValue_GUI_3.L4_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line4.slot6"));
        if (DefaultValue_GUI_3.L4_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line4.slot7"));
        if (DefaultValue_GUI_3.L4_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line4.slot8"));
        if (DefaultValue_GUI_3.L4_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line4.slot9"));

        if (DefaultValue_GUI_3.L5_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line5.slot1"));
        if (DefaultValue_GUI_3.L5_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line5.slot2"));
        if (DefaultValue_GUI_3.L5_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line5.slot3"));
        if (DefaultValue_GUI_3.L5_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line5.slot4"));
        if (DefaultValue_GUI_3.L5_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line5.slot5"));
        if (DefaultValue_GUI_3.L5_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line5.slot6"));
        if (DefaultValue_GUI_3.L5_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line5.slot7"));
        if (DefaultValue_GUI_3.L5_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line5.slot8"));
        if (DefaultValue_GUI_3.L5_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line5.slot9"));

        if (DefaultValue_GUI_3.L6_S1_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line6.slot1"));
        if (DefaultValue_GUI_3.L6_S2_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line6.slot2"));
        if (DefaultValue_GUI_3.L6_S3_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line6.slot3"));
        if (DefaultValue_GUI_3.L6_S4_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line6.slot4"));
        if (DefaultValue_GUI_3.L6_S5_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line6.slot5"));
        if (DefaultValue_GUI_3.L6_S6_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line6.slot6"));
        if (DefaultValue_GUI_3.L6_S7_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line6.slot7"));
        if (DefaultValue_GUI_3.L6_S8_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line6.slot8"));
        if (DefaultValue_GUI_3.L6_S9_Permission_Enable) Bukkit.getPluginManager().addPermission(new Permission("commandgui.use.gui3.line6.slot9"));

    }

}
