package lekro.bukkitplugins.torncraftutils;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class TorncraftCommands implements CommandExecutor {
	private TorncraftPlugin plugin;
	public TorncraftCommands(TorncraftPlugin plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("worldspawn")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				Location spawnLocation = player.getWorld().getSpawnLocation();
				player.teleport(TorncraftBlockUtils.getPlayerFittableLocation(spawnLocation));
				return true;
			}		
			else {
				plugin.getLogger().info("Not a player!");
				return false;
			}
		}
		if (cmd.getName().equalsIgnoreCase("unbreakable")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.getItemInHand().getType().getMaxDurability() > 0) {
					ItemMeta itemmeta = player.getItemInHand().getItemMeta();
					List<String> lore = new LinkedList<String>();
					if (itemmeta.hasLore()) {
						lore = itemmeta.getLore();
					
						if (lore.contains("Unbreakable")) {
							lore.remove("Unbreakable");
							itemmeta.setLore(lore);
							player.getItemInHand().setItemMeta(itemmeta);
						}
						else {
							lore.add("Unbreakable");
							itemmeta.setLore(lore);
							player.getItemInHand().setItemMeta(itemmeta);
						}
					}
					else {
						lore.add("Unbreakable");
						itemmeta.setLore(lore);
						player.getItemInHand().setItemMeta(itemmeta);
					}
				}
				return true;
			}
			return false;
		}
		if (cmd.getName().equalsIgnoreCase("vote")) {
			List<String> voteStrings = plugin.getVoteStrings();
			for(String s : voteStrings) {
				sender.sendMessage(s);
			}
			return true;
		}
		return false;
	}

}
