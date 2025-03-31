import java.io.*;
import java.util.*;

public class MarkdownGenerator {

  String partnerCsvFile = "";
  List<Partner> partners = new ArrayList<>();
  StringReader modelReader = new StringReader("models\\");
  StringReader templateReader = new StringReader("resources\\");
  StringWriter interimWriter = new StringWriter("temp\\");
  StringHandler stringHandler = new StringHandler();

  public MarkdownGenerator(String aPartnerCsvFile) {
    partnerCsvFile = aPartnerCsvFile;
    PartnerFileReader partnerFileReader = new PartnerFileReader();
    partners = partnerFileReader.readCsvFile(partnerCsvFile);
  }

  public static void main(String [] args) {
    String partnerCsvFile = args[0];
    System.out.println("MarkdownGenerator for ["+partnerCsvFile+"]");
    MarkdownGenerator markdownGenerator = new MarkdownGenerator(partnerCsvFile);
    StringWriter markdownWriter = new StringWriter("gen\\md\\");

    String markdownCode = markdownGenerator.generateSkeleton();
    markdownWriter.writeFile(markdownCode, partnerCsvFile+".md");
  }

  public String generateSkeleton() {
    String template = templateReader.readFile("PartnerMarkdownTemplate.tmpl");
    String result = "";
    for (Partner partner : partners) {
      String partnerCode = stringHandler.replaceAll(template, "%partnerName%", partner.getname());
      partnerCode = stringHandler.replaceAll(partnerCode, "%partnerId%", partner.getpartnerId());
      partnerCode = stringHandler.replaceAll(partnerCode, "%vatNumber%", partner.getvatNumber());
      partnerCode = stringHandler.replaceAll(partnerCode, "%contactPerson%", partner.getcontactPerson());
      partnerCode = stringHandler.replaceAll(partnerCode, "%phoneNumber%", partner.getphoneNumber());

      result += partnerCode;
    }
    interimWriter.writeFile(result, partnerCsvFile+"-skeleton.md");
    return result;
  }
}