package com.solvians.showcase;


import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        if (args.length < 2) {
            throw new RuntimeException("Expect at least number of threads and number of quotes. But got: "
                    + java.util.Arrays.toString(args));
        }

        int threads = Integer.parseInt(args[0]);
        int quotes = Integer.parseInt(args[1]);

        CertificateUpdateGenerator certificateUpdateGenerator = new CertificateUpdateGenerator(threads, quotes);
        Stream<CertificateUpdate> certificateUpdateStream = certificateUpdateGenerator.generateQuotes();
        printResult(certificateUpdateStream);
    }

    private static void printResult(Stream<CertificateUpdate> certificateUpdateStream) {
        certificateUpdateStream
                .map(certificateUpdate -> "CertificateUpdate")
                .forEach(System.out::println);
    }
}
