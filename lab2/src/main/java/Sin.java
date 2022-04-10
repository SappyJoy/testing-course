/*
 *   Класс для вычисления Синуса путем разложения в ряд Тейлора
 *   Формула sin(x) = (-1)^k * x^(2k+1)/(2k+1)!
 */


public class Sin extends MathFunction {

    public static double sin(double x, double precision) {
        double previousValue = x;
        double factorial = 2 * 3;
        double currentValue = x - Math.pow(x, 3) / factorial;
        for (int i = 2; Math.abs(currentValue - previousValue) > precision; i++) {
            previousValue = currentValue;
            double xPower = 2 * i + 1;
            factorial = xPower * (xPower - 1) * factorial;
            currentValue += Math.pow(-1, i) * Math.pow(x, xPower) / factorial;
        }
        return currentValue;
    }

    @Override
    public double calculate(double x, int precision) {
        return sin(x, precision);
    }
}
