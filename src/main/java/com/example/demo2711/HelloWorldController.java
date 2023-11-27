package com.example.demo2711;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        System.out.println("Received request for /hello");
        String response = "Hello, Santander!";
        System.out.println("Sending response: " + response);
        return response;
    }

    @GetMapping("/reverse")
    public String reverseString(@RequestParam("input") String input) {
        System.out.println("Received request for /reverse with input: " + input);
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        String response = reversed.toString();
        System.out.println("Sending response: " + response);
        return response;
    }

    @GetMapping("/remove-vowels")
    public String removeVowels(@RequestParam("input") String input) {
        System.out.println("Received request for /remove-vowels with input: " + input);
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (vowels.indexOf(c) == -1) {
                result.append(c);
            }
        }
        String response = result.toString();
        System.out.println("Sending response: " + response);
        return response;
    }

    @GetMapping("/is-palindrome")
    public boolean isPalindrome(@RequestParam("input") String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }
}

