package domain.model;

import java.util.function.Function;

public abstract class Subject extends AbstractThing implements IOwnerable {
  private String ownerName;

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  @Override
  public String getOwnerName() {
    return ownerName;
  }

  String begin(Function<java.lang.Object, String> act, java.lang.Object what) {
    return this.toString() + " начинают " + act.apply(what);
  }

  @Override
  public String toString() {
    if (ownerName == null || ownerName.isEmpty()) {
      return super.toString();
    }
    return ownerName + " " + super.toString();
  }
}
