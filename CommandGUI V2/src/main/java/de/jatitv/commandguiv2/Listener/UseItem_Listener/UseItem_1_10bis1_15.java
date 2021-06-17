package de.jatitv.commandguiv2.Listener.UseItem_Listener;

import de.jatitv.commandguiv2.gui.GUI_GUI;
import de.jatitv.commandguiv2.select.Select_config;
import de.jatitv.commandguiv2.select.Select_msg;
import de.jatitv.commandguiv2.select.Select_sound;
import de.jatitv.commandguiv2.system.Database;
import de.jatitv.commandguiv2.system.GUI_Give_UseItem;
import de.jatitv.commandguiv2.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Iterator;

public class UseItem_1_10bis1_15 implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        itemChange(e.getPlayer());
    }

    public static void itemChange(Player player){
        if (Select_config.UseItem_Enable) {
            if (Select_config.UseItem_GiveOnFirstJoin) {
                if (!Select_config.UseItem_AllowToggle || !Database.select("SELECT `Status` FROM `gui-item` WHERE  `UUID`='" + player.getUniqueId() + "';").equals("0")) {

                    if (!player.hasPlayedBefore()) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                GUI_Give_UseItem.onGive(player.getName());
                            }
                        }.runTaskLater(Main.getPlugin(), 20L * 1);
                        if (Select_config.Cursor_ToGUIItem_OnFirstLogin) {
                            player.getInventory().setHeldItemSlot(Select_config.UseItem_InventorySlot - 1);
                        }
                    }
                }
            } else if (Select_config.UseItem_GiveOnEveryJoin) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (int iam = 0; iam < player.getInventory().getSize() - 5; iam++) {
                            ItemStack itm = player.getInventory().getItem(iam);
                            if (itm != null) {
                                if (itm.getType() == Material.valueOf(Select_config.UseItem_Material) || itm.getType() == Main.Head) {
                                    if (itm.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                                        player.getInventory().remove(itm);
                                        player.updateInventory();
                                        break;
                                    }
                                }
                            }
                        }
                        if (!Select_config.UseItem_AllowToggle || !Database.select("SELECT `Status` FROM `gui-item` WHERE  `UUID`='" + player.getUniqueId() + "';").equals("0")) {
                            if (Select_config.UseItem_InventorySlotEnforce || player.getInventory().getItem(Select_config.UseItem_InventorySlot - 1) == null) {
                                GUI_Give_UseItem.onGive(player.getName());
                                if (Select_config.Cursor_ToGUIItem_OnLogin) {
                                    if (Select_config.UseItem_ServerChange) {
                                        player.getInventory().setHeldItemSlot(Select_config.UseItem_InventorySlot - 1);
                                    } else if (Database.select("SELECT `Status` FROM `gui-onlineplayer` WHERE  `UUID`='" + player.getUniqueId() + "';").equals("Offline")) {
                                        player.getInventory().setHeldItemSlot(Select_config.UseItem_InventorySlot - 1);
                                    }
                                }
                            } else {
                                boolean empty = false;
                                for (int i = 0; i < 9; i++) {
                                    if (player.getInventory().getItem(i) == null) {
                                        empty = true;
                                        break;
                                    }
                                }
                                if (empty) {
                                    GUI_Give_UseItem.onGiveADD(player.getName());
                                }
                            }
                        }
                    }
                }.runTaskLater(Main.getPlugin(), 20L * 1);
                if (Select_config.Bungee) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Database.query("INSERT INTO `gui-onlineplayer` (`UUID`, `Name`, `Status`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                                    + "', '" + Select_config.thisServer + "') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = '" + Select_config.thisServer + "';");
                        }
                    }.runTaskLater(Main.getPlugin(), 20L * 3);
                }
            }

        }
    }

    @EventHandler
    public void onDisconect(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        if (Select_config.Bungee) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Database.query("INSERT INTO `gui-onlineplayer` (`UUID`, `Name`, `Status`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                            + "', '" + Select_config.thisServer + "') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = 'Offline';");
                }
            }.runTaskLater(Main.getPlugin(), 20L * 2);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDeathDrop(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        for (int iam = 0; iam < player.getInventory().getSize() - 5; iam++) {
            ItemStack itm = player.getInventory().getItem(iam);
            if (itm != null) {
                if (itm.getType() == Material.valueOf(Select_config.UseItem_Material) || itm.getType() == Main.Head) {
                    if (itm.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                        player.getInventory().remove(itm);
                        player.updateInventory();
                        break;
                    }
                }
            }
        }

        if (!e.getDrops().isEmpty()) {
            Iterator var3 = (new ArrayList(e.getDrops())).iterator();
            while (var3.hasNext()) {
                ItemStack items = (ItemStack) var3.next();
                if (items != null && items.hasItemMeta() && items.getItemMeta().hasDisplayName()
                        && items.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                    e.getDrops().remove(items);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        if (Select_config.UseItem_Enable) {
            if (!Select_config.UseItem_AllowToggle || !Database.select("SELECT `Status` FROM `gui-item` WHERE  `UUID`='" + player.getUniqueId() + "';").equals("0")) {
                if (Select_config.UseItem_GiveOnFirstJoin) {
                    if (!player.hasPlayedBefore()) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                GUI_Give_UseItem.onGive(player.getName());
                            }
                        }.runTaskLater(Main.getPlugin(), 20L * 1);
                    }
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            GUI_Give_UseItem.onGive(player.getName());
                        }
                    }.runTaskLater(Main.getPlugin(), 20L * 1);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (Select_config.UseItem_Enable) {
            if (Select_config.UseItem_PlayerHead_Enable) {
                if (e.getItem() != null && p.getItemInHand().getType() == Main.Head) {
                    if (e.getItem().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                        e.setCancelled(true);
                        if (!Select_config.UseItem_Permission || p.hasPermission("commandgui.useitem")) {
                            GUI_GUI.openGUI(p, Main.guiHashMap.get(Select_config.UseItem_OpenGUI));
                            if (Select_sound.Sound_Enable && Select_sound.Sound_OpenInventory_Enable) {
                                p.playSound(p.getLocation(), Select_sound.Sound_OpenInventory, 3, 1);
                            }
                        } else {
                            p.sendMessage(Select_msg.NoPermissionForUseItem.replace("[perm]", "commandgui.useitem")
                                    .replace("[gui]", Select_config.UseItem_OpenGUI));
                        }
                    }
                }
            } else {
                if (e.getItem() != null && p.getItemInHand().getType() == Material.valueOf(Select_config.UseItem_Material)) {
                    Bukkit.getConsoleSender().sendMessage("item 1");
                    if (e.getItem().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                        Bukkit.getConsoleSender().sendMessage("item 2");
                        e.setCancelled(true);
                        Bukkit.getConsoleSender().sendMessage("item 3");
                        if (!Select_config.UseItem_Permission || p.hasPermission("commandgui.useitem")) {
                            Bukkit.getConsoleSender().sendMessage("item 4");
                            GUI_GUI.openGUI(p, Main.guiHashMap.get(Select_config.UseItem_OpenGUI));
                            if (Select_sound.Sound_Enable && Select_sound.Sound_OpenInventory_Enable) {
                                p.playSound(p.getLocation(), Select_sound.Sound_OpenInventory, 3, 1);
                            }
                        } else {
                            p.sendMessage(Select_msg.NoPermissionForUseItem.replace("[perm]", "commandgui.useitem")
                                    .replace("[gui]", Select_config.UseItem_OpenGUI));
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onHandSwap(PlayerSwapHandItemsEvent e) {
        if (Main.minecraft1_8 || Main.minecraft1_9) return;
        if (!Select_config.UseItem_BlockMoveAndDrop || !Select_config.UseItem_Enable) return;
        if (e.getMainHandItem() != null && e.getMainHandItem().hasItemMeta() && e.getMainHandItem().getItemMeta().hasDisplayName()
                && e.getMainHandItem().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
        }
        if (e.getOffHandItem() != null && e.getOffHandItem().hasItemMeta() && e.getOffHandItem().getItemMeta().hasDisplayName()
                && e.getOffHandItem().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemMoveEvent(InventoryMoveItemEvent e) {
        if (!Select_config.UseItem_BlockMoveAndDrop || !Select_config.UseItem_Enable) return;
        if (e.getItem() != null && e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasDisplayName()
                && e.getItem().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
            e.setCancelled(true);
        }
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemMove(InventoryDragEvent e) {
        if (!Select_config.UseItem_BlockMoveAndDrop || !Select_config.UseItem_Enable) return;
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            if (e.getCursor() != null && e.getCursor().hasItemMeta() && e.getCursor().getItemMeta().hasDisplayName()
                    && e.getCursor().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                p.closeInventory();
                e.setCancelled(true);
            }

            if (e.getOldCursor() != null && e.getOldCursor().hasItemMeta() && e.getOldCursor().getItemMeta().hasDisplayName()
                    && e.getOldCursor().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                p.closeInventory();
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemMove(InventoryClickEvent e) {
        if (!Select_config.UseItem_BlockMoveAndDrop || !Select_config.UseItem_Enable) return;
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            if (e.getCursor() != null && e.getCursor().hasItemMeta() && e.getCursor().getItemMeta().hasDisplayName()
                    && e.getCursor().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                p.closeInventory();
                e.setCancelled(true);
            }

            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()
                    && e.getCurrentItem().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                p.closeInventory();
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemMove(PlayerSwapHandItemsEvent e) {
        if (Main.minecraft1_8 || Main.minecraft1_9) return;
        if (!Select_config.UseItem_BlockMoveAndDrop || !Select_config.UseItem_Enable) return;
        Player p = e.getPlayer();
        if (e.getOffHandItem() != null && e.getOffHandItem().hasItemMeta() && e.getOffHandItem().getItemMeta().hasDisplayName()
                && e.getOffHandItem().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
            p.closeInventory();
            e.setCancelled(true);
        }

        if (e.getMainHandItem() != null && e.getMainHandItem().hasItemMeta() && e.getMainHandItem().getItemMeta().hasDisplayName()
                && e.getMainHandItem().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
            p.closeInventory();
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemMove(InventoryPickupItemEvent e) {
        if (!Select_config.UseItem_BlockMoveAndDrop || !Select_config.UseItem_Enable) return;
        if (e.getItem() != null && e.getItem().getItemStack() != null) {
            ItemStack item = e.getItem().getItemStack();
            if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()
                    && item.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlace(BlockPlaceEvent e) {
        if (!Select_config.UseItem_BlockMoveAndDrop || !Select_config.UseItem_Enable) return;
        if (e.getItemInHand() != null && e.getItemInHand().hasItemMeta() && e.getItemInHand().getItemMeta().hasDisplayName()
                && e.getItemInHand().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDrop(PlayerDropItemEvent e) {
        if (!Select_config.UseItem_BlockMoveAndDrop || !Select_config.UseItem_Enable) return;
        if (e.getItemDrop() != null && e.getItemDrop().getItemStack() != null) {
            ItemStack item = e.getItemDrop().getItemStack();
            if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()
                    && item.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                e.setCancelled(true);
            }
        }
    }
}