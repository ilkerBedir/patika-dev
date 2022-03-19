package util;

import exception.InvalidAuthenticationException;
import manager.AccountManager;
import model.account.Account;

import java.util.Scanner;

public class UserLogin {
  public static Account userLoginScreen() {
    Scanner input = new Scanner(System.in);
    Account account = null;
    boolean exitFlag = true;
    System.out.println("Kullanıcı Ekranına Giriş");
    while (exitFlag) {
      System.out.println("1-Kullanıcı Girişi");
      System.out.println("0-Çıkış Yap");
      String selection = input.nextLine();
      switch (selection) {
        case "1":
          System.out.println("Lütfen Hesap Bilgilerini Giriniz");
          System.out.println("Email : ");
          String email = input.nextLine();
          System.out.println("Şifre : ");
          String password = input.nextLine();
          try {
            account = AccountManager.login(email, password);
            System.out.println("Kullanıcı Giriş Başarılı");
            account.showUserInfo();
            System.out.println("Status : " + account.loginAuthenticationStatus().toString());
            exitFlag = false;
            return account;
          } catch (InvalidAuthenticationException e) {
            System.out.println(e.getMessage());
          }
          break;
        case "0":
          exitFlag = false;
          break;
        default:
          System.out.println("HATALI TUŞLAMA");
          break;
      }
    }
    return account;
  }
}
