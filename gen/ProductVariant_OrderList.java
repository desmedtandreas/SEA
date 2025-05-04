import java.util.ArrayList;

public class ProductVariant_OrderList {

   private String mName;
   private ArrayList<ProductVariant_Order> mMembers;

   public ProductVariant_OrderList(String aName) {
     mName = aName;
     mMembers = new ArrayList<ProductVariant_Order>();
   }

   public String getName() {
     return mName;
   }

   public ProductVariant_Order getMember(String aProductVariant_OrderId) {
     for (ProductVariant_Order aMember: mMembers) 
       if (aMember.getProductVariant_OrderId().equals(aProductVariant_OrderId)) {
          return aMember;
       }
     return null;
   }

   public ArrayList<ProductVariant_Order> getMembers() {
     return mMembers;
   }

   public void addMember(ProductVariant_Order aProductVariant_Order) {
     mMembers.add(aProductVariant_Order);
   }

   public void addAllMembers(ProductVariant_OrderList aProductVariant_OrderList) {
     mMembers.addAll(aProductVariant_OrderList.getMembers());
   }

   public void giveOverview() {
     System.out.println("ProductVariant_Order List: " + mName);
     for (ProductVariant_Order member : mMembers) {
         System.out.println(member);
     }
  }
}

