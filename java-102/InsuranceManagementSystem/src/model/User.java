package model;

import model.address.Address;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
  private String name;
  private String surname;
  private String email;
  private String password;
  private String profession;
  private int age;
  private ArrayList<Address> addressList;
  private LocalDate lastLoginDate;

  public User(String name, String surname, String email, String password, String profession, int age, ArrayList<Address> addressList, LocalDate lastLoginDate) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.profession = profession;
    this.age = age;
    this.addressList = addressList;
    this.lastLoginDate = lastLoginDate;
  }

  @Override
  public String toString() {
    String addressListToString="[";
    for (Address address:addressList) {
      addressListToString+=address.getAddress()+",";
    }
    addressListToString+="]";
    return "User{" +
      "name='" + name + '\'' +
      ", surname='" + surname + '\'' +
      ", email='" + email + '\'' +
      ", password='" + password + '\'' +
      ", profession='" + profession + '\'' +
      ", age=" + age +
      ", addressList=" + addressListToString +
      ", lastLoginDate=" + lastLoginDate +
      '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public ArrayList<Address> getAddressList() {
    return addressList;
  }

  public void setAddressList(ArrayList<Address> addressList) {
    this.addressList = addressList;
  }

  public LocalDate getLastLoginDate() {
    return lastLoginDate;
  }

  public void setLastLoginDate(LocalDate lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  public void addAddressToList(Address address){
    this.addressList.add(address);
  }
  public void removeAddressToList(Address address){
    this.addressList.remove(address);
  }
}
