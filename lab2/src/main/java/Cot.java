import java.util.List;

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
        assert x / Math.PI != 0 : "дурак оно в бесконечность уйдет";
        double sinus  = sin.calculate(x, precision);
        double cosinus = cos.calculate(x,precision);
        return cosinus/sinus;
    }

    @Override
    double calculate(double x, int precision) {
        return cot(x, precision);
    }
}