package domain.model;

import java.util.function.Function;

public abstract class Object extends AbstractThing {
  protected String ownerName;

  public void setName(String name) {
    this.name = name;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  String begin(Function<Object, String> act, Object what) {
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
