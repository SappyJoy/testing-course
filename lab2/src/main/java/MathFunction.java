public abstract class MathFunction {
  abstract double calculate(double x, int precision);

  static void checkPrecision(int precision) throws AssertionError {
    assert precision > 0 && precision <= Double.MIN_EXPONENT * -1 : "Precision should be in interval [1, " + Double.MIN_EXPONENT * -1 + "]";
  }

  Point[] generateArray(double startValue, double endValue, double step, int precision) {
    int size = (int) Math.ceil((endValue - startValue) / step) + 1;
    Point[] result = new Point[size];
    double val = startValue;
    for (int i = 0; i < size; i++) {
      result[i] = new Point(val, calculate(val, precision));
      val += step;
    }
    return result;
  }
}

