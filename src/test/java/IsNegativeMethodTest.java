import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class IsNegativeMethodTest {

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
    void testZeroIsNotNegative() {
        assertFalse(calculator.isNegative(0L), "0 should not be negative");
    }

    @Test
    @DisplayName("Negative number")
    void testNegativeNumberIsNegative() {
        assertTrue(calculator.isNegative(-5L), "-5 should be negative");
    }

    @Test
    @DisplayName("Positive number")
    void testPositiveNumberIsNotNegative() {
        assertFalse(calculator.isNegative(5L), "5 should not be negative");
    }
}

