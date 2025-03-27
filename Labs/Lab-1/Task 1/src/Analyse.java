import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Analyse extends ReadFile {

    private double netProfit;
    private double netLoss;
    private int transactions;
    private double highestExpense;



    public double calculateProfitOrLoss() {
        double sum = 0;
        if(sum >= 0) {
            netProfit = sum;
            return netProfit;
        }
        else {
            netLoss = sum;
            return netLoss;
        }
    }

    public int getTransactions() {
        return transactions;
    }

    public void getTopExpenses() {
    }

    public double getHighestExpense() {
        return highestExpense;
    }

    protected void readFile(File fileName) throws FileNotFoundException {
        readFile(fileName);
    }
}


