import java.io.File;
import java.io.FileNotFoundException;

public class Summary extends Analyse {

    private File fileName;

    public Summary(File fileName) {
        this.fileName = fileName;
    }

    public void readFile(File fileName) throws FileNotFoundException {
        super.readFile(fileName);
    }

    public void netProfitOrLoss() {
        if(super.calculateProfitOrLoss() >= 0) {
            System.out.println("Your total profit is: " + super.calculateProfitOrLoss() + " which is positive.");
        }
        else {
            System.out.println("Your total loss isL " + super.calculateProfitOrLoss() + " which is negative.");
        }
    }

    public void numberOfTransactions() {
        System.out.println("Total number of transactions: " + super.getTransactions());
    }

    public void topExpenses() {
        System.out.println("Your top 10 expenses are: ");
        super.getTopExpenses();
    }

    public void highestExpense() {
        super.getHighestExpense();
    }

}
