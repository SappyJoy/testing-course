package function;

public class MathCalculator {

  public Double arctg(double x, double precision) throws Exception {
    validateParameters(x, precision);
    if (Math.abs(x) == 1) {
      return x * 0.7853981633974483;
    }
    int n = 2;
    double prevValue = x;
    double result = calculateArctgTailorOnStep(x, n++, prevValue);
    for (; Math.abs(result - prevValue) > precision; n++) {
      prevValue = result;
      result = calculateArctgTailorOnStep(x, n, prevValue);
    }
    return calculateArctgTailorOnStep(x, n, result);
  }

  private double calculateArctgTailorOnStep(double x, int n, double prevSum) {
    return prevSum + Math.pow(-1, (n - 1)) * Math.pow(x, 2 * n - 1) / (2 * n - 1);
  }

  private void validateParameters(double x, double precision) throws Exception {
    if(Double.isInfinite(x))
      throw new IllegalArgumentException("X is Infinite");
    if(Double.isInfinite(precision))
      throw new IllegalArgumentException("Precision is Infinite");
    if(Double.isNaN(x))
      throw new IllegalArgumentException("X is NaN");
    if(Double.isNaN(precision))
      throw new IllegalArgumentException("Precision is NaN");
    if (precision <= 0)
      throw new IllegalArgumentException("Precision can't be less or equal 0");
    if (Math.abs(x) > 1)
      throw new IllegalArgumentException(
          "Module of x can't be more than 1, because of the way of calculating");
  }
}
