// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_1;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_2;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_3;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Give {

    public static void giveCommand(CommandSender sender, String reciver, String wb) {
        Player target = Bukkit.getPlayer(reciver);
        boolean empty = false;
        for (int i = 0; i < target.getInventory().getSize() - 5; i++) {
            if (target.getInventory().getItem(i) == null) {
                empty = true;

                break;
            }
        }
        if (empty) {

            if (wb.equals(DefultValue_GUI_1.Command)) {
                ItemStack item = new ItemStack(Material.valueOf(DefultValue_GUI_1.UseItem_Item));
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(DefultValue_GUI_1.UseItem_Name.replace("[guiname]", DefultValue_GUI_1.GUIName));
                itemMeta.setLore(DefultValue_GUI_1.UseItem_Lore);
                item.setItemMeta(itemMeta);
                item.setAmount(1);
                target.getInventory().addItem(item);

                sender.sendMessage(DefultValue.give.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                        .replace("[item]", DefultValue_GUI_1.UseItem_Name).replace("[guiname]", DefultValue_GUI_1.GUIName));
                target.sendMessage(DefultValue.giveReceived.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                        .replace("[wonderbag]", DefultValue_GUI_1.UseItem_Name).replace("[guiname]", DefultValue_GUI_1.GUIName));
            } else if (wb.equals(DefultValue_GUI_2.Command)) {
                ItemStack item = new ItemStack(Material.valueOf(DefultValue_GUI_2.UseItem_Item));
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(DefultValue_GUI_2.UseItem_Name.replace("[guiname]", DefultValue_GUI_2.GUIName));
                itemMeta.setLore(DefultValue_GUI_2.UseItem_Lore);
                item.setItemMeta(itemMeta);
                item.setAmount(1);
                target.getInventory().addItem(item);

                sender.sendMessage(DefultValue.give.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                        .replace("[item]", DefultValue_GUI_2.UseItem_Name).replace("[guiname]", DefultValue_GUI_2.GUIName));
                target.sendMessage(DefultValue.giveReceived.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                        .replace("[wonderbag]", DefultValue_GUI_2.UseItem_Name).replace("[guiname]", DefultValue_GUI_2.GUIName));
            } else if (wb.equals(DefultValue_GUI_3.Command)) {
                ItemStack item = new ItemStack(Material.valueOf(DefultValue_GUI_3.UseItem_Item));
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(DefultValue_GUI_3.UseItem_Name.replace("[guiname]", DefultValue_GUI_3.GUIName));
                itemMeta.setLore(DefultValue_GUI_3.UseItem_Lore);
                item.setItemMeta(itemMeta);
                item.setAmount(1);
                target.getInventory().addItem(item);

                sender.sendMessage(DefultValue.give.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                        .replace("[item]", DefultValue_GUI_3.UseItem_Name).replace("[guiname]", DefultValue_GUI_3.GUIName));
                target.sendMessage(DefultValue.giveReceived.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                        .replace("[wonderbag]", DefultValue_GUI_3.UseItem_Name).replace("[guiname]", DefultValue_GUI_3.GUIName));
            }
        } else {
            if (target == sender) {
                sender.sendMessage(DefultValue.NoInventorySpace);
            } else {
                sender.sendMessage(DefultValue.PlayerNoInventorySpace.replace("[player]", target.getName()));
            }
            if (sender instanceof Player) {
                if (DefultValue.Sound_NoInventorySpace_Enable && DefultValue.Sound_Enable) {
                    Player player = (Player) sender;
                    player.playSound(player.getLocation(), DefultValue.Sound_NoInventorySpace, 3, 1);
                }
            }

        }
    }
}







