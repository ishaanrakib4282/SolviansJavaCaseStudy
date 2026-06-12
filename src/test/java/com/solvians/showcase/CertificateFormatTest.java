package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CertificateFormatTest {
    @Test
    void shouldGenerateCertificatesInCorrectCommaSeparatedFormat() {

        CertificateUpdateGenerator generator = new CertificateUpdateGenerator(2, 10);

        List<String> certificateLines = generator.generateQuotes()
                .map(CertificateUpdate::toString)
                .collect(Collectors.toList());

        assertEquals(10, certificateLines.size());

        for (String certificate : certificateLines) {
            assertValidCertificate(certificate);
        }
    }

    private void assertValidCertificate(String line) {
        String[] fields = line.split(",");

        assertEquals(6, fields.length);

        assertTrue(fields[0].matches("\\d+")); // timestamp
        assertTrue(fields[1].matches("[A-Z]{2}[A-Z0-9]{10}")); // ISIN
        assertTrue(fields[2].matches("\\d+\\.\\d{2}")); // bid price
        assertTrue(fields[3].matches("\\d+")); // bid size
        assertTrue(fields[4].matches("\\d+\\.\\d{2}")); // ask price
        assertTrue(fields[5].matches("\\d+")); // ask size
    }
}
