package lekro.bukkitplugins.torncraftutils;

import org.bukkit.plugin.java.JavaPlugin;

public class TorncraftPlugin extends JavaPlugin {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new TorncraftListener(this), this);
		getCommand("worldspawn").setExecutor(new TorncraftCommands(this));
		getCommand("unbreakable").setExecutor(new TorncraftCommands(this));
	}
}
