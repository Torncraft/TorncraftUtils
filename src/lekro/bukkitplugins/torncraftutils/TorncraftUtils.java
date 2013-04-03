package lekro.bukkitplugins.torncraftutils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TorncraftUtils extends JavaPlugin implements Listener {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	public void onPlayerVoidHurt (EntityDamageEvent event) {
		if (event.getCause().equals(DamageCause.VOID) && (event.getEntity() instanceof Player)) {
			Player player = (Player) event.getEntity();
			player.teleport(player.getWorld().getSpawnLocation());
		}
		
	}
}
