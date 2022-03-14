package domain.model.composition;

public enum PunctuationMark {
  PERIOD("."),
  COMMA(","),
  EXCLAMATION("!"),
  QUESTION("?");

  private final String string;

  PunctuationMark(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return string;
  }
}
