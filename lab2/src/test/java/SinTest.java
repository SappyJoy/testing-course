import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class SinTest {

    private double DEFAULT_PRECISION = 10E-5;

    @DisplayName("Testing precision of calculating sin")
    @ParameterizedTest
    @CsvSource({
            "0,0",
            "0.1, 0.09983341664682815",
            "0.2, 0.19866933079506122",
            "0.3, 0.29552020666133955",
            "0.4, 0.3894183423086505",
            "0.5, 0.4794255386042",
            "0.6, 0.5646424733950354",
            "0.7, 0.644217687237691",
            "0.8, 0.7173560908995228",
            "0.9, 0.7833269096274834",
            "1  , 0.8414709848079",
            "0.001  , 0.0009999998333333417",
    })
    void TestSin(double x, double expected) {
        assertEquals(expected, Sin.sin(x, DEFAULT_PRECISION), DEFAULT_PRECISION);
    }

    @DisplayName("Testing sin Properties: четность")
    @ParameterizedTest
    @CsvSource({
            "0,0",
            "0.1, 0.09983341664682815",
            "0.2, 0.19866933079506122",
            "0.3, 0.29552020666133955",
            "0.4, 0.3894183423086505",
            "0.5, 0.4794255386042",
            "1  , 0.8414709848079",
            "2  , 0.9092974268256817",
            "5  , -0.95892427",
            "10 , -0.54402111",
            "23 , -0.8462204"
    })
    void TestSinProperties(double x, double expected) {
        assertEquals(-expected, Sin.sin(-x, DEFAULT_PRECISION), DEFAULT_PRECISION);
    }

    @DisplayName("Testing sin Properties: значения на границах четвертей")
    @ParameterizedTest
    @CsvSource({
            "0   ,0",
            "1   ,0",
            "2   ,0",
            "1.5 ,-1",
            "0.5 ,1"
    })
    void TestSinQuarters(double x, double expected) {
        assertEquals(expected, Sin.sin(x * Math.PI, DEFAULT_PRECISION), DEFAULT_PRECISION);
    }

    @DisplayName("Testing sin Properties: знаки в четвертях")
    @ParameterizedTest
    @CsvSource({
            "0.25 , 1",
            "0.75 , 1",
            "1.25 , -1",
            "1.75 , -1",
    })
    void TestSinMiddleQuarters(double x, double expected) {
        assertTrue(expected * Sin.sin(x * Math.PI, DEFAULT_PRECISION) > 0);
    }

}
