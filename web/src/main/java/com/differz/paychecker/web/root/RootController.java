package com.differz.paychecker.web.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

//  private final SubscriptionService subscriptionService;

    @GetMapping("/")
    public String paychecker() {

        return "paycheckerView";
    }
}
