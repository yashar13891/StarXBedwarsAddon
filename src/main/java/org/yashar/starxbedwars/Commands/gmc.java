package org.yashar.starxbedwars.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.yashar.starxbedwars.config;
import org.yashar.starxbedwars.configpath;

public class gmc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player player = (Player) sender;
                if (!player.hasPermission("starxbw.gmc")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.get().getString(configpath.NO_PERMISSION)));
                    return true;
                }
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.get().getString(configpath.CHANGE_GAMEMODE).replace("{gamemode}", player.getGameMode().name())));
            }
        }
        if (args.length > 0) {
            Player player = (Player) sender;
            if (!player.hasPermission("starxbw.gmc.others")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',configpath.NO_PERMISSION_OTHERS));
                return true;
            }
            String playername = args[0];
            Player target = Bukkit.getServer().getPlayerExact(playername);
            if (target == null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.get().getString(configpath.PLAYER_NOT_FOUND)));
                return true;
            }
            if (args.length == 1) {
                target.setGameMode(GameMode.CREATIVE);
                String message = config.get().getString(configpath.CHANGE_GAMEMODE_OTHERS)
                        .replace("{gamemode}", target.getGameMode().name())
                        .replace("{player}", target.getName());
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
            }

        }
        return true;
    }
}

