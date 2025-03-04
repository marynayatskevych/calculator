import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class CtgMethodTest {

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
    @DisplayName("Ctg of π/4")
    void testCtgOfPiOver4() {
        double expected = 1.0;  // ctg(π/4) = cos(π/4)/sin(π/4) = 1
        double actual = calculator.ctg(Math.PI / 4);
        assertEquals(expected, actual, 0.0001, "ctg(π/4) should be 1");
    }

    @Test
    @DisplayName("Ctg of π/3")
    void testCtgOfPiOver3() {
        double expected = Math.cos(Math.PI / 3) / Math.sin(Math.PI / 3);  // ctg(π/3)
        double actual = calculator.ctg(Math.PI / 3);
        assertEquals(expected, actual, 0.0001, "ctg(π/3) should be cos/sin");
    }

    @Test
    @DisplayName("Ctg of 0")
    void testCtgOfZero() {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> calculator.ctg(0.0),
                "ctg(0) should throw ArithmeticException (division by zero)");
    }

    @Test
    @DisplayName("Ctg of π")
    void testCtgOfPi() {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> calculator.ctg(Math.PI),
                "ctg(π) should throw ArithmeticException (division by zero)");
    }
}


