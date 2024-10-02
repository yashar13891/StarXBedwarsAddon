package org.yashar.starxbedwars.Commands;

import com.andrei1058.bedwars.api.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.yashar.starxbedwars.config;
import org.yashar.starxbedwars.configpath;

public class map implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                BedWars bedwarsAPI = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();
                IArena arena = bedwarsAPI.getArenaUtil().getArenaByPlayer(player);
                if (arena == null) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',config.get().getString(configpath.no_map)));
                    return false;
                }
                if (arena.getStatus() == GameState.waiting || arena.getStatus() == GameState.starting || arena.getStatus() == GameState.playing) {
                    String message = config.get().getString(configpath.in_map).replace("{map}",arena.getDisplayName());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
                }
            }
            return true;
        }
    }