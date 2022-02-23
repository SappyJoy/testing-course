package domain.model;

public class Human extends Object implements IActionable {
  Pronoun pronoun;

  public Human(String name, Pronoun pronoun) {
    this.name = name;
    this.pronoun = pronoun;
  }

  public Human(Pronoun pronoun) {
    this.pronoun = pronoun;
    this.name = pronoun.toString();
  }

  @Override
  public String toString() {
    return name;
  }
}
