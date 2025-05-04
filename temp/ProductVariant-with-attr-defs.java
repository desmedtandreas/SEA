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
  // end:getset-methods

  public void giveOverview() {
    // start:overview-elements
    // end:overview-elements
  }
}
