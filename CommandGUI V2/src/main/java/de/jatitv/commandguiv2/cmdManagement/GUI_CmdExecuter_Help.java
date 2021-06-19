package de.jatitv.commandguiv2.cmdManagement;

import de.jatitv.commandguiv2.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GUI_CmdExecuter_Help implements CommandExecutor {
    String Prefix;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Prefix = Main.Prefix;
        if (args.length == 0) {
            Help.sendHelp(sender, Prefix);
        } else Help.sendHelp(sender, Prefix);
        return false;

    }

}

