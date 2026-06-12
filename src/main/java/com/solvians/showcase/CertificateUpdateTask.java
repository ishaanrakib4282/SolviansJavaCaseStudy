package com.solvians.showcase;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class CertificateUpdateTask implements Callable<CertificateUpdate> {

    private final IsinGenerator isinGenerator = new IsinGenerator();

    @Override
    public CertificateUpdate call() {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        long timestamp = System.currentTimeMillis();

        String isin = isinGenerator.generate();

        double bidPrice = generateRandomLong(random, 10000, 20000) / 100.0;

        long bidSize = generateRandomLong(random, 1000, 5000);

        double askPrice = generateRandomLong(random, 10000, 20000) / 100.0;

        long askSize = generateRandomLong(random, 1000, 10000);

        return new CertificateUpdate(
                timestamp,
                isin,
                bidPrice,
                bidSize,
                askPrice,
                askSize
        );
    }

    long generateRandomLong(ThreadLocalRandom random, long inclusiveLowerLimit, long inclusiveHigherLimit) {
        return random.nextLong(inclusiveLowerLimit, inclusiveHigherLimit + 1);
    }
}
