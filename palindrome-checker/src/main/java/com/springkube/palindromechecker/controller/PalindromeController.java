package com.springkube.palindromechecker.controller;

import com.springkube.palindromechecker.service.PalindromeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/check")
public class PalindromeController {

    private final PalindromeService palindromeService;

    private static final Logger logger = LogManager.getLogger(PalindromeController.class);

    @Autowired
    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @GetMapping(value = "/{string}")
    public ResponseEntity<String> checkStatus(@PathVariable String string) {
        logger.info("PalindromeController => value: {} received!", string);
        String data = palindromeService.checkPalindrome(string);
        return ResponseEntity.ok(data);
    }
}
