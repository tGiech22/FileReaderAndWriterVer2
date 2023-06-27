package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

/**
 * tests for FileMdWriter
 */
public class FileMdWriterTests {

  /**
   * testing method
   *
   * @throws IOException throws exception in case inputs into constructor isn't valid
   */

  @Test
  public void testFileMdWriter() throws IOException {

    FileMdWriter writer = new FileMdWriter("ForTests/", "modified",
        "SampleOutput/output.md");
    assertEquals(writer.formatOrder, "modified");
    writer = new FileMdWriter("ForTests/", "created",
        "SampleOutput/output.md");
    assertEquals(writer.formatOrder, "created");
    writer = new FileMdWriter("ForTests/", "filename",
        "SampleOutput/output.md");
    assertEquals(writer.formatOrder, "filename");

    assertEquals(writer.outputDirectory, "SampleOutput/output.md");
    assertEquals(writer.startingDirectory, "ForTests/");

    Path path = Path.of("SampleOutput/output.md");
    Scanner input = new Scanner(path);
    assertTrue(input.hasNext());
    String s = "";

    s = input.nextLine();
    assertEquals(s, "");
  }

}
