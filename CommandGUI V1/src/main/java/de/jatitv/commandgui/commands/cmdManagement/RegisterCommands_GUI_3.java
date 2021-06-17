package de.jatitv.commandgui.commands.cmdManagement;

import de.jatitv.commandgui.commands.GUI_3;
import de.jatitv.commandgui.defaultValue.DefaultValue;
import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_3;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegisterCommands_GUI_3 extends Command {
    private String alias;

    public RegisterCommands_GUI_3(String alias) {
        super(alias);
        this.alias = alias;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!DefaultValue_GUI_3.Command_Permission_Enable || player.hasPermission("commandgui.command") || player.hasPermission("commandgui.admin") || player.isOp()) {
                if (DefaultValue_GUI_3.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                    GUI_3.openCGUI(player);
                } else player.sendMessage(DefaultValue.GUIisDisable.replace("[gui]", DefaultValue_GUI_3.GUIName));
            } else player.sendMessage(DefaultValue.NoPermission.replace("[cmd]", "/commandgui").replace("[perm]", "commandgui.command"));
        } else sender.sendMessage("§8[§6Command§9GUI§8] §cThis command is only for players!");
        return true;
    }
}

