package model.account;

import enums.AuthenticationStatus;
import exception.InvalidAuthenticationException;
import model.User;
import model.address.Address;
import model.insurance.Insurance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Account implements Comparable<Account> {
  protected User user;
  protected AuthenticationStatus status;
  protected ArrayList<Insurance> insurance;

  public Account(User user, AuthenticationStatus status, ArrayList<Insurance> insurance) {
    this.user = user;
    this.status = status;
    this.insurance = insurance;
  }

  public final void showUserInfo() {
    System.out.println(user.toString());
  }

  public Account login(String email,String password) throws Exception {
    if (user.getEmail().equals(email) && user.getPassword().equals(password)){
      user.setLastLoginDate(LocalDate.now());
      status=AuthenticationStatus.SUCCESS;
      return this;
    }
    throw new InvalidAuthenticationException();

  }

  public void addAddress(Address address) {
    user.addAddressToList(address);
  }

  public void removeAddress(Address address) {
    user.removeAddressToList(address);
  }

  public AuthenticationStatus loginAuthenticationStatus() {
    return this.status;
  }

  public abstract void addInsurance(Insurance insurance);

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return Objects.equals(user, account.user) && Objects.equals(status, account.status) && Objects.equals(insurance, account.insurance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, status, insurance);
  }

  public User getUser() {
    return user;
  }

  public AuthenticationStatus getStatus() {
    return status;
  }

  public ArrayList<Insurance> getInsurance() {
    return insurance;
  }

  @Override
  public int compareTo(Account account) {
    return account.getUser().getName().compareTo(user.getName());
  }
}
