import java.io.*;
import java.util.*;

public class ProductVariantFileReader {
    private Repository repository;

    public ProductVariantFileReader() {
        this.repository = Repository.getInstance();
    }

    public ProductVariantList readCsvFile(String aName) {
        ProductVariantList instanceList = new ProductVariantList(aName);
        ProductVariantList repositoryList = repository.getProductVariantList();
        try {
            int lineNr = 0;
            File aFile = new File(aName + ".csv");
            BufferedReader aBr = new BufferedReader(new FileReader(aFile));
            String aLine = "";
            while (aLine != null) {
                aLine = aBr.readLine();
                if (aLine != null) {
                    String [] lineParts = aLine.split(";", -1);
                    if (lineParts.length == 7) {
                        ProductVariant instance = new ProductVariant();
                        if (!(repositoryList.getMember(lineParts[0]) == null)) {
                            instance = repositoryList.getMember(lineParts[0]);
                        }
                        // start:attribute-assignments
                        // end:attribute-assignments
                        instanceList.addMember(instance);

                        if ((repositoryList.getMember(lineParts[0]) == null)) {
                        repositoryList.addMember(instance);
                        }
                    } else {
                        System.out.println("Number of attributes <> 7 on " + lineNr);
                    }
                    lineNr++;
                }
            }
            System.out.println("Number of instances that were read: " + lineNr);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return instanceList;
    }

    // start:retrieveOrCreate
    // end:retrieveOrCreate
}
