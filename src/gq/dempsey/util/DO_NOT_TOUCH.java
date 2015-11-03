package gq.dempsey.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DO_NOT_TOUCH {

	// KIT
	
	
	private static ItemStack helmet = new ItemStack(Material.IRON_HELMET,1);
	private static ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE,1);
	private static ItemStack pants = new ItemStack(Material.IRON_LEGGINGS,1);
	private static ItemStack boots = new ItemStack(Material.IRON_BOOTS,1);
	private static ItemStack sword = new ItemStack(Material.DIAMOND_SWORD,1);
	private static ItemStack bow = new ItemStack(Material.BOW,1);
	private static ItemMeta bmeta = bow.getItemMeta();
	
	public static void kit(Player p){
		bmeta.addEnchant(Enchantment.ARROW_INFINITE,1,true);
		bow.setItemMeta(bmeta);
		p.getInventory().clear();
		p.getInventory().setHelmet(helmet);
		p.getInventory().setChestplate(chestplate);
		p.getInventory().setLeggings(pants);
		p.getInventory().setBoots(boots);
		p.getInventory().setHeldItemSlot(0);
		p.getInventory().setItemInHand(sword);
		p.getInventory().addItem(bow, new ItemStack(Material.GOLDEN_APPLE, 32), new ItemStack(Material.ARROW,1));
		
		
	}
	
}
