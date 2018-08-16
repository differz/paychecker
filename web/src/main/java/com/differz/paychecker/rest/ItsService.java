package com.differz.paychecker.rest;

import com.differz.paychecker.contracts.repositories.SubscriptionRepository;
import com.differz.paychecker.core.Client;
import com.differz.paychecker.core.Subscription;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ItsService {

    private final SubscriptionRepository subscriptionRepository;

    public ItsService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public ItsDetails showItsInfo(String number) throws IOException {
        ItsDetails details = new ItsDetails();
        List<Subscription> subscriptions = subscriptionRepository.findAllSubscriptions();
        for (Subscription subscription : subscriptions) {
            Client client = subscription.getClient();
            if (number.equals(client.getId())) {
                details.setEdrpou(number);
                details.setName(client.getName());
                details.setLastMonth(subscription.getLastMonth());
                details.setExpireDate(subscription.getExpireDate());
            }
        }
        return details;
    }
}
