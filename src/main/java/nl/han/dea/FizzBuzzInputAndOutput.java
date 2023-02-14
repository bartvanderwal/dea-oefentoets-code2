package nl.han.dea;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzInputAndOutput {

    private final int start;
    private final int end;
    private int teller;

    public FizzBuzzInputAndOutput(int start, int end) {
        this.start = start;
        this.end = end;
        this.teller = start;
        output = new ArrayList<>(end-start+1);
    }

    public void hoogTellerOp() {
        this.teller++;
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

    public int getTeller() {
        return teller;
    }

    public void addOutput(String fizzbuzzValue) {
        output.add(fizzbuzzValue);
    }
}
