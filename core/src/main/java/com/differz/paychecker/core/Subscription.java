package com.differz.paychecker.core;

import java.time.LocalDate;

public class Subscription {

    private final Client client;
    private final LocalDate expireDate;

    public Subscription(Client client, LocalDate lastMonth) {
        this.client = client;
        this.expireDate = lastMonth.plusMonths(1);
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }
}
