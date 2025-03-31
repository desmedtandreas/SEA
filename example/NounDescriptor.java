import java.io.*;
import java.util.ArrayList;

public class NounDescriptor {

  public ArrayList<String> attributeTypes = new ArrayList<String>();
  public ArrayList<String> attributeNames = new ArrayList<String>();

  public NounDescriptor(String aName) {

    try {
      int lineNr = 0;
      File aFile = new File(aName+".descriptor");
      FileReader aFr = new FileReader(aFile);
      BufferedReader aBr = new BufferedReader(aFr);

      String aLine = "";
      String [] lineParts = null;
      while (aLine != null) {
        aLine = aBr.readLine();
        if (aLine != null) {
          lineParts = aLine.split(";", -1);
          if (lineParts.length == 2) {
            System.out.println("Attribute type [" + lineParts[0] + "]" +
                               " and name [" + lineParts[1] + "]");
            attributeTypes.add(lineParts[0]);
            attributeNames.add(lineParts[1]);
          }
          else System.err.println("Number entries <> 3 on " + lineNr);
          lineNr++;
        }
      }
    }
    catch (Exception e) { System.err.println("Failed to read descriptor: "); }
    return;
   }
}