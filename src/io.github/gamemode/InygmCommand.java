package io.github.gamemode;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class InygmCommand implements CommandExecutor {

    private final GameModeCommands plugin;

    public InygmCommand(GameModeCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            File messagesFile = new File(plugin.getDataFolder(), "messages.yml");
            FileConfiguration messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);
            sender.sendMessage("§a插件配置文件已成功重新加载！");
            return true;
        }

        sender.sendMessage("§e用法: /Inygm reload");
        return false;
    }
}