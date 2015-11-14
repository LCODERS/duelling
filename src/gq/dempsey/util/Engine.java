package gq.dempsey.util;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Engine {

	private static ArrayList<ArrayList<UUID>> que = new ArrayList<ArrayList<UUID>>();
	
	public static void a(ArrayList<UUID> players){
		for(UUID id : players){
			Player p = Bukkit.getPlayer(id);
			if(p.hasPermission("duel.bypassque")){
				for(Arena a : ArenaManager.getArenas()){
					if(!a.isOccupied()){
						a.occupy(players);
					}
				}
			}else{
				que.add(players);
				p.sendMessage(ChatColor.GOLD + "Your qued at nr. " + que.size());
			}
		}
	}
	
	
}
