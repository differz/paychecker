package com.differz.paychecker.rest;

import com.differz.paychecker.contracts.repositories.SubscriptionRepository;
import com.differz.paychecker.core.Subscription;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class ItsService {

    private final SubscriptionRepository subscriptionRepository;

    public ItsService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public ItsDetails showItsByNumber(String number) throws IOException {
        ItsDetails details = new ItsDetails();
        Optional<Subscription> result = subscriptionRepository.findSubscriptionByNumber(number);

        if (result.isPresent()) {
            Subscription subscription = result.get();
            details.setEdrpou(number);
            details.setName(subscription.getClient().getName());
            details.setLastMonth(subscription.getLastMonth());
            details.setExpireDate(subscription.getExpireDate());
        }
        return details;
    }

    public ItsDetails showItsById(String id) throws IOException {
        ItsDetails details = new ItsDetails();
        Optional<Subscription> result = subscriptionRepository.findSubscriptionById(id);

        if (result.isPresent()) {
            Subscription subscription = result.get();
            details.setNumber(id);
            details.setName(subscription.getClient().getName());
            details.setLastMonth(subscription.getLastMonth());
            details.setExpireDate(subscription.getExpireDate());
        }
        return details;
    }
}
