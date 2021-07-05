package de.jatitv.commandguiv2.Spigot.Objekte;

import java.util.List;

public class GUI_Slot {

    public Integer Slot;
    public Boolean Enable;
    public Boolean PlayerHead_Enable;
    public Boolean Base64Value_Enable;
    public String Base64Value;
    public Boolean PlayerWhoHasOpenedTheGUI;
    public String PlayerName;
    public String Item;
    public String Name;
    public List Lore;
    public Boolean CustomSound_Enable;
    public String CustomSound_Sound;
    public Boolean Cost_Enable;
    public Double Price;
    public Boolean Command_Enable;
    public Boolean Command_BungeeCommand;
    public Boolean CommandAsConsole;
    public Boolean ServerChange;
    public String ServerChangeServer;
    public List<String> Command;
    public Boolean OpenGUI_Enable;
    public String OpenGUI;
    public Boolean Message_Enable;
    public List<String> Message;
    public Boolean Perm;

    public GUI_Slot(Integer Slot,
                    Boolean Enable,
                    Boolean PlayerHead_Enable,
                    Boolean Base64Value_Enable,
                    String Base64Value,
                    Boolean PlayerWhoHasOpenedTheGUI,
                    String PlayerName,
                    String Item,
                    String Name,
                    List Lore,
                    Boolean CustomSound_Enable,
                    String CustomSound_Sound,
                    Boolean Cost_Enable,
                    Double Price,
                    Boolean Command_Enable,
                    Boolean Command_BungeeCommand,
                    Boolean CommandAsConsole,
                    List<String> Command,
                    Boolean ServerChange,
                    String ServerChangeServer,
                    Boolean OpenGUI_Enable,
                    String OpenGUI,
                    Boolean Message_Enable,
                    List<String> Message,
                    Boolean Perm) {
        this.Slot = Slot;
        this.Enable = Enable;
        this.PlayerHead_Enable = PlayerHead_Enable;
        this.Base64Value_Enable = Base64Value_Enable;
        this.Base64Value = Base64Value;
        this.PlayerWhoHasOpenedTheGUI = PlayerWhoHasOpenedTheGUI;
        this.PlayerName = PlayerName;
        this.Item = Item;
        this.Name = Name;
        this.Lore = Lore;
        this.CustomSound_Enable = CustomSound_Enable;
        this.CustomSound_Sound = CustomSound_Sound;
        this.Cost_Enable = Cost_Enable;
        this.Price = Price;
        this.Command_Enable = Command_Enable;
        this.Command_BungeeCommand = Command_BungeeCommand;
        this.CommandAsConsole = CommandAsConsole;
        this.Command = Command;
        this.ServerChange = ServerChange;
        this.ServerChangeServer = ServerChangeServer;
        this.OpenGUI_Enable = OpenGUI_Enable;
        this.OpenGUI = OpenGUI;
        this.Message_Enable = Message_Enable;
        this.Message = Message;
        this.Perm = Perm;
    }
}
