package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class ModelTest {

  /**
   *
   */
  @Test
  public void testModel() {
    Model model = new Model();

    assertEquals(model.getNumAnswered(), 0);
    assertEquals(model.getNumHardToEasy(), 0);
    assertEquals(model.getNumEasyToHard(), 0);
    assertEquals(model.getTotalHard(), 0);
    assertEquals(model.getTotalEasy(), 0);

    model.addToEasyToHard();
    model.addToHardToEasy();
    model.addToNumAnswered();
    model.addToHard();
    model.addToEasy();

    assertEquals(model.getNumAnswered(), 1);
    assertEquals(model.getNumHardToEasy(), 1);
    assertEquals(model.getNumEasyToHard(), 1);
    assertEquals(model.getTotalHard(), 1);
    assertEquals(model.getTotalEasy(), 1);
  }
}
