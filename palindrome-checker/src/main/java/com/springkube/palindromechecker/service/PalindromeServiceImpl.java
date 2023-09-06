package com.springkube.palindromechecker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    private static final String isPalindrome = "Given String is a Palindrome";
    private static final String isNotPalindrome = "Given String is not a Palindrome";

    private static final Logger logger = LoggerFactory.getLogger(PalindromeServiceImpl.class);

    @Override
    public String checkPalindrome(String string) {
        String reversed = new StringBuilder(string).reverse().toString();
        logger.info("reversed string: {}", reversed);
        return (string.equals(reversed)) ? isPalindrome : isNotPalindrome;
    }
}
