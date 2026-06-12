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
        return 0; // TODO: calculate check digit
    }
}