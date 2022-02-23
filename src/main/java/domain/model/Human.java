package domain.model;

public class Human extends Object implements IActionable {

  public Human(String name, Pronoun pronoun) {
    this.name = name;
    this.pronoun = pronoun;
  }

  public Human(Pronoun pronoun) {
    this(pronoun.toString(), pronoun);
  }
}
