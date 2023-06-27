package cs3500.pa02;

import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * tests for MarkDownFile
 */
public class MarkDownFileTest {

  MarkDownFile file1;
  MarkDownFile file2;

  /**
   * initializes the fields used for tests
   */
  public void setup() {
    long v1 = 1;
    long v2 = 2;

    FileTime time1 = FileTime.from(v1, TimeUnit.MINUTES);
    FileTime time2 = FileTime.from(v2, TimeUnit.MINUTES);

    file1 = new MarkDownFile(time1, time2, "random.md");
    file2 = new MarkDownFile(time2, time1, "bs.md");
  }

  /**
   * tests compareCreationTime() using the creation time of file1 and file2
   */
  @Test
  public void testCompareCreationTime() {
    setup();

    assertEquals(MarkDownFile.compareCreationTime(file1, file2), -1);
    assertEquals(MarkDownFile.compareCreationTime(file2, file1), 1);
    assertEquals(MarkDownFile.compareCreationTime(file1, file1), 0);
    assertEquals(MarkDownFile.compareCreationTime(file2, file2), 0);
  }

  /**
   * tests compareLastModified() using the last modified time of file1 and file2
   */
  @Test
  public void testCompareLastModified() {
    setup();

    assertEquals(MarkDownFile.compareLastModified(file1, file2), 1);
    assertEquals(MarkDownFile.compareLastModified(file2, file1), -1);
    assertEquals(MarkDownFile.compareLastModified(file1, file1), 0);
    assertEquals(MarkDownFile.compareLastModified(file2, file2), 0);
  }

  /**
   * tests compareName() using the file name of file1 and file2
   */
  @Test
  public void testCompareName() {
    setup();

    assertTrue(MarkDownFile.compareName(file1, file2) > 0);
    assertTrue(MarkDownFile.compareName(file2, file1) < 0);
    assertTrue(MarkDownFile.compareName(file1, file1) == 0);
  }
}
