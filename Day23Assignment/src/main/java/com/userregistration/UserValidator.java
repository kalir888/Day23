package com.userregistration;

import java.util.regex.Pattern;

public class UserValidator {

    private static final String NAME_PATTERN = "^([A-Z])([a-z]{2})([a-z]*)$";
    private static final String EMAIL_PATTERN = "^([a-z0-9]+)([.+_-]?[a-z0-9]+)?@([a-z0-9]+)(.[a-z]{2,4})?(.[a-z]{2,4})$";
    private static final String PHONE_NO_PATTERN = "^91 [0-9]{10}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=[^!@#$%^&+=]*[!@#$%^&+=][^!@#$%^&+=]*$).{8}$";

    public void validateName(String name) throws UserDetailException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        if(!pattern.matcher(name).matches())
            throw new UserDetailException("Invalid Name");
    }

    public void validateEmailAddress(String email) throws UserDetailException {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if(!pattern.matcher(email).matches())
            throw new UserDetailException("Invalid Email Id");
    }

    public void validatePhoneNo(String number) throws UserDetailException {
        Pattern pattern = Pattern.compile(PHONE_NO_PATTERN);
        if(!pattern.matcher(number).matches())
            throw new UserDetailException("Invalid Phone No");
    }

    public void validatePassword(String passWord) throws UserDetailException {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        if(!pattern.matcher(passWord).matches())
            throw new UserDetailException("Invalid Password");
    }
}
