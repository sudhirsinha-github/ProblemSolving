package connectionpool;

import model.Connection;

/**
 * Created by sudhirkumar on 3/12/17.
 */
public interface DBConnection {
    public void connect(Connection connectionString);
}
