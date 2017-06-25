package mypool;


import com.mongodb.MongoClient;

import java.io.Closeable;

/**
 * Created by sudhirkumar on 4/10/17.
 */
public interface ConnectionPool extends Closeable{ //y to implement to Closeable ?? to overwrite the close method
    // std .to close all connection as per given guidelines
 // we will not get benefit of AOP >>

     int getAvailableConnections();

        MongoClient getConnection() throws InterruptedException;
    // void initializePool(int size);
    void releaseConnection(MongoClient client) throws InterruptedException;
//    void shutDownConnectionPool();
}
