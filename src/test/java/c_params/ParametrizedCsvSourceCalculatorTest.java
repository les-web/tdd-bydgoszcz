package c_params;

import a_junit.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

public class ParametrizedCsvSourceCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,5",
            "7,8,15"})

    public void test(Integer input1, Integer input2, Integer expected){
        Assertions.assertEquals(expected, new Calculator().add(input1,input2));
    }
}