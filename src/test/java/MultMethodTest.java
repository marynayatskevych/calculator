import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class MultMethodTest {
    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Test finished");
    }

    @Test
    @DisplayName("Multiplication of two positive long numbers")
    void testMultiplicationOfTwoPositiveLongNumbers() {
        long result = calculator.mult(5L, 3L);
        assertEquals(15L, result, "5 * 3 should be 15");
    }

    @Test
    @DisplayName("Multiplication of positive and negative long numbers")
    void testMultiplicationOfPositiveAndNegativeLongNumbers() {
        long result = calculator.mult(5L, -3L);
        assertEquals(-15L, result, "5 * -3 should be -15");
    }

    @Test
    @DisplayName("Multiplication of two negative long numbers")
    void testMultiplicationOfTwoNegativeLongNumbers() {
        long result = calculator.mult(-5L, -3L);
        assertEquals(15L, result, "-5 * -3 should be 15");
    }

    @Test
    @DisplayName("Multiplication with zero (positive number)")
    void testMultiplicationWithZeroPositive() {
        long result = calculator.mult(5L, 0L);
        assertEquals(0L, result, "5 * 0 should be 0");
    }

    @Test
    @DisplayName("Multiplication with zero (negative number)")
    void testMultiplicationWithZeroNegative() {
        long result = calculator.mult(-5L, 0L);
        assertEquals(0L, result, "-5 * 0 should be 0");
    }

    @Test
    @DisplayName("Multiplication of two positive double numbers")
    void testMultiplicationOfTwoPositiveDoubleNumbers() {
        double result = calculator.mult(2.5, 4.0);
        assertEquals(10.0, result, 0.0001, "2.5 * 4.0 should be 10.0");
    }

    @Test
    @DisplayName("Multiplication of negative and positive double numbers")
    void testMultiplicationOfNegativeAndPositiveDoubleNumbers() {
        double result = calculator.mult(-3.5, 2.0);
        assertEquals(-7.0, result, 0.0001, "-3.5 * 2.0 should be -7.0");
    }

    @Test
    @DisplayName("Multiplication with zero (double)")
    void testMultiplicationWithZeroDouble() {
        double result = calculator.mult(9.7, 0.0);
        assertEquals(0.0, result, 0.0001, "9.7 * 0.0 should be 0.0");
    }

    @Test
    @DisplayName("Multiplication with rounding down due to Math.floor()")
    void testMultiplicationWithRoundingDown() {
        double result = calculator.mult(2.5, 3.7);  // 2.5 * 3.7 = 9.25
        assertEquals(9.0, result, 0.0001, "2.5 * 3.7 should round to 9.0");
    }
}
