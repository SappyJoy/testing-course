package domain.model;

import domain.model.composition.Pronoun;
import java.util.ArrayList;

public class Human extends Subject {

  private final Brain brain;

  public Human(String name, Pronoun pronoun) {
    if (pronoun == Pronoun.IT) {
      throw new IllegalArgumentException("Human can be only \"he\" or \"she\"");
    }
    this.name = name;
    this.pronoun = pronoun;
    this.brain = new Brain();
    this.brain.setOwnerName(this.name);
    this.brain.cells.setOwnerName(this.brain.toString());
  }

  public Human(Pronoun pronoun) {
    this(pronoun.toString(), pronoun);
  }

  static class Brain extends Subject {

    private Cells cells;

    public Brain() {
      this.name = "мозг";
      this.pronoun = Pronoun.IT;
      this.cells = new Cells();
      this.cells.setOwnerName(this.toString());
    }

    static class Cells extends Subject {
      ArrayList<Cell> cells;

      public Cells() {
        this.name = "клетки";
        this.cells = new ArrayList<>();
      }
    }

    static class Cell extends Subject {
      public Cell() {
        this.name = "клетка";
        this.pronoun = Pronoun.SHE;
      }
    }

    public Cells getCell() {
      return cells;
    }
  }

  public Brain getBrain() {
    return brain;
  }
}
