public class Logarithm {
    static int DEFAULT_PRECISION = 6;

    public static double ln(double x, int precision) {
        assert precision > 0 && precision <= Double.MIN_EXPONENT * -1 : "Precision should be in interval [1, " + Double.MIN_EXPONENT * -1 + "]";
        assert x > 0 : "x should be equals or greater zero";

        double y = (x - 1) / (x + 1);
        double previousResult = 0;
        double result = 2 * y;
        double epsilon = Math.pow(10, (-1) * precision);

        int i = 1;
        while (Math.abs(result - previousResult) > epsilon * epsilon) {
            previousResult = result;
            result += 2 * Math.pow(y, 2 * i + 1) / (2 * i + 1);
            i++;
        }
        return result;
    }

    public static double ln(double x) {
        return ln(x, DEFAULT_PRECISION);
    }
}
