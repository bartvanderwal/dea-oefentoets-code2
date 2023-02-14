package nl.han.dea;

import java.util.List;

public class App {
    public static void main(String[] args) {
        var input = List.of("Jan", "Jansen", "Henk", "van den Tillaert");
        var stringHelpers = new StringHelpers();
        var output = stringHelpers.concatenatePairwise(input);
        System.out.println(output);

        fizzbuzz();
    }

    private static void fizzbuzz() {
        var fbIo = new FizzBuzzInputAndOutput(1, 100);
        var fb = new FizzBuzzer(fbIo);
        for(var i=1; i<=100; i++) {
            System.out.println(fb.fizzbuzz(i));
        }
    }

}
