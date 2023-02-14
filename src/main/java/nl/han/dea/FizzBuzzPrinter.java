package nl.han.dea;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzPrinter {

    // TODO: Code smells eruit halen.
    public FizzBuzzPrinter(int nrOfThreads) {
        if (nrOfThreads==0) {
            nrOfThreads=1;
        }

        var availableProcs = Runtime.getRuntime().availableProcessors();
        if (nrOfThreads>availableProcs) {
            System.out.println("Gewenste aantal threads is: " + nrOfThreads + ". Dat is meer dan aantal cores: " + availableProcs + "; dat is wellicht niet handig.");
        }

        if (nrOfThreads>256) {
            System.out.println("Gewenste aantal threads is: " + nrOfThreads + ". Maar het maximaal aantal threads is " + 256);
            nrOfThreads=256;
        }

        this.nrOfThreads = nrOfThreads;
    }

    private List<ParallelFizzBuzzer> fbList;

    private FizzBuzzCollector fbCollector = new FizzBuzzCollector(100);

    private List<Thread> threadPool;

    private int nrOfThreads;

    public void printFizzbuzzNumbers() {

        fbList = new ArrayList<>(nrOfThreads);
        
        for(var i=0; i<nrOfThreads; i++) {
            fbList.add(new ParallelFizzBuzzer(fbCollector));
            var thread = new Thread(fbList.get(i));
            threadPool.add(thread);
            thread.start();
        }

        // TODO Output ordenen (?).

        // Print alle uitgerekende FizzBuzz waarden naar console.
        for (String item : fbCollector.getOutput()) {
            System.out.println(item);
        }
    }
}