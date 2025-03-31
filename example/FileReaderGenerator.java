import java.io.*;

public class FileReaderGenerator {

  String noun = "";
  NounDescriptor nounDescriptor = null;
  StringReader modelReader = new StringReader("models\\");
  StringReader templateReader = new StringReader("resources\\");
  StringWriter interimWriter = new StringWriter("temp\\");
  StringHandler stringHandler = new StringHandler();

  public FileReaderGenerator(String aNoun) {
    noun = aNoun;
    nounDescriptor = new NounDescriptor("models\\"+noun);
  }

  public static void main(String [] args) {
    String name = args[0];
    System.out.println("FileReaderGenerator for ["+name+"]");
    FileReaderGenerator fileReaderGenerator = new FileReaderGenerator(name);
    StringWriter sourceCodeWriter = new StringWriter("gen\\");

    String fileReaderSourceCode = fileReaderGenerator.generateSkeleton();
    fileReaderSourceCode = fileReaderGenerator.addAttributeAssignments(fileReaderSourceCode);
    sourceCodeWriter.writeFile(fileReaderSourceCode, name+"FileReader.java");
  }

  public String generateSkeleton() {
    String fileReaderTemplate = templateReader.readFile("FileReaderTemplate.tmpl");
    String result = stringHandler.replaceAll(fileReaderTemplate, "%Noun%", noun);
    result = stringHandler.replaceAll(result, "%nrOfAttributes%", Integer.toString(nounDescriptor.attributeNames.size()));
    interimWriter.writeFile(result, noun+"-reader-skeleton.java");
    return result;
  }

  private String addAttributeAssignments(String baseContent) {
    String result = baseContent;
    String stringAttrAssignmentTemplate = templateReader.readFile("FileReader-StringAttributeAssignmentTemplate.tmpl");
    String intAttrAssignmentTemplate = templateReader.readFile("FileReader-IntAttributeAssignmentTemplate.tmpl");
    String linkAttrAssignmentTemplate = templateReader.readFile("FileReader-LinkAttributeAssignmentTemplate.tmpl");

    for (int i = 0; i < nounDescriptor.attributeNames.size(); i++) {
      String type = nounDescriptor.attributeTypes.get(i);
      String name = nounDescriptor.attributeNames.get(i);

      if (type.equals("String")) {
        String attrDefinition = stringHandler.replaceAll(stringAttrAssignmentTemplate, "%attr%", name);
        attrDefinition = stringHandler.replaceAll(attrDefinition, "%lineNr%", Integer.toString(i));
        result = stringHandler.injectBefore(result, "                        // end:attribute-assignments", attrDefinition);
        continue;
      }

      if (type.equals("int")) {
        String attrDefinition = stringHandler.replaceAll(intAttrAssignmentTemplate, "%attr%", name);
        attrDefinition = stringHandler.replaceAll(attrDefinition, "%lineNr%", Integer.toString(i));
        result = stringHandler.injectBefore(result, "                        // end:attribute-assignments", attrDefinition);
        continue;
      }

      // Default: link
      String attrDefinition = stringHandler.replaceAll(linkAttrAssignmentTemplate, "%attr%", name);
      attrDefinition = stringHandler.replaceAll(attrDefinition, "%type%", type);
      attrDefinition = stringHandler.replaceAll(attrDefinition, "%lineNr%", Integer.toString(i));
      result = stringHandler.injectBefore(result, "                        // end:attribute-assignments", attrDefinition);
    }
    
    return result;
  }
}

