// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.defaultValue.DefaultValue;
import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_1;
import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_2;
import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_3;
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

            if (wb.equals(DefaultValue_GUI_1.Command)) {
                ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_1.UseItem_Item));
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(DefaultValue_GUI_1.UseItem_Name.replace("[guiname]", DefaultValue_GUI_1.GUIName));
                itemMeta.setLore(DefaultValue_GUI_1.UseItem_Lore);
                item.setItemMeta(itemMeta);
                item.setAmount(1);
                target.getInventory().addItem(item);

                if (sender != target){
                    sender.sendMessage(DefaultValue.give.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                            .replace("[item]", DefaultValue_GUI_1.UseItem_Name).replace("[guiname]", DefaultValue_GUI_1.GUIName));
                    target.sendMessage(DefaultValue.giveReceived.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                            .replace("[item]", DefaultValue_GUI_1.UseItem_Name).replace("[guiname]", DefaultValue_GUI_1.GUIName));

                } else {
                    if (DefaultValue.Sound_Give_Enable && DefaultValue.Sound_Enable){
                        target.playSound(target.getLocation(), DefaultValue.Sound_Give, 3, 1);
                    }
                }

            } else if (wb.equals(DefaultValue_GUI_2.Command)) {
                ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.UseItem_Item));
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(DefaultValue_GUI_2.UseItem_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName));
                itemMeta.setLore(DefaultValue_GUI_2.UseItem_Lore);
                item.setItemMeta(itemMeta);
                item.setAmount(1);
                target.getInventory().addItem(item);

                if (sender != target) {
                    sender.sendMessage(DefaultValue.give.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                            .replace("[item]", DefaultValue_GUI_2.UseItem_Name).replace("[guiname]", DefaultValue_GUI_2.GUIName));
                    target.sendMessage(DefaultValue.giveReceived.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                            .replace("[item]", DefaultValue_GUI_2.UseItem_Name).replace("[guiname]", DefaultValue_GUI_2.GUIName));
                    if (DefaultValue.Sound_Give_Enable && DefaultValue.Sound_Enable) {
                        ((Player) sender).playSound(((Player) sender).getLocation(), DefaultValue.Sound_Give, 3, 1);
                        target.playSound(target.getLocation(), DefaultValue.Sound_Give, 3, 1);
                    }
                } else{
                    if (DefaultValue.Sound_Give_Enable && DefaultValue.Sound_Enable) {
                        target.playSound(target.getLocation(), DefaultValue.Sound_Give, 3, 1);
                    }
                }

            } else if (wb.equals(DefaultValue_GUI_3.Command)) {
                ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_3.UseItem_Item));
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(DefaultValue_GUI_3.UseItem_Name.replace("[guiname]", DefaultValue_GUI_3.GUIName));
                itemMeta.setLore(DefaultValue_GUI_3.UseItem_Lore);
                item.setItemMeta(itemMeta);
                item.setAmount(1);
                target.getInventory().addItem(item);

                if (sender != target) {
                    sender.sendMessage(DefaultValue.give.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                            .replace("[item]", DefaultValue_GUI_3.UseItem_Name).replace("[guiname]", DefaultValue_GUI_3.GUIName));
                    target.sendMessage(DefaultValue.giveReceived.replace("[sender]", sender.getName()).replace("[player]", target.getName())
                            .replace("[item]", DefaultValue_GUI_3.UseItem_Name).replace("[guiname]", DefaultValue_GUI_3.GUIName));
                    if (DefaultValue.Sound_Give_Enable && DefaultValue.Sound_Enable) {
                        ((Player) sender).playSound(((Player) sender).getLocation(), DefaultValue.Sound_Give, 3, 1);
                        target.playSound(target.getLocation(), DefaultValue.Sound_Give, 3, 1);
                    }
                } else {
                    if (DefaultValue.Sound_Give_Enable && DefaultValue.Sound_Enable) {
                        target.playSound(target.getLocation(), DefaultValue.Sound_Give, 3, 1);
                    }
                }

            } else Help.Help(sender);
        } else {
            if (target == sender) {
                sender.sendMessage(DefaultValue.NoInventorySpace);
            } else {
                sender.sendMessage(DefaultValue.PlayerNoInventorySpace.replace("[player]", target.getName()));
            }
            if (sender instanceof Player) {
                if (DefaultValue.Sound_NoInventorySpace_Enable && DefaultValue.Sound_Enable) {
                    ((Player) sender).playSound(((Player) sender).getLocation(), DefaultValue.Sound_NoInventorySpace, 3, 1);
                }
            }

        }
    }
}







