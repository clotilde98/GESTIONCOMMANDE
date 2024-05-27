package test;

import exceptionPackage.CharOverflowException;
import exceptionPackage.CustomExceptions;
import exceptionPackage.InvalidEmailFormatException;
import exceptionPackage.InvalidPasswordFormatException;
import org.junit.jupiter.api.Test;
import viewPackage.CustomUtilities;

import static org.junit.jupiter.api.Assertions.*;

class CustomUtilitiesTest {

    @Test
    void validateEmail() throws CustomExceptions, InvalidEmailFormatException {
        assertEquals("test@te.te",CustomUtilities.validateEmail("test@te.te",""));
    }

    @Test
    void validateEmailException(){
        assertThrows(InvalidEmailFormatException.class, () -> {CustomUtilities.validateEmail("test","");});
    }

    @Test
    void validatePassword() throws InvalidPasswordFormatException, CustomExceptions {
        assertEquals("T&st1234",CustomUtilities.validatePassword("T&st1234",""));
    }

    @Test
    void validatePasswordCustomException(){
        assertThrows(CustomExceptions.class, () -> {CustomUtilities.validatePassword("","");});
    }

    @Test
    void validatePasswordException(){
        assertThrows(InvalidPasswordFormatException.class, () -> {CustomUtilities.validatePassword("test","");});
    }
    @Test
    void validateNumericField() throws CustomExceptions {
        assertEquals(42,CustomUtilities.validateNumericField("42",""));
    }

    @Test
    void validateNumericFieldException(){
        assertThrows(CustomExceptions.class, () -> {CustomUtilities.validateNumericField("-42","");});
        assertThrows(CustomExceptions.class, () -> {CustomUtilities.validateNumericField("test","");});
    }

    @Test
    void validateCharNumber() throws CharOverflowException {
        assertEquals("test",CustomUtilities.validateCharNumber("test",5,""));
    }

    @Test
    void validateCharNumberException(){
        assertThrows(CharOverflowException.class, () -> {CustomUtilities.validateCharNumber("test",3,"");});
    }
}