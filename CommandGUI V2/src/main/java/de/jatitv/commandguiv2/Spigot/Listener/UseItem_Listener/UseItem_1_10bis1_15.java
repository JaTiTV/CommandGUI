package de.jatitv.commandguiv2.Spigot.Listener.UseItem_Listener;

import de.jatitv.commandguiv2.Spigot.cmdManagement.Commands;
import de.jatitv.commandguiv2.Spigot.gui.GUI_GUI;
import de.jatitv.commandguiv2.Spigot.system.API;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_config;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_msg;
import de.jatitv.commandguiv2.Spigot.system.database.MySQL;
import de.jatitv.commandguiv2.Spigot.system.GUI_Give_UseItem;
import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.database.Select_Database;
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
        if  (API.JoinDisable) return;
        if (e.getPlayer().hasPermission("commandgui.get.guiitem.at.login")){
            itemChange(e.getPlayer());
        }
    }

    public static void itemChange(Player player){
        Integer slot;
        if (Select_Database.selectSlot(player) == null){
            slot = Select_config.UseItem_InventorySlot;
        } else {
            slot = Select_Database.selectSlot(player);
        }
        if (Select_config.UseItem_Enable) {
            if (Select_config.UseItem_GiveOnlyOnFirstJoin) {
                if (!Select_config.UseItem_AllowToggle || Select_Database.selectItemStatus(player)) {

                    if (!player.hasPlayedBefore()) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                GUI_Give_UseItem.onGive(player);
                            }
                        }.runTaskLater(Main.plugin, 20L * 1);
                        if (Select_config.Cursor_ToGUIItem_OnlyOnFirstLogin ||Select_config.Cursor_ToGUIItem_OnLogin) {
                            player.getInventory().setHeldItemSlot(slot - 1);
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
                        if (!Select_config.UseItem_AllowToggle || Select_Database.selectItemStatus(player)) {
                            if (Select_config.UseItem_InventorySlotEnforce || player.getInventory().getItem(slot - 1) == null) {
                                GUI_Give_UseItem.onGive(player);
                                if (Select_config.Cursor_ToGUIItem_OnLogin) {
                                    if (!Select_config.Cursor_ToGUIItem_OnlyOnFirstLogin) {
                                        if (Select_config.Storage.equals("MYSQL") && Select_config.Bungee && Select_config.UseItem_ServerChange) {
                                            player.getInventory().setHeldItemSlot(slot - 1);
                                        } else if (MySQL.select("SELECT `Status` FROM `gui-onlineplayer` WHERE  `UUID`='" + player.getUniqueId() + "';").equals("Offline")) {
                                            player.getInventory().setHeldItemSlot(slot - 1);
                                        }
                                    }
                                }
                            } else if (Select_config.UseItem_InventorySlot_FreeSlot){
                                boolean empty = false;
                                for (int i = 0; i < 9; i++) {
                                    if (player.getInventory().getItem(i) == null) {
                                        empty = true;
                                        break;
                                    }
                                }
                                if (empty) {
                                    GUI_Give_UseItem.onGiveADD(player);
                                }
                            }
                        }
                    }
                }.runTaskLater(Main.plugin, 20L * 1);
                if (Select_config.Storage.equals("MYSQL") &&Select_config.Bungee) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            MySQL.query("INSERT INTO `gui-onlineplayer` (`UUID`, `Name`, `Status`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                                    + "', '" + Select_config.thisServer + "') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = '" + Select_config.thisServer + "';");
                        }
                    }.runTaskLater(Main.plugin, 20L * 3);
                }
            }

        }
    }

    @EventHandler
    public void onDisconect(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        if (Select_config.Storage.equals("MYSQL") &&Select_config.Bungee) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    MySQL.query("INSERT INTO `gui-onlineplayer` (`UUID`, `Name`, `Status`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                            + "', '" + Select_config.thisServer + "') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = 'Offline';");
                }
            }.runTaskLater(Main.plugin, 20L * 2);
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
            if (!Select_config.UseItem_AllowToggle || Select_Database.selectItemStatus(player)) {
                if (Select_config.UseItem_GiveOnlyOnFirstJoin) {
                    if (!player.hasPlayedBefore()) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                GUI_Give_UseItem.onGive(player);
                            }
                        }.runTaskLater(Main.plugin, 20L * 1);
                    }
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            GUI_Give_UseItem.onGive(player);
                        }
                    }.runTaskLater(Main.plugin, 20L * 1);
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
                        if(p.isSneaking()){
                            Commands.info(p);
                            return;
                        }
                        if (!Select_config.UseItem_Permission || p.hasPermission("commandgui.useitem")) {
                            GUI_GUI.openGUI(p, Main.guiHashMap.get(Select_config.UseItem_OpenGUI));
                            if (Select_config.Sound_Enable && Select_config.Sound_OpenInventory_Enable) {
                                p.playSound(p.getLocation(), Select_config.Sound_OpenInventory, 3, 1);
                            }
                        } else {
                            p.sendMessage(Select_msg.NoPermissionForUseItem.replace("[perm]", "commandgui.useitem")
                                    .replace("[gui]", Select_config.UseItem_OpenGUI));
                        }
                    }
                }
            } else {
                if (e.getItem() != null && p.getItemInHand().getType() == Material.valueOf(Select_config.UseItem_Material)) {
                    if (e.getItem().getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                        e.setCancelled(true);
                        if(p.isSneaking()){
                            Commands.info(p);
                            return;
                        }
                        if (!Select_config.UseItem_Permission || p.hasPermission("commandgui.useitem")) {
                            GUI_GUI.openGUI(p, Main.guiHashMap.get(Select_config.UseItem_OpenGUI));
                            if (Select_config.Sound_Enable && Select_config.Sound_OpenInventory_Enable) {
                                p.playSound(p.getLocation(), Select_config.Sound_OpenInventory, 3, 1);
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