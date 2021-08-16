// This claas was created by JaTiTV

package de.jatitv.commandguiv2.Spigot.Listener;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.TextBuilder;
import de.jatitv.commandguiv2.Spigot.system.database.Select_Database;
import de.jatitv.commandguiv2.Spigot.system.config.config.SelectConfig;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        String foundVersion = Main.plugin.getDescription().getVersion();
        Select_Database.nameCheck(player);
        if (player.hasPermission("commandgui.admin") || player.isOp()) {
            if (!foundVersion.equals(Main.update_version)) {
                if (!SelectConfig.DisableUpdateChecker) {
                    if (SelectConfig.UpdateCheckOnJoin) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                player.sendMessage("§4============ §8[§4Command§9GUI§8] §4============");
                                player.sendMessage("§6A new version was found!");
                                TextComponent comp = new TextBuilder("§6Your version: §c" + foundVersion + " §7- §6Current version: §a" + Main.update_version)
                                        .addHover("§6You can download it here: §e" + Main.Spigot).addClickEvent(ClickEvent.Action.OPEN_URL, Main.Spigot).build();
                                player.spigot().sendMessage(comp);
                                TextComponent comp2 = new TextBuilder("§6You can find more information on Discord.")
                                        .addHover("§e" + Main.Discord).addClickEvent(ClickEvent.Action.OPEN_URL, Main.Discord).build();
                                player.spigot().sendMessage(comp2);
                                player.sendMessage("§4============ §8[§4Command§9GUI§8] §4============");
                            }
                        }.runTaskLater(Main.plugin, 200L);
                    }
                }
            }
        }
    }
}