public class Order {

  // start:attribute-definitions
  private String mOrderId;
  private String mLogoUrl;
  private Customer mCustomer;
  // end:attribute-definitions

  public Order() {
  }

  @Override
  public String toString() {
    return mOrderId;
  }

  // start:getset-methods
  // end:getset-methods

  public void giveOverview() {
    // start:overview-elements
    // end:overview-elements
  }
}
