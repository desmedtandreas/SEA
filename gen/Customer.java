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
  public String getCustomerId() {
    return mCustomerId;
  }
  public void setCustomerId(String aCustomerId) {
    mCustomerId = aCustomerId;
  }
  public String getFirstName() {
    return mFirstName;
  }
  public void setFirstName(String aFirstName) {
    mFirstName = aFirstName;
  }
  public String getLastName() {
    return mLastName;
  }
  public void setLastName(String aLastName) {
    mLastName = aLastName;
  }
  public String getBirthDate() {
    return mBirthDate;
  }
  public void setBirthDate(String aBirthDate) {
    mBirthDate = aBirthDate;
  }
  public String getPhoneNumber() {
    return mPhoneNumber;
  }
  public void setPhoneNumber(String aPhoneNumber) {
    mPhoneNumber = aPhoneNumber;
  }
  // end:getset-methods

  public void giveOverview() {
    // start:overview-elements
    System.out.println("mCustomerId: " + mCustomerId);
    System.out.println("mFirstName: " + mFirstName);
    System.out.println("mLastName: " + mLastName);
    System.out.println("mBirthDate: " + mBirthDate);
    System.out.println("mPhoneNumber: " + mPhoneNumber);
    // end:overview-elements
  }
}
