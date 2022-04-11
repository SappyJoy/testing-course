import java.util.List;

public class Cos extends MathFunction{
    private final MathFunction sin;

    public Cos() {
        this.sin = new Sin();
    }

    public Cos(MathFunction sin) {
        this.sin = sin;
    }

    private double cos(double x, int precision) {
        double sinus = sin.calculate(x, precision);
        double ctg_module = Math.sqrt(1 - Math.pow(sinus, 2));
        return SignDefiner.defineSign(x, List.of(1, -1, -1, 1)) * ctg_module;
    }

    @Override
    double calculate(Double x, Integer precision) {
        return cos(x, precision);
    }
}

