import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class SinMethodTest {

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
    @DisplayName("Sin(0)")
    void testSinOfZero() {
        double result = calculator.sin(0.0);
        assertEquals(0.0, result, 0.0001, "sin(0) should be 0");
    }

    @Test
    @DisplayName("Sin of π/2")
    void testSinOfPiOver2() {
        double result = calculator.sin(Math.PI / 2);
        assertEquals(1.0, result, 0.0001, "sin(π/2) should be 1");
    }

    @Test
    @DisplayName("Sin of π")
    void testSinOfPi() {
        double result = calculator.sin(Math.PI);
        assertEquals(0.0, result, 0.0001, "sin(π) should be 0");
    }

    @Test
    @DisplayName("Sin of negative angle (-π/4)")
    void testSinOfNegativeAngle() {
        double result = calculator.sin(-Math.PI / 4);
        assertEquals(-Math.sqrt(2) / 2, result, 0.0001, "sin(-π/4) should be -√2/2");
    }

    @Test
    @DisplayName("Sine of 45 degrees (π/4 radians)")
    void testSinOfPiOver4() {
        double result = calculator.sin(Math.PI / 4);
        assertEquals(Math.sqrt(2) / 2, result, 0.0001, "sin(π/4) should be √2/2");
    }
}

