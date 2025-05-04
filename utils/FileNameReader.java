import java.io.File;
import java.util.ArrayList;

public class FileNameReader {

    public ArrayList<String> nouns = new ArrayList<String>();

    public FileNameReader(String folderPath) {
        try {
            File folder = new File(folderPath);

            if (folder.exists() && folder.isDirectory()) {
                File[] files = folder.listFiles();

                if (files != null) {
                    for (File file : files) {
                        String name = file.getName();
                        int dotIndex = name.lastIndexOf('.');
                        if (dotIndex > 0) {
                            nouns.add(name.substring(0, dotIndex));
                        } else {
                            nouns.add(name);
                        }
                    }
                }
            } else {
                System.out.println("Directory does not exist: " + folderPath);
            }
        } catch (Exception e) {
            System.out.println("Exception during file reading: " + e.getMessage());
        }
    }
}
