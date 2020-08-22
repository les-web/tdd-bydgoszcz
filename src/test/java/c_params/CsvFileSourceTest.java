package c_params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CsvFileSourceTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void test(String input, String expected){
        Assertions.assertEquals(expected, input.toUpperCase());
    }
}
