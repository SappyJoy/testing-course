import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvPrinter {
  public static void print(final String filename, final MathFunction functionSystem, final double startValue, final double endValue, final double step, final int precision)
      throws IOException {
    final Path path = Paths.get(filename);
    final File file = new File(path.toUri());
    if (file.exists()) {
      file.delete();
    }

    Files.createDirectories(path.getParent());
    file.createNewFile();

    final PrintWriter printWriter = new PrintWriter(file);
    for (Point point : functionSystem.generateArray(startValue, endValue, step, precision)) {
      printWriter.println(point.x() + ", " + point.y());
    }
    printWriter.close();
  }
}
