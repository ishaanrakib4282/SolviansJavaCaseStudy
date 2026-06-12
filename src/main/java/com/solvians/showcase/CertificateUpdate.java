package com.solvians.showcase;

public class CertificateUpdate {

    private final long timestamp;
    private final String isin;
    private final double bidPrice;
    private final long bidSize;
    private final double askPrice;
    private final long askSize;

    public CertificateUpdate(
            long timestamp,
            String isin,
            double bidPrice,
            long bidSize,
            double askPrice,
            long askSize) {

        this.timestamp = timestamp;
        this.isin = isin;
        this.bidPrice = bidPrice;
        this.bidSize = bidSize;
        this.askPrice = askPrice;
        this.askSize = askSize;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getIsin() {
        return isin;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public long getBidSize() {
        return bidSize;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public long getAskSize() {
        return askSize;
    }

    @Override
    public String toString() {
        return timestamp + "," +
                isin + "," +
                String.format("%.2f", bidPrice) + "," +
                bidSize + "," +
                String.format("%.2f", askPrice) + "," +
                askSize;
    }
}
