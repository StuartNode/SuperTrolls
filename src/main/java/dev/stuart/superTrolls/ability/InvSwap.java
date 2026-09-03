package dev.stuart.superTrolls.ability;

import dev.stuart.superTrolls.action.TrollAction;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InvSwap extends TrollAction {
    public InvSwap() {
        super(
                "Inventory Swap",
                "move around all the items inside the player inventory",
                Material.HOPPER
        );
    }

    @Override
    public void run(Player player) {
        if (player.getInventory().getContents().length == 0) return;
        ItemStack[] inventories = player.getInventory().getContents();
        List<ItemStack> items = Arrays.asList(inventories);
        Collections.shuffle(items);
        player.getInventory().setContents(items.toArray(new ItemStack[0]));
    }
}
