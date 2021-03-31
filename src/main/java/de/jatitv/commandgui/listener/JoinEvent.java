// This claas was created by JaTiTV

// ___________________________________________________________________________________
//  __          __             _           ____               _____ _
//  \ \        / /            | |         |  _ \             / ____| |
//   \ \  /\  / /__  _ __   __| | ___ _ __| |_) | __ _  __ _| (___ | |__   ___  _ __
//    \ \/  \/ / _ \| '_ \ / _` |/ _ \ '__|  _ < / _` |/ _` |\___ \| '_ \ / _ \| '_ \
//     \  /\  / (_) | | | | (_| |  __/ |  | |_) | (_| | (_| |____) | | | | (_) | |_) |
//      \/  \/ \___/|_| |_|\__,_|\___|_|  |____/ \__,_|\__, |_____/|_| |_|\___/| .__/
//                                                      __/ |                  | |
//                                                     |___/                   |_|
// ___________________________________________________________________________________

package de.jatitv.commandgui.listener;

import de.jatitv.commandgui.defaultValue.DefaultValue;
import de.jatitv.commandgui.system.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinEvent implements Listener {



    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String foundVersion = Main.getPlugin().getDescription().getVersion();
        if (player.hasPermission("commandgui.admin") || player.isOp()) {
            if (!foundVersion.equals(Main.update_version)) {
                String updateFound = (DefaultValue.PrefixHC + "§6A new version of §8[§4Command§9GUI§8]§6 was found!");
                String yourVersion = (DefaultValue.PrefixHC + "§6Your version §c" + foundVersion);
                String currentVersion = (DefaultValue.PrefixHC + "§6Current version: §a" + Main.update_version);
                String downloadVersion = (DefaultValue.PrefixHC + "§6You can download it here: §e" + Main.Spigot);
                String discord = (DefaultValue.PrefixHC + "§6You can find more information about §8[§4Command§9GUI§8]§6 on Discord: §e" + Main.DiscordLink);
                String Snapshot = (DefaultValue.PrefixHC + "§4Please note!" +
                        "\n" + DefaultValue.PrefixHC + "§cYou are using the §6" + foundVersion + " §cof §4Command§9GUI!" +
                        "\n" + DefaultValue.PrefixHC + "§cThere may be errors and it is possible that not all functions work as they should!" +
                        "\n" + DefaultValue.PrefixHC + "§2If there are any bugs, please report them to me via Discord so I can fix them." +
                        "\n" + DefaultValue.PrefixHC + "§7" + Main.DiscordLink);
                if (Main.Snapshot) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("\n \n \n \n \n \n" + Snapshot);
                        }
                    }.runTaskLater(Main.getPlugin(), 100L);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("\n ");
                            player.sendMessage(updateFound);
                            player.sendMessage(yourVersion);
                            player.sendMessage(currentVersion);
                            player.sendMessage(downloadVersion);
                            player.sendMessage(discord);
                        }
                    }.runTaskLater(Main.getPlugin(), 200L);
                }
                if (DefaultValue.UpdateCheckOnJoin && !Main.Snapshot) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("\n ");
                            player.sendMessage(updateFound);
                            player.sendMessage(yourVersion);
                            player.sendMessage(currentVersion);
                            player.sendMessage(downloadVersion);
                            player.sendMessage(discord);
                        }
                    }.runTaskLater(Main.getPlugin(), 200L);
                }
            }
        }
    }
}