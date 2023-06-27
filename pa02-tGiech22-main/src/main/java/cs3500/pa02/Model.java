package cs3500.pa02;

/**
 * A representation of a model
 */
public class Model { // handles/manipulates data
  static int numAnswered;
  static int numEasyToHard;
  static int numHardToEasy;
  static int totalHard;
  static int totalEasy;

  /**
   * the constructor for model
   */
  public Model() {
    numAnswered = 0;
    numEasyToHard = 0;
    numHardToEasy = 0;
    totalHard = 0;
    totalEasy = 0;
  }

  /**
   * increments the number of questions that changed from hard to easy by 1
   */
  public static void addToHardToEasy() {
    numHardToEasy += 1;
  }

  /**
   * increments the number of questions that changed from easy to hard by 1
   */
  public static void addToEasyToHard() {
    numEasyToHard += 1;
  }

  /**
   * increments the total number of hard questions by 1
   */
  public static void addToHard() {
    totalHard += 1;
  }

  /**
   * increments the total number of easy questions by 1
   */
  public static void addToEasy() {
    totalEasy += 1;
  }

  /**
   * increments the number of questions to be answered by 1
   */
  public static void addToNumAnswered() {
    numAnswered += 1;
  }

  /**
   * returns the number of questions that changed from hard to easy
   *
   * @return the number of Hard to Easy
   */
  public static int getNumHardToEasy() {
    return numHardToEasy;
  }

  /**
   * returns the number of questions that changed from easy to hard
   *
   * @return the number of Easy to Hard
   */
  public static int getNumEasyToHard() {
    return numEasyToHard;
  }

  /**
   * returns the total number of hard questions
   *
   * @return the number of totalHard
   */
  public static int getTotalHard() {
    return totalHard;
  }

  /**
   * returns the total number of easy questions
   *
   * @return the total number of Easy
   */
  public static int getTotalEasy() {
    return totalEasy;
  }

  /**
   * returns the total number answered
   *
   * @return the total number Answered
   */
  public static int getNumAnswered() {
    return numAnswered;
  }

}
