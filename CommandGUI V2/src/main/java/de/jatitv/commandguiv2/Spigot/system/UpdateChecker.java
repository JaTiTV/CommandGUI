// This claas was created by JaTiTV

// -----------------------------
//    _____ _____ _    _ _____
//   / ____/ ____| |  | |_   _|
//  | |   | |  __| |  | | | |
//  | |   | | |_ | |  | | | |
//  | |___| |__| | |__| |_| |_
//   \_____\_____|\____/|_____|
// -----------------------------

package de.jatitv.commandguiv2.Spigot.system;

import de.jatitv.commandguiv2.Spigot.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateChecker {

    public static void sendUpdateMsg(String Prefix, String foundVersion, String update_version) {
        send.console("§4=========== " + Prefix + " §4===========");
        send.console("§6A new version was found!");
        send.console("§6Your version: §c" + foundVersion + " §7- §6Current version: §a" + update_version);
        send.console("§6You can download it here: §e" + Main.Spigot);
        send.console("§6You can find more information on Discord: §e" + Main.Discord);
        send.console("§4=========== " + Prefix + " §4===========");
    }

    public static void sendUpdateMsg(String Prefix, String foundVersion, String update_version, Player player) {
        TextComponent comp = new TextBuilder(Prefix + " §6A new version was found!")
                .addHover("§6You can download it here: §e" + Main.Spigot).addClickEvent(ClickEvent.Action.OPEN_URL, Main.Spigot).build();
        player.spigot().sendMessage(comp);
        TextComponent comp1 = new TextBuilder(Prefix + " §c" + foundVersion + " §7-> §a" + update_version)
                .addHover("§6You can download it here: §e" + Main.Spigot).addClickEvent(ClickEvent.Action.OPEN_URL, Main.Spigot).build();
        player.spigot().sendMessage(comp1);
        TextComponent comp2 = new TextBuilder(Prefix + " §6You can find more information on Discord.")
                .addHover("§e" + Main.Discord).addClickEvent(ClickEvent.Action.OPEN_URL, Main.Discord).build();
        player.spigot().sendMessage(comp2);
    }

    public static void onUpdateCheckTimer() {
        int taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
            public void run() {
                (new UpdateChecker(Main.plugin, Main.SpigotID)).getVersion((update_version) -> {
                    String foundVersion = Main.plugin.getDescription().getVersion();
                    Main.update_version = update_version;
                    if (!foundVersion.equalsIgnoreCase(update_version)) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                sendUpdateMsg(Main.Prefix, foundVersion, update_version);
                            }
                        }.runTaskLater(Main.plugin, 600L);
                    }
                });
            }
        }, 0L, 20 * 60 * 60L);
    }

    public static void onUpdateCheck() {
        (new UpdateChecker(Main.plugin, Main.SpigotID)).getVersion((update_version) -> {
            String foundVersion = Main.plugin.getDescription().getVersion();
            Main.update_version = update_version;
            if (foundVersion.equalsIgnoreCase(update_version)) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        send.console(Main.Prefix + " §2No update found.");
                    }
                }.runTaskLater(Main.plugin, 120L);
            }
        });
    }

    private JavaPlugin plugin;
    private int resourceId;

    public UpdateChecker(JavaPlugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getVersion(Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try {
                InputStream inputStream = (new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId)).openStream();
                try {
                    Scanner scanner = new Scanner(inputStream);

                    try {
                        if (scanner.hasNext()) {
                            consumer.accept(scanner.next());
                        }
                    } catch (Throwable var8) {
                        try {
                            scanner.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                        throw var8;
                    }
                    scanner.close();
                } catch (Throwable var9) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable var6) {
                            var9.addSuppressed(var6);
                        }
                    }
                    throw var9;
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException var10) {
                this.plugin.getLogger().severe(Main.Prefix + "§4 Cannot look for updates: " + var10.getMessage());
            }
        });
    }
}
