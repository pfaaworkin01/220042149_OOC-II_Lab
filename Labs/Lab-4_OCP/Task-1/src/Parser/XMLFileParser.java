package Parser;

import Main.Transaction;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

class XMLFileParser implements BankStatementParser {

    @Override
    public List<Transaction> parse(String fileName) throws IOException {
        List<Transaction> transactions = new ArrayList<>();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(Files.newInputStream(Paths.get(fileName)));

            NodeList nodeList = doc.getElementsByTagName("transaction");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String date = element.getElementsByTagName("date").item(0).getTextContent();
                    double amount = Double.parseDouble(element.getElementsByTagName("amount").item(0).getTextContent());
                    String category = element.getElementsByTagName("description").item(0).getTextContent();

                    transactions.add(new Transaction(date, amount, category));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }
}


