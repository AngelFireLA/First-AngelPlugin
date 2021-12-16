package fr.angel.angelplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.angel.angelplugin.Main;

public class CommandBvn implements CommandExecutor {
	
	private Main main;

	public CommandBvn(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("bvn")) {
				player.sendMessage(main.getConfig().getString("message.bvn"));
				return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("shout")) {
				
				if(args.length == 0) {
					player.sendMessage("Il te manque le texte a envoyer");
				}
				
				if(args.length >= 1) {
					
					StringBuilder shout = new StringBuilder();
					for(String part : args) {
						shout.append(part + " ");
					}
					
					Bukkit.broadcastMessage("§4[SHOUT] §6" + shout.toString());
					
			
				}
				
				return true;
			}

		}
		
		return false;
	}

}
