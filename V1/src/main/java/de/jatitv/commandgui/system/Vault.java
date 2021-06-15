// This claas was created by JaTiTV


package de.jatitv.commandgui.system;

import de.jatitv.commandgui.defaultValue.DefaultValue;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Vault {

    public static void loadVault() throws InterruptedException {
        if(Main.a.getServer().getPluginManager().getPlugin("Vault") != null){
            RegisteredServiceProvider<Economy> rsp = Main.a.getServer().getServicesManager().getRegistration(Economy.class);
            if(rsp != null){
                Main.eco = rsp.getProvider();
                if(Main.eco != null){
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Vault / Economy successfully connected!");
                }else{
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Economy could not be connected / found!");
                }
            }else{
                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Economy could not be connected / found!");
            }
        }else{
            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Vault / Economy could not be connected / found!");
        }
    }
    public static void vaultDisable(){
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Vault / Economy successfully deactivated.");
    }
}