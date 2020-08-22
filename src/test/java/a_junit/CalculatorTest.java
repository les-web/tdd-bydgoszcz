package a_junit;

import org.junit.jupiter.api.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("BEFORE ALL");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("AFTER ALL");
    }

    @BeforeEach
    public void beforeEach() {
        // Arrange
        calculator = new Calculator();

        System.out.println("BEFORE EACH");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("AFTER EACH");
    }

    @Test
    //  @Disabled

    public void add_2Plus2_shouldBeEqualTo4() {

// Act
        Integer sum = calculator.add(2, 2);
        // Assert

        Assertions.assertEquals(4, sum);
    }

    @Test
    public void substract_2Minus2_shouldBeEqualTo0() {

// Act
        Integer dif = calculator.substract(2, 2);
        // Assert

        Assertions.assertEquals(0, dif);
    }

    @Test
    public void multiply_2MultiplieddBy5_shouldBeEqualTo10() {

// Act
        Integer multi = calculator.multiply(2, 5);
        // Assert

        Assertions.assertEquals(10, multi);
    }

    @Test
    public void divide_20DividedBy4_shouldBeEqualTo5() {

// Act
        Integer div = calculator.divide(20, 4);
        // Assert

        Assertions.assertEquals(5, div);
    }
    //
}
