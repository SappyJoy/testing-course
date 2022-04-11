import java.util.List;

public class SignDefiner {
    public static Integer defineSign(double x, List<Integer> signs) {
        if (x >= 0)
            return positiveX(x, signs);
        else
            return negativeX(x,signs);
    }

    private static Integer positiveX(double x, List<Integer> signs) {
        double radians = x / Math.PI;
        while (radians > 2)
            radians -= 2;
        if (radians > 0 && radians < 0.5)
            return signs.get(0);
        if (radians > 0.5 && radians < 1)
            return signs.get(1);
        if (radians > 1 && radians < 1.5)
            return signs.get(2);
        if (radians > 1.5 && radians < 2)
            return signs.get(3);
        return 0;
    }
    private static Integer negativeX(double x, List<Integer> signs) {
        double radians = x / -Math.PI;
        while (radians > 2)
            radians -= 2;
        if (radians > 0 && radians < 0.5)
            return signs.get(3);
        if (radians > 0.5 && radians < 1)
            return signs.get(2);
        if (radians > 1 && radians < 1.5)
            return signs.get(1);
        if (radians > 1.5 && radians < 2)
            return signs.get(0);
        return 0;
    }
}
