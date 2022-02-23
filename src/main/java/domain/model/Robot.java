package domain.model;

public class Robot extends Object implements IActionable {
  Pronoun pronoun;

  public Robot(String name) {
    this.name = name;
    this.pronoun = Pronoun.IT;
  }

  public Robot(String name, Pronoun pronoun) {
    this.name = name;
    this.pronoun = pronoun;
  }

  String watch() {
    return this.name + " наблюдает";
  }

  String watch(ActionDescription description) {
    return watch() + " " + description;
  }

  String watch(Object what, ActionDescription description) {
    return watch() + " за " + what + " " + description;
  }
}
