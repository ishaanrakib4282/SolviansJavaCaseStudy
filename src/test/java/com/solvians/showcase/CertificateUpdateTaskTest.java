package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CertificateUpdateTaskTest {

    @Test
    void checkIfCertificateIsInCorrectFormat() throws Exception {

        long before = System.currentTimeMillis();

        CertificateUpdateTask task = new CertificateUpdateTask();
        CertificateUpdate certificate = task.call();

        long after = System.currentTimeMillis();

        assertValidCertificate(certificate, before, after);
    }

    @Test
    void shouldGenerateValidCertificatesMultipleTimes() throws Exception {

        CertificateUpdateTask task = new CertificateUpdateTask();

        int numberOfCertificates = 1000;

        for (int i = 0; i < numberOfCertificates; i++) {

            long before = System.currentTimeMillis();

            CertificateUpdate certificate = task.call();

            long after = System.currentTimeMillis();

            assertValidCertificate(certificate, before, after);
        }
    }

    private void assertValidCertificate(CertificateUpdate certificate, long before, long after) {

        assertNotNull(certificate);
        assertNotNull(certificate.getIsin());

        assertTrue(
                certificate.getTimestamp() >= before && certificate.getTimestamp() <= after,
                "Timestamp should hvae been generated during task execution"
        );
        assertEquals(12, certificate.getIsin().length());
        assertTrue(certificate.getBidPrice() >= 100.0 && certificate.getBidPrice() <= 200.0);
        assertTrue(certificate.getBidSize() >= 1000 && certificate.getBidSize() <= 5000);
        assertTrue(certificate.getAskPrice() >= 100.0 && certificate.getAskPrice() <= 200.0);
        assertTrue(certificate.getAskSize() >= 1000 && certificate.getAskSize() <= 10000);
    }
}