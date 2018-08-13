package com.differz.paychecker.web.subscription;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/subscription")
    public String subscription() throws IOException {

        String subs = subscriptionService.listSubscriptions();
        System.out.println(subs);

        return "paycheckerView";
    }
}

// No lines changed: content is already properly formatted
