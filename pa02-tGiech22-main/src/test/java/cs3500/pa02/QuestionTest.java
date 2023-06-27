package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class QuestionTest {
  /**
   *
   */
  @Test
  public void testQuestions() {
    Question question1 = new Question("What is the color of the sky?",
        "The color is blue.", true);

    assertEquals(question1.getQuestionAndAnswer(),
        "What is the color of the sky?The color is blue.");
    assertEquals(question1.getDifficulty(), true);

    Question question2 = new Question("", "", false);
    assertEquals(question2.getQuestionAndAnswer(), "");
    assertEquals(question2.getDifficulty(), false);

    question1.setDifficulty(false);
    assertEquals(question1.getDifficulty(), false);

    question2.setDifficulty(true);
    assertEquals(question2.getDifficulty(), true);
  }
}
