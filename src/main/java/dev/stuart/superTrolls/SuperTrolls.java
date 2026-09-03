package dev.stuart.superTrolls;

import dev.nexisApi.gui.GuiListener;
import dev.nexisApi.gui.GuiManager;
import dev.nexisApi.menu.PaginatedMenu;
import dev.stuart.superTrolls.command.TrollCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class SuperTrolls extends JavaPlugin {
    private GuiManager guiManager;

    @Override
    public void onEnable() {
        guiManager = new GuiManager();
        getCommand("troll").setExecutor(new TrollCommand(guiManager, this));
        getServer().getPluginManager().registerEvents(new GuiListener(guiManager), this);
    }

    @Override
    public void onDisable() {
        if (guiManager != null) {
            guiManager.closeAll();
        }

        PaginatedMenu.shutdownSearchExecutor();
    }
}
