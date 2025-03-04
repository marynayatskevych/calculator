import com.epam.tat.module4.Timeout;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class TimeoutTest {

    @BeforeEach
    void setup() {
        System.out.println("Setup before Timeout test");
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleanup after Timeout test");
    }

    @Test
    @DisplayName("Timeout sleep should wait approximately correct time")
    void testSleepDuration() {
        long start = System.currentTimeMillis();
        Timeout.sleep(1);
        long duration = System.currentTimeMillis() - start;
        assertTrue(duration >= 1000 && duration < 1200,
                "Sleep for 1 second should last between 1000 and 1200 ms");
    }

    @Test
    @DisplayName("Timeout sleep should not throw any exceptions")
    void testSleepNoException() {
        assertDoesNotThrow(() -> Timeout.sleep(1), "Sleep should not throw any exception");
    }
}

