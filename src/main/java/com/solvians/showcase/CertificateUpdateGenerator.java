package com.solvians.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {

    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() {

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        try {
            List<Future<CertificateUpdate>> futures = new ArrayList<>();

            for (int i = 0; i < quotes; i++) {
                futures.add(
                        executor.submit(new CertificateUpdateTask())
                );
            }

            List<CertificateUpdate> result = new ArrayList<>(quotes);

            for (Future<CertificateUpdate> future : futures) {
                result.add(future.get());
            }
            return result.stream();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}
