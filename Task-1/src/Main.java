public class Main {
    public static void main(String[] args) {

        NumWordPrinter printer = new NumWordPrinter();

        System.out.println(printer.printWord(2, false));
        System.out.println(printer.printWord(11, false));
        System.out.println(printer.printWord(13, false));
        System.out.println(printer.printWord(22, false));
        System.out.println(printer.printWord(286, false));
        System.out.println(printer.printWord(1, false));

    }
}