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
  public String getProductVariant_OrderId() {
    return mProductVariant_OrderId;
  }
  public void setProductVariant_OrderId(String aProductVariant_OrderId) {
    mProductVariant_OrderId = aProductVariant_OrderId;
  }
  public float getQuantity() {
    return mQuantity;
  }
  public void setQuantity(float aQuantity) {
    mQuantity = aQuantity;
  }
  public ProductVariant getProductVariant() {
    return mProductVariant;
  }
  public void setProductVariant(ProductVariant aProductVariant) {
    mProductVariant = aProductVariant;
  }
  public Order getOrder() {
    return mOrder;
  }
  public void setOrder(Order aOrder) {
    mOrder = aOrder;
  }
  // end:getset-methods

  public void giveOverview() {
    // start:overview-elements
    // end:overview-elements
  }
}
