package org.ezhik.clanEM;

import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClanSystem {
    public int id = 0;
    public String name = null;
    public String owner = null;
    List<String> members = new ArrayList<>();
    public int balance = 0;
    List<ItemStack> storage = new ArrayList<>();
    public boolean pvp = true;
    public Location home = null;

    private ClanSystem(int id) {
        File file = new File("plugins/ClanEM/clans/" + id + ".yml");
        YamlConfiguration clansystem = new YamlConfiguration();
        try {
            clansystem.load(file);
            this.id = clansystem.getInt("id");
            this.name = clansystem.getString("name");
            this.owner = clansystem.getString("owner");
            this.members = clansystem.getStringList("members");
            this.balance = clansystem.getInt("balance");
            this.storage = (List<ItemStack>) clansystem.getList("storage");
            this.pvp = clansystem.getBoolean("pvp");
            this.home = clansystem.getLocation("home");
        } catch (FileNotFoundException e) {
            System.out.println("Error file not found: " + e);
        } catch (IOException e) {
            System.out.println("Error loading config file: " + e);
        } catch (InvalidConfigurationException e) {
            System.out.println("Error loading config file: " + e);
        }
    }
    public static ClanSystem getClan(Player player) {
        File folder = new File("plugins/ClanEM/clans/");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                YamlConfiguration yamlConfig = YamlConfiguration.loadConfiguration(file);
                String owner = yamlConfig.getString("owner");
                List<String> members = yamlConfig.getStringList("members");
                if (owner.equals(player.getName()) || members.contains(player.getName())) {
                    return new ClanSystem(yamlConfig.getInt("id"));
                }
            }
        }
        return null;
    }

}
