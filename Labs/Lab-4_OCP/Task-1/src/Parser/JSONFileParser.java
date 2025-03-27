package Parser;

import Main.Transaction;
import org.json.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

class JSONFileParser implements BankStatementParser {

    @Override
    public List<Transaction> parse(String fileName) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        JSONArray jsonArray = new JSONArray(content);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String date = jsonObject.getString("date");
            double amount = jsonObject.getDouble("amount");
            String category = jsonObject.getString("description");
            transactions.add(new Transaction(date, amount, category));
        }
        return transactions;
    }
}

