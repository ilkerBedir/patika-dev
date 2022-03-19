package manager;

import model.address.Address;
import model.User;

public class AddressManager {
  public static void addAddress(User user, Address address){
    user.addAddressToList(address);
  }
  public static void deleteAddress(User user, Address address){
    user.removeAddressToList(address);
  }

}
