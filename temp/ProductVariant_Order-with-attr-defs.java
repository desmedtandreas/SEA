public class ProductVariant_Order {

  // start:attribute-definitions
  private String mProductVariant_OrderId;
  private float mQuantity;
  private ProductVariant mProductVariant;
  private Order mOrder;
  // end:attribute-definitions

  public ProductVariant_Order() {
  }

  @Override
  public String toString() {
    return mProductVariant_OrderId;
  }

  // start:getset-methods
  // end:getset-methods

  public void giveOverview() {
    // start:overview-elements
    // end:overview-elements
  }
}
