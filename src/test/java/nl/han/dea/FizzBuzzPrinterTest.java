package nl.han.dea;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.*;

public class FizzBuzzPrinterTest {

    private FizzBuzzPrinter sut;


    /** The collector is part of the tested unit, so we're not mocking one. */
    FizzBuzzCollector fbCollector;

    @BeforeEach
    void beforeEach() {
        fbCollector = new FizzBuzzCollector(1, 10);
    }

    @Test
    void testNonParallel() {
        sut = new FizzBuzzPrinter(1);


        // Arrange.
        var expected = new ArrayList<String>(Arrays.asList("1", "2", "Fuzz", "4", "Bizz", "Fuzz", "7", "8", "Fuzz", "Bizz"));

        // Act.
        while (!fbCollector.isDone()) {
            parallelFizzBuzzer.fizzbuzzNext();
        }
        var actual = fbCollector.getOutput();

        // Assert.
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testParallel() {

        parallelFizzBuzzer = new ParallelFizzBuzzer(fbCollector);

        // Arrange.
        var expected = new ArrayList<String>(Arrays.asList("1", "2", "Fuzz", "4", "Bizz", "Fuzz", "7", "8", "Fuzz", "Bizz"));

        // Act.
        while (!fbCollector.isDone()) {
            parallelFizzBuzzer.fizzbuzzNext();
        }
        var actual = fbCollector.getOutput();

        // Assert.
        Assertions.assertEquals(expected, actual);
    }

}
