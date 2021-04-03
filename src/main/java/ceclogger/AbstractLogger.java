package ceclogger;


public abstract class AbstractLogger implements ILogger{

    public abstract void logMessage(Level level,String log);

    @Override
    public void info(String logMessage) {
        System.out.println("Level INFO" + logMessage);
    }

    @Override
    public void warning(String logMessage) {
        System.out.println("Level WARNING" + logMessage);

    }

    @Override
    public void error(String logMessage, Throwable throwable) {
        System.out.println("Level Error" + logMessage + "**** Error message" + throwable.getMessage());

    }

    @Override
    public void debug(String logMessage) {
        System.out.println("Level DEBUG" + logMessage);

    }

    @Override
    public void trace(String logMessage) {
        System.out.println("Level INFO" + logMessage);
    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }
}
