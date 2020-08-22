package c_params;

import a_junit.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParametrizedMethodSourceCalculatorTest {


    @ParameterizedTest
    @MethodSource("data3")

    public void test(Integer i, Integer j, Integer expected) {
        Assertions.assertEquals(expected, new Calculator().add(i, j));
    }

    static public Stream<Arguments> data3() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(6, 7, 13),
                Arguments.of(2, 2, 7)
        );
    }
}
