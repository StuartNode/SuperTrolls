package dev.stuart.superTrolls.command;

import dev.nexisApi.gui.GuiManager;
import dev.stuart.superTrolls.SuperTrolls;
import dev.stuart.superTrolls.menu.TrollMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrollCommand implements CommandExecutor {
    private final GuiManager guiManager;
    private final SuperTrolls plugin;

    public TrollCommand(GuiManager guiManager, SuperTrolls plugin) {
        this.guiManager = guiManager;
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only player can use command.");
            return false;
        }

        if (!player.hasPermission("supertrolls.troll")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to run this command.");
            return false;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: /troll <player>");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatColor.RED + "That player is not online");
            return false;
        }

        guiManager.openMenuAndLoad(player, new TrollMenu(plugin, target));
        return true;
    }
}
