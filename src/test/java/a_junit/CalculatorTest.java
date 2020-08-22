package a_junit;

import org.junit.jupiter.api.*;

public class CalculatorTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("BEFORE ALL");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("AFTER ALL");
    }

    @Test
    //  @Disabled

    public void test() {
// Arrange
        Calculator calculator = new Calculator();
// Act
        Integer sum = calculator.add(2, 2);
        // Assert

        Assertions.assertEquals(4, sum);
    }

    @Test
    public void test2() {
// Arrange
        Calculator calculator = new Calculator();
// Act
        Integer sum = calculator.add(1, 1);
        // Assert

        Assertions.assertEquals(2, sum);
    }
}
