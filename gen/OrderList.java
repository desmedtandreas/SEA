import java.util.ArrayList;

public class OrderList {

   private String mName;
   private ArrayList<Order> mMembers;

   public OrderList(String aName) {
     mName = aName;
     mMembers = new ArrayList<Order>();
   }

   public String getName() {
     return mName;
   }

   public Order getMember(String aOrderId) {
     for (Order aMember: mMembers) 
       if (aMember.getOrderId().equals(aOrderId)) {
          return aMember;
       }
     return null;
   }

   public ArrayList<Order> getMembers() {
     return mMembers;
   }

   public void addMember(Order aOrder) {
     mMembers.add(aOrder);
   }

   public void addAllMembers(OrderList aOrderList) {
     mMembers.addAll(aOrderList.getMembers());
   }

   public void giveOverview() {
     System.out.println("Order List: " + mName);
     for (Order member : mMembers) {
         System.out.println(member);
     }
  }
}

