package org.ezhik.clanEM;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ClanSystem {
    private ClanSystem() {
        File file = new File("plugins/ClanEM/");
        YamlConfiguration clansystem = YamlConfiguration.loadConfiguration(file);
    }
}
