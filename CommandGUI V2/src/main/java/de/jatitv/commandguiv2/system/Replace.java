package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Replace {

    public static String replace(String Text) {
        return Text.replace("[prefix]", Main.Prefix).replace("&", "§").replace("[ue]", "ü")
                .replace("[UE]", "Ü").replace("[oe]", "Ö").replace("[OE]", "Ö")
                .replace("[ae]", "ä").replace("[AE]", "Ä");
    }
    public static String replace(Player player, String Text) {
        return  PlaceholderAPI.setPlaceholders(player, Text.replace("[prefix]", Main.Prefix).replace("&", "§")
                .replace("[ue]", "ü").replace("[UE]", "Ü").replace("[oe]", "Ö")
                .replace("[OE]", "Ö").replace("[ae]", "ä").replace("[AE]", "Ä"));
    }
    public static List<String> replace(List<String> Text) {
        List<String> output = new ArrayList<>();
        for(String input : Text) {
            output.add(input.replace("[prefix]", Main.Prefix).replace("&", "§")
                    .replace("[ue]", "ü").replace("[UE]", "Ü").replace("[oe]", "Ö")
                    .replace("[OE]", "Ö").replace("[ae]", "ä").replace("[AE]", "Ä"));
        }
        return output;
    }
    public static List<String> replace(Player player, List<String> Text) {
        List<String> output = new ArrayList();
        if (player == null) {
            return Arrays.asList("player is null");
        }
        if (Text == null) {
            return Arrays.asList("Text is null");
        }
        for(String input : Text) {
            output.add(PlaceholderAPI.setPlaceholders(player, input.replace("[prefix]", Main.Prefix).replace("&", "§")
                    .replace("[ue]", "ü").replace("[UE]", "Ü").replace("[oe]", "Ö")
                    .replace("[OE]", "Ö").replace("[ae]", "ä").replace("[AE]", "Ä")));
        }
        return output;
    }
    public static List replacePrice(List<String> Text, String price) {
        List rp = new ArrayList();
        for (String s : Text) {
            rp.add(s.replace("[prefix]", Main.Prefix).replace("&", "§")
                    .replace("[ue]", "ü").replace("[UE]", "Ü").replace("[oe]", "Ö")
                    .replace("[OE]", "Ö").replace("[ae]", "ä").replace("[AE]", "Ä")
                    .replace("[price]", String.valueOf(price)));
        }
        return rp;
    }
    public static List replacePrice(Player player, List<String> Text, String price) {
        List rp = new ArrayList();
        for (String s : Text) {
            rp.add(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", Main.Prefix).replace("&", "§")
                    .replace("[ue]", "ü").replace("[UE]", "Ü").replace("[oe]", "Ö")
                    .replace("[OE]", "Ö").replace("[ae]", "ä").replace("[AE]", "Ä")
                    .replace("[price]", String.valueOf(price))));
        }
        return rp;
    }

}
