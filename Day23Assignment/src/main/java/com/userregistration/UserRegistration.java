package com.userregistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
interface UserValidater {
    String NAME_PATTERN = "^([A-Z])([a-z]{2})([a-z]*)$";
    String EMAIL_PATTERN = "^([a-z0-9]+)([.+_-]?[a-z0-9]+)?@([a-z0-9]+)(.[a-z]{2,4})?(.[a-z]{2,4})$";
    String PHONE_NO_PATTERN = "^91-[0-9]{10}$";
    String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=[^!@#$%^&+=]*[!@#$%^&+=][^!@#$%^&+=]*$).{8}$";

    void validate(String s) throws UserDetailException;
}

public class UserRegistration {
    private Scanner get = new Scanner(System.in);

    public void getUserDetails() throws UserDetailException {
        getUserFirstName();
        getUserLastName();
        getUserEmailId();
        getUserPhoneNo();
        getPassWord();
    }

    UserValidater nameValidator = s -> {
        Pattern pattern = Pattern.compile(UserValidater.NAME_PATTERN);
        if(!pattern.matcher(s).matches())
            throw new UserDetailException("Invalid Name");};

    UserValidater phoneNoValidator = s -> {
        Pattern pattern = Pattern.compile(UserValidater.PHONE_NO_PATTERN);
        if(!pattern.matcher(s).matches())
            throw new UserDetailException("Invalid Phone no");};

    UserValidater emailValidator = s -> {
        Pattern pattern = Pattern.compile(UserValidater.EMAIL_PATTERN);
        if(!pattern.matcher(s).matches())
            throw new UserDetailException("Invalid Email Id");};

    UserValidater passwordValidator = s -> {
        Pattern pattern = Pattern.compile(UserValidater.PASSWORD_PATTERN);
        if(!pattern.matcher(s).matches())
            throw new UserDetailException("Invalid Password");};

    private void getUserFirstName() throws UserDetailException {
        System.out.println("Enter your First Name");
        nameValidator.validate(get.next());
    }

    private void getUserLastName() throws UserDetailException {
        System.out.println("Enter your Last Name");
        nameValidator.validate(get.next());
    }

    private void getUserPhoneNo() throws UserDetailException {
        System.out.println("Enter your Phone no");
        phoneNoValidator.validate(get.next());
    }

    private void getUserEmailId() throws UserDetailException {
        System.out.println("Enter your Email Id");
        emailValidator.validate(get.next());
    }

    private void getPassWord() throws UserDetailException {
        System.out.println("Enter your PassWord");
        passwordValidator.validate(get.next());
    }
}
