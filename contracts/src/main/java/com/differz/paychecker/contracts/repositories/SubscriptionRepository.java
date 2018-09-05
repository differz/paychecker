package com.differz.paychecker.contracts.repositories;

import com.differz.paychecker.core.Subscription;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository {

    List<Subscription> findAllSubscriptions() throws IOException;

    Optional<Subscription> findSubscriptionById(String id) throws IOException;

    Optional<Subscription> findSubscriptionByNumber(String number) throws IOException;

}
