package domain.model;

import static org.junit.jupiter.api.Assertions.*;

import domain.model.composition.Narrative;
import domain.model.composition.Pronoun;
import domain.model.composition.PunctuationMark;
import domain.model.composition.Union;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NarrativeCompositionTest {

  Narrative narrative = null;

  // Dramatis personae
  Robot marvin = new Robot("Марвин");

  // Subjects with which the robot interacts
  Human woman = new Human(Pronoun.SHE);
  Violence moralViolence = new Violence(Violence.Class.MORAL);
  String somethingToSay = "аномалии меня бесят";
  Door door = new Door();
  Cosmos cosmos = new Cosmos();

  @BeforeEach
  void setupThis() {
    narrative = new Narrative();
  }

  @Test
  void addSentenceTest() {
    narrative.addSentence(marvin.watch(woman, ActionDescription.COLD_CONTEMPT));
    narrative.addSentence(marvin.getLogic().manipulate(woman.getBrain().getCell()));
    narrative.addSentence(
        marvin.getLogic().measure(ActionDescription.ENCORE, door.molecularComponents.getAmount()));
    assertEquals(
        "Марвин наблюдает за она с холодным презрением. Марвин логические схемы манипулировать она"
            + " мозг клетки. Марвин логические схемы на бис измеряют количество дверь молекулярные"
            + " компоненты.",
        narrative.toString());
  }

  @Test
  void robotTest() {
    narrative.addSentence(marvin.apply(moralViolence, woman), Union.AND, marvin.turnAround());
    narrative.addSentence(
        Union.AFTER,
        marvin.getLogic().click(),
        PunctuationMark.COMMA,
        Union.AND,
        marvin.getLogic().say(somethingToSay));
    assertEquals(
        "Марвин применить моральное насилие к она и Марвин повернулся. Затем Марвин логические"
            + " схемы щёлкают, и Марвин логические схемы говорят: \"аномалии меня бесят\".",
        narrative.toString());
  }
}
