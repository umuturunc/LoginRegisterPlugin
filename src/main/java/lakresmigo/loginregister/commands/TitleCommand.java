package lakresmigo.loginregister.commands;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lakresmigo.loginregister.utilities.ConfigManager;
import lakresmigo.loginregister.utilities.TitleManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TitleCommand implements CommandExecutor {

    JavaPlugin plugin;

    public TitleCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 1)
        {
            if( sender instanceof Player)
            {
                //TitleManager titleManager = new TitleManager();
                Player player = (Player) sender;
                player.sendTitle(TitleManager.joinTitle);
            }
        }

        if(args.length==3)
        {
            String titleName = args[0];
            String titleParameter = args[1];
            String parameterValue = args[2];

            String configPath = "titles." + titleName + "." + titleParameter;

            String message;

//            message = Boolean.toString( plugin.getConfig().isConfigurationSection("titles." + titleName + "." + titleParameter));
//            message = plugin.getConfig().get("titles.join.title").toString();

            boolean flag = ConfigManager.setTitleDeneme(configPath,parameterValue);

            message = Boolean.toString(flag);

            sender.sendMessage(message);

            if(flag)
            {
                sender.sendMessage((String) ConfigManager.getConfigValue(configPath));
            }
//            if(ConfigManager.setTitleDeneme("titles."+titleName + "." + titleParameter , parameterValue))
//            {
//                sender.sendMessage("Başarılı!");
//                return true;
//            }

//            if(titleParameter.equals("title") || titleParameter.equals("subtitle"))
//            {
//                if(Integer.TYPE.isInstance(String.class))
//                {
//
//                }
//            }

        }
        return false;
    }
}
