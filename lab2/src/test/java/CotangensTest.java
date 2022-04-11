import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CotangensTest {

    MathFunction cot = new Cot();

    @ParameterizedTest
    @DisplayName("Testing ln function  (0, ]")
    @CsvSource({
            "-1.5,6,-0.07091484430265245",
            "-1,6, -0.6420926159343306",
            "1,6, 0.6420926159343306",
            "2,6,-0.457657",
            "3,6,-7.015252551434534"
    })
    void shouldCalculateCorrectly(double x, int precision, double expected) {
        assertEquals(expected, cot.calculate(x, precision), Math.pow(10, -1 * precision));
    }
}
