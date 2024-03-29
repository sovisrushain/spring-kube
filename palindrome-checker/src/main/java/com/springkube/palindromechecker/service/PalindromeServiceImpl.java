package com.springkube.palindromechecker.service;

import com.springkube.palindromechecker.controller.PalindromeController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    private static final String isPalindrome = "Given String is a Palindrome";
    private static final String isNotPalindrome = "Given String is not a Palindrome";

    private static final Logger logger = LogManager.getLogger(PalindromeController.class);

    @Override
    public String checkPalindrome(String string) {

        var regex = "^[a-z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if(!matcher.matches()) {
            logger.error("PalindromeServiceImpl => value: {} is not a valid string form for this function", string);
            return "Invalid String format";
        }

        String reversed = new StringBuilder(string).reverse().toString();
        logger.info("PalindromeServiceImpl => reversed string: {}", reversed);
        return (string.equals(reversed)) ? isPalindrome : isNotPalindrome;
    }
}
