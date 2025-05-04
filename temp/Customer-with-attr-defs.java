public class Customer {

  // start:attribute-definitions
  private String mCustomerId;
  private String mFirstName;
  private String mLastName;
  private String mBirthDate;
  private String mPhoneNumber;
  // end:attribute-definitions

  public Customer() {
  }

  @Override
  public String toString() {
    return mCustomerId;
  }

  // start:getset-methods
  // end:getset-methods

  public void giveOverview() {
    // start:overview-elements
    // end:overview-elements
  }
}
