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
  public String getOrderId() {
    return mOrderId;
  }
  public void setOrderId(String aOrderId) {
    mOrderId = aOrderId;
  }
  public String getLogoUrl() {
    return mLogoUrl;
  }
  public void setLogoUrl(String aLogoUrl) {
    mLogoUrl = aLogoUrl;
  }
  public Customer getCustomer() {
    return mCustomer;
  }
  public void setCustomer(Customer aCustomer) {
    mCustomer = aCustomer;
  }
  // end:getset-methods

  public void giveOverview() {
    // start:overview-elements
    // end:overview-elements
  }
}
