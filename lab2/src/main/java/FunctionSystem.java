public class FunctionSystem extends MathFunction {

  private final MathFunction trigonometric;
  private final Ln ln;
  private final Log log2;
  private final Log log3;

  public FunctionSystem() {
    this.trigonometric = new Cot();
    this.ln = new Ln();
    this.log2 = new Log(2D);
    this.log3 = new Log(3D);
  }

  public FunctionSystem(MathFunction trigonometric, Ln ln, Log log2, Log log3) {
    this.trigonometric = trigonometric;
    this.ln = ln;
    this.log2 = log2;
    this.log3 = log3;
  }

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
