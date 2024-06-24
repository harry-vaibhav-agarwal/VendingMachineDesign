package com.vaibhav.lld;

public class Coin {
    private final CoinType coinType;

    public Coin(CoinType coinType) {
        this.coinType = coinType;
    }

    public int getDenomination() {
        return coinType.getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(coinType.getValue());
    }
}


