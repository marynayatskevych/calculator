import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Execution(ExecutionMode.CONCURRENT)
public class SumMethodTest {
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
    @DisplayName("Addition of two positive long numbers")
    void testAdditionOfTwoPositiveLongNumbers() {
        long result = calculator.sum(10L, 20L);
        assertEquals(30L, result, "10 + 20 should be 30");
        System.out.println(Thread.currentThread().getName() + " is running test");
    }

    @Test
    @DisplayName("Addition of negative and positive long numbers")
    void testAdditionOfNegativeAndPositiveLongNumbers() {
        long result = calculator.sum(-15L, 5L);
        assertEquals(-10L, result, "-15 + 5 should be -10");
        System.out.println(Thread.currentThread().getName() + " is running test");
    }

    @Test
    @DisplayName("Addition of two negative long numbers")
    void testAdditionOfTwoNegativeLongNumbers() {
        long result = calculator.sum(-50L, -25L);
        assertEquals(-75L, result, "-50 + (-25) should be -75");
        System.out.println(Thread.currentThread().getName() + " is running test");
    }

    @Test
    @DisplayName("Addition of two positive double numbers")
    void testAdditionOfTwoPositiveDoubleNumbers() {
        double result = calculator.sum(1.5, 2.5);
        assertEquals(4.0, result, 0.0001, "1.5 + 2.5 should be 4.0");
        System.out.println(Thread.currentThread().getName() + " is running test");
    }

    @Test
    @DisplayName("Addition of negative and positive double numbers")
    void testAdditionOfNegativeAndPositiveDoubleNumbers() {
        double result = calculator.sum(-7.3, 2.2);
        assertEquals(-5.1, result, 0.0001, "-7.3 + 2.2 should be -5.1");
        System.out.println(Thread.currentThread().getName() + " is running test");
    }

    @Test
    @DisplayName("Addition of two negative double numbers")
    void testAdditionOfTwoNegativeDoubleNumbers() {
        double result = calculator.sum(-3.6, -1.4);
        assertEquals(-5.0, result, 0.0001, "-3.6 + (-1.4) should be -5.0");
        System.out.println(Thread.currentThread().getName() + " is running test");
    }
}
