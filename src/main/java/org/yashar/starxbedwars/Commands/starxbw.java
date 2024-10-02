package org.yashar.starxbedwars.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.yashar.starxbedwars.config;
import org.yashar.starxbedwars.configpath;

public class starxbw implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage("-------------------");
                player.sendMessage("HelpCommands");
                player.sendMessage("/starxbw reload");
                player.sendMessage("-------------------");
            }
        }
            if (args.length >= 1) {
                String action = args[0].toLowerCase();
                if (action.equals("reload")) {
                    config.reload();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.get().getString(configpath.RELOAD_MESSAGE)));
                }
            }
            return true;
        }
    }
