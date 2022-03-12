package domain.model.composition;

public enum Union {
  AND("и"),
  BUT("но"),
  IF("если"),
  AFTER("затем"),
  THEN("тогда");

  private final String string;

  Union(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return string;
  }
}
