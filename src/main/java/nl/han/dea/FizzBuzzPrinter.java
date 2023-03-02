package nl.han.dea;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class FizzBuzzPrinter {

    private int nrOfThreads;

    private boolean orderResults;

    // TODO: Code smells eruit halen.
    public FizzBuzzPrinter(int maxValue, int nrOfThreads, boolean orderResults) {
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

        fbCollector = new FizzBuzzCollector(maxValue);
        this.nrOfThreads = nrOfThreads;
        this.orderResults = orderResults;
    }

    /** Constructor met default values. */
    public FizzBuzzPrinter() {
        this(20, Runtime.getRuntime().availableProcessors(), true);
    }

    public FizzBuzzPrinter(int maxValue, int nrOfThreads) {
        this(maxValue, nrOfThreads, true);
    }

    private FizzBuzzCollector fbCollector;

    public void printFizzbuzzNumbers() throws InterruptedException {        
        // Determine fizzbuzz numbers concurrently.
        for(var i=0; i<nrOfThreads; i++) {
            // var pfb = new ParallelFizzBuzzer(fbCollector);
            // new Thread(pfb).start();
            new Thread(() -> {
                new ParallelFizzBuzzer(fbCollector).fizzbuzz();
            }).start();
        }

        // Print determined FizzBuzz values to console.
        var fizzbuzzNumbers = fbCollector.getOutput();
        System.out.println("Print concurrently acquired fizzbuzz results...");
        while (!isDone()) {
            TimeUnit.MILLISECONDS.sleep(1);
        }

        // Output ordenen (omdat thread executie volgorde onbepaalbaar/onbestuurbaar is).
        // NB Deze code zit NIET in oefentoets, net zoals de unit tests hiervoor.
        // Je moet dontOrder op true zetten om de in opgave beschreven errors (af en toe) te krijgen,
        // maar om de unit tests te laten slagen moet deze op false staan.
        var dontOrder = !orderResults;
        var ordered = dontOrder ? fizzbuzzNumbers : fizzbuzzNumbers.stream()
            .sorted((r1, r2) -> r1.getInput()-r1.getInput())
            .map(r -> r.getOutput()).toList();  

        if (ordered.size()==0) {
            System.out.println("Ain't nothing there :S");
        } else {
            for (FizzBuzzCalculation item : fizzbuzzNumbers) {
                System.out.println(item);
            }
        }
    }

    public synchronized boolean isDone() {
        return fbCollector.isDone();
    }

    public synchronized List<String> getOutput() {
        // Haal alleen fizzbuzz output veld uit fizzbuzzcalculation waarden. Typisch om te printen of te vergelijken.
        return fbCollector.getOutput().stream().map(o -> o.getOutput()).collect(Collectors.toList());
    }

}