package domain.model;

public class Logic extends Object implements IActionable {

  public Logic() {
    this.name = "логические схемы";
  }

  String chirp(ActionDescription description) {
    return this.toString() + " стрекочут " + description;
  }

  String manipulate(Object what) {
    return this.toString() + manipulateWith(what);
  }

  static String manipulateWith(Object what) {
    return "манипулировать " + what;
  }
}
