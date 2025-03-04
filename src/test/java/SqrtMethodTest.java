import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class SqrtMethodTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Test finished");
    }

    @Test
    @DisplayName("Square root of positive number")
    void testSqrtOfPositiveNumber() {
        double result = calculator.sqrt(16.0);
        assertEquals(4.0, result, 0.0001, "sqrt(16) should be 4");
    }

    @Test
    @DisplayName("Square root of zero")
    void testSqrtOfZero() {
        double result = calculator.sqrt(0.0);
        assertEquals(0.0, result, 0.0001, "sqrt(0) should be 0");
    }

    @Test
    @DisplayName("Square root of negative number")
    void testSqrtOfNegativeNumber() {
        double result = calculator.sqrt(-25.0); // abs(-25) = 25
        assertEquals(5.0, result, 0.0001, "sqrt(-25) should be 5");
    }

    @Test
    @DisplayName("Square root of fractional positive number")
    void testSqrtOfFractionalPositiveNumber() {
        double result = calculator.sqrt(2.25);
        assertEquals(1.5, result, 0.0001, "sqrt(2.25) should be 1.5");
    }

    @Test
    @DisplayName("Square root of fractional negative number")
    void testSqrtOfFractionalNegativeNumber() {
        double result = calculator.sqrt(-2.25); // abs(-2.25) = 2.25
        assertEquals(1.5, result, 0.0001, "sqrt(-2.25) should be 1.5");
    }
}

