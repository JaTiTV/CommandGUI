// This claas was created by JaTiTV


package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.select.Select_msg;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Vault {

    public static boolean buy(Player p, Double preis) {
        if (Main.eco == null) {
            if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
                Bukkit.getConsoleSender().sendMessage(Main.Prefix + " §4\n" + Main.Prefix + " §4Vault could not be found! §9Please download it here: " +
                        "§6https://www.spigotmc.org/resources/vault.34315/§4\n" + Main.Prefix);
            }
            p.sendMessage(Main.Prefix + "\n" + Select_msg.VaultNotSetUp + "\n" + Main.Prefix);
        } else {
            if (Main.eco.getBalance(p) < preis) {
                return false;
            } else {
                Main.eco.withdrawPlayer(p, preis);
                return true;
            }
        }
        return false;
    }

    public static void loadVault() throws InterruptedException {
        if(Main.a.getServer().getPluginManager().getPlugin("Vault") != null){
            RegisteredServiceProvider<Economy> rsp = Main.a.getServer().getServicesManager().getRegistration(Economy.class);
            if(rsp != null){
                Main.eco = rsp.getProvider();
                if(Main.eco != null){
                    Bukkit.getConsoleSender().sendMessage(Main.Prefix + " §2Vault / Economy successfully connected!");
                }else{
                    Bukkit.getConsoleSender().sendMessage(Main.Prefix + " §4Economy could not be connected / found!");
                }
            }else{
                Bukkit.getConsoleSender().sendMessage(Main.Prefix + " §4Economy could not be connected / found!");
            }
        }else{
            Bukkit.getConsoleSender().sendMessage(Main.Prefix + " §4Vault / Economy could not be connected / found!");
        }
    }
    public static void vaultDisable(){
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + " §4Vault / Economy successfully deactivated.");
    }
}