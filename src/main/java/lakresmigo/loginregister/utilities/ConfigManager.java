package lakresmigo.loginregister.utilities;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private static JavaPlugin plugin;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public static boolean setTitleDeneme(String path, Object value) {
//        if(configurationSectionExist(path))
//        {
//            plugin.getConfig().set(path,value);
//        }

        if (plugin.getConfig().isSet(path) == false)
            return false;
        setConfigValue(path,value);
        return true;

    }

    public static boolean configurationSectionExist(String sectionName) {
        return plugin.getConfig().isConfigurationSection(sectionName);
    }

    public static boolean configVariableExist(String path)
    {
        return plugin.getConfig().isSet(path);
    }

    public static void setConfigValue(String path, Object value) {
        plugin.getConfig().set(path, value);
        plugin.saveConfig();
    }

    public static Object getConfigValue(String path) {
        return plugin.getConfig().get(path);
    }

    public static String getConfigValueString(String path)
    {
        return plugin.getConfig().getString(path);
    }

    public static int getConfigValueInt(String path)
    {
        return  plugin.getConfig().getInt(path);
    }

}
