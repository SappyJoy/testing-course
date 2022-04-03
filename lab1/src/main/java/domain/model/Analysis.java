package domain.model;

import domain.model.composition.Helpers;

public class Analysis extends AbstractThing {

  Class classOfAnalysis;
  java.lang.Object[] what;

  public Analysis() {
    this.name = "анализ";
  }

  public Analysis(Class classOfAnalysis) {
    this();
    this.classOfAnalysis = classOfAnalysis;
  }

  public Analysis(Class classOfAnalysis, java.lang.Object... what) {
    this(classOfAnalysis);
    this.what = what;
  }

  enum Class {
    COMPARATIVE("сравнительный"),
    COMPREHENSIVE("всесторонний"),
    SPECTRAL("спектральный");

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
    StringBuilder result = new StringBuilder();
    if (classOfAnalysis != null) {
      result.append(classOfAnalysis).append(" ");
    }
    result.append(this.name);
    if (what != null && what.length != 0) {
      result.append(" ").append(Helpers.accumulateSeparatedByCommasAndFinalAnd(what));
    }

    return result.toString();
  }
}
