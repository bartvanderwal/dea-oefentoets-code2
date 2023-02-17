package nl.han.dea;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzCollector {

    private int counter;
    private final int end;
    private List<FizzBuzzCalculation> output;

    public FizzBuzzCollector(int end) {
        this.end = end;
        this.counter = 1;
        output = new ArrayList<>(end);
    }

    public synchronized int getCounter() {
        return counter++;
    }

    public synchronized void addOutput(FizzBuzzCalculation fizzbuzzValue) {
        output.add(fizzbuzzValue);
    }

    public synchronized List<FizzBuzzCalculation> getOutput() {
        return output;
    }

    public synchronized boolean isDone() {
        return this.counter>this.end;
    }

}
