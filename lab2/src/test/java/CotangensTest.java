import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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


    @DisplayName("Testing sin Properties: четность")
    @ParameterizedTest
    @CsvSource({
            "-2,  -0.9092974268256817,-0.4161468365471424",
            "-1.6,-0.9995736030415051,-0.029199522301288815",
            "-1.2,-0.9320390859672263, 0.3623577544766736",
            "-0.8,-0.7173560908995228, 0.6967067093471654",
            "-0.4,-0.3894183423086505, 0.9210609940028851",
            "0,   0,                   1",
            "0.4, 0.3894183423086505,  0.9210609940028851",
            "0.8, 0.7173560908995228,  0.6967067093471654",
            "1.2, 0.9320390859672263,  0.3623577544766736",
            "1.6, 0.9995736030415051,  -0.029199522301288815",
            "2,   0.9092974268256817,  -0.4161468365471424"
    })
    void integrationSinCos(double x, double sinExpected,double cosExpected, double cotExpected){
        when(mockSin.calculate(x, any(Integer.class))).thenReturn(sinExpected);

        final Cot cot = new Cot(mockSin,mockCos);

    }

}
