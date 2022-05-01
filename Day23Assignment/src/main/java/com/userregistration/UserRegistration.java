package com.userregistration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {
    private Scanner get = new Scanner(System.in);

    public void getUserDetails() throws UserDetailException {
        getUserFirstName();
        getUserLastName();
        getUserEmailId();
        getUserPhoneNo();
        getPassWord();
    }

    private void getUserFirstName() throws UserDetailException {
        System.out.println("Enter your First Name");
        String firstName = get.next();
        UserValidater userValidater = () -> {
            Pattern pattern = Pattern.compile(UserValidater.NAME_PATTERN);
            if(!pattern.matcher(firstName).matches())
                throw new UserDetailException("Invalid First Name");};
        userValidater.validateUserDetails();
    }

    private void getUserLastName() throws UserDetailException {
        System.out.println("Enter your Last Name");
        String secondName = get.next();
        UserValidater userValidater = () -> {
            Pattern pattern = Pattern.compile(UserValidater.NAME_PATTERN);
            if(!pattern.matcher(secondName).matches())
                throw new UserDetailException("Invalid Second Name");};
        userValidater.validateUserDetails();
    }

    private void getUserPhoneNo() throws UserDetailException {
        System.out.println("Enter your Phone no");
        String phoneNo = get.next();
        UserValidater userValidater = () -> {
            Pattern pattern = Pattern.compile(UserValidater.PHONE_NO_PATTERN);
            if(!pattern.matcher(phoneNo).matches())
                throw new UserDetailException("Invalid Phone no");};
        userValidater.validateUserDetails();
    }

    private void getUserEmailId() throws UserDetailException {
        System.out.println("Enter your Email Id");
        String emailId = get.next();
        UserValidater userValidater = () -> {
            Pattern pattern = Pattern.compile(UserValidater.EMAIL_PATTERN);
            if(!pattern.matcher(emailId).matches())
                throw new UserDetailException("Invalid Email Id");};
        userValidater.validateUserDetails();
    }

    private void getPassWord() throws UserDetailException {
        System.out.println("Enter your PassWord");
        String password = get.next();
        UserValidater userValidater = () -> {
            Pattern pattern = Pattern.compile(UserValidater.PASSWORD_PATTERN);
            if(!pattern.matcher(password).matches())
                throw new UserDetailException("Invalid Password");};
        userValidater.validateUserDetails();
    }
}
