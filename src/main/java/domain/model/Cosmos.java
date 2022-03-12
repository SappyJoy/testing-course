package domain.model;

import domain.model.Cosmos.CubicParsecs.CubicParsec;
import java.util.ArrayList;

public class Cosmos extends AbstractThing {
  CubicParsecs cubicParsecs;

  public Cosmos() {
    this.name = "космос";
    this.cubicParsecs = new CubicParsecs(1202321);
    this.cubicParsecs.setOwnerName(this.name);
  }

  protected static class CubicParsecs extends Subject {
    ArrayList<CubicParsec> parsecs;
    int amount = 0;

    public CubicParsecs(int amount) {
      if (amount <= 0) {
        throw new IllegalArgumentException("Amount of parsecs in cosmos must be more than zero!");
      }
      this.name = "кубические парсеки";
      this.parsecs = new ArrayList<CubicParsec>();
      this.amount = amount;
      for (int i = 0; i < this.amount; ++i) {
        CubicParsec parsec = new CubicParsec();
        parsec.setOwnerName(this.toString());
        this.parsecs.add(parsec);
      }
    }

    protected static class CubicParsec extends Subject {

      private String description = null;
      private final HydrogenLevel hydrogenLevel;

      public CubicParsec() {
        this.name = "кубический парсек";
        this.hydrogenLevel = new HydrogenLevel();
      }

      protected static class HydrogenLevel extends Subject {
        public HydrogenLevel() {
          this.name = "уровень водорода";
        }
      }

      public void setDescription(String description) {
        this.description = description;
      }

      public String getDescription() {
        return description;
      }

      public String getHydrogenLevel() {
        return hydrogenLevel + " в " + this;
      }

      @Override
      public String toString() {
        if (description != null) {
          return description + " " + super.toString();
        }
        return super.toString();
      }
    }

    @Override
    public void setOwnerName(String ownerName) {
      for (int i = 0; i < this.amount; ++i) {
        this.parsecs.get(i).setOwnerName(ownerName);
      }
    }

    CubicParsec getClosest() {
      return parsecs.get(0);
    }
  }

  public CubicParsec getClosestCubicParsec() {
    CubicParsec parsec = cubicParsecs.getClosest();
    parsec.setDescription("ближайший");
    return parsec;
  }
}
