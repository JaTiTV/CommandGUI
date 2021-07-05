// This claas was created by JaTiTV


package de.jatitv.commandguiv2.Spigot.system;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_msg;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Vault {

    public static boolean buy(Player p, Double price) {
        if (Main.eco == null) {
            if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
                send.console(Main.Prefix + " §4\n" + Main.Prefix + " §4Vault could not be found! §9Please download it here: " +
                        "§6https://www.spigotmc.org/resources/vault.34315/§4\n" + Main.Prefix);
            }
            p.sendMessage(Main.Prefix + "\n" + Select_msg.VaultNotSetUp + "\n" + Main.Prefix);
        } else {
            if (Main.eco.getBalance(p) < price) {
                return false;
            } else {
                Main.eco.withdrawPlayer(p, price);
                return true;
            }
        }
        return false;
    }

    public static void loadVault() throws InterruptedException {
        Long long_ = Long.valueOf(System.currentTimeMillis());
        if(Main.plugin.getServer().getPluginManager().getPlugin("Vault") != null){
            RegisteredServiceProvider<Economy> rsp = Main.plugin.getServer().getServicesManager().getRegistration(Economy.class);
            if(rsp != null){
                Main.eco = rsp.getProvider();
                if(Main.eco != null){
                    send.console(Main.Prefix + " §2Vault / Economy successfully connected!" + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
                }else{
                    send.console(Main.Prefix + " §4Economy could not be connected / found!" + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
                }
            }else{
                send.console(Main.Prefix + " §4Economy could not be connected / found!" + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
            }
        }else{
            send.console(Main.Prefix + " §4Vault / Economy could not be connected / found!" + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
        }
    }
    public static void vaultDisable(){
        send.console(Main.Prefix + " §4Vault / Economy successfully deactivated.");
    }
}