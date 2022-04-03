package domain.model;

public class Idea extends Subject {
  String description;

  public Idea() {
    this.name = "идея";
  }

  void setDescription(String description) {
    this.description = description;
  }

  String what() {
    return this + " " + description;
  }

  @Override
  public String toString() {
    if (description == null) {
      return super.toString();
    }
    return super.toString() + " " + description;
  }
}
