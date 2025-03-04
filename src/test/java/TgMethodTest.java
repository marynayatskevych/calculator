import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class TgMethodTest {

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
    @DisplayName("Tangent of zero degrees")
    void testTgOfZero() {
        double result = calculator.tg(0.0); // tg(0) = 0
        assertEquals(0.0, result, 0.0001, "tg(0) should be 0");
    }

    @Test
    @DisplayName("Tangent of 45 degrees (π/4 radians)")
    void testTgOf45Degrees() {
        double result = calculator.tg(Math.PI / 4); // tg(π/4) = 1
        assertEquals(1.0, result, 0.0001, "tg(π/4) should be 1");
    }

    @Test
    @DisplayName("Tangent of 90 degrees (π/2 radians)")
    void testTgOf90Degrees() {
        double result = calculator.tg(Math.PI / 2); // tg(π/2) = Infinity
        assertTrue(Double.isInfinite(result), "tg(π/2) should be Infinity");
    }

    @Test
    @DisplayName("Tangent of negative angle (-45 degrees)")
    void testTgOfNegativeAngle() {
        double result = calculator.tg(-Math.PI / 4); // tg(-π/4) = -1
        assertEquals(-1.0, result, 0.0001, "tg(-π/4) should be -1");
    }

    @Test
    @DisplayName("Tangent of 180 degrees (π radians)")
    void testTgOf180Degrees() {
        double result = calculator.tg(Math.PI); // tg(π) = 0
        assertEquals(0.0, result, 0.0001, "tg(π) should be 0");
    }
}

