package dataAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class SingletonConnection {

        private static Connection singleConnection;
        public static Connection getInstance( )  {
            if(singleConnection == null){
                try {
                    singleConnection =
                            DriverManager.getConnection("jdbc:mysql://localhost:3306/commands_db",
                                    "root",
                                    "root") ;

                }
                catch (SQLException exception) {
                    System.err.println("Erreur SQL : " + exception.getMessage());
                }

            }
            return singleConnection;
        }

        public static void closeConnection(){
            try {
                if (singleConnection != null) {
                    singleConnection.close();
                }
            }
            catch (SQLException exception) {
                System.err.println("Erreur SQL : " + exception.getMessage());
            }

        }

    }


