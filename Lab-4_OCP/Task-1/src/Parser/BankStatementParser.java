package Parser;
import Main.Transaction;
import java.util.List;
import java.io.IOException;

public interface BankStatementParser {

    List<Transaction> parse(String fileName) throws IOException, IOException;

}
