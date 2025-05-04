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
  public ProductVariant_OrderList getProductVariant_OrderList() {
    return mProductVariant_OrderList;
  }

  public void setProductVariant_OrderList(ProductVariant_OrderList aProductVariant_OrderList) {
    this.mProductVariant_OrderList = aProductVariant_OrderList;
  }
  public OrderList getOrderList() {
    return mOrderList;
  }

  public void setOrderList(OrderList aOrderList) {
    this.mOrderList = aOrderList;
  }
  public PriceList getPriceList() {
    return mPriceList;
  }

  public void setPriceList(PriceList aPriceList) {
    this.mPriceList = aPriceList;
  }
  public ProductVariantList getProductVariantList() {
    return mProductVariantList;
  }

  public void setProductVariantList(ProductVariantList aProductVariantList) {
    this.mProductVariantList = aProductVariantList;
  }
  public CustomerList getCustomerList() {
    return mCustomerList;
  }

  public void setCustomerList(CustomerList aCustomerList) {
    this.mCustomerList = aCustomerList;
  }
  // end:getset-methods
}

