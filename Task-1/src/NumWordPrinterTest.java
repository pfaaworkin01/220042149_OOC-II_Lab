import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumWordPrinterTest {

    @Test
    public void testEven() {
        NumWordPrinter printer = new NumWordPrinter();
        assertEquals("Even", printer.printWord(2, false));
    }

//    @Test
//    public void testPrimeEleven() {
//        NumWordPrinter printer = new NumWordPrinter();
//        assertEquals("PrimeEleven", printer.printWord(11, false));
//    }
//
//    @Test
//    public void testLuckyThirteen() {
//        NumWordPrinter printer = new NumWordPrinter();
//        assertEquals("LuckyThirteen", printer.printWord(13, false));
//    }
//
//    @Test
//    public void testEvenPrimeEleven() {
//        NumWordPrinter printer = new NumWordPrinter();
//        assertEquals("EvenPrimeEleven", printer.printWord(22, false));
//    }
//
//    @Test
//    public void testEvenPrimeLucky() {
//        NumWordPrinter printer = new NumWordPrinter();
//        assertEquals("EvenPrimeLucky", printer.printWord(286, false));
//    }
//
//    @Test
//    public void testOddOneOut() {
//        NumWordPrinter printer = new NumWordPrinter();
//        assertEquals("OddOneOut", printer.printWord(1, false));
//    }
//
//    @Test
//    public void testUppercase() {
//        NumWordPrinter printer = new NumWordPrinter();
//        assertEquals("EVEN", printer.printWord(2, true));
//    }

}