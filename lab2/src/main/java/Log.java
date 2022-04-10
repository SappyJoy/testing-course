public class Log extends MathFunction {

  private final Ln ln;
  private final int base;

  public Log(int base) {
    this.ln = new Ln();
    this.base = base;
  }

  @Override
  double calculate(double x, int precision) {
    checkPrecision(precision);
    assert x > 0 : "x should be equals or greater zero";

    return ln.calculate(x, precision) / ln.calculate(base, precision);
  }
}
