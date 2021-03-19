// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_First;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Give {

    public static void giveCommand(CommandSender sender, String reciver, String wb) {

        Player target = Bukkit.getPlayer(reciver);

        if (wb.equals("firstguiitem")) {

            ItemStack item = new ItemStack(Material.valueOf(DefultValue_GUI_First.UseItem_Item));
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(DefultValue_GUI_First.UseItem_Name.replace("[guiname]", DefultValue_GUI_First.FirstGUIName));
            ArrayList<String> lore = new ArrayList<>();
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
            item.setAmount(1);
            NBTItem nbti = new NBTItem(item);
            nbti.setBoolean("firstguiitem", true);
            target.getInventory().addItem(nbti.getItem());

            sender.sendMessage(DefultValue.give.replace("[sender]", player.getName()).replace("[player]", target.getName())
                    .replace("[wonderbag]", DefultValueChest_1.Name));
        }
    }
}







