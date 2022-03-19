package model.address;

public class BusinessAddress implements Address {
  private String address;

  public BusinessAddress(String address) {
    this.address = address;
  }

  @Override
  public void writeAddress() {
    System.out.println(address);
  }

  @Override
  public String getAddress() {
    return address;
  }
}
