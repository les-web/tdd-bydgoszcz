package c_params;

import a_junit.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class ParametrizedArgumentsSourceCalculatorTest {


    @ParameterizedTest
    @ArgumentsSource(MyProviderForAddTest.class)

    public void test (Integer i, Integer j, Integer expected){
        Assertions.assertEquals(expected, new Calculator().add(i,j));
    }
}
