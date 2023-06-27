package cs3500.pa02;

// imports
import java.nio.file.attribute.FileTime;

/**
 * A representation of a MarkDownFile
 */
public class MarkDownFile {
  FileTime creationTime;
  FileTime lastModified;
  String name;

  /**
   * The constructor for MarkDownFile
   * instantiates the creationTime, lastModified, and name of each MarkDownFile object
   *
   * @param creationTime the creation time of the MarkDownFile
   * @param lastModified the last modified time of the MarkDownFile
   * @param name the name of the MarkDownFile
   */
  MarkDownFile(FileTime creationTime, FileTime lastModified, String name) {
    this.creationTime = creationTime;
    this.lastModified = lastModified;
    this.name = name;
  }

  /**
   * a comparator that compares two MarkDownFiles based on their creation time
   *
   * @param file1 the MarkDownFile that compareTo() is called on
   * @param file2 the MarkDownFile that is passed into compareTo()
   * @return negative int (-1), positive int (1), or zero
   *
   */
  public static int compareCreationTime(MarkDownFile file1, MarkDownFile file2) {

    return file1.creationTime.compareTo(file2.creationTime);
  }

  /**
   * a comparator that compares two MarkDownFiles based on their last modified time
   *
   * @param file1 the MarkDownFile that compareTo() is called on
   * @param file2 the MarkDownFile that is passed into compareTo()
   * @return negative int (-1), positive int (1), or zero
   */
  public static int compareLastModified(MarkDownFile file1, MarkDownFile file2) {

    return file1.lastModified.compareTo(file2.lastModified);
  }

  /**
   * a comparator that compares two MarkDownFiles based on their file name
   *
   * @param file1 the MarkDownFile that compareTo() is called on
   * @param file2 the MarkDownFile that is passed into compareTo()
   * @return negative int (-1), positive int (1), or zero
   */
  public static int compareName(MarkDownFile file1, MarkDownFile file2) {
    return file1.name.compareTo(file2.name);
  }
}
