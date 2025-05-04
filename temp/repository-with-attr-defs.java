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

