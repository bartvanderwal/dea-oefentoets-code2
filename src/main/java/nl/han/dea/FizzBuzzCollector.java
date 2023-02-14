package nl.han.dea;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzCollector {

    private final int start;
    private final int end;
    private int counter;

    public FizzBuzzCollector(int start, int end) {
        this.start = start;
        this.end = end;
        this.counter = start;
        output = new ArrayList<>(end-start+1);
    }

    public void increaseCounter() {
        this.counter++;
    }

    private List<String> output;

    public List<String> getOutput() {
        return output;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getCounter() {
        return counter;
    }

    public void addOutput(String fizzbuzzValue) {
        output.add(fizzbuzzValue);
    }

    public boolean isDone() {
        return this.counter>this.end;
    }
}
