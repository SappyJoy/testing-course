public class FunctionSystem extends MathFunction {

  private final MathFunction trigonometric = new Cot();
  private final Ln ln = new Ln();
  private final Log log2 = new Log(2D);
  private final Log log3 = new Log(3D);

  @Override
  public double calculate(Double x, Integer precision) {
    if (x <= 0) {
      return trigonometric.calculate(x, precision);
    }
    return Math.pow(Math.pow(log3.calculate(x, precision), 2)
        * ln.calculate(x, precision)
        * log2.calculate(x, precision), 6);
  }
}
