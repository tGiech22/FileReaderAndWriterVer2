package cs3500.pa02;

// imports
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * Represents a FileReader that implements the FileVisitor interface
 */
public class FileReader implements FileVisitor<Path> {

  static ArrayList<MarkDownFile> listOfMdFiles = new ArrayList<>();
  SrFileScanner srFileScanner = new SrFileScanner();

  /**
   * called before visiting a directory and will continue through to that directory
   *
   * @param dir
   *          a reference to the directory
   * @param attrs
   *          the directory's basic attributes
   *
   * @return the enumeration FileVisitResult.CONTINUE to continue along the directory
   * @throws IOException in case file cannot be visited
   */
  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    return FileVisitResult.CONTINUE;
  }

  /**
   * adds any ".md" files into this listOfMdFiles by creating a new MarkDownFile object
   * with all the necessary attributes and calls getFileContents() on any .md files to get the
   * questions or if the file is .sr will call getFileContents() on the .sr file
   *
   * @param file
   *          a reference to the file
   * @param attrs
   *          the file's basic attributes
   *
   * @return the enumeration FileVisitResult.CONTINUE to continue along the directory
   * @throws IOException in case file cannot be visited
   */
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    if (file.getFileName().toString().endsWith(".md")) {

      listOfMdFiles.add(new MarkDownFile(attrs.creationTime(), attrs.lastModifiedTime(),
          file.getFileName().toString()));

      srFileScanner.getFileContent(file);
    }

    if (file.getFileName().toString().endsWith(".sr")) {
      srFileScanner.getFileContent(file);
    }

    return FileVisitResult.CONTINUE;
  }

  /**
   * will print out the exception if called and continue along the directory
   *
   * @param file
   *          a reference to the file
   * @param exc
   *          the I/O exception that prevented the file from being visited
   *
   * @return the enumeration FileVisitResult.CONTINUE to continue along the directory
   * @throws IOException when called because file cannot be visited
   */
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
    System.err.println(exc);
    return FileVisitResult.CONTINUE;
  }

  /**
   * called after visiting a directory and will continue through said directory
   *
   * @param dir
   *          a reference to the directory
   * @param exc
   *          {@code null} if the iteration of the directory completes without
   *          an error; otherwise the I/O exception that caused the iteration
   *          of the directory to complete prematurely
   *
   * @return the enumeration FileVisitResult.CONTINUE to continue along the directory
   * @throws IOException in case files cannot be visited
   */
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
    return FileVisitResult.CONTINUE;
  }

  /**
   * A getter for this listOfMdFiles
   *
   * @return ArrayList of MarkDownFiles which is a list of all the MD files found in the directory
   */
  public static ArrayList<MarkDownFile> getListOfMdFiles() {
    return listOfMdFiles;
  }
}
