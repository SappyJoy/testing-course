package domain.model;

enum Pronoun {
  HE("он"),
  SHE("она"),
  IT("оно");

  private String string;

  Pronoun(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return string;
  }
}
