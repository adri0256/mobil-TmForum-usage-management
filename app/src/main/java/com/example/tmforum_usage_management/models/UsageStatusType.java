package com.example.tmforum_usage_management.models;

import java.util.HashMap;
import java.util.Map;

public enum UsageStatusType {
    RECEIVED(0),
    REJECTED(1),
    RECYCLED(2),
    GUIDED(3),
    RATED(4),
    RERATED(5),
    BILLED(6);

    private int value;
    private static Map map = new HashMap<>();

    UsageStatusType(int value) {
        this.value = value;
    }

    static {
        for (UsageStatusType pageType : UsageStatusType.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static UsageStatusType valueOf(int pageType) {
        return (UsageStatusType) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}
