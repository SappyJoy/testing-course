package domain.model;

enum ActionDescription {
  COLD_CONTEMPT("с холодным презрением"),
  DISGUST("с отвращением"),
  ENCORE("на бис"),
  CONVULSIVELY("судорожно"),
  WITH_SPASM_OF_DESPAIR("с судорогой отчаяния");

  private final String string;

  ActionDescription(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return string;
  }
}
