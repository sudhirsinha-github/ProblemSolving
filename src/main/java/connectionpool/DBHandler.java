package connectionpool;

import model.Connection;

/**
 * Created by sudhirkumar on 3/12/17.
 */
public class DBHandler {
    public static void main(String[] args) {

        Connection connection = new Connection();
        connection.setHost("localhost");
        connection.setPortNo(27017);

        DBConnection dbConnection = new CECMongoClient();
        dbConnection.connect(connection);
    }
}
