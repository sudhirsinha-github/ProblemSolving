package mypool;

/**
 * Singleton Config model
 * Created by sudhirkumar on 4/10/17.
 */
public class Config {
    private static Config config;

    private Config() {
    }

    public static Config getConfig() {

        if (config == null) {
            synchronized (Config.class) {
                if (config == null)
                    config = new Config();
            }
        }


        return config;
    }

     final String HOST ="localhost";
     final Integer TIMEOUT = 3000;
}
