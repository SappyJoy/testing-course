package domain.model.composition;

import java.io.PrintStream;

public class Narrative {
  private final StringBuilder builder;

  public Narrative() {
    builder = new StringBuilder();
  }

  public void addSentence(java.lang.Object... words) {
    if (words.length == 0) {
      return;
    }

    if (builder.length() != 0) {
      builder.append(" ");
    }

    builder
        .append(words[0].toString().substring(0, 1).toUpperCase())
        .append(words[0].toString().substring(1));

    String delim = " ";
    for (int i = 1; i < words.length; ++i) {
      if (words[i] != PunctuationMark.COMMA) {
        builder.append(delim);
      }
      builder.append(words[i]);
    }
    builder.append(".");
  }

  public void print(PrintStream out) {
    out.print(builder);
  }

  public void print(PrintStream out, int limit) {
    String[] sentenceElements = builder.toString().split(" ");
    int caret = 0;
    for (String element : sentenceElements) {
      if (caret + element.length() + 1 <= limit) {
        caret += element.length();
        out.print(element);
        out.print(" ");
      } else if (caret == 0 && element.length() > limit) {
        caret = element.length();
        out.print(element);
      } else {
        caret = element.length() + 1;
        out.print("\n");
        out.print(element);
        out.print(" ");
      }

      if (caret >= limit) {
        out.print("\n");
        caret = 0;
      }
    }
  }
}
