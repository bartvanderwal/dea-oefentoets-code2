package nl.han.dea;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzCollector {

    private int counter;
    private final int start;
    private final int end;
    private List<FizzBuzzCalculation> output;

    public FizzBuzzCollector(int end) {
        this.start = 1;
        this.end = end;
        this.counter = start;
        output = new ArrayList<>(end-start+1);
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
