import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LogarithmTest {

    private final double DEFAULT_PRECISION = 6;

    @ParameterizedTest
    @DisplayName("Testing ln function  (0, ]")
    @CsvSource({
            "0.0001, 5, -9.21034",
            "0.11, 5, -2.20727",
            "0.23, 5, -1.46968",
            "0.5, 6, -0.693147",
            "0.779, 6, -0.249744",
            "1, 6, 0",
            "1.2, 6, 0.182322",
            "2, 6, 0.693147",
            "3, 6, 1.098612",
            "4, 6, 1.386294",
            "5, 6, 1.609438",
            "9, 6, 2.197224",
            "9, 6, 2.197224",
            "15, 5, 2.70805",
            "153, 5, 5.030438",
    })
    void testLnWithCorrectValues(double x, int precision, double expected) {
        assertEquals(expected, Logarithm.ln(x, precision), Math.pow(10, -1 * precision));
    }

    @Test
    void testLnPrecisionEqualsZero() {
        assertThrows(AssertionError.class, () -> Logarithm.ln(5, 0));
    }

    @Test
    void testLnPrecisionLessThanZero() {
        assertThrows(AssertionError.class, () -> Logarithm.ln(5, -3));
    }

    @ParameterizedTest
    @DisplayName("Testing ln function with x less or equals zero")
    @CsvSource({
            "0", "-0.123", "-0.21", "-132", "-1024", "" + Integer.MIN_VALUE
    })
    void testLnWithWrongValues(double x) {
        assertThrows(AssertionError.class, () -> Logarithm.ln(x));
    }
}
