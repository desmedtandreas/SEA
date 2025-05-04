import java.util.ArrayList;

public class ProductVariantList {

   private String mName;
   private ArrayList<ProductVariant> mMembers;

   public ProductVariantList(String aName) {
     mName = aName;
     mMembers = new ArrayList<ProductVariant>();
   }

   public String getName() {
     return mName;
   }

   public ProductVariant getMember(String aProductVariantId) {
     for (ProductVariant aMember: mMembers) 
       if (aMember.getProductVariantId().equals(aProductVariantId)) {
          return aMember;
       }
     return null;
   }

   public ArrayList<ProductVariant> getMembers() {
     return mMembers;
   }

   public void addMember(ProductVariant aProductVariant) {
     mMembers.add(aProductVariant);
   }

   public void addAllMembers(ProductVariantList aProductVariantList) {
     mMembers.addAll(aProductVariantList.getMembers());
   }

   public void giveOverview() {
     System.out.println("ProductVariant List: " + mName);
     for (ProductVariant member : mMembers) {
         System.out.println(member);
     }
  }
}

