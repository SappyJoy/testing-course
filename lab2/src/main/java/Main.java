import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

  final static Logger logger = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    try {
    MathFunction system = new FunctionSystem();
    CsvPrinter.print("csv/function.csv", system, -2, 2, 0.1, 6);
    } catch (IOException exception) {
      logger.log(Level.SEVERE, "File cannot be used for printing", exception);
      System.exit(1);
    }
  }
}
