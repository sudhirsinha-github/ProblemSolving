package adalogger;

public abstract class AbstractLogger{
   public enum Level{
      INFO(1),
      DEBUG(2),
      ERROR(3);

       private final int value;

      private Level(int value) {
         this.value = value;
      }

      public int getValue() {
         return value;
      }
   }

    int level;

   //next element in chain or responsibility
   AbstractLogger nextLogger;

   public void setNextLogger(AbstractLogger logger){
      nextLogger = logger;
   }

   public void logMessage(int level, String message){
      if(this.level <= level){
         write(message);
      }
      if(nextLogger !=null){
         nextLogger.logMessage(level, message);
      }
   }

   abstract protected void write(String message);

}



