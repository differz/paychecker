package com.differz.paychecker.data.gsheet;

import com.differz.paychecker.contracts.repositories.SubscriptionRepository;
import com.differz.paychecker.core.Client;
import com.differz.paychecker.core.Subscription;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.differz.paychecker.data.gsheet.SheetHeader.*;

public class GoogleSheetRepository implements SubscriptionRepository {

    private static final String MAX_DATE = "2222-01-01";
    private final String spreadsheetId;
    private final String range;

    public GoogleSheetRepository(String spreadsheetId, String range) {
        this.spreadsheetId = spreadsheetId;
        this.range = range;
    }

    @Override
    public List<Subscription> findAllSubscriptions() throws IOException {
        List<Subscription> subscriptions = new ArrayList<>();
        GoogleSheetAPI sheetAPI = new GoogleSheetAPI();
        List<List<Object>> values = sheetAPI.getSpreadSheetRecords(spreadsheetId, range);

        for (List<Object> row : values) {
            String clientId = "";
            String clientName = "";
            String clientNumber = "";
            LocalDate lastMonth = LocalDate.parse(MAX_DATE);
            int index = 0;
            for (Object cell : row) {
                SheetHeader header = SheetHeader.byCode(++index);
                if (header == NUMBER) {
                    clientId = "" + cell;
                }
                if (header == CLNAME) {
                    clientName = "" + cell;
                }
                if (header == EDRPOU) {
                    clientNumber = "" + cell;
                }
                if (header == EXPIRE) {
                    String lastPaidMonth = "01." + cell;
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    lastMonth = LocalDate.parse(lastPaidMonth, df);
                }
            }
            Client client = new Client(clientId, clientName, clientNumber);
            Subscription subscription = new Subscription(client, lastMonth);
            subscriptions.add(subscription);
        }
        return subscriptions;
    }

    @Override
    public Optional<Subscription> findSubscriptionById(String id) throws IOException {
        for (Subscription subscription : findAllSubscriptions()) {
            if (id.equals(subscription.getClient().getId())) {
                return Optional.of(subscription);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Subscription> findSubscriptionByNumber(String number) throws IOException {
        return findAllSubscriptions()
                .stream()
                .filter(e -> e.getClient().getNumber().equals(number))
                .findAny();
    }
}
