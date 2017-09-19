package tescologger;

/**
 * Created by sudhirkumar on 9/19/17.
 */
public class LoggerFactory {
    public static AbstractLogger getLogger(String type)
    {
        AbstractLogger logger;

        if(type == "CONSOLE") {
            logger = new ConsoleLogger(1);
        }
        else {
            logger = new FileLogger(3);
        }

        return logger;
    }
}
