package nl.han.dea;

public class FizzBuzzCalculation {

    private final int input;

    private final String output;

    private final long threadId;

    public FizzBuzzCalculation(int input, String output, long threadId) {
        this.input = input;
        this.output = output;
        this.threadId = threadId;
    }

    public String getOutput() {
        return output;
    }

    public String toString() {
        return "input: " + input + ". output: " + output + ". ThreadId: " + threadId;
    }
}
