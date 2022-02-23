package function;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArctgTests {
  private MathCalculator calculator = new MathCalculator();

  @Test
  void testArctg() {
    System.out.printf(calculator.arctg(3, 0.0001).toString());
  }

  @ParameterizedTest
  @CsvSource({"0,0.001,0", "1,0.0001, 0.78539", "3,0.0001, 1.2490"})
  void testAround0(double x, double precision, double expectedResult) {
    assertTrue(Math.abs(calculator.arctg(x, precision) - expectedResult) < precision);
  }
}
