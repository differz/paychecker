package com.differz.paychecker.configuration;

import com.differz.paychecker.data.gsheet.GoogleSheetRepository;
import com.differz.paychecker.contracts.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:subscription.properties")
public class SubscriptionConfiguration {

    @Bean
    public SubscriptionRepository subscriptionRepository(@Value("${subscription.server}") String server,
                                                         @Value("${subscription.key}") String key) {
        return new GoogleSheetRepository(server, key);
    }
}
