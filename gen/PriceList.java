import java.util.ArrayList;

public class PriceList {

   private String mName;
   private ArrayList<Price> mMembers;

   public PriceList(String aName) {
     mName = aName;
     mMembers = new ArrayList<Price>();
   }

   public String getName() {
     return mName;
   }

   public Price getMember(String aPriceId) {
     for (Price aMember: mMembers) 
       if (aMember.getPriceId().equals(aPriceId)) {
          return aMember;
       }
     return null;
   }

   public ArrayList<Price> getMembers() {
     return mMembers;
   }

   public void addMember(Price aPrice) {
     mMembers.add(aPrice);
   }

   public void addAllMembers(PriceList aPriceList) {
     mMembers.addAll(aPriceList.getMembers());
   }

   public void giveOverview() {
     System.out.println("Price List: " + mName);
     for (Price member : mMembers) {
         System.out.println(member);
     }
  }
}

