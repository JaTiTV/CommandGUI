// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_First;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUI_First {

    public static void openCGUI(Player player) {

        Inventory inventory = Bukkit.createInventory((InventoryHolder) null, 9 * DefultValue_GUI_First.GUILines, "§6§8§9§r" + DefultValue_GUI_First.FirstGUIName);

        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta itemMetaglass = glass.getItemMeta();
        itemMetaglass.setDisplayName(" ");
        glass.setItemMeta(itemMetaglass);
        glass.setAmount(1);
        for (int i = 0; i < 9 * DefultValue_GUI_First.GUILines; i++) {
            inventory.setItem(i, glass);
        }

        if (DefultValue_GUI_First.L1_S1_Enable) {
            ItemStack item = new ItemStack(Material.valueOf(DefultValue_GUI_First.L1_S1_Item));
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(DefultValue_GUI_First.L1_S1_Name);
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§8-------------");
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
            item.setAmount(1);
            inventory.setItem(0, item);
        }


        player.openInventory(inventory);
    }

    public static boolean buy(Player p, Double preis){
        if(Main.eco == null ){
            if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4\n" + DefultValue.PrefixHC + "§4Vault could not be found! §9Please download it here: " +
                        "§6https://www.spigotmc.org/resources/vault.34315/§4\n" + DefultValue.PrefixHC);
            }
            p.sendMessage(DefultValue.Prefix+ "\n" + DefultValue.VaultNotSetUp + "\n" + DefultValue.Prefix);
        }else {
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






