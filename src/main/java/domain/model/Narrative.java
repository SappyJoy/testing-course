package domain.model;

import java.io.PrintStream;

public class Narrative {
  StringBuilder builder;

  public Narrative() {
    builder = new StringBuilder();
  }

  void addSentence(java.lang.Object... words) {
    if (words.length == 0) {
      return;
    }

    if (builder.length() != 0) {
      builder.append(" ");
    }

    builder.append(
        words[0].toString().substring(0, 1).toUpperCase() + words[0].toString().substring(1));

    String delim = " ";
    for (int i = 1; i < words.length; ++i) {
      builder.append(delim);
      builder.append(words[i]);
    }
    builder.append(".");
  }

  void print(PrintStream out) {
    out.print(builder);
  }
}
