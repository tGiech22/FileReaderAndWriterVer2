package cs3500.pa02;

/**
 * A representation of a question
 */
public class Question {
  private String question;
  private String answer;
  private boolean isHard;

  /**
   * the constructor for a question object
   *
   * @param question part of Question object
   * @param answer part of Question object
   * @param isHard determines difficulty
   */
  Question(String question, String answer, boolean isHard) {
    this.question = question;
    this.answer = answer;
    this.isHard = isHard;
  }

  /**
   * sets the difficulty of the question
   *
   * @param newDifficulty determines new difficulty of question
   */
  public void setDifficulty(boolean newDifficulty) {
    this.isHard = newDifficulty;
  }

  /**
   * returns the difficulty of the question
   *
   * @return difficulty of question as boolean isHard
   */
  public boolean getDifficulty() {
    return this.isHard;
  }

  /**
   * returns the contents of the question (question and its corresponding answer)
   *
   * @return a string with the question and answer parts combined
   */
  public String getQuestionAndAnswer() {
    return this.question + this.answer;
  }
}
