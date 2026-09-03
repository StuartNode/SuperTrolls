package dev.stuart.superTrolls.ability;

import dev.stuart.superTrolls.action.TrollAction;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Smite extends TrollAction {
    public Smite() {
        super("Smite", "Strike lighting on the target", Material.LIGHT);
    }

    @Override
    public void run(Player player) {
        player.getWorld().strikeLightningEffect(player.getLocation());
    }
}
