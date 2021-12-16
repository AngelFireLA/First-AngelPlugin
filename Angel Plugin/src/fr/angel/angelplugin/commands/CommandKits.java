package fr.angel.angelplugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandKits implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("kits")) {
			
				ItemStack ironsword = new ItemStack(Material.IRON_SWORD);
				player.getInventory().setItem(1, ironsword);
				
				ItemStack chainhelmet = new ItemStack(Material.CHAINMAIL_HELMET);
				player.getInventory().setItem(3, chainhelmet);
				
				ItemStack chainchesplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
				player.getInventory().setItem(4, chainchesplate);
				
				ItemStack chainleggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
				player.getInventory().setItem(5, chainleggings);
				
				ItemStack chainboots = new ItemStack(Material.CHAINMAIL_BOOTS);
				player.getInventory().setItem(6, chainboots);
			
				ItemStack steacks = new ItemStack(Material.COOKED_BEEF, 16);
				player.getInventory().setItem(2, steacks);
				
				player.sendMessage("§aVous avez correctement reçus votre kit!");
				
			}
	}
		
		return false;
	}

}
