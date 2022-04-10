public class FunctionSystem extends MathFunction {

  private MathFunction trigonometric;
  private MathFunction logarithmic;

  public FunctionSystem() {
    trigonometric = new Sin();
    logarithmic = new Logarithm();
  }

  @Override
  public double calculate(double x, int precision) {
    if (x <= 0) {
      return trigonometric.calculate(x, precision);
    }
    return logarithmic.calculate(x, precision);
  }
}
