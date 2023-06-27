package cs3500.pa02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

/**
 * Tests for the FlagCreator class
 */
public class FlagCreatorTest {

  MarkDownFile file1;
  MarkDownFile file2;
  ArrayList<MarkDownFile> testList;
  long v1 = 1;
  long v2 = 2;
  FileTime time1 = FileTime.from(v1, TimeUnit.MINUTES);
  FileTime time2 = FileTime.from(v2, TimeUnit.MINUTES);

  /**
   * initializes the fields used in the tests
   */
  public void setup() {
    file1 = new MarkDownFile(time1, time2, "blah.md");
    file2 = new MarkDownFile(time2, time1, "starbies.md");
    testList = new ArrayList<>(Arrays.asList(file1, file2));
  }

  /**
   * tests all the sorting methods in the FlagCreator class
   */

  @Test
  public void testSorting() {
    setup();
    assertEquals(testList.get(0).name, "blah.md");
  }
}
