public class MathCalculator {
    public Double arctg(double x, double precision) {
//        validateParameters(precision);
        int n = 2;
        double prevValue = x;
        double result = calculateArctgTailorOnStep(x, n++, prevValue);
        for (; Math.abs(result - prevValue) > precision; n++) {
            prevValue = result;
            result = calculateArctgTailorOnStep(x, n, prevValue);
        }
        return calculateArctgTailorOnStep(x,n,result);
    }

    private void validateParameters(double precision) {
        if (precision <= 0)
            throw new IllegalArgumentException("Precision can't be less or equal 0");
    }

    private double calculateArctgTailorOnStep(double x, int n, double prevSum) {
        return prevSum + Math.pow(-1, (n - 1)) *
                Math.pow(x, 2 * n - 1) /
                (2 * n - 1);
    }
}
