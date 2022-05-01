package com.userregistration;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailStorage {
    List<String> emailIds = new ArrayList<>();
    List<String> validEmailIds = new ArrayList<>();
    List<String> inValidEmailIds = new ArrayList<>();
    public void addEmails() {

        emailIds.add("abc@yahoo.com");
        emailIds.add("abc-100@yahoo.com");
        emailIds.add("abc.100@yahoo.com");
        emailIds.add("abc111@abc.com");
        emailIds.add("abc-100@abc.net");
        emailIds.add("abc.100@abc.com.au");
        emailIds.add("abc@1.com");
        emailIds.add("abc@gmail.com.com");
        emailIds.add("abc+100@gmail.com");
        emailIds.add("abc");
        emailIds.add("abc@.com.my");
        emailIds.add("abc123@gmail.a");
        emailIds.add("abc123@.com");
        emailIds.add("abc123@.com.com");
        emailIds.add(".abc@abc.com");
        emailIds.add("abc()*@gmail.com");
        emailIds.add("abc@%*.com");
        emailIds.add("abc..2002@gmail.com");
        emailIds.add("abc.@gmail.com");
        emailIds.add("abc@abc@gmail.com");
        emailIds.add("abc@gmail.com.1a");
        emailIds.add("abc@gmail.com.aa.au");

        Pattern email = Pattern.compile("^([a-z0-9]+)([.+_-]?[a-z0-9]+)?@([a-z0-9]+)(.[a-z]{2,4})?(.[a-z]{2,4})$");

        for(String eMail: emailIds) {
            Matcher matchEmail = email.matcher(eMail);
            if(matchEmail.find())
                validEmailIds.add(eMail);
            else
                inValidEmailIds.add(eMail);
        }
    }
}
