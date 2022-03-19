package manager;

import enums.AuthenticationStatus;
import exception.InvalidAuthenticationException;
import model.User;
import model.account.Account;
import model.account.IndividualAccount;
import model.address.Address;
import model.address.BusinessAddress;
import model.address.HomeAddress;
import model.insurance.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

public class AccountManager {
  private static TreeSet<Account> accountSet=new TreeSet<>();
  static {
    HomeAddress ilkerAddress = new HomeAddress("BAYRAMPAŞA/İSTANBUL");
    ArrayList<Address> ilkerAddressList = new ArrayList<>();
    ilkerAddressList.add(ilkerAddress);
    User ilker = new User("ilker", "bedir", "ilker@email.com", "12345", "mühendis", 24, ilkerAddressList, LocalDate.now());
    CarInsurance ilkerCarInsurance = new CarInsurance("ilker araba sigorta", 120, LocalDate.now(), LocalDate.of(2022, 10, 25));
    HealthInsurance ilkerHealthInsurance = new HealthInsurance("ilker sağlık sigorta", 150, LocalDate.now(), LocalDate.of(2022, 10, 25));
    ArrayList<Insurance> ilkerInsuranceList = new ArrayList<>();
    ilkerInsuranceList.add(ilkerCarInsurance);
    ilkerInsuranceList.add(ilkerHealthInsurance);
    Account ilkerAccount = new IndividualAccount(ilker, AuthenticationStatus.FAIL, ilkerInsuranceList);
    accountSet.add(ilkerAccount);
    BusinessAddress tubitakAddress1 = new BusinessAddress("BAYRAMPAŞA/İSTANBUL");
    ArrayList<Address> tubitakAddressList = new ArrayList<>();
    tubitakAddressList.add(tubitakAddress1);
    User tubitak = new User("tubitak", "bilgem", "tubitak@email.com", "12345", "yönetici", 60, tubitakAddressList, LocalDate.now());
    ResidenceInsurance tubitakResidenceInsurance = new ResidenceInsurance("tubitak bina sigorta", 240, LocalDate.now(), LocalDate.of(2023, 10, 25));
    TravelInsurance tubitakTravelInsurance = new TravelInsurance("tubitak seyahat sigorta", 300, LocalDate.now(), LocalDate.of(2023, 10, 25));
    ArrayList<Insurance> tubitakInsuranceList = new ArrayList<>();
    tubitakInsuranceList.add(tubitakResidenceInsurance);
    tubitakInsuranceList.add(tubitakTravelInsurance);
    Account tubitakAccount = new IndividualAccount(tubitak, AuthenticationStatus.FAIL, tubitakInsuranceList);
    accountSet.add(tubitakAccount);
  }



  public static Account login(String email,String password) throws InvalidAuthenticationException {
    for (Account account:accountSet) {
      try {
        return account.login(email,password);
      }catch (Exception exception){

      }
    }
    throw new InvalidAuthenticationException("Böyle Bir Kullanıcı Yoktur");
  }
  public static TreeSet<Account> getAccountSet() {
    return accountSet;
  }
}
