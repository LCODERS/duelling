package me.duelling.utils;

import me.duelling.Core;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ColoredNames implements Listener {
	
	Core plugin = new Core();
	
	@EventHandler
	public void async(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if(player.hasPermission("duel.colorednames.dark-red")) {
			player.setCustomName(ChatColor.DARK_RED + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.red")) {
			player.setCustomName(ChatColor.RED + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.dark-purple")) {
			player.setCustomName(ChatColor.DARK_PURPLE + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.purple")) {
			player.setCustomName(ChatColor.LIGHT_PURPLE + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.dark-blue")) {
			player.setCustomName(ChatColor.DARK_BLUE + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.blue")) {
			player.setCustomName(ChatColor.BLUE + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.aqua")) {
			player.setCustomName(ChatColor.AQUA + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.gold")) {
			player.setCustomName(ChatColor.GOLD + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.yellow")) {
			player.setCustomName(ChatColor.YELLOW + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.dark-green")) {
			player.setCustomName(ChatColor.DARK_GREEN + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.green")) {
			player.setCustomName(ChatColor.GREEN + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.white")) {
			player.setCustomName(ChatColor.WHITE + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.dark-gray")) {
			player.setCustomName(ChatColor.DARK_GRAY + "" + player.getName());
			player.setCustomNameVisible(true);
		} else if(player.hasPermission("duel.colorednames.black")) {
			player.setCustomName(ChatColor.BLACK + "" + player.getName());
			player.setCustomNameVisible(true);
		} else {
			player.setCustomName(ChatColor.GRAY + "" + player.getName());
			player.setCustomNameVisible(true);
		}
	}

}
