package lekro.bukkitplugins.torncraftutils;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TorncraftPlugin extends JavaPlugin implements Listener {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new VoidFall(this), this);
		getCommand("worldspawn").setExecutor(new TorncraftCommands(this));
	}
}
