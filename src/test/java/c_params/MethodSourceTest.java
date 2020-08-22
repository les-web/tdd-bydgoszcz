package c_params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MethodSourceTest {

    @ParameterizedTest
    @MethodSource("data")

    public void test(Integer i) {
        Assertions.assertTrue(i % 2 == 0);
    }

    public static Stream<Integer> data() {
        return Stream.of(0, 2, 4, 6, 8, 9, -10);
    }

    @ParameterizedTest
    @MethodSource("data2")

    public void test2(Integer i, boolean isEven) {
        Assertions.assertEquals(isEven, i % 2 == 0);
    }

    static public Stream<Arguments> data2() {
        return Stream.of(
                Arguments.of(0, true),
                Arguments.of(1, false),
                Arguments.of(2, true)
        );
    }
}
