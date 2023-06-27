package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * tests for the FileReader class
 */
public class FileReaderTest {

  /**
   * tests walking through the file tree
   *
   * @throws IOException when files cannot be visited/fail
   */


  @Test
  public void testFileVisitorMethods() throws IOException {
    Path path = Path.of("ForTests/");
    FileReader fr = new FileReader();
    Files.walkFileTree(path, fr);

    FileReader fr2 = new FileReader();
    Files.walkFileTree(path, fr2);

    ArrayList<MarkDownFile> actualFiles = fr.getListOfMdFiles();
    ArrayList<MarkDownFile> expectedFiles = fr2.getListOfMdFiles();

    // compare both lists
    assertEquals("blah.md", actualFiles.get(0).name);
    assertEquals("starbies.md", actualFiles.get(1).name);
    assertArrayEquals(expectedFiles.toArray(), actualFiles.toArray());
  }


}
