package com.differz.paychecker.contracts.repositories;

import com.differz.paychecker.core.Subscription;

import java.io.IOException;
import java.util.List;

public interface SubscriptionRepository {

    List<Subscription> findAllSubscriptions() throws IOException;

}
