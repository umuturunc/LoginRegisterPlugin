package lakresmigo.loginregister.commands;

import com.destroystokyo.paper.Title;
import lakresmigo.loginregister.livedata.OnlinePlayers;
import lakresmigo.loginregister.utilities.PasswordManager;
import lakresmigo.loginregister.utilities.PermissionManager;
import lakresmigo.loginregister.utilities.TitleManager;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;

public class LoginCommand implements CommandExecutor {
    JavaPlugin plugin;

    public LoginCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            if(args.length == 1)
            {
                String password = args[0];
                if(PasswordManager.isPasswordCorrect(player,password))
                {
                    OnlinePlayers.setPlayerLoggedIn(player);
                    PermissionManager.removePermision(player,"login");
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendTitle(TitleManager.loginSuccessTitle);
                    player.sendMessage(TitleManager.loginSuccessTitle.getTitle());
                    player.sendMessage(TitleManager.loginSuccessTitle.getSubtitle());
                    return true;
                }
            }
        }
        return false;
    }
}
