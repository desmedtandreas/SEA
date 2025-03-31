import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class StringReader {

  private String targetDir = "";
  public StringReader(String target) {
    targetDir = target;
  }

  public String readFile(String fileName) {
    String outputString = "";
    try {
      File aFile = new File(targetDir+fileName);
      FileReader aFr = new FileReader(aFile);
      BufferedReader aBr = new BufferedReader(aFr);
      String aLine = "";
      while (aLine != null) {
        aLine = aBr.readLine();
        if (aLine != null) outputString = outputString + aLine + "\n";
      }
    } catch (Exception e) { 
      System.out.println("Exception during file reading: " + e.getMessage() + ", trace: " + e.getStackTrace());
    }
    return outputString;
  }
}

