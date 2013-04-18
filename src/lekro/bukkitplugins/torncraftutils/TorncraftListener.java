package lekro.bukkitplugins.torncraftutils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class TorncraftListener implements Listener {
	private TorncraftPlugin plugin;
	public TorncraftListener(TorncraftPlugin plugin) {
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
	@EventHandler
	public void onWeaponDamage(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player) {
			Player player = (Player) event.getDamager();
			if (player.getItemInHand().getItemMeta().hasLore()) {
				if (player.getItemInHand().getItemMeta().getLore().contains("Unbreakable")) {
					player.getItemInHand().setDurability((short) -32768);
				}
			}
		}
	}
}
