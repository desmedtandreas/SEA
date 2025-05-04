import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class RepositoryGenerator {
  
  FileNameReader fileNameReader = null;
  StringReader templateReader = new StringReader("resources/");
  StringWriter interimWriter = new StringWriter("temp/");
  StringHandler stringHandler = new StringHandler();

  public RepositoryGenerator() {
    fileNameReader = new FileNameReader("models/");
  }

  public static void main(String [] args) {
    System.out.println("RepositoryGenerator");
    RepositoryGenerator repositoryGenerator = new RepositoryGenerator();
    StringWriter sourceCodeWriter = new StringWriter("gen/");
    
    String repositorySourceCode = repositoryGenerator.generateSkeleton();
    repositorySourceCode = repositoryGenerator.addAttributeDefinitions(repositorySourceCode);
    repositorySourceCode = repositoryGenerator.addAttributeAssignment(repositorySourceCode);
    repositorySourceCode = repositoryGenerator.addGetSetMethods(repositorySourceCode);

    sourceCodeWriter.writeFile(repositorySourceCode, "Repository.java");
  }

  public String generateSkeleton() {
    String repositoryTemplate = templateReader.readFile("RepositoryTemplate.tmpl");
    interimWriter.writeFile(repositoryTemplate, "repository-skeleton.java");
    return repositoryTemplate;
  }

  public String addAttributeDefinitions(String baseContent) {
    String result = baseContent;
    String attrDefTemplate = templateReader.readFile("RepositoryAttributeDefinitionTemplate.tmpl");
    for (int i=0; i < fileNameReader.nouns.size(); i++) {
      String attrDefinition = stringHandler.replaceAll(attrDefTemplate, "%Noun%", fileNameReader.nouns.get(i));
      result = stringHandler.injectBefore(result, "  // end:attribute-definitions", attrDefinition);
    }
    interimWriter.writeFile(result, "repository-with-attr-defs.java");
    return result;
  }

  public String addAttributeAssignment(String baseContent) {
    String result = baseContent;
    String attrAssignTemplate = templateReader.readFile("RepositoryAttributeAssignmentTemplate.tmpl");
    for (int i=0; i < fileNameReader.nouns.size(); i++) {
      String attrAssignment = stringHandler.replaceAll(attrAssignTemplate, "%Noun%", fileNameReader.nouns.get(i));
      result = stringHandler.injectBefore(result, "    // end:attribute-assignment", attrAssignment);
    }
    interimWriter.writeFile(result, "repository-with-attr-assign.java");
    return result;
  }

  public String addGetSetMethods(String baseContent) {
    String result = baseContent;
    String attrGetSetTemplate = templateReader.readFile("RepositoryGetSetTemplate.tmpl");
    for (int i=0; i < fileNameReader.nouns.size(); i++) {
      String attrGetSet = stringHandler.replaceAll(attrGetSetTemplate, "%Noun%", fileNameReader.nouns.get(i));
      result = stringHandler.injectBefore(result, "  // end:getset-methods", attrGetSet);
    }
    interimWriter.writeFile(result, "repository-with-attr-getsets.java");
    return result;
  }

}