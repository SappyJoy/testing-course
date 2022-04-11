import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LogTest {

    @Mock Ln mockLn;

    @ParameterizedTest
    @CsvSource({
            "0.11, 5, -2.20727, -3.1844245711374275",
            "0.23, 5, -1.46968,-2.1202942337177118",
            "0.5, 6, -0.693147, -1",
            "1, 6, 0, 0",
            "1.2, 6, 0.182322,0.2630344058337938",
            "3, 6, 1.098612, 1.584962500721156",
            "5, 6, 1.609438, 2.321928094887362",
    })
    void integrationTestWithMockLn(double x, int precision, double lnExpected, double log2Expected) {
        when(mockLn.calculate(eq(2D), any(Integer.class))).thenReturn(0.6931471805599453);
        when(mockLn.calculate(eq(x), any(Integer.class))).thenReturn(lnExpected);
        MathFunction log2WithMock = new Log(2D,mockLn);
        assertEquals(log2Expected, log2WithMock.calculate(x, precision), Math.pow(10, -1 * precision));
    }
}
