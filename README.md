<p align="center">
    <img src="https://i.imgur.com/QHOQIMm.png" width="400">
</p>

---

<img src="https://i.imgur.com/mmnBjBG.pngg" width="600">

CommandGUI | FunctionsGUI is a handy plugin that allows you to create as many and different GUIs (user interfaces) as you need for your server.

Features:
- With CommandGUI you can send commands, messages to players.
- You can also charge money for it via Economy (Vault and Economy plugin required).
- You can decide per slot if the players need certain permissions or not.
- You can play a custom sound for each slot.
- You can also open another GUI directly via slots.
- You can also just display information by setting a lore for the items in the GUIs, these also support placeholders.
- There is an item that players can get in the inventory, with which they can open a specific GUI.

<img src="https://i.imgur.com/2f9Ewnl.png" width="600">

Optional:
- Permission Plugin
  LuckPerms recommended
- Vault
- Economy Plugin
  Recommendations: Economy, EssentialsX, CMI (Paid) (more possible)
  
<img src="https://i.imgur.com/wNDEjg9.png" width="600">

/commandgui - Open the default GUI (adjustable)
/commandgui [gui] - Open the selected GUI
/gui-item on - Activate the GUIItem for you.
/gui-item off - Disable the GUIItem for you.
/commandguihelp - Open the help file.
/commandguiadmin info - Open the CommandGUI info.
/commandguiadmin createdefaultgui - create a default GUI
/commandguiadmin reload - Reload the plugin.

[code=YAML]permissions:
  commandgui.admin:
    description: All permissions from CommandGUI
    default: op
    children:
      commandgui.command: true
      commandgui.giveitem: true
      commandgui.useitem.toggle: true
      commandgui.bypass: true
      commandgui.command.info: true
      commandgui.command.give: true

  commandgui.command:
    description: Required permission to open GUIs via command
    default: op
  commandgui.giveitem:
    description: Only players with this permission will receive the GUI item
    default: op
  commandgui.useitem.toggle:
    description: Required permission to enable/disable the GUI item for itself (if the function UseItem/AllowToggle is set to true)
    default: op
  commandgui.bypass:
    description: Bypass to open disabled GUIs
    default: op
  commandgui.command.info:
    description: Permission to view CommandGUI info
    default: not op
  commandgui.command.give:
    description: Kommend in V2.1.0
    default: op[/code]

---

# Links
* [Download](https://www.spigotmc.org/resources/commandgui-cgui.90671/)
* [Discord](https://discord.gg/vRyXFFterJ)
