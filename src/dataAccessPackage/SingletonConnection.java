package dataAccessPackage;

import exceptionPackage.DataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class SingletonConnection {

        private static Connection singleConnection;
        public static Connection getInstance( ) throws DataAccessException {
            if(singleConnection == null){
                try {
                    singleConnection =
                            DriverManager.getConnection("jdbc:mysql://localhost:3306/commands_db",
                                    "root",
                                    "root") ;

                }
                catch (SQLException exception) {
                    throw new DataAccessException(exception.getMessage());
                }

            }
            return singleConnection;
        }

        public static void closeConnection() throws DataAccessException {
            try {
                if (singleConnection != null) {
                    singleConnection.close();
                }
            }
            catch (SQLException exception) {
                throw new DataAccessException(exception.getMessage());
            }

        }

    }


