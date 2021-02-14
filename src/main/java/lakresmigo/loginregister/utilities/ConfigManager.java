package lakresmigo.loginregister.utilities;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private static JavaPlugin plugin;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public static boolean configurationSectionExist(String sectionName)
    {
        return plugin.getConfig().isConfigurationSection(sectionName);
    }


}
