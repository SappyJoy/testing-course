package domain.model;

public interface IActionable {
  enum ActionDescription {
    COLD_CONTEMPT("с холодным презрением"),
    DISGUST("с отвращением");

    private String string;

    ActionDescription(String string) {
      this.string = string;
    }

    @Override
    public String toString() {
      return string;
    }
  }
}
