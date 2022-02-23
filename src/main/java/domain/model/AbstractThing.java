package domain.model;

public abstract class AbstractThing {
  protected String name;
  protected Pronoun pronoun = Pronoun.IT;

  @Override
  public String toString() {
    if (name == null) {
      return pronoun.toString();
    }
    return name;
  }
}
