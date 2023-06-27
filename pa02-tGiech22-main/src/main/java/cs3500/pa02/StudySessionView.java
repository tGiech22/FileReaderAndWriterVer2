package cs3500.pa02;

import java.io.IOException;

/**
 * represents the view for a study session
 */
public class StudySessionView {

  // fields
  private static int numAnswered;
  private static int numEasyToHard;
  private static int numHardToEasy;
  private static int totalHard;
  private static int totalEasy;
  private static Appendable appendable;

  /**
   * the constructor for study session view
   *
   * @param numAnswered number of questions answered
   * @param numEasyToHard number of questions that changed from easy to hard
   * @param numHardToEasy number of questions that changed from hard to easy
   * @param totalHard total number of hard questions
   * @param totalEasy total number of easy questions
   */
  StudySessionView(int numAnswered, int numEasyToHard,
                   int numHardToEasy, int totalHard, int totalEasy) {
    this.numAnswered = numAnswered;
    this.numEasyToHard = numEasyToHard;
    this.numHardToEasy = numHardToEasy;
    this.totalHard = totalHard;
    this.totalEasy = totalEasy;
  }

  /**
   * constructor with appendable
   *
   * @param appendable to help print out messages
   */
  StudySessionView(Appendable appendable) {
    this.appendable = appendable;
  }

  /**
   * outputs the stats for a study session
   *
   * @throws IOException when issue with append
   */
  public static void outputSessionStats() throws IOException {
      appendable.append("This session's stats: ");
      appendable.append("\nNumber of questions answered this session: " + numAnswered);
      appendable.append("\nNumber of questions that were changed from EASY to HARD: " +
          numEasyToHard);
      appendable.append("\nNumber of questions that were changed from HARD to EASY: " +
          numHardToEasy);
      appendable.append("\nTotal number of HARD questions: " + totalHard);
      appendable.append("\nTotal number of EASY questions: " + totalEasy);
  }

  /**
   * prints the welcom screen and gets the sr file path from the user
   *
   * @throws IOException when error with append
   */
  public static void printWelcomeScreen() throws IOException {
      appendable.append("-----Welcome!-----");
      appendable.append("\nPlease enter the path to the SR file that contains the question bank: ");
  }

  /**
   * asks the user how many questions they would like to be quized on and gets the int from the user
   *
   * @throws IOException when error with append
   */
  public static void askNumToBeAnswered() throws IOException {
      appendable.append("How many questions would you like to answer for this study session? ");
      appendable.append("(Please only type in an integer)");
  }

  /**
   * shows the user a question at random from the question bank and gets the user to input
   * if the question is easy, hard, or if they need to show the answer
   *
   * @param question that is shown to the user
   *
   * @throws IOException when error with append
   */
  public static void showQuestion(String question) throws IOException {
    // print this question
      appendable.append(question);
      appendable.append("[easy: 1] [hard: 2] [show answer: 3]");
  }

  /**
   * shows the answer for the question
   *
   * @param answer for the question shown
   *
   * @throws IOException when error with append
   */
  public static void showAnswer(String answer) throws IOException {
      appendable.append("Answer: " + answer);
  }

  /**
   * returns the number of questions that changed from hard to easy
   *
   * @return number of questions that changed from hard to easy
   */
  public static int getNumHardToEasy() {
    return numHardToEasy;
  }

  /**
   * returns the number of questions that changed from easy to hard
   *
   * @return number of questions that changed from easy to hard
   */
  public static int getNumEasyToHard() {
    return numEasyToHard;
  }

  /**
   * returns the total number of hard questions
   *
   * @return the total number of hard questions
   */
  public static int getTotalHard() {
    return totalHard;
  }

  /**
   * returns the total number of easy questions
   *
   * @return the total number of easy questions
   */
  public static int getTotalEasy() {
    return totalEasy;
  }

  /**
   * returns the number of questions answered
   *
   * @return the total number answered
   */
  public static int getNumAnswered() {
    return numAnswered;
  }

}
