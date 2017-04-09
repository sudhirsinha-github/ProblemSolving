package connPool;

/**
 * Created by sudhirkumar on 4/4/17.
 */
public class Configuration {

    public String DB_USER_NAME ;

    public String DB_PASSWORD ;

    public String DB_URL;

    public String DB_DRIVER;

    public Integer DB_MAX_CONNECTIONS;

    public Configuration(){
        init();
    }

    private static Configuration configuration = new Configuration();

    public static Configuration getInstance(){
        return configuration;
    }

    private void init(){
        DB_USER_NAME = "root";
        DB_PASSWORD = "root";
        DB_URL = "mongodb://127.0.0.1:27017";
        DB_DRIVER = "mongodb.jdbc.MongoDriver";
        DB_MAX_CONNECTIONS = 5;
    }
}
