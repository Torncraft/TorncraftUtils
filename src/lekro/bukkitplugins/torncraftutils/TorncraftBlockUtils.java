package lekro.bukkitplugins.torncraftutils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class TorncraftBlockUtils {
	public static Location getPlayerFittableLocation(Location loc) {
		if (!loc.getBlock().getType().equals(Material.AIR)) {
			boolean foundAir = false;
			Block currBlock = loc.getBlock().getRelative(BlockFace.UP);
			while (foundAir == false) {
				if (currBlock.getType().equals(Material.AIR) && (currBlock.getRelative(BlockFace.UP).getType().equals(Material.AIR))) {
					return currBlock.getLocation();
				}
				currBlock = currBlock.getRelative(BlockFace.UP);
				if (currBlock.getY() >= currBlock.getWorld().getMaxHeight()) {
					return currBlock.getLocation();
				}
			}
			return null;
		} else {
			return loc;
		}
	}
}
