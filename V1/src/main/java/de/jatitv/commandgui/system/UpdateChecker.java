// This claas was created by JaTiTV

// -----------------------------
//    _____ _____ _    _ _____
//   / ____/ ____| |  | |_   _|
//  | |   | |  __| |  | | | |
//  | |   | | |_ | |  | | | |
//  | |___| |__| | |__| |_| |_
//   \_____\_____|\____/|_____|
// -----------------------------

package de.jatitv.commandgui.system;

import de.jatitv.commandgui.defaultValue.DefaultValue;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateChecker {

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
                this.plugin.getLogger().severe(DefaultValue.PrefixHC + "§4 Cannot look for updates: " + var10.getMessage());
            }
        });
    }
}
