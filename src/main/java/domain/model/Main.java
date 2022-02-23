package domain.model;

import domain.model.IActionable.ActionDescription;
import domain.model.Violence.Class;

public class Main {
  public static void main(String[] args) {
    run(createNarrative());
  }

  public static Narrative createNarrative() {
    Narrative narrative = new Narrative();

    Robot marvin = new Robot("Марвин");
    Human she = new Human(Pronoun.SHE);
    Violence physicalViolence = new Violence(Class.PHYSICAL);
    Door door = new Door();
    marvin.idea.setDescription(marvin.apply(physicalViolence, door));
    //    Idea idea = new Idea(); // Turn it to code

    narrative.addSentence(marvin.watch(she, ActionDescription.COLD_CONTEMPT));
    narrative.addSentence(
        marvin.getLogic().chirp(ActionDescription.DISGUST),
        Union.AND,
        marvin.getLogic().begin(Logic::manipulateWith, marvin.idea));

    return narrative;
  }

  public static void run(Narrative creator) {
    creator.print(System.out);
  }
}
