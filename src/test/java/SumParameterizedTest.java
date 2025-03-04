import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class SumParameterizedTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Test finished");
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for sum(long, long)")
    @CsvSource({
            "1, 2, 3",
            "0, 0, 0",
            "-5, 5, 0",
            "-3, -7, -10",
            "100, 200, 300"
    })
    void testSumLong(long a, long b, long expectedResult) {
        long result = calculator.sum(a, b);
        assertEquals(expectedResult, result, a + " + " + b + " should be " + expectedResult);
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for sum(double, double)")
    @CsvSource({
            "1.5, 2.5, 4.0",
            "0.0, 0.0, 0.0",
            "-5.5, 5.5, 0.0",
            "-3.3, -7.7, -11.0",
            "100.1, 200.2, 300.3"
    })
    void testSumDouble(double a, double b, double expectedResult) {
        double result = calculator.sum(a, b);
        assertEquals(expectedResult, result, 0.0001, a + " + " + b + " should be " + expectedResult);
    }
}

