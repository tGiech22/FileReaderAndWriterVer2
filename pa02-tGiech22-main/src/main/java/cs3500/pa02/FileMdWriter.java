package cs3500.pa02;

// imports
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A representation of a FileWriter
 */
public class FileMdWriter {

  ArrayList<MarkDownFile> listOfMdFiles;
  ArrayList<Question> questionBank;
  String formatOrder;
  SrFileScanner srFileScanner = new SrFileScanner();
  String outputDirectory;
  String startingDirectory;

  /**
   * A constructor for FileMdWriter
   * Instantiates the FileWriter
   *
   * @param directory is the directory given by the user to search through for the MD files
   * @param formatOrder is the way the user wants content formatted
   * @param outputDirectory is the absolute path that has the file the user wants to write to
   * @throws IOException throws exception when input into constructor isn't valid and when file
   *     can't be visited
   */
  FileMdWriter(String directory, String formatOrder, String outputDirectory) throws IOException {
    // directory initializes startingDirectory which is where user wants searched for MD files
    this.startingDirectory = directory;
    Path to = Path.of(directory);
    // uses the given directory to walk through and find the MD files by calling FileReader
    FileReader fr = new FileReader();
    Files.walkFileTree(to, fr);

    // the formatOrder of the contents of the file
    this.formatOrder = formatOrder;
    // gets the list of MarkDownFiles from FileReader which gets them
    // from the user inputted directory
    this.listOfMdFiles = fr.getListOfMdFiles();

    // where the user wants the contents to be written to
    this.outputDirectory = outputDirectory;

    // gets the list of questions from SRFileScanner
    this.questionBank = srFileScanner.getQuestionBank();

    System.out.println("size: " + questionBank.size());

    writeContents();
  }

  /**
   * sorts the listOfMdFiles based one of three formatOrders:
   * filename
   * creation time
   * last modified time
   *
   * @return ArrayList of MarkDownFiles of the sorted MarkDownFiles
   */
  private ArrayList<MarkDownFile> sortList() {
    ArrayList<MarkDownFile> sortedList = null;

    // cases for how the user wants the content to be formatted/sorted
    if (formatOrder.toLowerCase().equals("filename")) {
      sortedList = FlagCreator.sortByName(listOfMdFiles);
    } else if (formatOrder.toLowerCase().equals("created")) {
      sortedList = FlagCreator.sortByCreation(listOfMdFiles);
    } else if (formatOrder.toLowerCase().equals("modified")) {
      sortedList = FlagCreator.sortLastModified(listOfMdFiles);
    }

    return sortedList;
  }

  /**
   * writes the contents of the sorted listOfMdFiles to the specified output file
   *
   * @throws IOException when input into constructor isn't valid thus fields of class aren't valid
   */
  public void writeContents() throws IOException {
    // sorts the list of MarkDownFiles gotten from the FileReader
    ArrayList<MarkDownFile> sortedList = sortList();

    Path outputPath = Path.of(outputDirectory);

    FileWriter output = new FileWriter(outputPath.toFile());

    // goes through each markdown file in the list and formats their contents
    for (MarkDownFile md : sortedList) {
      formatHelper(md.name, output);
    }

    String srOutputFile = outputDirectory.substring(0, outputDirectory.length() - 2);
    System.out.println(outputDirectory);
    output.close();

    srOutputFile = srOutputFile + "sr";

    Path outputPathSr = Path.of(srOutputFile);

    FileWriter outputSR = new FileWriter(outputPathSr.toFile());

    for (Question question : questionBank) {

      String fullQandA = question.getQuestionAndAnswer();

      String questionPart = fullQandA.substring(0, (fullQandA.indexOf("?") + 1));
      String answerPart = fullQandA.substring(fullQandA.indexOf("?") + 1);

      writeToSrFile(questionPart, answerPart, outputSR);
    }

    outputSR.close();
  }

  public void writeToSrFile(String question, String answer, FileWriter output) throws IOException {
    output.write(question + " " + answer + "\n");
  }

  /**
   * helps writeContent() format the content of each MD file in the sorted
   * listOfMdFiles
   *
   * @param fileName is the fileName of the file whose contents are being formatted
   * @param output is the FileWriter object that will write to the output file
   * @throws IOException throws IO exception for one of methods used in this method
   */
  public void formatHelper(String fileName, FileWriter output) throws IOException {

    // gets the filename to start going through
    Scanner input = new Scanner(new File(startingDirectory + "/" + fileName));

    while (input.hasNextLine()) {
      // separate into different strings for ease of reading
      String header = "";
      String information = ""; // important info in []
      String line = input.nextLine(); // read from the file

      if (line.length() > 0) {
        // checking if it is a header
        if (line.charAt(0) == '#') {
          header = line;
          output.write("\r\n" + header + "\r\n");
          // checking if it is important info
        } else if (line.contains("[") && line.contains("]")) {
          StringBuilder sb = new StringBuilder();

          if (line.charAt(2) == '[') {
            for (int i = line.lastIndexOf("[") + 1; i < line.length(); i++) {
              if (line.charAt(i) == ']') {
                break; // exits if it reaches the closing bracket
              }
              sb.append(line.charAt(i));
            }
          }

          information = sb.toString();
          // makes sure information isn't empty and thus doesn't print unnecessary blank
          // lines to the output file
          if (!information.equals("") && !information.equals(" ")) {
            output.write("- " + information + "\n");
          }
          // checks to see if there is a starting bracket but no ending
        } else if ((line.lastIndexOf("[") > -1) && (line.lastIndexOf("]") < 0)) {
          int startBracket = line.lastIndexOf("[");
          information = line.substring(startBracket);
          output.write("- " + information);
          // checks to see if there is an ending bracket but no starting
        } else if ((line.indexOf("]") > -1) && (line.indexOf("[") < 0)) {
          int endBracket = line.indexOf("]");
          information = line.substring(0, endBracket);
          output.write(information + "\n");
        }
      }
    }
  }

}
