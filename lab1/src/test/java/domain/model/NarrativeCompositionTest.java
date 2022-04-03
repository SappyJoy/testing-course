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
  Robot marvin = null;

  // Subjects with which the robot interacts
  Human woman = null;
  Violence moralViolence = null;
  String somethingToSay = null;
  Door door = null;
  Cosmos cosmos = null;

  @BeforeEach
  void setupThis() {
    narrative = new Narrative();

    marvin = new Robot("Марвин");
    woman = new Human(Pronoun.SHE);
    moralViolence = new Violence(Violence.Class.MORAL);
    somethingToSay = "аномалии меня бесят";
    door = new Door();
    cosmos = new Cosmos();
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
    narrative.addSentence(marvin.apply(marvin, marvin));
    narrative.addSentence(marvin.getLogic().measure(ActionDescription.ENCORE, marvin));
    narrative.addSentence(
        Union.THEN,
        moralViolence,
        PunctuationMark.COMMA,
        Union.BUT,
        marvin.watch(marvin.getIdea(), ActionDescription.DISGUST));
    narrative.addSentence(marvin.watch(cosmos, ActionDescription.WITH_SPASM_OF_DESPAIR));
    assertEquals(
        "Марвин применить моральное насилие к она и Марвин повернулся. Затем Марвин логические"
            + " схемы щёлкают, и Марвин логические схемы говорят: \"аномалии меня бесят\". Марвин"
            + " применить Марвин к Марвин. Марвин логические схемы на бис измеряют Марвин. Тогда"
            + " моральное насилие, но Марвин наблюдает за Марвин идея с отвращением. Марвин"
            + " наблюдает за космос с судорогой отчаяния.",
        narrative.toString());

    marvin.getIdea().setDescription(door.toString());
    assertEquals("Марвин идея дверь", marvin.getIdea().toString());
  }

  @Test
  void wrongInputTest() {
    narrative.addSentence(marvin.getIdea()); // Idea.description is null

    NullPointerException thrown1 =
        assertThrows(NullPointerException.class, () -> narrative.addSentence(null, Union.AND));

    cosmos.getClosestCubicParsec().setDescription(null);
    assertNotEquals(null, cosmos.getClosestCubicParsec().toString());

    door.molecularComponents.setOwnerName(null);
    assertNotEquals(null, door.molecularComponents.toString());

    assertNotEquals(null, marvin.watch(null, null));

    woman.getBrain().getCell().setName(null);
    assertNotEquals(null, woman.getBrain().getCell().toString());
  }
}
