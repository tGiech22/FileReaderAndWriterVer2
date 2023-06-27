package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * tests for the view
 */
public class StudySessionViewTest {
  /**
   * testing the view
   */
  @Test
  public void testStudySessionView() {
    StudySessionView view = new StudySessionView(1, 1, 1, 1, 1);

    assertEquals(view.getNumEasyToHard(), 1);
    assertEquals(view.getNumHardToEasy(), 1);
    assertEquals(view.getTotalHard(), 1);
    assertEquals(view.getTotalEasy(), 1);
    assertEquals(view.getNumAnswered(), 1);
  }
}
