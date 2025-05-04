public class Repository {
  private static Repository instance;

  // start:attribute-definitions
  private ProductVariant_OrderList mProductVariant_OrderList;
  private OrderList mOrderList;
  private PriceList mPriceList;
  private ProductVariantList mProductVariantList;
  private CustomerList mCustomerList;
  // end:attribute-definitions

  private Repository() {
    // start:attribute-assignment
    this.mProductVariant_OrderList = new ProductVariant_OrderList("ProductVariant_Order Repository");
    this.mOrderList = new OrderList("Order Repository");
    this.mPriceList = new PriceList("Price Repository");
    this.mProductVariantList = new ProductVariantList("ProductVariant Repository");
    this.mCustomerList = new CustomerList("Customer Repository");
    // end:attribute-assignment
  }

  public static Repository getInstance() {
    if (instance == null) {
      instance = new Repository();
    }

      return instance;
    }

  // start:getset-methods
  // end:getset-methods
}

