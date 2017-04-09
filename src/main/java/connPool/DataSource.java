package connPool;

import com.mongodb.connection.Connection;

import java.sql.SQLException;

/**
 * Created by sudhirkumar on 4/5/17.
 */
public class DataSource {


    static MongoConnectionPool pool = new MongoConnectionPool();

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = pool.getConnectionFromPool();
        return connection;
    }

    public static void returnConnection(Connection connection) {
        pool.returnConnectionToPool(connection);
    }
}


class TestMe{

    public static void main(String[] args) {
     DataSource dataSource = new DataSource();
     try {
         dataSource.getConnection();
     }
     catch (Exception ex)
     {
         System.out.println("excep -- " + ex);
     }

    }
}
