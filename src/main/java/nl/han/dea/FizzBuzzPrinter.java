package nl.han.dea;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzPrinter {

    public FizzBuzzPrinter(int nrOfThreads) {
        this.nrOfThreads = nrOfThreads;
    }

    private List<ParallelFizzBuzzer> fbList;

    private FizzBuzzCollector fbCollector = new FizzBuzzCollector(0, 100);

    private List<Thread> threadPool;

    private int nrOfThreads;

    public void printFizzbuzzNumbers() {

        fbList = new ArrayList<>(nrOfThreads);
        
        for(var i=0; i<nrOfThreads; i++) {
            fbList.add(new ParallelFizzBuzzer(null));
            threadPool.add(new Thread(fbList.get(i)));
        }

        var fb = new ParallelFizzBuzzer(fbCollector);
        while (!fbCollector.isDone()) {
            fb.fizzbuzzNext();
        }
        for (String item : fbCollector.getOutput()) {
            System.out.println(item);
        }
    }
}