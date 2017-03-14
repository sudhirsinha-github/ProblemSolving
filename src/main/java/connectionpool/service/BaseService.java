package connectionpool.service;

import com.mongodb.*;

import java.util.Date;
import java.util.List;

/**
 * Created by sudhirkumar on 3/12/17.
 */
public class BaseService {
    private MongoClient mongoClient = new MongoClient();
    private String jsonData;
    private String collection;
    private DB database;

    BaseService(String jsonData, String collection) {
        this.jsonData = jsonData;
        this.collection = collection;
    }
    /*
        public void setUp()
        {
            MongoClient client = new MongoClient();
        }*/

    public boolean insertDocument()
    {
        database = mongoClient.getDB("nextgencec");

        if (this.database.getCollection(this.collection) == null) {
            this.database.getCollection(this.collection);
        }

        DBCollection coll = this.database.getCollection(this.collection);
        BasicDBObject obj = BasicDBObject.parse(this.jsonData);
        WriteResult result = coll.insert(obj);
        System.out.println(result.wasAcknowledged());


        return result.wasAcknowledged();
    }
}
