package gq.dempsey.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Arena {

	private static ArrayList<Player> players = new ArrayList<Player>();
	public static Location sp1,sp2,y1,y2,x,z;
	private static int id;
	private static ArenaState dstate = ArenaState.FREE;
	private static File file;
	private static FileConfiguration conf;
	
	public static void setup(Plugin p) throws IOException{
		if(!p.getDataFolder().exists()){
			p.getDataFolder().mkdir();
		}
		file = new File(p.getDataFolder(), "Arena.yml");
		if(!file.exists()){
			file.createNewFile();
		}
		conf = YamlConfiguration.loadConfiguration(file);
	}
	
	public Arena(int id, Location sp1, Location sp2, Location y1, Location y2, Location x, Location z){
		Arena.sp1 = sp1;
		Arena.sp2 = sp2;
		Arena.y1 = y1;
		Arena.y2 = y2;
		Arena.x = x;
		Arena.z = z;
		Arena.id = id;
	}
	
	public static synchronized void save(){
		
		
		try{
			conf.save(file);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static ArenaState getState(){
		return dstate;
	}
	
	public static void setState(ArenaState state){
		dstate = state;
	}
	
	private static boolean invEmpty(Player player){
		for(ItemStack i : player.getInventory().getContents()){
			if(i != null){
				return false;
			}
		}
		return true;
		
	}
	
	public static void addPlayer(Player player){
		if(!invEmpty(player)){
			player.sendMessage(ChatColor.RED + "Your inventory is required to be empty to join a duel!");
		}else{
			if(!(players.size() >= 2)){
				players.add(player);
				DO_NOT_TOUCH.kit(player);
			}else{
				System.out.println("Max Players Reached For Arena " + id + "!");
			}
		}
	}
	
	public static void resetArena(){
		for(Player pls : players){
			pls.setHealth(0.0D);
		}
		players.clear();
		setState(ArenaState.FREE);
	}
	
}
