public class Ln extends MathFunction {
    static int DEFAULT_PRECISION = 6;

    private double ln(double x, int precision) throws AssertionError {
        checkPrecision(precision);
        assert x > 0 : "x should be greater than zero";

        double y = (x - 1) / (x + 1);
        double previousResult = 0;
        double result = 2 * y;
        double epsilon = Math.pow(10, (-1) * precision);

        int i = 1;
        while (i < DEFAULT_MAX_ITERATIONS && Math.abs(result - previousResult) > epsilon * epsilon) {
            previousResult = result;
            result += 2 * Math.pow(y, 2 * i + 1) / (2 * i + 1);
            i++;
        }
        return result;
    }

    public double ln(double x) {
        return ln(x, DEFAULT_PRECISION);
    }

    @Override
    public double calculate(Double x, Integer precision) {
        return ln(x, precision);
    }
}
