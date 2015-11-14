package gq.dempsey.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Arena {

	private static ArrayList<Player> players = new ArrayList<Player>();
	public static Location sp1,sp2,b1,b2;
	private static int id;
	private static ArenaState dstate = ArenaState.FREE;
	private static File file;
	private static FileConfiguration conf;
	private static boolean occupied = false;
	
	public boolean isOccupied(){
		return occupied;
	}
	
	public void setOccupied(boolean b){
		occupied = b;
	}
	
	public int getId(){
		return id;
	}
	
	public static Arena getById(int id){
		return new Arena(id, new Location(Bukkit.getWorld(conf.getString("arenas."+id+".b1.world")),conf.getInt("arenas."+id+".b1.x"),conf.getInt("arenas."+id+".b1.y"), conf.getInt("arenas."+id+".b1.z")),new Location(Bukkit.getWorld(conf.getString("arenas."+id+".b2.world")),conf.getInt("arenas."+id+".b2.x"),conf.getInt("arenas."+id+".b2.y"), conf.getInt("arenas."+id+".b2.z")), new Location(Bukkit.getWorld(conf.getString("arenas."+id+".sp1.world")),conf.getInt("arenas."+id+".sp1.x"),conf.getInt("arenas."+id+".sp1.y"), conf.getInt("arenas."+id+".sp1.z")), new Location(Bukkit.getWorld(conf.getString("arenas."+id+".sp2.world")),conf.getInt("arenas."+id+".sp2.x"),conf.getInt("arenas."+id+".sp2.y"), conf.getInt("arenas."+id+".sp2.z")));
	}
	
	public void delete(){
		conf.set("arenas."+id, null);
		try{
			conf.save(file);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
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
	
	public void occupy(ArrayList<UUID> id){
		int turncounter = 0;
		for(UUID uid : id){
			Player p = Bukkit.getPlayer(uid);
			turncounter++;
			if(!invEmpty(p)){
				p.sendMessage(ChatColor.RED + "Your inventory has to be empty to join it!");
			}else{
				if(turncounter == 0){
					p.teleport(sp1);
				}else{
					p.teleport(sp2);
					return;
				}
			}
		}
		
		occupied = true;
	}
	
	public Arena(int id, Location b1, Location b2, Location sp1, Location sp2){
		Arena.sp1 = sp1;
		Arena.sp2 = sp2;
		Arena.b1 = b1;
		Arena.b2 = b2;
		Arena.id = id;
	}
	
	public ArrayList<Location> protectedBlocks(){
		int mix = 0,max = 0,miy = 0,may = 0,miz = 0,maz = 0;
		if(b1.getBlockX() < b2.getBlockX()){
			mix = b1.getBlockX();
			max = b2.getBlockX();
		}else{
			mix = b2.getBlockX();
			max = b1.getBlockX();
		}
		if(b1.getBlockX() < b2.getBlockX()){
			mix = b1.getBlockY();
			max = b2.getBlockY();
		}else{
			mix = b2.getBlockY();
			max = b1.getBlockY();
		}
		if(b1.getBlockX() < b2.getBlockX()){
			mix = b1.getBlockZ();
			max = b2.getBlockZ();
		}else{
			mix = b2.getBlockZ();
			max = b1.getBlockZ();
		}
		ArrayList<Location> b = new ArrayList<Location>();
		for(int x = mix; x<=max;x++){
			for(int y = miy; y<=may;y++){
				for(int z = miz; z<=maz;z++){
					Location l = new Location(b1.getWorld(), x,y,z);
					b.add(l);
				}
			}
		}
		return b;
	}
	
	public synchronized void save(){
		conf.set("arenas."+id+".sp1.world", sp1.getWorld());
		conf.set("arenas."+id+".sp1.x", sp1.getX());
		conf.set("arenas."+id+".sp1.y", sp1.getY());
		conf.set("arenas."+id+".sp1.z", sp1.getZ());
		conf.set("arenas."+id+".sp2.world", sp2.getWorld());
		conf.set("arenas."+id+".sp2.x", sp2.getX());
		conf.set("arenas."+id+".sp2.y", sp2.getY());
		conf.set("arenas."+id+".sp2.z", sp2.getZ());
		conf.set("arenas."+id+".b1.world", b1.getWorld());
		conf.set("arenas."+id+".b1.x", b1.getX());
		conf.set("arenas."+id+".b1.y", b1.getY());
		conf.set("arenas."+id+".b1.z", b1.getZ());
		conf.set("arenas."+id+".b2.world", b2.getWorld());
		conf.set("arenas."+id+".b2.x", b2.getX());
		conf.set("arenas."+id+".b2.y", b2.getY());
		conf.set("arenas."+id+".b2.z", b2.getZ());
		try{
			conf.save(file);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ArenaState getState(){
		return dstate;
	}
	
	public void setState(ArenaState state){
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
	
	public void resetArena(){
		for(Player pls : players){
			pls.setHealth(0.0D);
		}
		players.clear();
		setState(ArenaState.FREE);
		occupied = false;
	}
	
}
