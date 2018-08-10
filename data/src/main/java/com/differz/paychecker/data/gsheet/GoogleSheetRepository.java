package com.differz.paychecker.data.gsheet;

import com.differz.paychecker.contracts.repositories.SubscriptionRepository;

import java.util.List;

public class GoogleSheetRepository implements SubscriptionRepository {

    private final String server;
    private final String key;

    public GoogleSheetRepository(String server, String key) {
        this.server = server;
        this.key = key;
    }

    @Override
    public List<Object> findAllSubscriptions() {
        return null;
    }
}
