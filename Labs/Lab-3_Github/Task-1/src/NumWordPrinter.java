public class NumWordPrinter {

    private String printWord(int n) {
        if(n%2==0 && n%11==0 && n%13==0) {
            return "EvenPrimeLucky";
        }
        else if(n%2==0 && n%11==0) {
            return "EvenPrimeEleven";
        }
        else if(n%2==0) {
            return "Even";
        }
        else if(n%11==0) {
            return "PrimeEleven";
        }
        else if(n%13==0) {
            return "LuckyThirteen";
        }
        else {
            return "OddOneOut";
        }
    }

    public String printWord(int n, boolean Uppercase) {
        if(Uppercase) {
            return printWord(n).toUpperCase();
        }
        else {
            return printWord(n);
        }
    }

}
