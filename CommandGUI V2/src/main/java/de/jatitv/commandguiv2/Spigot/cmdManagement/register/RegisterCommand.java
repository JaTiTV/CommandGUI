package de.jatitv.commandguiv2.Spigot.cmdManagement.register;


import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.Objekte.Objekt;
import de.jatitv.commandguiv2.Spigot.gui.OpenGUI;
import de.jatitv.commandguiv2.Spigot.system.config.config.SelectConfig;
import de.jatitv.commandguiv2.Spigot.system.config.languages.SelectMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegisterCommand extends Command {
    private String alias;

    public RegisterCommand(String alias) {
        super(alias);
        this.alias = alias;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Objekt gui = Main.guiHashMap.get(alias);
            if (gui.GUI_Enable || player.hasPermission("commandgui.bypass")) {
                if (!gui.Command_Permission_Enable || player.hasPermission("commandgui.command." + alias) || player.hasPermission("commandgui.bypass")) {
                    OpenGUI.openGUI(player, gui, alias);
                    if (SelectConfig.Sound_Enable && SelectConfig.Sound_OpenInventory_Enable) {
                        player.playSound(player.getLocation(), SelectConfig.Sound_OpenInventory, 3, 1);
                    }
                } else player.sendMessage(SelectMessages.NoPermissionForCommand.replace("[cmd]", "/commandgui " + alias)
                        .replace("[perm]", "commandgui.command." + alias));
            } else player.sendMessage(SelectMessages.GUIIsDisabled.replace("[gui]", gui.GUI_Name));
        } else sender.sendMessage("§8[§6Command§9GUI§8] §cThis command is only for players!");
        return true;
    }
}

