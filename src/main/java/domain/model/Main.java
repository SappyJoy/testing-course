package domain.model;

import domain.model.composition.Narrative;
import domain.model.composition.Pronoun;
import domain.model.composition.PunctuationMark;
import domain.model.composition.Union;

public class Main {
  public static void main(String[] args) {
    run(createNarrative());
  }

  public static Narrative createNarrative() {
    Narrative narrative = new Narrative();

    Robot marvin = new Robot("Марвин");
    Violence physicalViolence = new Violence(Violence.Class.PHYSICAL);
    Door door = new Door(1200000);
    marvin.idea.setDescription(marvin.apply(physicalViolence, door));
    Human she = new Human(Pronoun.SHE);
    Analysis comparativeAnalysis =
        new Analysis(
            Analysis.Class.COMPARATIVE, door.molecularComponents, she.getBrain().getCell());
    Cosmos cosmos = new Cosmos();

    narrative.addSentence(marvin.watch(she, ActionDescription.COLD_CONTEMPT));
    narrative.addSentence(
        marvin.getLogic().chirp(ActionDescription.DISGUST),
        Union.AND,
        marvin.getLogic().begin(Logic::manipulateWith, marvin.idea));
    narrative.addSentence(
        Union.AFTER,
        marvin.getLogic().click(),
        Union.AND,
        marvin.getLogic().say("А стоит ли обращать внимание? Ради чего?"));
    narrative.addSentence(
        Union.THEN,
        marvin.getLogic().decide(Logic::haveFun),
        PunctuationMark.COMMA,
        marvin.getLogic().produce(comparativeAnalysis));
    narrative.addSentence(
        Union.AFTER,
        marvin
            .getLogic()
            .measure(ActionDescription.ENCORE, cosmos.getClosestCubicParsec().getHydrogenLevel()),
        PunctuationMark.COMMA,
        Union.AFTER,
        marvin.getLogic().getBored(),
        PunctuationMark.COMMA,
        Union.AND,
        marvin.getLogic().shutDown());
    narrative.addSentence(marvin.turnAround(ActionDescription.WITH_SPASM_OF_DESPAIR));

    return narrative;
  }

  public static void run(Narrative creator) {
    creator.print(System.out, 70);
  }
}
