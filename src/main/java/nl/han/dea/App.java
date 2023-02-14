package nl.han.dea;

import java.util.List;

public class App {
    public static void main(String[] args) {
        var input = List.of("Jan", "Jansen", "Henk", "van den Tillaert");
        var stringHelpers = new StringHelpers();
        var output = stringHelpers.concatenatePairwise(input);
        System.out.println(output);

        var app = new FizzBuzzPrinter(10, 1);
        app.printFizzbuzzNumbers();
    }

}
