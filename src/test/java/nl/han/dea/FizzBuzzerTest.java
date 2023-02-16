package nl.han.dea;

import org.junit.jupiter.api.*;

public class FizzBuzzerTest {

    FizzBuzzer sut;

    @BeforeEach
    void beforeEach() {
        sut = new FizzBuzzer();
    }

    @Test
    void testNumber() {
        // Arrange.
        var expected = "1";

        // Act.
        var actual = sut.fizzbuzz(1);

        // Assert.
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFizzBuzz() {
        // Arrange.
        var expected = "FuzzBizz";

        // Act.
        var actual = sut.fizzbuzz(15);

        // Assert.
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFizz() {
        // Arrange.
        var expected = "Fuzz";

        // Act.
        var actual = sut.fizzbuzz(3);

        // Assert.
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBuzz() {
        // Arrange.
        var expected = "Bizz";

        // Act.
        var actual = sut.fizzbuzz(5);

        // Assert.
        Assertions.assertEquals(expected, actual);
    }
}
