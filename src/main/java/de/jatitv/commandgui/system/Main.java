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

import de.jatitv.commandgui.commands.cmdManagement.TabComplete;
import de.jatitv.commandgui.defaultValue.DefaultValue;
import de.jatitv.commandgui.commands.cmdManagement.CmdExecuter;
import de.jatitv.commandgui.listener.GUI_1;
import de.jatitv.commandgui.listener.GUI_2;
import de.jatitv.commandgui.listener.GUI_3;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    // Debug Settings

    public static Boolean Bstats = true;

    public static Boolean Snapshot = false;

    public static Boolean UpdateMSG = true;
    public static String UpdateInfo = DefaultValue.PrefixHC + "";

    public static String Autor = "JaTiTV";
    public static String Spigot = "https://www.spigotmc.org/resources/commandgui-cgui.90671/";
    public static String DiscordLink = "https://discord.gg/vRyXFFterJ";
    public static String DiscordMSG = "You want to discuss and decide about current bugs, planned updates, new features?\n" +
            "Then come to our Discord ➙ " + DiscordLink;
    public static String DiscordLoad = "https://discord.gg/vRyXFFterJ";

    // ---------------------------------------------

    public static Main plugin;
    public static Plugin a;
    public static Economy eco = null;
    public static String update_version = null;
    public static Boolean PaPi = false;
    public static boolean minecraft1_8;
    public static boolean minecraft1_9;
    public static boolean minecraft1_10;
    public static boolean minecraft1_11;
    public static boolean minecraft1_12;
    public static boolean minecraft1_13;
    public static boolean minecraft1_14;
    public static boolean minecraft1_15;
    public static boolean minecraft1_16;

    public static Main getPlugin() {
        return plugin;
    }
    public static Plugin thisp() {
        return plugin;
    }

    @Override
    public void onEnable() {

        // Plugin startup logic
        Logger logger = this.getLogger();
        plugin = this;
        a = this;
        minecraft1_8 = Bukkit.getServer().getClass().getPackage().getName().contains("1_8");
        minecraft1_9 = Bukkit.getServer().getClass().getPackage().getName().contains("1_9");
        minecraft1_10 = Bukkit.getServer().getClass().getPackage().getName().contains("1_10");
        minecraft1_11 = Bukkit.getServer().getClass().getPackage().getName().contains("1_11");
        minecraft1_12 = Bukkit.getServer().getClass().getPackage().getName().contains("1_12");
        minecraft1_13 = Bukkit.getServer().getClass().getPackage().getName().contains("1_13");
        minecraft1_14 = Bukkit.getServer().getClass().getPackage().getName().contains("1_14");
        minecraft1_15 = Bukkit.getServer().getClass().getPackage().getName().contains("1_15");
        minecraft1_16 = Bukkit.getServer().getClass().getPackage().getName().contains("1_16");

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            PaPi = true;
        }

        try {
            Load.LoadSend(getDescription().getVersion());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getCommand("commandgui").setExecutor(new CmdExecuter());
        getCommand("commandgui").setTabCompleter(new TabComplete());
        Permissions.addPermission();
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_1(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_2(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_3(), this);

        if (Main.Bstats) {
            int pluginId = 10840; // <-- Replace with the id of your plugin!
            Metrics metrics = new Metrics(this, pluginId);
            metrics.addCustomChart(new Metrics.SimplePie("updatecheckonjoin", () -> String.valueOf(DefaultValue.UpdateCheckOnJoin)));
        } else {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4\n" + DefaultValue.PrefixHC + "§4Bstats is disabled!");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                }
            }.runTaskLater(Main.getPlugin(), 200L);
        }

        // Optional: Add custom charts
        // metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));

        int taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                (new UpdateChecker((JavaPlugin) Main.thisp(), 90671)).getVersion((version) -> {
                    String foundVersion = Main.thisp().getDescription().getVersion();
                    update_version = version;
                    if (!foundVersion.equalsIgnoreCase(version)) {
                        String updateFound = (DefaultValue.PrefixHC + "§6A new version of §8[§4Command§9GUI§8]§6 was found!");
                        String yourVersion = (DefaultValue.PrefixHC + "§6Your version §c" + foundVersion);
                        String currentVersion = (DefaultValue.PrefixHC + "§6Current version: §a" + version);
                        String downloadVersion = (DefaultValue.PrefixHC + "§6You can download it here: §e" + Spigot);
                        String discord = (DefaultValue.PrefixHC + "§6You can find more information about §8[§4Command§9GUI§8]§6 on Discord: §e" + DiscordLink);
                        String SnapshotConsole = (DefaultValue.PrefixHC + "§6" +
                                "\n" + DefaultValue.PrefixHC + "§4Please note!§6" +
                                "\n" + DefaultValue.PrefixHC + "§4You are using the §6" + foundVersion + " §4of §4Command§9GUI!§6" +
                                "\n" + DefaultValue.PrefixHC + "§4There may be errors and it is possible that not all functions work as they should!§6" +
                                "\n" + DefaultValue.PrefixHC + "§2If there are any bugs, please report them to me via Discord so I can fix them!§6" +
                                "\n" + DefaultValue.PrefixHC + "§7" + DiscordLink);

                        if (Main.Snapshot) {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                                    Bukkit.getConsoleSender().sendMessage(SnapshotConsole);
                                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                                }
                            }.runTaskLater(Main.getPlugin(), 300L);
                        }

                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                                Bukkit.getConsoleSender().sendMessage(updateFound);
                                Bukkit.getConsoleSender().sendMessage(yourVersion);
                                Bukkit.getConsoleSender().sendMessage(currentVersion);
                                Bukkit.getConsoleSender().sendMessage(downloadVersion);
                                Bukkit.getConsoleSender().sendMessage(discord);
                                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                            }
                        }.runTaskLater(Main.getPlugin(), 600L);
                    } else {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2No update found");
                            }
                        }.runTaskLater(Main.getPlugin(), 120L);
                    }
                });

            }
        }, 0L, 20 * 60 * 60L);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Disable.disableSend(getDescription().getVersion());
    }
}
