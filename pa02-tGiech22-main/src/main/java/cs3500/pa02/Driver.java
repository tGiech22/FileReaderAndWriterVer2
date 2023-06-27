package cs3500.pa02;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

/**
 * This is the main driver of this project.
 */
public class Driver {

  static Path userInput;
  static String formatOrder;
  static Path whereUserWantsOutput;

  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) throws IOException {

    //C:\Users\tonyg\OOD\work\pa02-tGiech22\ForTests\
    // filename
    // C:\Users\tonyg\OOD\work\pa02-tGiech22\SampleOutput\output3.md

    //C:\Users\tonyg\OOD\work\pa02-tGiech22\testSRFile.sr

    if (args.length == 3) {
      userInput = Path.of(args[0]);
      formatOrder = args[1];
      whereUserWantsOutput = Path.of(args[2]);

      // checking if user input is valid
      if (!Files.exists(userInput) || !Files.isDirectory(userInput)) {
        throw new IllegalArgumentException("Please type in a valid directory.");
      }
      if (formatOrder.isEmpty()) {
        throw new IllegalArgumentException("Please type in a valid format order.");
      }

      // calls FileMdWriter where it will take user input and create the output file
      FileMdWriter f = new FileMdWriter(userInput.toString(),
          formatOrder, whereUserWantsOutput.toString());

    } else if (args.length == 0) {
      // execute controller study session
      StudySessionView view = new StudySessionView(new PrintStream(System.out));
      Readable input = new InputStreamReader(System.in);
      Random rand = new Random();
      Controller study = new Controller(input, view, rand);
      study.run();
    } else {
      throw new IllegalArgumentException("Invalid number of Command Line arguments");
    }
  }
}