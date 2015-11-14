package me.duelling.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormat implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
	Player player = e.getPlayer();
	if(player.hasPermission("duel.colorednames.owner")) {
		e.setFormat("§8[§4Ejer§8] §4" + e.getPlayer().getName() + "§7: §4" + e.getMessage());
		
	} else if(player.hasPermission("duel.colorednames.admin")) {
		e.setFormat("§8[§cAdmin§8] §c" + e.getPlayer().getName() + "§7: §c" + e.getMessage());
		
	} else if(player.hasPermission("duel.colorednames.moderator")) {
		e.setFormat("§8[§9Moderator§8] §9" + e.getPlayer().getName() + "§7: §9" + e.getMessage());
		
	} else if(player.hasPermission("duel.colorednames.helper")) {
		e.setFormat("§8[§6Helper§8] §6" + e.getPlayer().getName() + "§7: §6" + e.getMessage());
		
	} else if(player.hasPermission("duel.colorednames.developer")) {
		e.setFormat("§8[§5Developer§8] §5" + e.getPlayer().getName() + "§7: §5" + e.getMessage());
		
	} else if(player.hasPermission("duel.colorednames.vip")) {
		e.setFormat("§8[§aVIP§8] §a" + e.getPlayer().getName() + "§7: §a" + e.getMessage());
		
	} else if(player.hasPermission("duel.colorednames.aqua")) {
		e.setFormat("§8[§bMVP§8] §b" + e.getPlayer().getName() + "§7: §b" + e.getMessage());
		
	} else {
		e.setFormat("§8[§7Spiller§8] §7" + e.getPlayer().getName() + "§7: §7" + e.getMessage());
	}
}

}
