package cs3500.pa02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * represents the controller
 */
public class Controller { // accepts user input and has logic for when to call
  // model and view etc.
  private int practiceQuestionNum;
  private ArrayList<Question> questionBank;
  private SrFileScanner srFileScanner;
  private String srFilePath;
  private Readable readable;
  private StudySessionView view;
  private Scanner scannerObj;

  private Random rand;
  /**
   * constructor for Controller
   *
   * @throws IllegalArgumentException if one of the parameters is an invalid argument
   */
  public Controller(Readable readable, StudySessionView view, Random rand)
      throws IllegalArgumentException {
    this.questionBank = new ArrayList<>();
    this.srFileScanner = new SrFileScanner();
    this.srFilePath = "";
    this.readable = readable;
    this.view = view;
    this.scannerObj = new Scanner(readable);
    this.rand = rand;
  }

  /**
   * gets input from the user
   *
   * @return a string of the user input
   */
  public String getsUserInput() {
    return scannerObj.nextLine();
  }

  /**
   *
   * @throws IOException when there is problem with view
   */
  public void run() throws IOException {
    StudySessionView.printWelcomeScreen();
    srFilePath = getsUserInput();

    try {
      StudySessionView.askNumToBeAnswered();
      practiceQuestionNum = Integer.parseInt(getsUserInput());
    } catch (IOException e) {
      System.out.println("Please type in a valid integer: " + e.getMessage());
    }

    FileReader fr = new FileReader();
    Files.walkFileTree(Path.of(srFilePath), fr);

    questionBank = srFileScanner.getQuestionBank();
    int questionNumber = 0;
    Collections.shuffle(questionBank, rand);

    for (int i = questionNumber; i < practiceQuestionNum; i++) {
      if (questionNumber <= practiceQuestionNum) {
        String fullQAndA = questionBank.get(i).getQuestionAndAnswer();
        String questionPart = fullQAndA.substring(0, (fullQAndA.indexOf("?") + 1));
        String answerPart = fullQAndA.substring(fullQAndA.indexOf("?") + 1);
        StudySessionView.showQuestion(questionPart);
        String response = getsUserInput();
        handleResponse(response, i, answerPart);
      }
    }

    StudySessionView view = new StudySessionView(Model.getNumAnswered(), Model.getNumEasyToHard(),
        Model.getNumHardToEasy(), Model.getTotalHard(), Model.getTotalEasy());

    view.outputSessionStats();
  }

  /**
   * handles user input
   *
   * @param userInput a string representing what the user types into the console
   * @param index of the questionBank
   * @param answer the answer to the question
   *
   * @throws IOException when there is problem with study session view
   */

  public void handleResponse(String userInput, int index, String answer) throws IOException {
    switch (userInput) {
      case "1":
        questionBank.get(index).setDifficulty(false); // Change from "hard" to "easy"
        StudySessionView.showAnswer(answer);
        Model.addToHardToEasy();
        Model.addToNumAnswered();
        Model.addToEasy();
        break;
      case "2":
        StudySessionView.showAnswer(answer);
        questionBank.get(index).setDifficulty(true);
        Model.addToEasyToHard();
        Model.addToNumAnswered();
        Model.addToHard();
        break;
      case "3":
        StudySessionView.showAnswer(answer);
        Model.addToNumAnswered();
        break;
      default:
        break;
    }
  }

  /**
   * returns the question bank
   *
   * @return an array list of questions
   */
  public ArrayList<Question> getQuestionBank() {
    return questionBank;
  }
}
