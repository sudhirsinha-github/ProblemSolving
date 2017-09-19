package ceclogger;

/**
 * Created by sudhirkumar on 7/18/17.
 */

enum Level{
    INFO(1),
    Warn(2),
    Error(3),
    Trace(4),
    Debug(5);

    private final int value;

    private Level(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

 public interface ILogger {
     void info(String logMessage);

     void warning(String logMessage);

     void error(String logMessage, Throwable throwable);

     void debug(String logMessage);

     void trace(String logMessage);

     boolean isDebugEnabled();
 }

