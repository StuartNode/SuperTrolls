package dev.stuart.superTrolls.ability;

import dev.stuart.superTrolls.action.TrollAction;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Launch extends TrollAction {
    public Launch() {
        super("Launch Troll", "Send the player in the air", Material.SLIME_BLOCK);
    }

    @Override
    public void run(Player player) {
        player.setVelocity(player.getLocation().getDirection().setY(5));
    }
}
