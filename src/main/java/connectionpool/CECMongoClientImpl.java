package connectionpool;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import model.Connection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sudhirkumar on 3/12/17.
 */
public class CECMongoClientImpl implements DBConnection {

    @Override
    public void connect(Connection connectionString) {

        MongoClient client = null;
        try {
           /* MongoClientOptions.Builder options = new MongoClientOptions.Builder();
            options.minConnectionsPerHost(1);
            options.connectionsPerHost(50)*/
            client = new MongoClient(connectionString.getHost(), connectionString.getPortNo());
            MongoDatabase db = client.getDatabase("nextgencec");
            System.out.println(db.listCollectionNames().first());
            if (db.getCollection("TestMongo") == null) {
                db.createCollection("TestMongo");
            } else {
                db.getCollection("TestMongo").drop();
                db.createCollection("TestMongo");
            }
            System.out.println(db.listCollectionNames().first());
        } finally {
            client.close();
        }
    }
}
