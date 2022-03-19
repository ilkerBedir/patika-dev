package model.account;

import enums.AuthenticationStatus;
import model.User;
import model.insurance.Insurance;

import java.util.ArrayList;

public class EnterpriseAccount extends Account{
  public EnterpriseAccount(User user, AuthenticationStatus status, ArrayList<Insurance> insurance) {
    super(user, status, insurance);
  }

  @Override
  public void addInsurance(Insurance insurance) {
    this.insurance.add(insurance);
  }


}
