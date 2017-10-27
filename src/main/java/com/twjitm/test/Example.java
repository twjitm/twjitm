package com.twjitm.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 文江 on 2017/10/25.
 */
public class Example {

    public static void main(String[] args) {
        getStringMore("2[abb]c");
    }


    public static String getStringMore(String value) {
        String regex = "(?<=\\[)(\\S+)(?=\\])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        matcher.find();
        System.out.println(matcher.group());
        String regEx = "[^0-9]";
        pattern = Pattern.compile(regEx);
        pattern.matcher(value);
        

        return null;
    }
}
