public class Log extends MathFunction {

  private final Ln ln = new Ln();
  private final int base;

  public Log(int base) {
    this.base = base;
  }

  @Override
  double calculate(double x, int precision) {
    checkPrecision(precision);
    assert x > 0 : "x should be equals or greater zero";

    return ln.calculate(x, precision) / ln.calculate(base, precision);
  }
}
