package businessPackage;

import dataAccessPackage.SingletonConnection;
import exceptionPackage.DataAccessException;

public class ConnectionManager {
    public void closeConnection() throws DataAccessException {
        SingletonConnection.closeConnection();
    }
}
