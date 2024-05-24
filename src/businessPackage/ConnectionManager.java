package businessPackage;

import dataAccessPackage.SingletonConnection;

public class ConnectionManager {
    public void closeConnection(){
        SingletonConnection.closeConnection();
    }
}
