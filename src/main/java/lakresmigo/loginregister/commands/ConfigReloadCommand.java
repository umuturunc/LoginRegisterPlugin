package lakresmigo.loginregister.commands;

import lakresmigo.loginregister.utilities.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConfigReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp())
        {
            ConfigManager.reloadConfigFromDisk();
            sender.sendMessage("Ayarlar kaydedildi");
            return true;
        }
        return false;
    }
}
