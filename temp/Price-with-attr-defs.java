public class Price {

  // start:attribute-definitions
  private String mPriceId;
  private String mName;
  private float mUnitPrice;
  private ProductVariant mProductVariant;
  // end:attribute-definitions

  public Price() {
  }

  @Override
  public String toString() {
    return mPriceId;
  }

  // start:getset-methods
  // end:getset-methods

  public void giveOverview() {
    // start:overview-elements
    // end:overview-elements
  }
}
