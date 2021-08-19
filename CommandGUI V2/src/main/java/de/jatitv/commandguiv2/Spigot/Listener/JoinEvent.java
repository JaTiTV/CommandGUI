// This claas was created by JaTiTV

package de.jatitv.commandguiv2.Spigot.Listener;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.UpdateChecker;
import de.jatitv.commandguiv2.Spigot.system.database.Select_Database;
import de.jatitv.commandguiv2.Spigot.system.config.config.SelectConfig;
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
        if (player.hasPermission("commandgui.updatemsg") || player.isOp()) {
            if (!foundVersion.equals(Main.update_version)) {
                if (!SelectConfig.DisableUpdateChecker) {
                    if (SelectConfig.UpdateCheckOnJoin) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                UpdateChecker.sendUpdateMsg(Main.Prefix, foundVersion, Main.update_version, player);
                            }
                        }.runTaskLater(Main.plugin, 200L);
                    }
                }
            }
        }
    }
}