import java.io.*;
import java.util.*;

public class CustomerFileReader {
    private Repository repository;

    public CustomerFileReader() {
        this.repository = Repository.getInstance();
    }

    public CustomerList readCsvFile(String aName) {
        CustomerList instanceList = new CustomerList(aName);
        CustomerList repositoryList = repository.getCustomerList();
        try {
            int lineNr = 0;
            File aFile = new File(aName + ".csv");
            BufferedReader aBr = new BufferedReader(new FileReader(aFile));
            String aLine = "";
            while (aLine != null) {
                aLine = aBr.readLine();
                if (aLine != null) {
                    String [] lineParts = aLine.split(";", -1);
                    if (lineParts.length == 5) {
                        Customer instance = new Customer();
                        if (!(repositoryList.getMember(lineParts[0]) == null)) {
                            instance = repositoryList.getMember(lineParts[0]);
                        }
                        // start:attribute-assignments
                        instance.setCustomerId(lineParts[0]);
                        instance.setFirstName(lineParts[1]);
                        instance.setLastName(lineParts[2]);
                        instance.setBirthDate(lineParts[3]);
                        instance.setPhoneNumber(lineParts[4]);
                        // end:attribute-assignments
                        instanceList.addMember(instance);

                        if ((repositoryList.getMember(lineParts[0]) == null)) {
                        repositoryList.addMember(instance);
                        }
                    } else {
                        System.out.println("Number of attributes <> 5 on " + lineNr);
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
