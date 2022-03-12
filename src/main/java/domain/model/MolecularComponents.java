package domain.model;

public class MolecularComponents extends Subject {

  private final int amount;

  public MolecularComponents(int amount) {
    if (amount == 1) {
      this.name = "молекулярный компонент";
    } else if (amount > 1) {
      this.name = "молекулярные компоненты";
    } else {
      throw new IllegalArgumentException("Количество должно быть строго больше нуля");
    }
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }
}
