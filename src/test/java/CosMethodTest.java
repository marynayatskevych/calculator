import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class CosMethodTest {

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
    @DisplayName("Cosine of zero")
    void testCosOfZero() {
        double result = calculator.cos(0.0);  // cos(0) = 1
        assertEquals(1.0, result, 0.0001, "cos(0) should be 1");
    }

    @Test
    @DisplayName("Cosine of π/2")
    void testCosOfPiOver2() {
        double result = calculator.cos(Math.PI / 2);  // cos(π/2) = 0
        assertEquals(0.0, result, 0.0001, "cos(π/2) should be 0");
    }

    @Test
    @DisplayName("Cosine of π")
    void testCosOfPi() {
        double result = calculator.cos(Math.PI);  // cos(π) = -1
        assertEquals(-1.0, result, 0.0001, "cos(π) should be -1");
    }

    @Test
    @DisplayName("Cosine of -π/4")
    void testCosOfNegativeAngle() {
        double result = calculator.cos(-Math.PI / 4);  // cos(-π/4) = cos(π/4) = √2/2
        assertEquals(Math.sqrt(2) / 2, result, 0.0001, "cos(-π/4) should be √2/2");
    }
}


