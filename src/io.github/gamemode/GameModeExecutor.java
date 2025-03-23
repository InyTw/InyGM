package com.example.gamemode;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeExecutor implements CommandExecutor {
    private final String mode;

    public GameModeExecutor(String mode) {
        this.mode = mode;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String message = MessageUtils.format("&a你现在处于 " + mode + " 模式！");
            player.sendMessage(message);
            return true;
        }
        sender.sendMessage(ChatColor.RED + "只有玩家可以执行此命令！");
        return false;
    }
}

