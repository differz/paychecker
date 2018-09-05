package com.differz.paychecker.core;

public class Client {

    private final String id;
    private final String name;
    private final String number;

    public Client(String id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
