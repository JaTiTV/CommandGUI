// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_1;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Give {

    public static void giveCommand(CommandSender sender, String reciver, String wb) {

        Player target = Bukkit.getPlayer(reciver);

        if (wb.equals("1")) {

            ItemStack item = new ItemStack(Material.valueOf(DefultValue_GUI_1.UseItem_Item));
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(DefultValue_GUI_1.UseItem_Name.replace("[guiname]", DefultValue_GUI_1.GUIName));
            itemMeta.setLore(DefultValue_GUI_1.UseItem_Lore);
            item.setItemMeta(itemMeta);
            item.setAmount(1);
            target.getInventory().addItem(item);

            sender.sendMessage(DefultValue.give.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                    .replace("[item]", DefultValue_GUI_1.UseItem_Name));
            target.sendMessage(DefultValue.giveReceived.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                    .replace("[wonderbag]", DefultValue_GUI_1.UseItem_Name));
        }
    }
}







