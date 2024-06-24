package com.vaibhav.lld;

import java.util.Arrays;
import java.util.Optional;

public enum CoinType {
    RUPEE_1(1),
    RUPEE_5(5),
    RUPEE_10(10),

    RUPEE_20(20);
    private final int value;
    CoinType(int value) {
        this.value = value;
    }

    public static CoinType getCoin(Integer value) {
        Optional<CoinType> coinType =  Arrays.stream(CoinType.values()).filter(it -> it.getValue() == value).findFirst();
        return coinType.orElse(null);
    }

    public int getValue(){
        return value;
    }
}