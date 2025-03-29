package org.ezhik.clanEM;

import org.bukkit.plugin.java.JavaPlugin;
import org.ezhik.clanEM.commands.ClanCMD;

public final class ClanEM extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("clan").setExecutor(new ClanCMD());
    }

    @Override
    public void onDisable() {
    }
}
