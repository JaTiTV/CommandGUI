// This claas was created by JaTiTV

// -----------------------------
//    _____ _____ _    _ _____
//   / ____/ ____| |  | |_   _|
//  | |   | |  __| |  | | | |
//  | |   | | |_ | |  | | | |
//  | |___| |__| | |__| |_| |_
//   \_____\_____|\____/|_____|
// -----------------------------

package de.jatitv.commandguiv2.Bungee;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class BUpdateChecker {

    public static void sendUpdateMsg(String Prefix, String foundVersion, String update_version) {
        Bsend.console("§4=========== " + Prefix + " §4===========");
        Bsend.console("§6A new version was found!");
        Bsend.console("§6Your version: §c" + foundVersion + " §7- §6Current version: §a" + update_version);
        Bsend.console("§6You can download it here: §e" + BMain.Spigot);
        Bsend.console("§6You can find more information on Discord: §e" + BMain.Discord);
        Bsend.console("§4=========== " + Prefix + " §4===========");
    }


    public static void onUpdateCheckTimer() {
        ProxyServer.getInstance().getScheduler().schedule(BMain.plugin, new Runnable() {
            public void run() {
                (new BUpdateChecker(BMain.plugin, BMain.SpigotID)).getVersion((update_version) -> {
                    String foundVersion = BMain.plugin.getDescription().getVersion();
                    BMain.update_version = update_version;
                    if (!foundVersion.replace("_Bungee", "").equalsIgnoreCase(update_version)) {
                        sendUpdateMsg(BMain.Prefix, foundVersion, update_version);
                    }
                });
            }
        }, 0, 20 * 60 * 60L, TimeUnit.SECONDS);
    }

    public static void onUpdateCheck() {
        (new BUpdateChecker(BMain.plugin, BMain.SpigotID)).getVersion((update_version) -> {
            String foundVersion = BMain.plugin.getDescription().getVersion();
            BMain.update_version = update_version;
            if (foundVersion.replace("_Bungee", "").equalsIgnoreCase(update_version)) {
                Bsend.console(BMain.Prefix + " §2No update found.");
            }
        });
    }

    private Plugin plugin;
    private int resourceId;

    public BUpdateChecker(Plugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getVersion(Consumer<String> consumer) {
        ProxyServer.getInstance().getScheduler().runAsync(this.plugin, () -> {
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
                this.plugin.getLogger().severe(BMain.Prefix + "§4 Cannot look for updates: " + var10.getMessage());
            }
        });
    }
}
