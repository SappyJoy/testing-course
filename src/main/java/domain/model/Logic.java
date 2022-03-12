package domain.model;

import domain.model.composition.Helpers;
import java.util.function.Supplier;

public class Logic extends Subject {

  public Logic() {
    this.name = "логические схемы";
  }

  String chirp(ActionDescription description) {
    return this + " стрекочут " + description;
  }

  String manipulate(Subject what) {
    return this + manipulateWith(what);
  }

  static String manipulateWith(java.lang.Object what) {
    return "манипулировать " + what;
  }

  String click() {
    return this + " щёлкают";
  }

  String say() {
    return this + " говорят";
  }

  String say(String what) {
    return say() + ": \"" + what + "\"";
  }

  String decide(Supplier<String> act) {
    return this + " решают " + act.get();
  }

  String produce(java.lang.Object what) {
    return this + " производят " + what;
  }

  String measure(ActionDescription adv, java.lang.Object what) {
    return this + " " + adv + " измеряют " + Helpers.accumulateSeparatedByCommasAndFinalAnd(what);
  }

  String getBored() {
    return this + " всё надоело";
  }

  String shutDown() {
    return this + " отключились";
  }

  static String haveFun() {
    return "забавляться";
  }
}
