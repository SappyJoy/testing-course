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
public class CosTest {
    private int DEFAULT_PRECISION = 6;

    MathFunction cos = new Cos();

    @Mock Sin mockSin;

    @DisplayName("Testing precision of calculating cos")
    @ParameterizedTest
    @CsvSource({
            "0,1",
            "0.1, 0.9950041652780258",
            "0.2, 0.9800665778412416",
            "2,  -0.4161468365471424",
            "4,  -0.6536436208636119",
            "-2  , -0.4161468365471424"
    })
    void testCos(double x, double expected) {
        assertEquals(expected, cos.calculate(x, DEFAULT_PRECISION), DEFAULT_PRECISION);
    }

    @DisplayName("Integration tests with mock sin")
    @ParameterizedTest
    @CsvSource({
            "-2,-0.9092974268256817,-0.4161468365471424",
            "-1.6,-0.9995736030415051,-0.029199522301288815",
            "-1.2,-0.9320390859672263,0.3623577544766736",
            "-0.8,-0.7173560908995228,0.6967067093471654",
            "-0.4,-0.3894183423086505,0.9210609940028851",
            "0,0,1",
            "0.4,0.3894183423086505,0.9210609940028851",
            "0.8,0.7173560908995228,0.6967067093471654",
            "1.2,0.9320390859672263,0.3623577544766736",
            "1.6,0.9995736030415051,-0.029199522301288815",
            "2,0.9092974268256817,-0.4161468365471424"
    })
    void testCos(double x, double sinExpected,double cosExpected) {
        when(mockSin.calculate(eq(x), any(Integer.class))).thenReturn(sinExpected);
        MathFunction cosWithMock = new Cos(mockSin);
        assertEquals(cosExpected, cosWithMock.calculate(x, DEFAULT_PRECISION), DEFAULT_PRECISION);
    }

}
