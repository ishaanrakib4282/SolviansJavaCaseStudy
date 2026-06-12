package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsinGeneratorTest {

    @Test
    void checkIfIsinGenerationIsCorrect() {
        IsinGenerator generator = new IsinGenerator();

        String isin = generator.generate();

        assertNotNull(isin);
        assertEquals(12, isin.length());

        String isinRegex = "[A-Z]{2}[A-Z0-9]{9}[0-9]";
        assertTrue(isin.matches(isinRegex));
    }

    @Test
    void calculateCheckDigit() {
        IsinGenerator generator = new IsinGenerator();

        assertEquals(6, generator.calculateCheckDigit("DE123456789"));
    }
}