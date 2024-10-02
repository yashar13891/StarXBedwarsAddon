package org.yashar.starxbedwars;

import com.andrei1058.bedwars.api.BedWars;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.yashar.starxbedwars.Commands.*;

public final class StarXbedwars extends JavaPlugin {
    @Override
    public void onEnable() {
        //register bw1058
        //Disable if pl not found
        if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {
            getLogger().severe("BedWars1058 was not found. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        BedWars bedwarsAPI = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();
        //setupconfig

        config.setup();

        config.get().addDefault(configpath.PLAYER_NOT_FOUND, "&cThis player is not online.");
        config.get().addDefault(configpath.NO_PERMISSION,"&cYou don't have permission to use this command.");
        config.get().addDefault(configpath.CHANGE_GAMEMODE, "&aYour gamemode has been set to &e{gamemode}&a!");
        config.get().addDefault(configpath.NO_PERMISSION_OTHERS, "&cYou don't have permission to use this command on others.");
        config.get().addDefault(configpath.CHANGE_GAMEMODE_OTHERS, "&aYou changed &e{player}'s gamemode to &e{gamemode}&a!");
        config.get().addDefault(configpath.RELOAD_MESSAGE, "&aConfiguration Reloaded");
        config.get().addDefault(configpath.in_map, "&aYou are currently playing on &e{map}");
        config.get().addDefault(configpath.no_map, "&aYou aren't in the map");

        config.get().options().copyDefaults(true);

        config.save();
        //registering command or listeners
        getServer().getPluginCommand("gma").setExecutor(new gma());
        getServer().getPluginCommand("gms").setExecutor(new gms());
        getServer().getPluginCommand("gmc").setExecutor(new gmc());
        getServer().getPluginCommand("gmsp").setExecutor(new gmsp());
        getServer().getPluginCommand("starxbw").setExecutor(new starxbw());
        getServer().getPluginCommand("map").setExecutor(new map());


    }
}
