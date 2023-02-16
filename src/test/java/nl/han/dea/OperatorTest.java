package nl.han.dea;
import java.util.*;

import org.junit.jupiter.api.*;

public class OperatorTest {

    Operator sut;

    @BeforeEach
    void beforeEach() {
        sut = new Operator();
    }

    @Test
    void test1() {
        var input = Arrays.asList(1,2,3,4,5);
        sut.writeAll1(input);
    }

    @Test
    void test2() {
        var input = Arrays.asList(1,2,3,4,5);
        sut.writeAll2(input);
    }

    @Test
    void test3() {
        var input = Arrays.asList(1,2,3,4,5);
        sut.writeAll3(input);
    }

    @Test
    void test4() {
        var input = Arrays.asList(1,2,3,4,5);
        sut.writeAll4(input);
    }

    @Test
    void test5() {
        var input = Arrays.asList(1,2,3,4,5);
        sut.writeAll5(input);
    }
}
