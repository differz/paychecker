package com.differz.paychecker.contracts.repositories;

import java.io.IOException;
import java.util.List;

public interface SubscriptionRepository {

    List<Object> findAllSubscriptions() throws IOException;

}
