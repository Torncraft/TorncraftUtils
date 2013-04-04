package lekro.bukkitplugins.torncraftutils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class VoidFall implements Listener {
	private TorncraftPlugin plugin;
	public VoidFall(TorncraftPlugin plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onPlayerVoidHurt (EntityDamageEvent event) {
		if (event.getCause().equals(DamageCause.VOID) && (event.getEntity() instanceof Player)) {
			Player player = (Player) event.getEntity();
			player.teleport(player.getWorld().getHighestBlockAt(player.getLocation()).getLocation());
			plugin.getLogger().info("Saved "+player.getDisplayName()+" from the horrors of the void!");
			player.sendMessage("Saved you from the horrors of the void! *shivers*");
			event.setCancelled(true);
		}
		
	}
}
