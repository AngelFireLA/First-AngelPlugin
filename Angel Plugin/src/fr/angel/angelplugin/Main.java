package fr.angel.angelplugin;

import org.bukkit.plugin.java.JavaPlugin;

import fr.angel.angelplugin.commands.CommandBvn;
import fr.angel.angelplugin.commands.CommandHub;
import fr.angel.angelplugin.commands.CommandKits;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		System.out.println("[AngelPlugin] Le plugin est on");
		getServer().getPluginManager().registerEvents(new AngelListener(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[AngelPlugin] Le plugin est off");
	}

}
