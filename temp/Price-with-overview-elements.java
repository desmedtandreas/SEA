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
  public String getPriceId() {
    return mPriceId;
  }
  public void setPriceId(String aPriceId) {
    mPriceId = aPriceId;
  }
  public String getName() {
    return mName;
  }
  public void setName(String aName) {
    mName = aName;
  }
  public float getUnitPrice() {
    return mUnitPrice;
  }
  public void setUnitPrice(float aUnitPrice) {
    mUnitPrice = aUnitPrice;
  }
  public ProductVariant getProductVariant() {
    return mProductVariant;
  }
  public void setProductVariant(ProductVariant aProductVariant) {
    mProductVariant = aProductVariant;
  }
  // end:getset-methods

  public void giveOverview() {
    // start:overview-elements
    System.out.println("mPriceId: " + mPriceId);
    System.out.println("mName: " + mName);
    System.out.println("mUnitPrice: " + mUnitPrice);
    System.out.println("mProductVariant: " + mProductVariant);
    // end:overview-elements
  }
}
