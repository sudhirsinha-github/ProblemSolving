package mypool;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoClientOptions;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by sudhirkumar on 4/10/17.
 */
 class ConnectionPoolImpl implements ConnectionPool {

    private static final int DEFAULT_POOL_SIZE = 5;

    private static BlockingQueue<MongoClient> blockingQueue ;

    public synchronized int getAvailableConnections() {
        return blockingQueue.size();
    }

    public ConnectionPoolImpl(int size) {
        int MAX_SIZE = (size != 0) ? size : DEFAULT_POOL_SIZE;
        if(blockingQueue == null) {
            blockingQueue = new ArrayBlockingQueue<MongoClient>(MAX_SIZE);
        }

        for (int i = 0; i < MAX_SIZE; i++) {
            try {
                blockingQueue.put(createConnection());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (MongoClientException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public MongoClient getConnection() throws InterruptedException {
        System.out.println("size before getting connection" + blockingQueue.size());
        MongoClient con = null;
        if (getAvailableConnections() != 0) {
            con = blockingQueue.take();
        } else {
            System.out.println("All resources under utilization ,Release old one !!!");
        }

        System.out.println("size after getting connection" + blockingQueue.size());

        return (con);
    }

    /** reuse released connection
     * */
    @Override
    public void releaseConnection(MongoClient client) throws InterruptedException{
        System.out.println("size before releasing connection" + blockingQueue.size());
        blockingQueue.put(client);
        System.out.println("size after releasing connection" + blockingQueue.size());
    }

    private MongoClient createConnection()
    {
        // this can be moved to dao package
        Config config = Config.getConfig();
        return new MongoClient(config.HOST,
                new MongoClientOptions.Builder().connectTimeout(config.TIMEOUT).build());
    }

    @Override
    public void close() throws IOException {
        Iterator<MongoClient> iterator = blockingQueue.iterator();

        while (iterator.hasNext()) {
            MongoClient client = iterator.next();
            //System.out.println(client.hashCode());
            client.close();
        }

        System.out.println("Closeee");
    }
}


    public static void main(String[] args) throws InterruptedException,IOException {
        ConnectionPoolFactory factory = new ConnectionPoolFactory();
        ConnectionPool pool = factory.getConnectionPool(4);

        MongoClient client1 = null;
        MongoClient client2 = null;
        MongoClient client3 = null;
        MongoClient client4 = null;
        MongoClient client5 = null;

            client1 = pool.getConnection();
            client2 = pool.getConnection();
            client3 = pool.getConnection();
            client4 = pool.getConnection();
            System.out.println(pool.getAvailableConnections());
            //client5 = pool.getConnection();
            pool.releaseConnection(client1);
            pool.releaseConnection(client2);
            pool.releaseConnection(client3);
            pool.releaseConnection(client4);
            System.out.println(pool.getAvailableConnections());

            pool.close();
              /* client1 = pool.getConnection();
        pool.close();*/


        /*} catch (Exception e) {
            System.out.println("Error occured >>> " + e);
        } finally {
            try {
                pool.close();
            }catch(IOException ix){
                System.out.println("Broken!!!");
            }

        }*/
    }
}