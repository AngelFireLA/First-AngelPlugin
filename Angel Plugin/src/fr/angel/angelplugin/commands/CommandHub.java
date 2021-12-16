package fr.angel.angelplugin.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;

public class CommandHub implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		

		if(sender instanceof Player) {
			Player player = (Player)sender;
			Location pLocation = player.getLocation(); //récupère la position actuelle du joueur
			
			if(cmd.getName().equalsIgnoreCase("sethub")) {
				player.getWorld().setSpawnLocation(pLocation.getBlockX(), pLocation.getBlockY(), pLocation.getBlockZ());
				player.sendMessage("§2Hub corectement mis dans votre monde actuel");
				return true;
			}else if(cmd.getName().equalsIgnoreCase("hub")) {
				
				player.teleport(player.getWorld().getSpawnLocation());
				player.sendMessage("§2Vous avez été téléporté correctement");
				
				return true;
			}
			
			
		}
		
		
		return false;
	}

}
