public class Log extends MathFunction {

  private final Ln ln;
  private final Double base;

  public Log(Double base) {
    this.base = base;
    this.ln = new Ln();
  }

  public Log(Double base, Ln ln) {
    this.base = base;
    this.ln = ln;
  }

  @Override
  double calculate(Double x, Integer precision) {
    checkPrecision(precision);
    assert x > 0 : "x should be equals or greater zero";

    return ln.calculate(x, precision) / ln.calculate(base, precision);
  }
}
