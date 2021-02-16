package lakresmigo.loginregister.utilities;

import com.destroystokyo.paper.Title;

public class TitleManager {

//    public static void showTitle(Player player,String titleName) {
//        Title title = new Title("adwawd", "awdd", );
//        player.sendTitle("");
//    }

    public static Title joinTitle = titleInitializer("join");
    public static Title registerTitle = titleInitializer("register");
    public static Title loginTitle = titleInitializer("login");
    public static Title loginSuccessTitle = titleInitializer("loginsuccess");

//    public TitleManager() {
//        joinTitle = titleInitializer("join");
//        registerTitle = titleInitializer("register");
//        loginTitle = titleInitializer("login");
//    }

    private static Title titleInitializer(String titleName) {
        String path = "titles." + titleName + ".";
        Title title = new Title(
                ConfigManager.getConfigValueString(path + "title"),
                ConfigManager.getConfigValueString(path + "subtitle"),
                ConfigManager.getConfigValueInt(path + "fadein"),
                ConfigManager.getConfigValueInt(path + "stay"),
                ConfigManager.getConfigValueInt(path + "fadeout")
        );
        return title;
    }

//
//    public static Title getJoinTitle()
//    {
//
//    }

//    public static void setJoinParameter(String parameter, Object value) {
//        ConfigManager.setConfigValue("titles.join." + parameter, value);
//
//    }
//
//    public static void setRegisterParameter(String parameter, Object value) {
//        ConfigManager.setConfigValue("titles.register." + parameter, value);
//    }
//
//    public static void setLoginParameter(String parameter, Object value) {
//        ConfigManager.setConfigValue("titles.login." + parameter, value);
//    }
//
//    public static Object getJoinParameter(String parameter) {
//        return ConfigManager.getConfigValue("titles.join." + parameter);
//    }
//
//    public static Object getRegisterParameter(String parameter) {
//        return ConfigManager.getConfigValue("titles.register." + parameter);
//    }
//
//    public static Object getLoginParameter(String parameter) {
//        return ConfigManager.getConfigValue("titles.login." + parameter);
//    }
}
