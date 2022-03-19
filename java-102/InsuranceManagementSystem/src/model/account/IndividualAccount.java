package model.account;

import enums.AuthenticationStatus;
import model.User;
import model.insurance.Insurance;

import java.util.ArrayList;

public class IndividualAccount extends Account{
  public IndividualAccount(User user, AuthenticationStatus status, ArrayList<Insurance> insurance) {
    super(user, status, insurance);
  }

  @Override
  public void addInsurance(Insurance insurance) {
    //todo
  }
}
