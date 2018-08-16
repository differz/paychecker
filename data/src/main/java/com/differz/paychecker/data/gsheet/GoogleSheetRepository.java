package com.differz.paychecker.data.gsheet;

import com.differz.paychecker.contracts.repositories.SubscriptionRepository;
import com.differz.paychecker.core.Client;
import com.differz.paychecker.core.Subscription;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.differz.paychecker.data.gsheet.SheetHeader.*;

public class GoogleSheetRepository implements SubscriptionRepository {

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

            String clientCode = "";
            String clientName = "";
            LocalDate lastMonth = LocalDate.MAX;
            int index = 0;
            for (Object cell : row) {
                System.out.println(cell.toString());

                SheetHeader header = SheetHeader.byCode(++index);
                if (header == PROJECT) {
                    clientName = "" + cell;
                }
                if (header == EDRPOU) {
                    clientCode = "" + cell;
                }
                if (header == EXPIRE) {
                    String lastPaidMonth = "01." + cell;
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    lastMonth = LocalDate.parse(lastPaidMonth, df);
                }
            }
            Client client = new Client(clientCode, clientName);
            Subscription subscription = new Subscription(client, lastMonth);
            subscriptions.add(subscription);
        }

        return subscriptions;
    }
}
