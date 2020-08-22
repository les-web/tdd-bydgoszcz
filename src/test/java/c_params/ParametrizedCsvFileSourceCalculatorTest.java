package c_params;

import a_junit.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ParametrizedCsvFileSourceCalculatorTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/dataforadd.csv")
    public void test(Integer input1, Integer input2, Integer expected) {
        Assertions.assertEquals(expected, new Calculator().add(input1, input2));
    }
}