package domain.model.composition;

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

  public String toString() {
    return builder.toString();
  }

  public String toString(int limit) {
    StringBuilder result = new StringBuilder();
    String[] sentenceElements = builder.toString().split(" ");
    int caret = 0;
    for (String element : sentenceElements) {
      if (caret + element.length() + 1 <= limit) {
        caret += element.length();
        result.append(element).append(" ");
      } else if (caret == 0 && element.length() > limit) {
        caret = element.length();
        result.append(element);
      } else {
        caret = element.length() + 1;
        result.append("\n").append(element).append(" ");
      }

      if (caret >= limit) {
        result.append("\n");
        caret = 0;
      }
    }

    return result.toString();
  }
}
