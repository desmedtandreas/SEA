import java.io.*;
import java.util.*;

public class ProductVariant_OrderFileReader {
    private Repository repository;

    public ProductVariant_OrderFileReader() {
        this.repository = Repository.getInstance();
    }

    public ProductVariant_OrderList readCsvFile(String aName) {
        ProductVariant_OrderList instanceList = new ProductVariant_OrderList(aName);
        ProductVariant_OrderList repositoryList = repository.getProductVariant_OrderList();
        try {
            int lineNr = 0;
            File aFile = new File(aName + ".csv");
            BufferedReader aBr = new BufferedReader(new FileReader(aFile));
            String aLine = "";
            while (aLine != null) {
                aLine = aBr.readLine();
                if (aLine != null) {
                    String [] lineParts = aLine.split(";", -1);
                    if (lineParts.length == 4) {
                        ProductVariant_Order instance = new ProductVariant_Order();
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
                        System.out.println("Number of attributes <> 4 on " + lineNr);
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
