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
public class FunctionTest {

    @Mock
    private Cot cotMock;

    @Mock
    private Ln lnMock;

    @Mock
    private Log log2Mock;

    @Mock
    private Log log3Mock;

    @DisplayName("Testing function when x <= 0")
    @ParameterizedTest
    @CsvSource({
            "-2,  -0.4161468365471424,   0,                     0,                  0,          -0.4161468365471424",
            "-1.6,-0.029199522301288815, 0,                     0,                  0,          -0.029199522301288815",
            "-1.2, 0.3623577544766736,   0,                     0,                  0,          0.3623577544766736",
            "-0.8, 0.6967067093471654,   0,                     0,                  0,          0.6967067093471654",
            "-0.4, 0.9210609940028851,   0,                     0,                  0,          0.9210609940028851",
            "0,    1,                    0,                     0,                  0,          1                 "
    })
    void integrationTestLeft(double x, double cotExpected,double lnExpected, double log2Expected, double log3Expected, double functionExpected){
        when(cotMock.calculate(eq(x), any(Integer.class))).thenReturn(cotExpected);

        final MathFunction system = new FunctionSystem(cotMock, new Ln(), new Log(2D), new Log(3D));
        assertEquals(functionExpected, system.calculate(x, 6), 6);
    }

    @DisplayName("Testing function when x > 0")
    @ParameterizedTest
    @CsvSource({
            "0.4,  0.9210609940028851,   -0.916290731874155,    -1.3219280948873622,-0.834044,  3",
            "0.8,  0.6967067093471654,   -0.2231435513142097,   -0.3219280948873623,-0.203114,  3",
            "1.2,  0.3623577544766736,   0.1823215567939546 ,   0.2630344058337938, 0.165956,   3",
            "1.6, -0.029199522301288815, 0.47000362924573563,   0.6780719051126377, 0.427816,   3",
            "2,   -0.4161468365471424,   0.6931471805599453,    1,                  0.630930,   3"
    })
    void integrationTestRight(double x, double cotExpected,double lnExpected, double log2Expected, double log3Expected, double functionExpected){
        when(lnMock.calculate(eq(x), any(Integer.class))).thenReturn(lnExpected);
        when(log2Mock.calculate(eq(x), any(Integer.class))).thenReturn(log2Expected);
        when(log3Mock.calculate(eq(x), any(Integer.class))).thenReturn(log3Expected);

        final MathFunction system = new FunctionSystem(new Cot(),lnMock, log2Mock, log3Mock);
        assertEquals(functionExpected, system.calculate(x, 6), 6);
    }
}
