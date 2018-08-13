package com.differz.paychecker.web.subscription;

import com.differz.paychecker.contracts.repositories.SubscriptionRepository;
import com.differz.paychecker.core.Subscription;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }


    public String listSubscriptions() throws IOException {

        List<Subscription> subscriptions = subscriptionRepository.findAllSubscriptions();

        System.out.println(subscriptions);

        return "123";
    }
}
