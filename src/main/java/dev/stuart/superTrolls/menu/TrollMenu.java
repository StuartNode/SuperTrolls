package dev.stuart.superTrolls.menu;

import dev.nexisApi.menu.PaginatedMenu;
import dev.stuart.superTrolls.action.TrollAction;
import dev.stuart.superTrolls.registry.TrollRegistry;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TrollMenu extends PaginatedMenu<TrollAction> {
    private final Player target;

    public TrollMenu(JavaPlugin plugin, Player target) {
        super(plugin);
        this.target = target;
    }

    @Override
    public String getMenuName() {
        return "Trolls";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    protected CompletableFuture<List<TrollAction>> loadDataAsync(Player viewer) {
        return CompletableFuture.completedFuture(TrollRegistry.getTrolls());
    }

    @Override
    protected ItemStack toItem(TrollAction troll) {
        return makeItem(troll.getIcon(), ChatColor.AQUA + troll.getName(), ChatColor.GRAY + troll.getLore());
    }

    @Override
    protected void onElementClick(Player player, TrollAction troll, InventoryClickEvent event) {
        troll.run(target);
        player.sendActionBar(Component.text(
                ChatColor.AQUA + "ran " + ChatColor.WHITE + troll.getName() +
                        ChatColor.AQUA + " on " + ChatColor.WHITE + target.getName())
        );
    }
}
