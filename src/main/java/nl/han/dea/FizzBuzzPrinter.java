package nl.han.dea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzzPrinter {

    // TODO: Code smells eruit halen.
    public FizzBuzzPrinter(int maxValue, int nrOfThreads) {
        if (nrOfThreads==0) {
            nrOfThreads=1;
        }

        if (nrOfThreads>256) {
            throw new IllegalArgumentException("Gewenste aantal threads is: " + nrOfThreads + ". Maar het maximaal aantal toegestane threads is " + 256);
        }

        var availableProcs = Runtime.getRuntime().availableProcessors();
        if (nrOfThreads>availableProcs) {
            System.out.println("Gewenste aantal threads is: " + nrOfThreads + ". Dat is meer dan aantal cores: " + availableProcs + "; dat is wellicht niet handig.");
        }

        this.nrOfThreads = nrOfThreads;
        fbList = new ArrayList<>(nrOfThreads);

        fbCollector = new FizzBuzzCollector(maxValue); 
    }

    private List<ParallelFizzBuzzer> fbList;

    private FizzBuzzCollector fbCollector;

    private int nrOfThreads;

    public synchronized List<String> getOutput() {
        return fbCollector.getOutput().stream().map(o -> o.getOutput()).collect(Collectors.toList());
    }

    public void printFizzbuzzNumbers() {        
        for(var i=0; i<nrOfThreads; i++) {
            fbList.add(new ParallelFizzBuzzer(fbCollector));
            var thread = new Thread(fbList.get(i));
            thread.start();
        }

        // TODO Output ordenen (?).

        // Print alle uitgerekende FizzBuzz waarden naar console.
        for (FizzBuzzCalculation item : fbCollector.getOutput()) {
            System.out.println(item);
        }
    }

    public boolean isDone() {
        return fbCollector.isDone();
    }
}