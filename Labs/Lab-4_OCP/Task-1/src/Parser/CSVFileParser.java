package Parser;
import Main.Transaction;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

class CSVFileParser implements BankStatementParser {

    @Override
    public List<Transaction> parse(String fileName) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(fileName));

        for (String line : lines) {
            String[] parts = line.split(",");
            String date = parts[0].trim();
            double amount = Double.parseDouble(parts[1].trim());
            String category = parts[2].trim();
            transactions.add(new Transaction(date, amount, category));
        }
        return transactions;
    }
}

