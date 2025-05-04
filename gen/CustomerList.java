import java.util.ArrayList;

public class CustomerList {

   private String mName;
   private ArrayList<Customer> mMembers;

   public CustomerList(String aName) {
     mName = aName;
     mMembers = new ArrayList<Customer>();
   }

   public String getName() {
     return mName;
   }

   public Customer getMember(String aCustomerId) {
     for (Customer aMember: mMembers) 
       if (aMember.getCustomerId().equals(aCustomerId)) {
          return aMember;
       }
     return null;
   }

   public ArrayList<Customer> getMembers() {
     return mMembers;
   }

   public void addMember(Customer aCustomer) {
     mMembers.add(aCustomer);
   }

   public void addAllMembers(CustomerList aCustomerList) {
     mMembers.addAll(aCustomerList.getMembers());
   }

   public void giveOverview() {
     System.out.println("Customer List: " + mName);
     for (Customer member : mMembers) {
         System.out.println(member);
     }
  }
}

