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
public class CotangensTest {

    MathFunction cot = new Cot();

    private int DEFAULT_PRECISION = 6;

    @Mock
    private Sin mockSin;

    @Mock
    private Sin mockCos;

    @ParameterizedTest
    @DisplayName("Testing ln function  (0, ]")
    @CsvSource({
            "-2,6,0.45765755436028577",
            "-1.5,6,-0.07091484430265245",
            "-1,6, -0.6420926159343306",
            "1,6, 0.6420926159343306",
            "2,6,-0.457657",
            "3,6,-7.015252551434534"
    })
    void shouldCalculateCorrectly(double x, int precision, double expected) {
        assertEquals(expected, cot.calculate(x, precision), Math.pow(10, -1 * precision));
    }


    @DisplayName("Testing Котангенс с двумя моками")
    @ParameterizedTest
    @CsvSource({
            "-2,  -0.9092974268256817,-0.4161468365471424,      0.45765755436028577",
            "-1.6,-0.9995736030415051,-0.029199522301288815,    0.029211978199944887",
            "-1.2,-0.9320390859672263, 0.3623577544766736,      -0.3887795693682",
            "-0.8,-0.7173560908995228, 0.6967067093471654,      -0.9712146006504743",
            "-0.4,-0.3894183423086505, 0.9210609940028851,      -2.3652224200391103",
            "0.4, 0.3894183423086505,  0.9210609940028851,      2.3652224200391103",
            "0.8, 0.7173560908995228,  0.6967067093471654,      0.9712146006504743",
            "1.2, 0.9320390859672263,  0.3623577544766736,      0.3887795693682",
            "1.6, 0.9995736030415051,  -0.029199522301288815,   -0.029211978199944887",
            "2,   0.9092974268256817,  -0.4161468365471424,     -0.45765755436028577"
    })
    void integrationSinCos(double x, double sinExpected,double cosExpected, double cotExpected){
        when(mockSin.calculate(eq(x), any(Integer.class))).thenReturn(sinExpected);
        when(mockCos.calculate(eq(x), any(Integer.class))).thenReturn(cosExpected);

        final Cot cotWithMockSinCos = new Cot(mockSin,mockCos);

        assertEquals(cotExpected, cotWithMockSinCos.calculate(x, DEFAULT_PRECISION), DEFAULT_PRECISION);
    }
}
