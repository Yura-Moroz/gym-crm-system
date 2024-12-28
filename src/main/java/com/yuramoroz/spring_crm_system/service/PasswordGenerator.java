package com.yuramoroz.spring_crm_system.service;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final SecureRandom random = new SecureRandom();
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = UPPER.toLowerCase();
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+{}[]";

    private static final String ALL_CHARS = UPPER + LOWER + DIGITS + SPECIAL_CHARS;

    public static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int randIndex = random.nextInt(chars.length);
            char temp = chars[i];
            chars[i] = chars[randIndex];
            chars[randIndex] = temp;
        }
        return new String(chars);
    }
}
