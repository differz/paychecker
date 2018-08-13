package com.differz.paychecker.data.gsheet;

import com.differz.paychecker.contracts.repositories.SubscriptionRepository;

import java.io.IOException;
import java.util.List;

public class GoogleSheetRepository implements SubscriptionRepository {

    private final String spreadsheetId;
    private final String range;

    public GoogleSheetRepository(String spreadsheetId, String range) {
        this.spreadsheetId = spreadsheetId;
        this.range = range;
    }

    @Override
    public List<Object> findAllSubscriptions() throws IOException {

        GoogleSheetAPI sheetAPI = new GoogleSheetAPI();
        List<List<Object>> values = sheetAPI.getSpreadSheetRecords(spreadsheetId, range);

        for (List<Object> row : values) {
            for (Object cell : row) {
                System.out.println(cell.toString());
            }
        }

        return null;
    }
}
