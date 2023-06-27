package cs3500.pa02;

// imports
import java.util.ArrayList;

/**
 * a representation of a flag
 */
public class FlagCreator {
  static ArrayList<MarkDownFile> listOfMdFiles = new ArrayList<>();

  /**
   * sorts the given listOfMdFiles alphabetically and initializes this listOfMdFiles to the
   * sorted list
   *
   * @param givenListOfFiles is the given list of MarkDownFiles to be sorted
   * @return ArrayList of MarkDownFiles that is sorted alphabetically
   */
  public static ArrayList<MarkDownFile> sortByName(ArrayList<MarkDownFile> givenListOfFiles) {

    listOfMdFiles.add(givenListOfFiles.get(0));

    for (int i = 1; i < givenListOfFiles.size(); i++) {
      if (MarkDownFile.compareName(givenListOfFiles.get(i - 1), givenListOfFiles.get(i)) >= 0) {
        listOfMdFiles.add(givenListOfFiles.get(i));
      } else {
        listOfMdFiles.add((i - 1), givenListOfFiles.get(i));
      }
    }

    return listOfMdFiles;
  }

  /**
   * sorts the given listOfMdFiles by creation time and initializes this listOfMdFiles to the
   * sorted list
   *
   * @param givenListOfFiles is the given list of MarkDownFiles to be sorted
   * @return ArrayList of MarkDownFiles that is sorted by creation time
   */
  public static ArrayList<MarkDownFile> sortByCreation(ArrayList<MarkDownFile> givenListOfFiles) {
    for (int i = 1; i < givenListOfFiles.size(); i++) {
      if (MarkDownFile
          .compareCreationTime(givenListOfFiles.get(i), givenListOfFiles.get(i - 1)) >= 0) {
        listOfMdFiles.add(givenListOfFiles.get(i));
      } else {
        listOfMdFiles.add((i - 1), givenListOfFiles.get(i));
      }
    }

    return listOfMdFiles;
  }

  /**
   * sorts the given listOfMdFiles by last modified time and initializes this listOfMdFiles
   * to the sorted list
   *
   * @param givenListOfFiles is the given list of MarkDownFiles to be sorted
   * @return ArrayList of MarkDownFiles that is sorted by last modified time
   */
  public static ArrayList<MarkDownFile> sortLastModified(ArrayList<MarkDownFile> givenListOfFiles) {
    for (int i = 1; i < givenListOfFiles.size(); i++) {
      if (MarkDownFile
          .compareLastModified(givenListOfFiles.get(i), givenListOfFiles.get(i - 1)) >= 0) {
        listOfMdFiles.add(givenListOfFiles.get(i));
      } else {
        listOfMdFiles.add((i - 1), givenListOfFiles.get(i));
      }
    }

    return listOfMdFiles;
  }

}
