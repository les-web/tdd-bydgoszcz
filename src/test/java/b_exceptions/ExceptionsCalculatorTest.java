package b_exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionsCalculatorTest {
    @Test
    public void divide_whenPassingNullAsFirstParameter_shouldThrowAnException() {
        ExceptionsCalculator exceptionsCalculator = new ExceptionsCalculator();
        try {
            exceptionsCalculator.divide(null, 1);
            fail("expected exception");
        } catch (Exception e) {
            Assertions.assertEquals("null argument", e.getMessage());

        }
    }
@Test
    public void divide_whenPassing0AsSecondParameter_shouldThrowAnException(){
        ExceptionsCalculator exceptionsCalculator = new ExceptionsCalculator();
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                ()-> exceptionsCalculator.divide(1,0)
                );
        Assertions.assertEquals("do not divide by 0", exception.getMessage());
}
}