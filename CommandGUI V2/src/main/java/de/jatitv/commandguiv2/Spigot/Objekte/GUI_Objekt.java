package de.jatitv.commandguiv2.Spigot.Objekte;

import java.util.ArrayList;

public class GUI_Objekt {
    public Boolean GUI_Enable;
    public Integer GUI_Lines;
    public String GUI_Name;
    public Boolean GUI_FillItem_Enable;
    public String GUI_FillItem_Item;


    public String Command_Command;
    public Boolean Command_Alias_Enable;
    public Boolean Command_Permission_Enable;
    public ArrayList<GUI_Slot> GUI_Slots;

    public GUI_Objekt(Boolean GUI_Enable, Integer GUI_Lines, String GUI_Name, Boolean GUI_FillItem_Enable, String GUI_FillItem_Item,
                      String Command_Command, Boolean Command_Alias_Enable, Boolean Command_Permission_Enable, ArrayList<GUI_Slot> GUI_Slots){
        this.GUI_Enable = GUI_Enable;
        this.GUI_Lines = GUI_Lines;
        this.GUI_Name = GUI_Name;
        this.GUI_FillItem_Enable = GUI_FillItem_Enable;
        this.GUI_FillItem_Item = GUI_FillItem_Item;
        this.Command_Command = Command_Command;
        this.Command_Alias_Enable = Command_Alias_Enable;
        this.Command_Permission_Enable = Command_Permission_Enable;
        this.GUI_Slots = GUI_Slots;
    }
}
