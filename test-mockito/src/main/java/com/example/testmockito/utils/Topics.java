package com.example.testmockito.utils;

public enum Topics {
    USER("User", 100);
    private final String name;
    private final int code;

    private Topics(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
