package domain.model;

import domain.model.IActionable.ActionDescription;

public class Main {
  public static void main(String[] args) {
    run(createNarrative());
  }

  public static Narrative createNarrative() {
    Narrative narrative = new Narrative();

    Robot marvin = new Robot("Марвин");
    Human she = new Human(Pronoun.SHE);

    narrative.addSentence(marvin.watch(she, ActionDescription.COLD_CONTEMPT));

    return narrative;
  }

  public static void run(Narrative creator) {
    creator.print(System.out);
  }
}
