package nl.han.dea;

public class ParallelFizzBuzzer implements Runnable {

    private FizzBuzzCollector fbCollector;

    private FizzBuzzer fb;

    public ParallelFizzBuzzer(FizzBuzzCollector fbIo) {
        this.fbCollector = fbIo;
        fb = new FizzBuzzer();
    }

    public void fizzbuzz() {
        while(!fbCollector.isDone()) {
            String fizzBuzzValue = fb.fizzbuzz(fbCollector.getCounter());
            fbCollector.addOutput(fizzBuzzValue);
        }
    }

    @Override
    public void run() {
        fizzbuzz();
    }

}
