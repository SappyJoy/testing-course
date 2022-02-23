package domain.model;

public enum Union {
  AND("и"),
  BUT("но"),
  IF("если");

  private String string;

  Union(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return string;
  }
}
