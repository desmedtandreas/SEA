public class ProductVariant {

  // start:attribute-definitions
  private String mProductVariantId;
  private float mVatRate;
  private float mStockQuantity;
  private float mOrderQuantity;
  private float mWeight;
  private String mDimensions;
  private String mColor;
  // end:attribute-definitions

  public ProductVariant() {
  }

  @Override
  public String toString() {
    return mProductVariantId;
  }

  // start:getset-methods
  public String getProductVariantId() {
    return mProductVariantId;
  }
  public void setProductVariantId(String aProductVariantId) {
    mProductVariantId = aProductVariantId;
  }
  public float getVatRate() {
    return mVatRate;
  }
  public void setVatRate(float aVatRate) {
    mVatRate = aVatRate;
  }
  public float getStockQuantity() {
    return mStockQuantity;
  }
  public void setStockQuantity(float aStockQuantity) {
    mStockQuantity = aStockQuantity;
  }
  public float getOrderQuantity() {
    return mOrderQuantity;
  }
  public void setOrderQuantity(float aOrderQuantity) {
    mOrderQuantity = aOrderQuantity;
  }
  public float getWeight() {
    return mWeight;
  }
  public void setWeight(float aWeight) {
    mWeight = aWeight;
  }
  public String getDimensions() {
    return mDimensions;
  }
  public void setDimensions(String aDimensions) {
    mDimensions = aDimensions;
  }
  public String getColor() {
    return mColor;
  }
  public void setColor(String aColor) {
    mColor = aColor;
  }
  // end:getset-methods

  public void giveOverview() {
    // start:overview-elements
    // end:overview-elements
  }
}
