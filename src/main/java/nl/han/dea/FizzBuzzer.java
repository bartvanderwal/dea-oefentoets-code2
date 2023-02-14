package nl.han.dea;

public class FizzBuzzer {
    public String fizzbuzz(int counter) {
        if (isDividableBy3(counter) && isDividableBy5(counter)) {
            return "FuzzBizz";
        }
        if (isDividableBy3(counter)) {
            return "Fuzz";
        }
        if (isDividableBy5(counter)) {
            return "Bizz";
        }
        return "" + counter;
    }

    private boolean isDividableBy3(int counter) {
        return counter % 3 == 0;
    }

    private boolean isDividableBy5(int counter) {
        return counter % 5 == 0;
    }
}
