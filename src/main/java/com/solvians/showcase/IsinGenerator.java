package com.solvians.showcase;

import java.util.concurrent.ThreadLocalRandom;

public class IsinGenerator {

    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generate() {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        StringBuilder base = new StringBuilder();

        // adding 2 capital letters
        base.append(LETTERS.charAt(random.nextInt(LETTERS.length())))
                .append(LETTERS.charAt(random.nextInt(LETTERS.length())));

        // adding 9 capital-letters/numbers
        for (int i = 0; i < 9; i++) {
            base.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));
        }

        String isinWithoutCheckDigit = base.toString();
        int checkDigit = calculateCheckDigit(isinWithoutCheckDigit);

        return base.append(checkDigit).toString();
    }

    public int calculateCheckDigit(String isinWithoutCheckDigit) {

        StringBuilder numeric = new StringBuilder();

        // convert letter to number if there's any
        for (char c : isinWithoutCheckDigit.toCharArray()) {
            if (Character.isDigit(c)) {
                numeric.append(c);
            } else {
                numeric.append(c - 'A' + 10);
            }
        }

        // all the digits are here
        String digits = numeric.toString();

        // double each digit (only odd positioned) starting from right
        StringBuilder transformed = new StringBuilder();
        for (int i = digits.length() - 1, j = 1; i >= 0; i--, j++) {
            int digit = digits.charAt(i) - '0';

            if (j % 2 == 1) {
                digit = digit * 2;
            }
            transformed.append(digit);
        }

        // calculate sum
        int sum = 0;
        for (int i = 0; i < transformed.length(); i++) {
            sum += transformed.charAt(i) - '0';
        }

        int checkDigit = 10 - (sum % 10);
        return checkDigit % 10; // mod by 10 again because sum can be multiple of 10
    }
}
