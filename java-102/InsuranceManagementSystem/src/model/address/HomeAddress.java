package model.address;

public class HomeAddress implements Address {
  private String address;

  public HomeAddress(String address) {
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
