package nl.han.dea;

public class ParallelFizzBuzzer implements Runnable {

    private FizzBuzzCollector fbCollector;

    private FizzBuzzer fb;

    public ParallelFizzBuzzer(FizzBuzzCollector fbIo) {
        this.fbCollector = fbIo;
        fb = new FizzBuzzer();
    }

    public void fizzbuzzNext() {
        String fizzBuzzValue = fb.fizzbuzz(fbCollector.getCounter());
        fbCollector.addOutput(fizzBuzzValue);
        fbCollector.increaseCounter();
    }

    @Override
    public void run() {
        fizzbuzzNext();
    }

}
