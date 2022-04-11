import java.util.List;

import static java.lang.String.format;

public class Cot extends MathFunction {

    private final MathFunction sin;
    private final MathFunction cos;

    public Cot(){
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public Cot(MathFunction sin, MathFunction cos){
        this.sin = sin;
        this.cos = cos;
    }

    private double cot(double x, int precision) {
        if (x < EPSILON && x > -EPSILON) {
            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
        }

        double sinus  = sin.calculate(x, precision);
        double cosinus = cos.calculate(x,precision);
        return cosinus/sinus;
    }

    @Override
    double calculate(double x, int precision) {
        return cot(x, precision);
    }
}