package domain.model;

public class Violence extends AbstractThing {
  Class classOfViolence;

  public Violence() {
    this.name = "насилие";
  }

  public Violence(Class classOfViolence) {
    this();
    this.classOfViolence = classOfViolence;
  }

  enum Class {
    PHYSICAL("физическое"),
    MORAL("моральное");

    private String string;

    Class(String string) {
      this.string = string;
    }

    @Override
    public String toString() {
      return string;
    }
  }

  @Override
  public String toString() {
    if (classOfViolence == null) {
      return super.toString();
    }
    return classOfViolence.toString() + " " + this.name;
  }
}
