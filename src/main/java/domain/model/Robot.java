package domain.model;

import domain.model.composition.Pronoun;

public class Robot extends Subject {
  private Pronoun pronoun;
  private Logic logic;
  private Idea idea;

  public Robot(String name, Pronoun pronoun) {
    this.name = name;
    this.pronoun = pronoun;
    logic = new Logic();
    logic.setOwnerName(this.name);
    idea = new Idea();
  }

  public Robot(String name) {
    this(name, Pronoun.IT);
  }

  public Logic getLogic() {
    return logic;
  }

  public Idea getIdea() {
    return idea;
  }

  String watch() {
    return this.name + " наблюдает";
  }

  String watch(ActionDescription description) {
    return watch() + " " + description;
  }

  String watch(Subject what, ActionDescription description) {
    return watch() + " за " + what + " " + description;
  }

  String apply(AbstractThing what, Subject toWhat) {
    return this + " применить " + what + " к " + toWhat;
  }

  String turnAround() {
    return this + " повернулся";
  }

  String turnAround(ActionDescription adverb) {
    return adverb + " " + turnAround();
  }
}
