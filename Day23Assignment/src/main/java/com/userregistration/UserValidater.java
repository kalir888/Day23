package com.userregistration;

public interface UserValidater {
    String NAME_PATTERN = "^([A-Z])([a-z]{2})([a-z]*)$";
    String EMAIL_PATTERN = "^([a-z0-9]+)([.+_-]?[a-z0-9]+)?@([a-z0-9]+)(.[a-z]{2,4})?(.[a-z]{2,4})$";
    String PHONE_NO_PATTERN = "^91-[0-9]{10}$";
    String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=[^!@#$%^&+=]*[!@#$%^&+=][^!@#$%^&+=]*$).{8}$";

    void validateUserDetails() throws UserDetailException;
}
