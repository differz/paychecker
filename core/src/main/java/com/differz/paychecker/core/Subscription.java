package com.differz.paychecker.core;

import java.time.LocalDate;

public class Subscription {

    private final Client client;
    private final LocalDate lastMonth;

    public Subscription(Client client, LocalDate lastMonth) {
        this.client = client;
        this.lastMonth = lastMonth;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getLastMonth() {
        return lastMonth;
    }

    public LocalDate getExpireDate() {
        return lastMonth.plusMonths(1);
    }
}
