package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * tests for the controller
 */
public class ControllerTest {
  /**
   * test for the controller
   */
  @Test
  public void testController() {
    StringBuilder output = new StringBuilder();
    Readable readable = new InputStreamReader(System.in);
    StudySessionView view = new StudySessionView(output);
    Random rand = new Random(3);

    Controller controller = new Controller(readable, view, rand);

    SrFileScanner srFileScanner = new SrFileScanner();

    assertEquals(controller.getQuestionBank(), srFileScanner.getQuestionBank());

    String testInput = "ForTests/\n" + "3\n1\n2\n3\n";
    StringReader srInput = new StringReader(testInput);
    Controller controller2 = new Controller(srInput, view, rand);

    try {
      controller2.run();
    } catch (IOException e) {
      e.printStackTrace();
    }

    assertEquals("-----Welcome!-----\n"
        + "Please enter the path to the SR file that contains the question bank:"
        + " How many questions would you like to answer for this study session?"
        + " (Please only type in an integer)"
        + "What is a squared plus b squared equal to?"
        + "[easy: 1] [hard: 2] [show answer: 3]"
        + "Answer: It is equal to c squared."
        + "What is the capital of Vietnam?"
        + "[easy: 1] [hard: 2] [show answer: 3]"
        + "Answer: The capital of Vietnam is Hanoi."
        + "Does mint chocolate chip ice cream suck?"
        + "[easy: 1] [hard: 2] [show answer: 3]"
        + "Answer: Yes it does.This session's stats: \n"
        + "Number of questions answered this session: 3\n"
        + "Number of questions that were changed from EASY to HARD: 1\n"
        + "Number of questions that were changed from HARD to EASY: 1\n"
        + "Total number of HARD questions: 1\n"
        + "Total number of EASY questions: 1", output.toString());
  }

}
