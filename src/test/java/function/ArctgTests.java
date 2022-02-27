package function;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArctgTests {

  private MathCalculator calculator = new MathCalculator();
  private double DEFAULT_PRECISION = Math.pow(10D,-15);

  @Test
  void testArctg() throws Exception {
    System.out.println(calculator.arctg(1, DEFAULT_PRECISION).toString());
  }

  @DisplayName("Testing precision of calculating method in interval [0,1]")
  @ParameterizedTest
  @CsvSource({"0,0",
      "0.1, 0.09966865249116204",
      "0.2, 0.19739555984988078",
      "0.3, 0.2914567944778671",
      "0.4, 0.3805063771123649",
      "0.5, 0.4636476090008061",
      "0.6, 0.5404195002705842",
      "0.7, 0.6107259643892086",
      "0.8, 0.6747409422235527",
      "0.9, 0.7328151017865066",
      "1  , 0.7853981633974483",
  })
  void testPrecision(double x, Double expectedResult) throws Exception {
    assertTrue(Math.abs(calculator.arctg(x, DEFAULT_PRECISION) - expectedResult) <= DEFAULT_PRECISION);
  }

  @DisplayName("Testing precision of calculating negative values in interval [-1,1]")
  @ParameterizedTest
  @CsvSource({
      "-0.1, -0.09966865249116204",
      "-0.3, -0.2914567944778671",
      "-0.5, -0.4636476090008061",
      "-0.7, -0.6107259643892086",
      "-0.9, -0.7328151017865066",
      "-1  , -0.7853981633974483",})
  void testNegative(double x, Double expectedResult) throws Exception {
    assertTrue(Math.abs(calculator.arctg(x, DEFAULT_PRECISION) - expectedResult) <= DEFAULT_PRECISION);
  }

  @DisplayName("Testing throwing exception while x more than 1")
  @Test
  void testMoreThen1() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> calculator.arctg(1.1, DEFAULT_PRECISION));
  }

  @DisplayName("Testing throwing exception while x less than -1")
  @Test
  void testLessThenMinus1() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> calculator.arctg(-1.1, DEFAULT_PRECISION));
  }

  @DisplayName("Testing throwing exception while precision equals 0")
  @Test
  void testPrecision0() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> calculator.arctg(-1.1, 0));
  }

  @DisplayName("Testing throwing exception while precision less then 0")
  @Test
  void testPrecisionLess0() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> calculator.arctg(-1.1, -1));
  }


}
