import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

  final static Logger logger = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    try {
      Sin sin = new Sin();
      CsvPrinter.print("csv/sin.csv", sin, -2, 2, 0.1, 6);

      Cos cos = new Cos();
      CsvPrinter.print("csv/cos.csv", cos, -2, 2, 0.1, 6);

      Cot cot = new Cot();
      CsvPrinter.print("csv/cot.csv", cot, -2, 2, 0.1, 6);

      Ln ln = new Ln();
      CsvPrinter.print("csv/ln.csv", ln, 0.1, 2, 0.1, 6);

      Log log2 = new Log(2D);
      CsvPrinter.print("csv/log2.csv", log2, 0.1, 2, 0.1, 6);

      Log log3 = new Log(3D);
      CsvPrinter.print("csv/log3.csv", log3, 0.1, 2, 0.1, 6);

      MathFunction system = new FunctionSystem();
      CsvPrinter.print("csv/function.csv", system, -2, 2, 0.1, 6);
    } catch (IOException exception) {
      logger.log(Level.SEVERE, "File cannot be used for printing", exception);
      System.exit(1);
    }
  }
}
