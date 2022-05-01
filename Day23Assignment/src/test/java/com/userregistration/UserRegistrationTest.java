package com.userregistration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    @Test
    public void givenName_WhenValid_NotThrowException() {
        Assertions.assertDoesNotThrow(() -> {
                    UserValidator userValidator = new UserValidator();
                    userValidator.validateName("Kalimuthu");});
    }

    @Test
    public void givenName_WhenShort_ThrowMyCustomException() {
        Exception exception = Assertions.assertThrows(
                UserDetailException.class, () -> {
                    UserValidator userValidator = new UserValidator();
                    userValidator.validateName("Ka");});
        Assertions.assertEquals("Invalid Name",exception.getMessage());
    }

    @Test
    public void givenEmail_WhenValid_NotThrowException() {
        Assertions.assertDoesNotThrow(() -> {
            UserValidator userValidator = new UserValidator();
            userValidator.validateEmailAddress("kalir888@gmail.com");});
    }

    @Test
    public void givenEmail_WhenNotValid_ThrowMyCustomException() {
        Exception exception = Assertions.assertThrows(
                UserDetailException.class, () -> {
                    UserValidator userValidator = new UserValidator();
                    userValidator.validateEmailAddress("kalir888@@gmail.com");
                });
        Assertions.assertEquals("Invalid Email Id",exception.getMessage());
    }

    @Test
    public void givenPhoneNo_WhenValid_NotThrowException() {
        Assertions.assertDoesNotThrow(() -> {
                    UserValidator userValidator = new UserValidator();
                    userValidator.validatePhoneNo("91 9790295762");});
    }

    @Test
    public void givenPhoneNO_WhenNoCountryCode_ThrowMyCustomException() {
        Exception exception = Assertions.assertThrows(
                UserDetailException.class, () -> {
                    UserValidator userValidator = new UserValidator();
                    userValidator.validatePhoneNo("9790295762");
                });
        Assertions.assertEquals("Invalid Phone No",exception.getMessage());
    }

    @Test
    public void givenPassWord_WhenValid_NotThrowException() {
        Assertions.assertDoesNotThrow(() -> {
                    UserValidator userValidator = new UserValidator();
                    userValidator.validatePassword("K@lir888");});
    }

    @Test
    public void givenPassWord_WhenHaveMoreCharacters_ThrowMyCustomException() {
        Exception exception = Assertions.assertThrows(
                UserDetailException.class, () -> {
                    UserValidator userValidator = new UserValidator();
                    userValidator.validatePassword("K@lir8888");
                });
        Assertions.assertEquals("Invalid Password",exception.getMessage());
    }

    public void passedEmail_WhenValid_NotThrowException(String email) {
        Assertions.assertDoesNotThrow(() -> {
                    UserValidator userValidator = new UserValidator();
                    userValidator.validateEmailAddress(email);});
    }

    public void passedEmail_WhenNotValid_ThrowMyCustomException(String email) {
        Exception exception = Assertions.assertThrows(
                UserDetailException.class, () -> {
                    UserValidator userValidator = new UserValidator();
                    userValidator.validateEmailAddress(email);
                });
        Assertions.assertEquals("Invalid Email Id",exception.getMessage());
    }

    @Test
    public void multipleEmail_WhenValid_NotThrowException() {
        EmailStorage emailStorage = new EmailStorage();
        emailStorage.addEmails();
        for(String email: emailStorage.validEmailIds) {
            passedEmail_WhenValid_NotThrowException(email);
        }
    }

    @Test
    public void multipleEmail_WhenNotValid_ThrowMyCustomException() {
        EmailStorage emailStorage = new EmailStorage();
        emailStorage.addEmails();
        for(String email: emailStorage.inValidEmailIds) {
            passedEmail_WhenNotValid_ThrowMyCustomException(email);
        }
    }
}
