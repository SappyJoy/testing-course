public class FunctionSystem extends MathFunction {

  private final MathFunction trigonometric;
  private final Ln ln;
  private final Log log2;
  private final Log log3;

  public FunctionSystem() {
    trigonometric = new Sin();
    ln = new Ln();
    log2 = new Log(2);
    log3 = new Log(3);
  }

  @Override
  public double calculate(double x, int precision) {
    if (x <= 0) {
      return trigonometric.calculate(x, precision);
    }
    return Math.pow(Math.pow(log3.calculate(x, precision), 2)
        * ln.calculate(x, precision)
        * log2.calculate(x, precision), 6);
  }
}
