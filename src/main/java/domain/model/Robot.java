package domain.model;

import domain.model.composition.Pronoun;

public class Robot extends Subject {
  Pronoun pronoun;
  Logic logic;
  Idea idea;

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

  String turnAround(ActionDescription adverb) {
    return adverb + " " + this + " повернулся";
  }
}
