package io.github.gamemode;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class GameModeCommands extends JavaPlugin {

    private String serverVersion;

    @Override
    public void onEnable() {
        String serverVersion = getServer().getClass().getPackage().getName().split("\\.")[3];
        VersionUtils.handleVersionLogic(serverVersion);

        // Register commands
        getCommand("Inygm").setExecutor(new InygmCommand(this));
        getCommand("gmc").setExecutor(new GameModeExecutor("gmc"));
        getCommand("gms").setExecutor(new GameModeExecutor("gms"));
        getCommand("gma").setExecutor(new GameModeExecutor("gma"));
        getCommand("gmsp").setExecutor(new GameModeExecutor("gmsp"));
    }

    private void loadMessagesConfig() {
        File messagesFile = new File(getDataFolder(), "config.yml");
        if (!messagesFile.exists()) {
            saveResource("config.yml", false);
        }
        messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);
    }

    public class InygmCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
                loadMessagesConfig(); // 重新加载配置文件
                sender.sendMessage("插件配置文件已重新加载！");
                return true;
            }
            sender.sendMessage(ChatColor.YELLOW"用法: /Inygm reload");
            return false;
        }
    }

    public class GameModeExecutor implements CommandExecutor {
        private final String mode;

        public GameModeExecutor(String mode) {
            this.mode = mode;
        }

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                if (sender instanceof Player) {
                        Player player = (Player) sender;
                        String message = ChatColor.translateAlternateColorCodes('&',
                        messagesConfig.getString("messages." + mode, PREFIX + ChatColor.YELLOW + "默认游戏模式消息！"));
                        String message = MessageUtils.format("&a你现在处于 " + mode + " 模式！");
                        player.sendMessage(message);
                    return true;
            }
            sender.sendMessage(PREFIX + ChatColor.RED + "只有玩家可以执行此命令！");
            return false;
        }
    }
}