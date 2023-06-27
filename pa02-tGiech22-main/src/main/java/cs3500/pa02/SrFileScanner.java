package cs3500.pa02;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * represents a object that pulls the questions from files
 *
 */
public class SrFileScanner {

  private static ArrayList<Question> questionBank;

  /**
   * constructor for class to initialize the question bank
   */
  SrFileScanner() {
    questionBank = new ArrayList<>();
  }

  /**
   * Gets the contents of a file to find if there are any questions in the file
   *
   * @param srFilePath is the path to the sr File
   * @throws IOException that will be handled
   */
  public void getFileContent(Path srFilePath) throws IOException {
    Scanner readsFromFile = new Scanner(srFilePath);
    String line = "";

    ArrayList<String> fileContents = new ArrayList<>();

    while (readsFromFile.hasNextLine()) {
      line = readsFromFile.nextLine();
      fileContents.add(line);
    }

    String everything = "";

    for (int i = 0; i < fileContents.size(); i++) {
      everything += fileContents.get(i);
    }

    addQuestionToBank(everything);
  }

  /**
   * gets the questions from the given string holding the files entire contents
   *
   * @param everything is the string holding the files entire contents
   */
  public void addQuestionToBank(String everything) {
    String tempHolder = "";
    int startIndex = 0;

    for (int i = 0; i < everything.length(); i++) {

      if (everything.charAt(i) == '[') {
        startIndex = i + 1;
      } else if (everything.charAt(i) == ']') {
        tempHolder = everything.substring(startIndex, i);
        i++;
      }

      if (tempHolder.contains(":::")) {
        String question = tempHolder.substring(0, tempHolder.indexOf(":"));
        String answer = tempHolder.substring(tempHolder.lastIndexOf(":") + 1, tempHolder.length());
        Question questionBankAddition = new Question(question, answer, true);
        questionBank.add(questionBankAddition);
        tempHolder = "";
        System.out.println(questionBank.size());
      }
    }
  }

  /**
   * a getter for the questionBank
   * @return an arraylist of questions
   */
  public ArrayList<Question> getQuestionBank() {
    return questionBank;
  }

}



