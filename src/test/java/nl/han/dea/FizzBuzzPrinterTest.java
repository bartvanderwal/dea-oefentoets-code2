package nl.han.dea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;

public class FizzBuzzPrinterTest {

    /** The collector is part of the tested unit, so we're not mocking one. */
    FizzBuzzCollector fbCollector;


    private ArrayList<String> expected;

    @BeforeEach
    void beforeEach() {
        // Arrange.
        expected = new ArrayList<String>(Arrays.asList("1", "2", "Fuzz", "4", "Bizz", "Fuzz", "7", "8", "Fuzz", "Bizz"));
    }

    @Test
    void testNonParallel() throws InterruptedException {
        var sut = new FizzBuzzPrinter(10, 1);

        // Act.
        sut.printFizzbuzzNumbers();

        // Wait for fizzbuzz to complete before asserting.
        // Await dynamically instead of with fixed 1 second for faster unit tests.
        // Note: Still waiting for a millisecond between checks, otherwise getDeclaredFields error or something.
        while (!sut.isDone()) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        var actual = sut.getOutput();

        // Assert.
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testParallel() throws InterruptedException {
        // Arrange.
        var sut = new FizzBuzzPrinter(10, 2);

        // Act.
        sut.printFizzbuzzNumbers();

        // Wait for fizzbuzz to complete before asserting.
        while (!sut.isDone()) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        TimeUnit.SECONDS.sleep(1);
        
        var actual = sut.getOutput();

        // Assert.
        Assertions.assertEquals(expected, actual);
    }

}
