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
    public SubscriptionRepository subscriptionRepository(@Value("${subscription.spreadsheetId}") String spreadsheetId,
                                                         @Value("${subscription.range}") String range) {
        return new GoogleSheetRepository(spreadsheetId, range);
    }
}
