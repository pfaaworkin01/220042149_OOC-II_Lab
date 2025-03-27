package Parser;

public class DetermineParser {

    public static BankStatementParser getParser(String fileName) {
        if (fileName.endsWith(".csv")) {
            return new CSVFileParser();
        } else if (fileName.endsWith(".json")) {
            return new JSONFileParser();
        } else if (fileName.endsWith(".xml")) {
            return new XMLFileParser();
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }
    }
}
