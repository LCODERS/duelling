package gq.dempsey.util;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public abstract class Arena {

	private static ArrayList<Player> players = new ArrayList<Player>();
	public static Location sp1,sp2,y1,y2,x,z;
	private static int id;
	private static ArenaState dstate = ArenaState.FREE;
	
	public Arena(int id, Location sp1, Location sp2, Location y1, Location y2, Location x, Location z){
		Arena.sp1 = sp1;
		Arena.sp2 = sp2;
		Arena.y1 = y1;
		Arena.y2 = y2;
		Arena.x = x;
		Arena.z = z;
		Arena.id = id;
	}
	
	public static ArenaState getState(){
		return dstate;
	}
	
	public static void setState(ArenaState state){
		dstate = state;
	}
	
	public static void addPlayer(Player player){
		if(!(players.size() >= 2)){
			players.add(player);
			DO_NOT_TOUCH.kit(player);
		}else{
			System.out.println("Max Players Reached For Arena " + id + "!");
		}
	}
	
	public static void resetArena(){
		players.clear();
	}
	
}
