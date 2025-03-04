import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class IsPositiveMethodTest {

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
    @DisplayName("Zero")
    void testZeroIsNotPositive() {
        assertFalse(calculator.isPositive(0L), "0 should not be positive");
    }

    @Test
    @DisplayName("Positive number")
    void testPositiveNumberIsPositive() {
        assertTrue(calculator.isPositive(5L), "5 should be positive");
    }

    @Test
    @DisplayName("Negative number")
    void testNegativeNumberIsNotPositive() {
        assertFalse(calculator.isPositive(-3L), "-3 should not be positive");
    }
}

