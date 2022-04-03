package domain.model.composition;

public enum Pronoun {
  HE("он"),
  SHE("она"),
  IT("оно");

  private final String string;

  Pronoun(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return string;
  }
}
