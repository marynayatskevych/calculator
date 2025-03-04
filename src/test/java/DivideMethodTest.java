import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class DivideMethodTest {

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
    @DisplayName("Division of two positive long numbers")
    void testDivisionOfTwoPositiveLongNumbers() {
        long result = calculator.div(20L, 5L);
        assertEquals(4L, result, "20 / 5 should be 4");
    }

    @Test
    @DisplayName("Division of negative and positive long numbers")
    void testDivisionOfNegativeAndPositiveLongNumbers() {
        long result = calculator.div(-20L, 5L);
        assertEquals(-4L, result, "-20 / 5 should be -4");
    }

    @Test
    @DisplayName("Division of two negative long numbers")
    void testDivisionOfTwoNegativeLongNumbers() {
        long result = calculator.div(-30L, -5L);
        assertEquals(6L, result, "-30 / -5 should be 6");
    }

    @Test
    @DisplayName("Division resulting in zero")
    void testDivisionResultingInZero() {
        long result = calculator.div(0L, 5L);
        assertEquals(0L, result, "0 / 5 should be 0");
    }

    @Test
    @DisplayName("Division by zero should throw exception")
    void testDivisionByZeroThrowsException() {
        NumberFormatException exception = assertThrows(
                NumberFormatException.class,
                () -> calculator.div(5L, 0L),
                "Division by zero should throw NumberFormatException"
        );
        assertEquals("Attempt to divide by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Division of two positive double numbers")
    void testDivisionOfTwoPositiveDoubleNumbers() {
        double result = calculator.div(10.0, 2.0);
        assertEquals(5.0, result, 0.0001, "10.0 / 2.0 should be 5.0");
    }

    @Test
    @DisplayName("Division of negative and positive double numbers")
    void testDivisionOfNegativeAndPositiveDoubleNumbers() {
        double result = calculator.div(-10.0, 2.0);
        assertEquals(-5.0, result, 0.0001, "-10.0 / 2.0 should be -5.0");
    }

    @Test
    @DisplayName("Division of two negative double numbers")
    void testDivisionOfTwoNegativeDoubleNumbers() {
        double result = calculator.div(-9.0, -3.0);
        assertEquals(3.0, result, 0.0001, "-9.0 / -3.0 should be 3.0");
    }

    @Test
    @DisplayName("Division resulting in zero double numbers")
    void testDivisionResultingInZeroDoubleNumbers() {
        double result = calculator.div(0.0, 5.0);
        assertEquals(0.0, result, 0.0001, "0.0 / 5.0 should be 0.0");
    }

    @Test
    @DisplayName("Division by zero should result in Infinity")
    void testDivisionByZeroDouble(){
        double result = calculator.div(5.0, 0.0);
        assertTrue(Double.isInfinite(result), "5.0 / 0.0 should be Infinity");
    }
}
