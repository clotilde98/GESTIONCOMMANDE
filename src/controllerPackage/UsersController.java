package controllerPackage;

import exceptionPackage.InvalidEmailFormatException;
import exceptionPackage.InvalidPasswordFormatException;
import exceptionPackage.customExceptions;
import modelPackage.UsersModel;

public class UsersController {

    private UsersModel usersModel;

    public UsersController(UsersModel usersModel) {
        this.usersModel = usersModel;
    }

    public void addUser(String firstName, String lastName, String email, String phoneNumber, String password,
                        char gender, int year, int month, int dayOfMonth, boolean isAdmin, boolean isAdherent,
                       String street, int streetNumber, int numberSponsorised, String locality) throws customExceptions, InvalidPasswordFormatException, InvalidEmailFormatException {
        try {
            usersModel = new UsersModel(firstName, lastName, email, phoneNumber, password, gender, year, month,
                    dayOfMonth, isAdmin, isAdherent, street, streetNumber, numberSponsorised,locality);
            usersModel.addUserToDatabase();
        } catch (customExceptions | InvalidEmailFormatException | InvalidPasswordFormatException e) {
            throw e;        }
    }
}