package fr.angel.angelplugin;

import java.util.Arrays;

import org.apache.logging.log4j.core.pattern.EqualsIgnoreCaseReplacementConverter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mysql.fabric.Server;

import gnu.trove.impl.hash.TPrimitiveHash;

public class AngelListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		player.getInventory().clear();
	
		
		ItemStack menu = new ItemStack(Material.COMPASS); //boussole qui ouvre le menu
		ItemMeta cm = menu.getItemMeta();
		cm.setDisplayName("§6MENU");
		cm.setLore(Arrays.asList("Permet d'ouvrir la liste des serveurs"));
		menu.setItemMeta(cm);
		player.getInventory().setItem(0, menu);
		
		player.updateInventory();
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player  = event.getPlayer();
		Action action  = event.getAction();
		ItemStack it = event.getItem();
	
		
		if(it!= null && it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6MENU")) {
			Inventory inv = Bukkit.createInventory(null, 9, "§8Menu");
			
			ItemStack kits = new ItemStack(Material.BED);
			ItemMeta ck = kits.getItemMeta();
			ck.setDisplayName("Bedwras/Skywars");
			ck.setLore(Arrays.asList("§aTeleport to the Bedwars/skywars server"));
			kits.setItemMeta(ck);
			
			ItemStack crea = new ItemStack(Material.GRASS);
			ItemMeta cm = crea.getItemMeta();
			cm.setDisplayName("Creative");
			cm.setLore(Arrays.asList("§aTeleport to the Creative server"));
			crea.setItemMeta(cm);
			
			inv.setItem(1, kits);
			inv.setItem(3, crea);
			player.openInventory(inv);
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Inventory inv =event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		if(current == null) return;
		
		if(inv.getName().equalsIgnoreCase("§8Menu")) {
			
			event.setCancelled(true);
			
			switch(current.getType()) {
			
			case BED:
				player.chat("/Server bw");
				break;
			default:
				break;
			}
			
			if(current.getType() == Material.BED) {
				player.closeInventory();
			}
			switch(current.getType()) {
			
			case GRASS:
				player.chat("/Server Creative");
				break;
			default:
				break;
			}
			
			if(current.getType() == Material.GRASS) {
				player.closeInventory();
			}
		}
		
	}

}
