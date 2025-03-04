import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class PowMethodTest {

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
    @DisplayName("Power with positive integer exponent")
    void testPowerWithPositiveIntegerExponent() {
        double result = calculator.pow(2.0, 3.0);
        assertEquals(8.0, result, 0.0001, "2^3 should be 8");
    }

    @Test
    @DisplayName("Power with positive non-integer exponent (floor applied)")
    void testPowerWithPositiveNonIntegerExponent() {
        double result = calculator.pow(2.0, 3.7); // floor(3.7) = 3
        assertEquals(8.0, result, 0.0001, "2^3.7 should be treated as 2^3 = 8");
    }

    @Test
    @DisplayName("Power with negative exponent")
    void testPowerWithNegativeExponent() {
        double result = calculator.pow(2.0, -2.0);
        assertEquals(0.25, result, 0.0001, "2^-2 should be 0.25");
    }

    @Test
    @DisplayName("Power with negative non-integer exponent (floor applied)")
    void testPowerWithNegativeNonIntegerExponent() {
        double result = calculator.pow(2.0, -2.7); // floor(-2.7) = -3
        assertEquals(1.0 / 8.0, result, 0.0001, "2^-2.7 should be treated as 2^-3 = 1/8");
    }

    @Test
    @DisplayName("Power with zero exponent")
    void testPowerWithZeroExponent() {
        double result = calculator.pow(5.0, 0.0);
        assertEquals(1.0, result, 0.0001, "5^0 should be 1");
    }

    @Test
    @DisplayName("Power with base zero")
    void testPowerWithBaseZero() {
        double result = calculator.pow(0.0, 5.0);
        assertEquals(0.0, result, 0.0001, "0^5 should be 0");
    }
}

