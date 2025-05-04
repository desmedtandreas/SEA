public class StringHandler {

  public String replaceAll(String content, String target, String replacement) {
    String outputString = new String(content);
    int position = outputString.indexOf(target);
    while (position > 0) {
      outputString = new String(outputString.substring(0,position) + replacement + 
                     outputString.substring(position + target.length()));
      position = outputString.indexOf(target);
    }
    return outputString;
  }

  public String injectBefore(String content, String target, String injection) {
    String outputString = new String(content);
    int position = outputString.indexOf(target);
    outputString = new String(outputString.substring(0,position) + injection + 
                     outputString.substring(position));
    return outputString;
  }

}
