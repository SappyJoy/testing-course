package domain.model;

public class Idea extends Object {
  String what;
  String description;

  public Idea() {
    this.name = "идея";
  }

  void setDescription(String description) {
    this.description = description;
  }

  String what() {
    return this.toString() + " " + description;
  }

  @Override
  public String toString() {
    if (description == null) {
      return super.toString();
    }
    return super.toString() + " " + description;
  }
}
