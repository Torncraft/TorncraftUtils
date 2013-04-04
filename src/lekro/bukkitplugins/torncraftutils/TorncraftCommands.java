package lekro.bukkitplugins.torncraftutils;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
		else {
			plugin.getLogger().info("Not my command!");
			return false;
		}
	}

}
