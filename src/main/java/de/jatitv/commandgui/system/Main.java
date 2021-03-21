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

import de.jatitv.commandgui.commands.GUI_1_Command;
import de.jatitv.commandgui.commands.cmdManagement.TabComplete;
import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.commands.cmdManagement.CmdExecuter;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_1;
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

    public static Boolean Bstats = false;

    public static Boolean Snapshot = true;

    public static Boolean UpdateMSG = false;
    public static String UpdateInfo = DefultValue.PrefixHC + "§4You have just updated WonderBagShop! §6Here is some important information:" +
            "§4\n" + DefultValue.PrefixHC +
            "§4\n" + DefultValue.PrefixHC + "§4In the version 2.3.0, a critical bug was fixed that was responsible for the config not being created correctly." +
            "§4\n" + DefultValue.PrefixHC + "§4Therefore, you must urgently recreate it!" +
            "§4\n" + DefultValue.PrefixHC + "§4Otherwise I can not guarantee that the plugin will work properly." +
            "§4\n" + DefultValue.PrefixHC + "§4If you encounter any errors please contact me via Discord: §6https://discord.com/invite/vRyXFFterJ" +
            "§4\n" + DefultValue.PrefixHC +
            "§4\n" + DefultValue.PrefixHC + "§2Sincerely JaTiTV";

    public static String Autor = "JaTiTV";
    public static String Spigot = "...";
    public static String DiscordLink = "https://discord.gg/vRyXFFterJ";
    public static String DiscordMSG = "You want to discuss and decide about current bugs, planned updates, new features?\n" +
            "Then come to our Discord. " + DiscordLink;
    public static String DiscordLoad = "https://discord.gg/vRyXFFterJ";

    // ---------------------------------------------

    public static Main plugin;
    public static Plugin a;
    public static Economy eco = null;
    public static String update_version = null;
    public static Boolean PaPi= false;
    public static boolean minecraft1_8;

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



            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                PaPi = true;
            }


        try {
            Load.LoadSend(getDescription().getVersion());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getCommand("commandgui").setExecutor(new CmdExecuter());
        getCommand("cgui").setExecutor(new CmdExecuter());
        //getCommand(DefultValue_GUI_1.Command).setExecutor(new GUI_1_Command());

        Bukkit.getServer().getPluginManager().registerEvents(new GUI_1(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_2(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_3(), this);
        if (!minecraft1_8){
            getCommand("commandgui").setTabCompleter(new TabComplete());
            getCommand("cgui").setTabCompleter(new TabComplete());
        }

        if (Main.Bstats) {
            int pluginId = 0000; // <-- Replace with the id of your plugin!
            Metrics metrics = new Metrics(this, pluginId);
            metrics.addCustomChart(new Metrics.SimplePie("updatecheckonjoin", () -> String.valueOf(DefultValue.UpdateCheckOnJoin)));
        } else {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4\n" + DefultValue.PrefixHC + "§4Bstats is disabled!");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                }
            }.runTaskLater(Main.getPlugin(), 200L);
        }


        // Optional: Add custom charts
        // metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));

        int taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {


            public void run() {

                (new UpdateChecker((JavaPlugin) Main.thisp(), 0000)).getVersion((version) -> {
                    String foundVersion = Main.thisp().getDescription().getVersion();
                    if (!foundVersion.equalsIgnoreCase(version)) {
                        update_version = version;
                        String updateFound = (DefultValue.PrefixHC + "§6A new version of §8[§2Wonder§6Bag§9Shop§8]§6 was found!");
                        String yourVersion = (DefultValue.PrefixHC + "§6Your version §c" + foundVersion);
                        String currentVersion = (DefultValue.PrefixHC + "§6Current version: §a" + version);
                        String downloadVersion = (DefultValue.PrefixHC + "§6You can download it here: §ehttps://www.spigotmc.org/resources/wonderbagshop.89234/");
                        String discord = (DefultValue.PrefixHC + "§6You can find more information about §8[§2Wonder§6Bag§9Shop§8]§6 on Discord: §ehttps://discord.com/invite/vRyXFFterJ");
                        String SnapshotConsole = (DefultValue.PrefixHC + "§6" +
                                "\n" + DefultValue.PrefixHC + "§4Please note!§6" +
                                "\n" + DefultValue.PrefixHC + "§4You are using the §6" + foundVersion + " §4of WonderBagShop!§6" +
                                "\n" + DefultValue.PrefixHC + "§4There may be errors and it is possible that not all functions work as they should!§6" +
                                "\n" + DefultValue.PrefixHC + "§2If there are any bugs, please report them to me via Discord so I can fix them!§6" +
                                "\n" + DefultValue.PrefixHC + "§7https://discord.gg/vRyXFFterJ");

                        if (Main.Snapshot) {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                                    Bukkit.getConsoleSender().sendMessage(SnapshotConsole);
                                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                                }
                            }.runTaskLater(Main.getPlugin(), 300L);
                        }

                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                                Bukkit.getConsoleSender().sendMessage(updateFound);
                                Bukkit.getConsoleSender().sendMessage(yourVersion);
                                Bukkit.getConsoleSender().sendMessage(currentVersion);
                                Bukkit.getConsoleSender().sendMessage(downloadVersion);
                                Bukkit.getConsoleSender().sendMessage(discord);
                                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + " ");
                            }
                        }.runTaskLater(Main.getPlugin(), 600L);
                    } else {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2No update found");
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
    }
}
