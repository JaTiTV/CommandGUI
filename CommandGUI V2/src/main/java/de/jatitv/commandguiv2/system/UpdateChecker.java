// This claas was created by JaTiTV

// -----------------------------
//    _____ _____ _    _ _____
//   / ____/ ____| |  | |_   _|
//  | |   | |  __| |  | | | |
//  | |   | | |_ | |  | | | |
//  | |___| |__| | |__| |_| |_
//   \_____\_____|\____/|_____|
// -----------------------------

package de.jatitv.commandguiv2.system;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateChecker {

    public static void onCheck(String Prefix, String Discord, String Spigot ,Integer SpigotID){
        int taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
            public void run() {
                (new UpdateChecker((JavaPlugin) Main.thisp(), SpigotID)).getVersion((version) -> {
                    String foundVersion = Main.thisp().getDescription().getVersion();
                    Main.update_version = version;
                    if (!foundVersion.equalsIgnoreCase(version)) {
                        String updateFound = (Prefix + " §6A new version of §8[§4Command§9GUI§8]§6 was found!");
                        String yourVersion = (Prefix + " §6Your version §c" + foundVersion);
                        String currentVersion = (Prefix + " §6Current version: §a" + version);
                        String downloadVersion = (Prefix + " §6You can download it here: §e" + Spigot);
                        String discord = (Prefix + " §6You can find more information about §8[§4Command§9GUI§8]§6 on Discord: §e" + Discord);


                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.getConsoleSender().sendMessage(Prefix + " ");
                                Bukkit.getConsoleSender().sendMessage(updateFound);
                                Bukkit.getConsoleSender().sendMessage(yourVersion);
                                Bukkit.getConsoleSender().sendMessage(currentVersion);
                                Bukkit.getConsoleSender().sendMessage(downloadVersion);
                                Bukkit.getConsoleSender().sendMessage(discord);
                                Bukkit.getConsoleSender().sendMessage(Prefix + " ");
                            }
                        }.runTaskLater(Main.getPlugin(), 600L);
                    } else {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.getConsoleSender().sendMessage(Prefix + " §2No update found");
                            }
                        }.runTaskLater(Main.getPlugin(), 120L);
                    }
                });

            }
        }, 0L, 20 * 60 * 60L);
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
