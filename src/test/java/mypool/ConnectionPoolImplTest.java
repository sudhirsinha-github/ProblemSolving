package mypool;

import com.mongodb.MongoClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sudhirkumar on 4/12/17.
 */
public class ConnectionPoolImplTest {

    ConnectionPoolFactory factory =null;
    ConnectionPool pool = null;

    @Before
    public void setUpConnectionPool() throws InterruptedException
    {
        factory = new ConnectionPoolFactory();
        pool = factory.getConnectionPool(4);
    }


    @Test
    public void getConnPoolOnALLUSEIntegrationTest() throws InterruptedException{


        MongoClient client1 = null;
        MongoClient client2 = null;
        MongoClient client3 = null;
        MongoClient client4 = null;
        MongoClient client5 = null;


        client1 = pool.getConnection();
        client2 = pool.getConnection();
        client3 = pool.getConnection();
        client4 = pool.getConnection();
        Assert.assertEquals(pool.getAvailableConnections(), 0);


        pool.releaseConnection(client1);
        pool.releaseConnection(client2);
        pool.releaseConnection(client3);
        pool.releaseConnection(client4);

        Assert.assertEquals(pool.getAvailableConnections(), 4);
    }



}