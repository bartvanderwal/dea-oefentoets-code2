package nl.han.dea;

import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
        var input = List.of("Jan", "Jansen", "Henk", "van den Tillaert");
        var stringHelpers = new StringHelpers();
        var output = stringHelpers.concatenatePairwise(input);
     
        var fbPrinter = new FizzBuzzPrinter(1000, 3);
        fbPrinter.printFizzbuzzNumbers();

        System.out.println(output);
    }

}
