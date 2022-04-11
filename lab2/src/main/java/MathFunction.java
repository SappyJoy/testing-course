import java.util.ArrayList;
import java.util.List;

public abstract class MathFunction {

  static final double EPSILON = 1E-6;
    static final int DEFAULT_MAX_ITERATIONS = 1000;

  abstract double calculate(double x, int precision);

  void checkPrecision(int precision) throws AssertionError {
    assert precision > 0 && precision <= Double.MIN_EXPONENT * -1 : "Precision should be in interval [1, " + Double.MIN_EXPONENT * -1 + "]";
  }

  List<Point> generateArray(double startValue, double endValue, double step, int precision) throws AssertionError {
    List<Point> result = new ArrayList<>();
    for (double x = startValue; x <= endValue; x += step) {
      double y = 0;
      try {
        y = calculate(x, precision);
      } catch (AssertionError | ArithmeticException err) {
        continue;
      }
      result.add(new Point(x, y));
    }
    return result;
  }
}

