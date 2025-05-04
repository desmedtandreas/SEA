import java.io.File;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class StringWriter {

  private String targetDir = "";
  public StringWriter(String target) {
    targetDir = target;
  }

  public void writeFile(String content, String fileName) {
    try {
        File nFile = new File(targetDir+fileName);
        if (true) { // (!(nFile.exists())) {
          DataOutputStream nDos = new DataOutputStream(
            new BufferedOutputStream(new FileOutputStream(nFile.getCanonicalPath(), false)));
          nDos.writeBytes(content);
          nDos.flush();
          nDos.close();
        }
        else System.out.println("Writing file failed : " + targetDir+fileName);
    }
    catch (Exception e) { 
      System.out.println("Exception during file writing: " + e.getMessage() + ", trace: " + e.getStackTrace());
    }
  }
}

