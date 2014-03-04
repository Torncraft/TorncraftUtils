package lekro.bukkitplugins.torncraftutils;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class TorncraftPlugin extends JavaPlugin {
	
	private List<String> voteStrings;
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new TorncraftListener(this), this);
		
		voteStrings = getConfig().getStringList("vote");
		
		TorncraftCommands commandListener = new TorncraftCommands(this);

		getCommand("worldspawn").setExecutor(commandListener);
		getCommand("unbreakable").setExecutor(commandListener);
		getCommand("vote").setExecutor(commandListener);
	}
	
	public List<String> getVoteStrings() {
		return voteStrings;
	}
	
	public void onDisable() {
		// nothing!
	}
}
