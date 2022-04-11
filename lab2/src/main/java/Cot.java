import java.util.List;

public class Cot extends MathFunction {

    private final MathFunction sin = new Sin();

    private double cot(double x, int precision) {
        assert x / Math.PI != 0 : "дурак оно в бесконечность уйдет";
        double sinus  = sin.calculate(x, precision);
        double ctg_module = Math.sqrt((1 / Math.pow(sinus, 2)) - 1);
        return SignDefiner.defineSign(x, List.of(1, -1, 1, -1)) * ctg_module;
    }

    @Override
    double calculate(double x, int precision) {
        return cot(x, precision);
    }
}