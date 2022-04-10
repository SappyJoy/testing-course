public abstract class MathFunction {
  abstract double calculate(double x, int precision);
  Point[] generateArray(double startValue, double endValue, double step, int precision) {
    int size = (int) Math.ceil((endValue - startValue) / step) + 1;
    Point[] result = new Point[size];
    int i = 0;
    for (double val = startValue; val <= endValue; val += step) {
      result[i++] = new Point(val, calculate(val, precision));
    }
    return result;
  }
}

