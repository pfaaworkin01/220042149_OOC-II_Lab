package Main;

import Parser.BankStatementParser;
import Parser.DetermineParser;

import java.io.IOException;
import java.util.*;
import java.util.stream.*;

class ModifiedBankStatementAnalyzer {

    private List<Transaction> transactions;

    public void loadTransactions(String fileName) throws IOException {
        BankStatementParser parser = DetermineParser.getParser(fileName);
        this.transactions = parser.parse(fileName);
    }
}


