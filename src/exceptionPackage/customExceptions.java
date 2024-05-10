package exceptionPackage;

public class customExceptions extends Exception{

         public customExceptions(String fieldName) {
            super(fieldName + " est obligatoire.");
        }
    }

