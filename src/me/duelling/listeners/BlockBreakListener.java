package me.duelling.listeners;

import gq.dempsey.util.Arena;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener{
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		for(Location l : Arena.protectedBlocks()){
			if(e.getBlock().getLocation().equals(l)){
				e.setCancelled(true);
			}
		}
	}

}
