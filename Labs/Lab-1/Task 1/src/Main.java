import java.io.File;

public class Main {
    public static void main(String[] args) {

        File file = new File("transactions1.csv");

        Summary summary = new Summary(file);

        summary.netProfitOrLoss();
        summary.numberOfTransactions();
        summary.topExpenses();
        summary.highestExpense();

    }
}