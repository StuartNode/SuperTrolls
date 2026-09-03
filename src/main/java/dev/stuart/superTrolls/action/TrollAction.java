package dev.stuart.superTrolls.action;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public abstract class TrollAction {
    private final String name;
    private final String lore;
    private final Material icon;

    public TrollAction(String name, String lore, Material icon) {
        this.name = name;
        this.lore = lore;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getLore() {
        return lore;
    }

    public Material getIcon() {
        return icon;
    }

    public abstract void run(Player player);
}
