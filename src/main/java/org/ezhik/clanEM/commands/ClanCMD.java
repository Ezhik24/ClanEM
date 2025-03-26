package org.ezhik.clanEM.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ClanCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings[0]) {
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
