// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CGUI {

    public static void openCGUI(Player player) {

        Inventory inventory = Bukkit.createInventory((InventoryHolder) null, 9 * 4, "§6§8§9§rHi");

        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta itemMetaglass = glass.getItemMeta();
        itemMetaglass.setDisplayName(" ");
        glass.setItemMeta(itemMetaglass);
        glass.setAmount(1);
        for (int i = 0; i < 9 * 4; i++) {
            inventory.setItem(i, glass);
        }

        ItemStack item = new ItemStack(Material.CHEST);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("test");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§8-------------");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        item.setAmount(1);
        inventory.setItem(11, item);


        player.openInventory(inventory);
    }
}






