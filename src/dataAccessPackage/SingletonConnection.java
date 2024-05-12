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
                    System.out.println("connexion réussi");
                }
                catch (SQLException exception) {
                    System.err.println("Erreur SQL : " + exception.getMessage());
                }

            }
            return singleConnection;
        }

    }


