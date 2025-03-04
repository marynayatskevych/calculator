import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class SubMethodTest {

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
    @DisplayName("Subtraction of two positive long numbers")
    void testSubtractionOfTwoPositiveLongNumbers() {
        long result = calculator.sub(20L, 10L);
        assertEquals(10L, result, "20 - 10 should be 10");
    }

    @Test
    @DisplayName("Subtraction of negative and positive long numbers")
    void testSubtractionOfNegativeAndPositiveLongNumbers() {
        long result = calculator.sub(-15L, 5L);
        assertEquals(-20L, result, "-15 - 5 should be -20");
    }

    @Test
    @DisplayName("Subtraction of two negative long numbers")
    void testSubtractionOfTwoNegativeLongNumbers() {
        long result = calculator.sub(-50L, -25L);
        assertEquals(-25L, result, "-50 - (-25) should be -25");
    }

    @Test
    @DisplayName("Subtraction of two positive double numbers")
    void testSubtractionOfTwoPositiveDoubleNumbers() {
        double result = calculator.sub(5.5, 2.0);
        assertEquals(3.5, result, 0.0001, "5.5 - 2.0 should be 3.5");
    }

    @Test
    @DisplayName("Subtraction of negative and positive double numbers")
    void testSubtractionOfNegativeAndPositiveDoubleNumbers() {
        double result = calculator.sub(-7.5, 2.2);
        assertEquals(-9.7, result, 0.0001, "-7.5 - 2.2 should be -9.7");
    }

    @Test
    @DisplayName("Subtraction of two negative double numbers")
    void testSubtractionOfTwoNegativeDoubleNumbers() {
        double result = calculator.sub(-3.5, -1.5);
        assertEquals(-2.0, result, 0.0001, "-3.5 - (-1.5) should be -2.0");
    }
}