package ceclogger;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Calendar;

/**
 * Created by sudhirkumar on 7/18/17.
 */
public class LoggerClient {
    public static void main(String[] args) throws UnsupportedEncodingException {
       /* ConsoleLogger consoleLogger = new ConsoleLogger();
        consoleLogger.logMessage(Level.INFO, "test");*/


       FileLogger logger = new FileLogger();
            logger.logMessage(Level.Warn, "Main -"+ Calendar.getInstance().getTime().getTime());
            logger.logMessage(Level.Warn, "Main -----"+ Calendar.getInstance().getTime().getTime() );
            logger.logMessage(Level.Warn, "Main --------"+ Calendar.getInstance().getTime().getTime() );

            logger.close();
    }
}
