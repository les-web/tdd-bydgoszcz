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
    public void afterEach(){
        System.out.println("AFTER EACH");
    }

    @Test
    //  @Disabled

    public void test() {

// Act
        Integer sum = calculator.add(2, 2);
        // Assert

        Assertions.assertEquals(4, sum);
    }

    @Test
    public void test2() {

// Act
        Integer sum = calculator.add(1, 1);
        // Assert

        Assertions.assertEquals(2, sum);
    }
}
