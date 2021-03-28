// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.defultValue.DefaultValue;
import de.jatitv.commandgui.defultValue.DefaultValue_GUI_2;
import de.jatitv.commandgui.system.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class GUI_2 {

    public static String GUI_NAME;

    public static void openCGUI(Player player) {

        if (Main.PaPi) {
            Inventory inventory = Bukkit.createInventory((InventoryHolder) null, 9 * DefaultValue_GUI_2.GUILines,
                    (PlaceholderAPI.setPlaceholders(player, GUI_NAME)));

            if (DefaultValue_GUI_2.FillItem_Enable) {
                if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {

                    ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, DefaultValue_GUI_2.FillItem_1_8);
                    ItemMeta itemMetaglass = glass.getItemMeta();
                    itemMetaglass.setDisplayName(" ");
                    glass.setItemMeta(itemMetaglass);
                    glass.setAmount(1);
                    for (int i = 0; i < 9 * DefaultValue_GUI_2.GUILines; i++) {
                        inventory.setItem(i, glass);
                    }
                } else {
                    ItemStack glass = new ItemStack(Material.valueOf(DefaultValue_GUI_2.FillItem));
                    ItemMeta itemMetaglass = glass.getItemMeta();
                    itemMetaglass.setDisplayName(" ");
                    glass.setItemMeta(itemMetaglass);
                    glass.setAmount(1);
                    for (int i = 0; i < 9 * DefaultValue_GUI_2.GUILines; i++) {
                        inventory.setItem(i, glass);
                    }
                }
            }

            if (DefaultValue_GUI_2.GUILines == 1 || DefaultValue_GUI_2.GUILines > 1) {
                if (DefaultValue_GUI_2.L1_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S1_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S1_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(0, item);
                }
                if (DefaultValue_GUI_2.L1_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S2_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S2_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(1, item);
                }
                if (DefaultValue_GUI_2.L1_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S3_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S3_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(2, item);
                }
                if (DefaultValue_GUI_2.L1_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S4_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S4_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(3, item);
                }
                if (DefaultValue_GUI_2.L1_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S5_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S5_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(4, item);
                }
                if (DefaultValue_GUI_2.L1_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S6_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S6_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(5, item);
                }
                if (DefaultValue_GUI_2.L1_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S7_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S7_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(6, item);
                }
                if (DefaultValue_GUI_2.L1_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S8_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S8_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(7, item);
                }
                if (DefaultValue_GUI_2.L1_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S9_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L1_S9_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(8, item);
                }
            } else if (DefaultValue_GUI_2.GUILines == 2 || DefaultValue_GUI_2.GUILines > 2) {
                if (DefaultValue_GUI_2.L2_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S1_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S1_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(9, item);
                }
                if (DefaultValue_GUI_2.L2_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S2_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S2_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(10, item);
                }
                if (DefaultValue_GUI_2.L2_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S3_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S3_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(11, item);
                }
                if (DefaultValue_GUI_2.L2_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S4_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S4_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(12, item);
                }
                if (DefaultValue_GUI_2.L2_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S5_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S5_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(13, item);
                }
                if (DefaultValue_GUI_2.L2_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S6_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S6_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(14, item);
                }
                if (DefaultValue_GUI_2.L2_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S7_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S7_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(15, item);
                }
                if (DefaultValue_GUI_2.L2_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S8_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S8_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(16, item);
                }
                if (DefaultValue_GUI_2.L2_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S9_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L2_S9_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(17, item);
                }
            } else if (DefaultValue_GUI_2.GUILines == 3 || DefaultValue_GUI_2.GUILines > 3) {
                if (DefaultValue_GUI_2.L3_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S1_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S1_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(18, item);
                }
                if (DefaultValue_GUI_2.L3_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S2_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S2_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(19, item);
                }
                if (DefaultValue_GUI_2.L3_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S3_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S3_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(20, item);
                }
                if (DefaultValue_GUI_2.L3_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S4_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S4_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(21, item);
                }
                if (DefaultValue_GUI_2.L3_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S5_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S5_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(22, item);
                }
                if (DefaultValue_GUI_2.L3_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S6_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S6_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(23, item);
                }
                if (DefaultValue_GUI_2.L3_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S7_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S7_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(24, item);
                }
                if (DefaultValue_GUI_2.L3_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S8_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S8_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(25, item);
                }
                if (DefaultValue_GUI_2.L3_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S9_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L3_S9_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(26, item);
                }
            } else if (DefaultValue_GUI_2.GUILines == 4 || DefaultValue_GUI_2.GUILines > 4) {
                if (DefaultValue_GUI_2.L4_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S1_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S1_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(27, item);
                }
                if (DefaultValue_GUI_2.L4_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S2_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S2_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(28, item);
                }
                if (DefaultValue_GUI_2.L4_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S3_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S3_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(29, item);
                }
                if (DefaultValue_GUI_2.L4_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S4_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S4_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(30, item);
                }
                if (DefaultValue_GUI_2.L4_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S5_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S5_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(31, item);
                }
                if (DefaultValue_GUI_2.L4_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S6_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S6_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(32, item);
                }
                if (DefaultValue_GUI_2.L4_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S7_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S7_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(33, item);
                }
                if (DefaultValue_GUI_2.L4_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S8_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S8_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(34, item);
                }
                if (DefaultValue_GUI_2.L4_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S9_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L4_S9_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(35, item);
                }
            } else if (DefaultValue_GUI_2.GUILines == 5 || DefaultValue_GUI_2.GUILines > 5) {
                if (DefaultValue_GUI_2.L5_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S1_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S1_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(36, item);
                }
                if (DefaultValue_GUI_2.L5_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S2_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S2_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(37, item);
                }
                if (DefaultValue_GUI_2.L5_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S3_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S3_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(38, item);
                }
                if (DefaultValue_GUI_2.L5_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S4_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S4_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(39, item);
                }
                if (DefaultValue_GUI_2.L5_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S5_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S5_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(40, item);
                }
                if (DefaultValue_GUI_2.L5_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S6_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S6_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(41, item);
                }
                if (DefaultValue_GUI_2.L5_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S7_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S7_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(42, item);
                }
                if (DefaultValue_GUI_2.L5_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S8_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S8_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(43, item);
                }
                if (DefaultValue_GUI_2.L5_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S9_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L5_S9_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(44, item);
                }
            } else if (DefaultValue_GUI_2.GUILines == 6) {
                if (DefaultValue_GUI_2.L6_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S1_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S1_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(45, item);
                }
                if (DefaultValue_GUI_2.L6_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S2_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S2_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(46, item);
                }
                if (DefaultValue_GUI_2.L6_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S3_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S3_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(47, item);
                }
                if (DefaultValue_GUI_2.L6_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S4_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S4_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(48, item);
                }
                if (DefaultValue_GUI_2.L6_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S5_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S5_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(49, item);
                }
                if (DefaultValue_GUI_2.L6_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S6_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S6_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(50, item);
                }
                if (DefaultValue_GUI_2.L6_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S7_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S7_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(51, item);
                }
                if (DefaultValue_GUI_2.L6_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S8_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S8_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(52, item);
                }
                if (DefaultValue_GUI_2.L6_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S9_Name));
                    itemMeta.setLore(PlaceholderAPI.setPlaceholders(player, DefaultValue_GUI_2.L6_S9_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(53, item);
                }
            }
            player.openInventory(inventory);

        } else {
            Inventory inventory = Bukkit.createInventory((InventoryHolder) null, 9 * DefaultValue_GUI_2.GUILines, GUI_NAME);
            if (DefaultValue_GUI_2.FillItem_Enable) {
                if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
                    ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, DefaultValue_GUI_2.FillItem_1_8);
                    ItemMeta itemMetaglass = glass.getItemMeta();
                    itemMetaglass.setDisplayName(" ");
                    glass.setItemMeta(itemMetaglass);
                    glass.setAmount(1);
                    for (int i = 0; i < 9 * DefaultValue_GUI_2.GUILines; i++) {
                        inventory.setItem(i, glass);
                    }
                } else {
                    ItemStack glass = new ItemStack(Material.valueOf(DefaultValue_GUI_2.FillItem));
                    ItemMeta itemMetaglass = glass.getItemMeta();
                    itemMetaglass.setDisplayName(" ");
                    glass.setItemMeta(itemMetaglass);
                    glass.setAmount(1);
                    for (int i = 0; i < 9 * DefaultValue_GUI_2.GUILines; i++) {
                        inventory.setItem(i, glass);
                    }
                }
            }
            if (DefaultValue_GUI_2.GUILines == 1 || DefaultValue_GUI_2.GUILines > 1) {
                if (DefaultValue_GUI_2.L1_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L1_S1_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L1_S1_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(0, item);
                }
                if (DefaultValue_GUI_2.L1_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L1_S2_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L1_S2_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(1, item);
                }
                if (DefaultValue_GUI_2.L1_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L1_S3_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L1_S3_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(2, item);
                }
                if (DefaultValue_GUI_2.L1_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L1_S4_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L1_S4_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(3, item);
                }
                if (DefaultValue_GUI_2.L1_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L1_S5_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L1_S5_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(4, item);
                }
                if (DefaultValue_GUI_2.L1_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L1_S6_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L1_S6_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(5, item);
                }
                if (DefaultValue_GUI_2.L1_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L1_S7_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L1_S7_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(6, item);
                }
                if (DefaultValue_GUI_2.L1_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L1_S8_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L1_S8_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(7, item);
                }
                if (DefaultValue_GUI_2.L1_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L1_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L1_S9_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L1_S9_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(8, item);
                }
            } else if (DefaultValue_GUI_2.GUILines == 2 || DefaultValue_GUI_2.GUILines > 2) {
                if (DefaultValue_GUI_2.L2_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L2_S1_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L2_S1_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(9, item);
                }
                if (DefaultValue_GUI_2.L2_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L2_S2_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L2_S2_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(10, item);
                }
                if (DefaultValue_GUI_2.L2_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L2_S3_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L2_S3_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(11, item);
                }
                if (DefaultValue_GUI_2.L2_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L2_S4_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L2_S4_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(12, item);
                }
                if (DefaultValue_GUI_2.L2_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L2_S5_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L2_S5_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(13, item);
                }
                if (DefaultValue_GUI_2.L2_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L2_S6_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L2_S6_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(14, item);
                }
                if (DefaultValue_GUI_2.L2_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L2_S7_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L2_S7_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(15, item);
                }
                if (DefaultValue_GUI_2.L2_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L2_S8_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L2_S8_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(16, item);
                }
                if (DefaultValue_GUI_2.L2_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L2_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L2_S9_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L2_S9_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(17, item);
                }
            } else if (DefaultValue_GUI_2.GUILines == 3 || DefaultValue_GUI_2.GUILines > 3) {
                if (DefaultValue_GUI_2.L3_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L3_S1_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L3_S1_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(18, item);
                }
                if (DefaultValue_GUI_2.L3_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L3_S2_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L3_S2_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(19, item);
                }
                if (DefaultValue_GUI_2.L3_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L3_S3_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L3_S3_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(20, item);
                }
                if (DefaultValue_GUI_2.L3_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L3_S4_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L3_S4_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(21, item);
                }
                if (DefaultValue_GUI_2.L3_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L3_S5_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L3_S5_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(22, item);
                }
                if (DefaultValue_GUI_2.L3_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L3_S6_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L3_S6_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(23, item);
                }
                if (DefaultValue_GUI_2.L3_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L3_S7_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L3_S7_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(24, item);
                }
                if (DefaultValue_GUI_2.L3_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L3_S8_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L3_S8_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(25, item);
                }
                if (DefaultValue_GUI_2.L3_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L3_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L3_S9_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L3_S9_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(26, item);
                }
            } else if (DefaultValue_GUI_2.GUILines == 4 || DefaultValue_GUI_2.GUILines > 4) {
                if (DefaultValue_GUI_2.L4_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L4_S1_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L4_S1_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(27, item);
                }
                if (DefaultValue_GUI_2.L4_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L4_S2_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L4_S2_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(28, item);
                }
                if (DefaultValue_GUI_2.L4_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L4_S3_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L4_S3_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(29, item);
                }
                if (DefaultValue_GUI_2.L4_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L4_S4_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L4_S4_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(30, item);
                }
                if (DefaultValue_GUI_2.L4_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L4_S5_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L4_S5_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(31, item);
                }
                if (DefaultValue_GUI_2.L4_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L4_S6_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L4_S6_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(32, item);
                }
                if (DefaultValue_GUI_2.L4_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L4_S7_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L4_S7_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(33, item);
                }
                if (DefaultValue_GUI_2.L4_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L4_S8_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L4_S8_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(34, item);
                }
                if (DefaultValue_GUI_2.L4_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L4_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L4_S9_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L4_S9_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(35, item);
                }
            } else if (DefaultValue_GUI_2.GUILines == 5 || DefaultValue_GUI_2.GUILines > 5) {
                if (DefaultValue_GUI_2.L5_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L5_S1_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L5_S1_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(36, item);
                }
                if (DefaultValue_GUI_2.L5_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L5_S2_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L5_S2_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(37, item);
                }
                if (DefaultValue_GUI_2.L5_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L5_S3_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L5_S3_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(38, item);
                }
                if (DefaultValue_GUI_2.L5_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L5_S4_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L5_S4_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(39, item);
                }
                if (DefaultValue_GUI_2.L5_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L5_S5_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L5_S5_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(40, item);
                }
                if (DefaultValue_GUI_2.L5_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L5_S6_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L5_S6_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(41, item);
                }
                if (DefaultValue_GUI_2.L5_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L5_S7_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L5_S7_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(42, item);
                }
                if (DefaultValue_GUI_2.L5_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L5_S8_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L5_S8_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(43, item);
                }
                if (DefaultValue_GUI_2.L5_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L5_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L5_S9_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L5_S9_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(44, item);
                }
            } else if (DefaultValue_GUI_2.GUILines == 6) {
                if (DefaultValue_GUI_2.L6_S1_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S1_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L6_S1_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L6_S1_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(45, item);
                }
                if (DefaultValue_GUI_2.L6_S2_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S2_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L6_S2_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L6_S2_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(46, item);
                }
                if (DefaultValue_GUI_2.L6_S3_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S3_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L6_S3_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L6_S3_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(47, item);
                }
                if (DefaultValue_GUI_2.L6_S4_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S4_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L6_S4_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L6_S4_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(48, item);
                }
                if (DefaultValue_GUI_2.L6_S5_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S5_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L6_S5_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L6_S5_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(49, item);
                }
                if (DefaultValue_GUI_2.L6_S6_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S6_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L6_S6_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L6_S6_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(50, item);
                }
                if (DefaultValue_GUI_2.L6_S7_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S7_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L6_S7_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L6_S7_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(51, item);
                }
                if (DefaultValue_GUI_2.L6_S8_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S8_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L6_S8_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L6_S8_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(52, item);
                }
                if (DefaultValue_GUI_2.L6_S9_Enable) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.L6_S9_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.L6_S9_Name);
                    itemMeta.setLore(DefaultValue_GUI_2.L6_S9_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    inventory.setItem(53, item);
                }
            }
            player.openInventory(inventory);
        }
    }

    public static boolean buy(Player p, Double preis) {
        if (Main.eco == null) {
            if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4\n" + DefaultValue.PrefixHC + "§4Vault could not be found! §9Please download it here: " +
                        "§6https://www.spigotmc.org/resources/vault.34315/§4\n" + DefaultValue.PrefixHC);
            }
            p.sendMessage(DefaultValue.Prefix + "\n" + DefaultValue.VaultNotSetUp + "\n" + DefaultValue.Prefix);
        } else {
            if (Main.eco.getBalance(p) < preis) {
                return false;
            } else {
                Main.eco.withdrawPlayer(p, preis);
                return true;
            }
        }
        return false;
    }
}