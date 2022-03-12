package domain.model;

public class Door extends Subject {

  MolecularComponents molecularComponents;

  public Door() {
    this(1000000);
  }

  public Door(int amountOfMolecularComponents) {
    this.name = "дверь";
    molecularComponents = new MolecularComponents(amountOfMolecularComponents);
    molecularComponents.setOwnerName(this.name);
  }
}
