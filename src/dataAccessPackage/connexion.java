package dataAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class connexion {

        private static Connection connexionUnique;
        public static Connection getInstance( )  {
            if(connexionUnique == null){
                try {
                    Connection connection =
                            DriverManager.getConnection("jdbc:mysql://localhost:3306/commande",
                                    "root",
                                    "root") ;
                    System.out.println("connexion reussi");
                }
                catch (SQLException exception) {
                    System.err.println("Erreur SQL : " + exception.getMessage());
                }

            }
            return connexionUnique;
        }

    }


