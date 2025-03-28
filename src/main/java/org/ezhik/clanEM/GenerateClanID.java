package org.ezhik.clanEM;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Random;

public class GenerateClanID {
    public static int generateClanID() {
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        if (clanNotID(randomNumber)) {
            generateClanID();
        }
        return randomNumber;
    }

    public static boolean clanNotID(int id) {
        File folder = new File("plugins/ClanEM/clans/");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                YamlConfiguration yamlConfig = YamlConfiguration.loadConfiguration(file);
                if (yamlConfig.contains("id") && yamlConfig.get("id").equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }
}
