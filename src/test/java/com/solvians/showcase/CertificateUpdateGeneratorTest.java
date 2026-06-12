package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CertificateUpdateGeneratorTest {

    @Test
    public void generateQuotes() {
        int threadCount = 10;
        int quotesInTotal = 100;
        CertificateUpdateGenerator certificateUpdateGenerator = new CertificateUpdateGenerator(
                threadCount, quotesInTotal);
        Stream<CertificateUpdate> quotes = certificateUpdateGenerator.generateQuotes();
        assertNotNull(quotes);
        // Need clarification: 1000 or 100? Assuming, expected is: quotes, so coding for 100 quote generation.
        assertEquals(100, quotes.count());
    }
}
