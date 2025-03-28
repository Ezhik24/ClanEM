package org.ezhik.clanEM.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.C;
import org.ezhik.clanEM.ClanSystem;
import org.ezhik.clanEM.GenerateClanID;

import java.io.File;

public class ClanCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player;
        ClanSystem clanSystem;
        switch (strings[0]) {
            case "accept":
                break;
            case "cancel":
                break;
            case "chat":
                break;
            case "kick":
                break;
            case "invite":
                break;
            case "leave":
                break;
            case "disband":
                break;
            case "promote":
                break;
            case "invest":
                break;
            case "home":
                break;
            case "sethome":
                break;
            case "delhome":
                break;
            case "rename":
                break;
            case "info":
                break;
            case "create":
                player = (Player) commandSender;
                clanSystem = ClanSystem.getClan(player);
                if (clanSystem != null) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f&l[&6&lClanEM&f&l] &c&lВы уже состоите в клане"));
                    return false;
                }
                int clanID = GenerateClanID.generateClanID();
                File file = new File("plugins/ClanEM/clans/" + clanID + ".yml");
                YamlConfiguration clanConf = YamlConfiguration.loadConfiguration(file);
                clanConf.set("id", clanID);
                clanConf.set("name", strings[1]);
                clanConf.set("owner", player.getName());
                clanConf.set("members", null);
                clanConf.set("balance", 0);
                clanConf.set("pvp", true);
                clanConf.set("home", null);
                try {
                    clanConf.save(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&f&l[&6&lClanEM&f&l] &a&lВы успешно создали клан &f&l" + strings[1]));
                break;
            case "menu":
                break;
            case "help":
                break;
            case "pvp":
                break;
            case "money":
                break;
            case "withdraw":
                break;
            case "storage":
                break;
            default:
                break;
        }
        return true;
    }
}
