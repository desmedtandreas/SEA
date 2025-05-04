import java.io.*;

public class NounGenerator {

  String noun = "";
  NounDescriptor nounDescriptor = null;
  StringReader modelReader = new StringReader("models/");
  StringReader templateReader = new StringReader("resources/");
  StringWriter interimWriter = new StringWriter("temp/");
  StringHandler stringHandler = new StringHandler();

  public NounGenerator(String aNoun) {
    noun = aNoun;
    nounDescriptor = new NounDescriptor("models/"+noun);
  }

  public static void main(String [] args) {
    String name = args[0];
    System.out.println("NounGenerator for ["+name+"]");
    NounGenerator nounGenerator = new NounGenerator(name);
    StringWriter sourceCodeWriter = new StringWriter("gen/");

    String nounSourceCode = nounGenerator.generateSkeleton();
    nounSourceCode = nounGenerator.addAttributeDefinitions(nounSourceCode);
    nounSourceCode = nounGenerator.addGetSetMethods(nounSourceCode);
    nounSourceCode = nounGenerator.addOverviewElements(nounSourceCode);
    sourceCodeWriter.writeFile(nounSourceCode, name+".java");

    String nounListSourceCode = nounGenerator.generateNounList();
    sourceCodeWriter.writeFile(nounListSourceCode, name+"List.java");
  }

  public String generateSkeleton() {
    String nounTemplate = templateReader.readFile("NounTemplate.tmpl");
    String result = stringHandler.replaceAll(nounTemplate, "%Noun%", noun);
    interimWriter.writeFile(result, noun+"-skeleton.java");
    return result;
  }

  public String addAttributeDefinitions(String baseContent) {
    String result = baseContent;
    String attrDefTemplate = templateReader.readFile("AttributeDefinitionTemplate.tmpl");
    for (int i=0; i < nounDescriptor.attributeTypes.size(); i++) {
      String attrDefinition = stringHandler.replaceAll(attrDefTemplate, "%type%", nounDescriptor.attributeTypes.get(i));
      attrDefinition = stringHandler.replaceAll(attrDefinition, "%name%", nounDescriptor.attributeNames.get(i));
      result = stringHandler.injectBefore(result, "  // end:attribute-definitions", attrDefinition);
    }
    interimWriter.writeFile(result, noun+"-with-attr-defs.java");
    return result;
  }

  public String addGetSetMethods(String baseContent) {
    String result = baseContent;
    String attrDefTemplate = templateReader.readFile("AttributeGetSetTemplate.tmpl");
    for (int i=0; i < nounDescriptor.attributeTypes.size(); i++) {
      String attrGetSet = stringHandler.replaceAll(attrDefTemplate, "%type%", nounDescriptor.attributeTypes.get(i));
      attrGetSet = stringHandler.replaceAll(attrGetSet, "%name%", nounDescriptor.attributeNames.get(i));
      result = stringHandler.injectBefore(result, "  // end:getset-methods", attrGetSet);
    }
    interimWriter.writeFile(result, noun+"-with-attr-getsets.java");
    return result;
  }

  public String addOverviewElements(String baseContent) {
    String result = baseContent;
    String overviewElemTemplate = templateReader.readFile("OverviewElementTemplate.tmpl");
    for (int i=0; i < nounDescriptor.attributeTypes.size(); i++) {
      String overviewElem = stringHandler.replaceAll(overviewElemTemplate, "%type%", nounDescriptor.attributeTypes.get(i));
      overviewElem = stringHandler.replaceAll(overviewElem, "%name%", nounDescriptor.attributeNames.get(i));
      result = stringHandler.injectBefore(result, "    // end:overview-elements", overviewElem);
    }
    interimWriter.writeFile(result, noun+"-with-overview-elements.java");
    return result;
  }

  public String generateNounList() {
    String nounListTemplate = templateReader.readFile("NounListTemplate.tmpl");
    String result = stringHandler.replaceAll(nounListTemplate, "%Noun%", noun);
    return result;
  }

}

