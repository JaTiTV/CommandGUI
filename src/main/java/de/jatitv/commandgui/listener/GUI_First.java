// This claas was created by JaTiTV


package de.jatitv.commandgui.listener;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_First;
import de.jatitv.commandgui.system.Main;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUI_First implements Listener {

    @EventHandler
    public void onFirstJoin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if (Bukkit.getPluginManager().getPlugin("NBTAPI") != null) {
            if (DefultValue_GUI_First.UseItem) {
                if (!p.hasPlayedBefore()) {
                    ItemStack item = new ItemStack(Material.valueOf(DefultValue_GUI_First.UseItem_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefultValue_GUI_First.UseItem_Name.replace("[guiname]", DefultValue_GUI_First.FirstGUIName));
                    ArrayList<String> lore = new ArrayList<>();
                    itemMeta.setLore(lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    NBTItem nbti = new NBTItem(item);
                    nbti.setBoolean("firstguiitem", true);
                    p.getInventory().addItem(nbti.getItem());
                }
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4\n" + DefultValue.PrefixHC + "§4NBTAPI could not be connected / found! " +
                    "§9Please download it here: §6https://www.spigotmc.org/resources/nbt-api.7939/§4\n" + DefultValue.PrefixHC);
        }
    }

    @EventHandler
    public void onInteractWB1(PlayerInteractEvent e) {
        if (Bukkit.getPluginManager().getPlugin("NBTAPI") != null) {
            Player p = e.getPlayer();
            if (!DefultValue_GUI_First.Permission_Enable || p.hasPermission(DefultValue_GUI_First.Permission)
                    || p.hasPermission("commandgui.admin") || p.isOp()) {
                if (e.getItem() != null && !p.getItemInHand().getType().isAir()) {
                    ItemStack item = p.getItemInHand();
                    NBTItem nbti = new NBTItem(item);
                    if (e.getItem().getItemMeta().getDisplayName().equals(DefultValue_GUI_First.UseItem_Name.replace("[guiname]", DefultValue_GUI_First.FirstGUIName))
                            && e.getItem().getType() == Material.valueOf(DefultValue_GUI_First.UseItem_Item) && nbti.hasKey("loot_item_1")) {
                        de.jatitv.commandgui.commands.GUI_First.openCGUI(e.getPlayer());
                    }
                }
            } else {
                e.setCancelled(true);
                p.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_First.UseItem_Name.replace("[guiname]", DefultValue_GUI_First.FirstGUIName))
                        .replace("[perm]", DefultValue_GUI_First.Permission));
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {


        if (!(e.getWhoClicked() instanceof Player)) return;
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory() != null && e.getCurrentItem() != null) {
            if (e.getWhoClicked().getOpenInventory().getTitle().equals("§6§8§9§r" + DefultValue_GUI_First.FirstGUIName)) {
                e.setCancelled(true);

                if (DefultValue_GUI_First.L1_S1_Enable) {
                    if (e.getSlot() == 0) {

                        if (!DefultValue_GUI_First.L1_S1_Permission_Enable || player.hasPermission(DefultValue_GUI_First.L1_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_First.L1_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_First.buy(player, DefultValue_GUI_First.L1_S1_Price)) {
                                    if (DefultValue_GUI_First.L1_S1_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_First.L1_S1_Command);
                                    }
                                    if (DefultValue_GUI_First.L1_S1_Message_Enable) {
                                        player.closeInventory();
                                        player.sendMessage(DefultValue_GUI_First.L1_S1_Message);
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_First.L1_S1_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_First.L1_S1_Command);
                                }
                                if (DefultValue_GUI_First.L1_S1_Message_Enable) {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue_GUI_First.L1_S1_Message);
                                }
                            }
                        } else
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_First.L1_S1_Name.replace("[guiname]", DefultValue_GUI_First.FirstGUIName))
                                    .replace("[perm]", DefultValue_GUI_First.L1_S1_Permission));
                    }
                }
            }
        }
    }
}
