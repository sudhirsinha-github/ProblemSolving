package mypool;

import com.mongodb.MongoClient;

/**
 * Created by sudhirkumar on 4/10/17.
 */
public class ConnectionPoolFactory {

    public ConnectionPool getConnectionPool(int size){

        return new ConnectionPoolImpl(size);
    }
}
