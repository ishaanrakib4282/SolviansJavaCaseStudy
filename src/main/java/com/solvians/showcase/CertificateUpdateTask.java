package com.solvians.showcase;

import java.util.concurrent.Callable;

public class CertificateUpdateTask implements Callable<CertificateUpdate> {

    @Override
    public CertificateUpdate call() {

        return new CertificateUpdate();
    }
}
