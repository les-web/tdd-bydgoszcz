package d_assertj;
/*
# Zadanie


        1. Utwórz klasę z testami o nazwie `AssertJCalculatorTest`.
        1. W tej klasie napisz testy dla metody `divide` klasy `ExceptionsCalculator` wykorzystując asercje z biblioteki AssertJ:
        * standardowe dzielenie
        * sytuacja gdy rzucany jest wyjątek
*/


import b_exceptions.ExceptionsCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

// import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

// import static org.assertj.core.api.Assertions.assertThat;


public class AssertJCalculatorTest {
    ExceptionsCalculator exceptionsCalculator = new ExceptionsCalculator();

    @Test
    public void testDivide() {

        Assertions.assertThat(exceptionsCalculator.divide(10, 5))
                .isEqualTo(2);
    }

    @Test
    public void test() {

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> exceptionsCalculator.divide(1, 0))
                .withMessage("do not divide by 0");

    }
}

