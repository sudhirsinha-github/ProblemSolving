package lru;

import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class LoggingSSCCE {
    private static String LOG_FILE_NAME = "loggingsscce.log";
    Hashtable<String, Logger> loggers = new Hashtable<String, Logger>();
    FileHandler handler = null;

    public static void main(String[] args) throws IOException {

        LogTest lta = new LogTestA();
        lta.doLog();
    }

    public Logger getLogger(String loggerName) throws IOException {
        if ( loggers.get(loggerName) != null )
            return loggers.get(loggerName);

        if ( handler == null ) {
            boolean append = true;
            handler = new FileHandler(LoggingSSCCE.LOG_FILE_NAME, append);
            handler.setFormatter(new SimpleFormatter());
        }

        Logger logger = Logger.getLogger(loggerName);
        logger.setLevel(Level.ALL);
        logger.addHandler(handler);
        loggers.put(loggerName, logger);
        return logger;
    }
}

interface LogTest {
    public void doLog();
}


class LogTestA implements LogTest {
    @Override
    public void doLog() {
        LoggingSSCCE loggingSSCCE = new LoggingSSCCE();

        try {
            loggingSSCCE.getLogger(LogTestA.class.getName()).log(Level.INFO, "LogTestA.doLog()");
        }
        catch (Exception ex){

        }
    }
}