package domain.model.composition;

public class Helpers {
  public static String accumulateSeparatedByCommasAndFinalAnd(java.lang.Object... words) {
    if (words.length == 0) {
      return "";
    }

    StringBuilder builder = new StringBuilder();
    builder.append(words[0].toString());

    for (int i = 1; i < words.length - 1; ++i) {
      builder.append(", ").append(words[i].toString());
    }
    if (words.length > 1) {
      builder.append(" ").append(Union.AND).append(" ").append(words[words.length - 1]);
    }

    return builder.toString();
  }
}
