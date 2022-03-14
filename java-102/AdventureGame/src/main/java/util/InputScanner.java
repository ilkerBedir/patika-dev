package util;

import java.util.Scanner;

//Kullanıcıdan input almak için yazılan Singleton Tasarımına uygun sınıf.
public class InputScanner {
  private static Scanner instance = null;

  public static Scanner getInstance() {
    if (instance == null) {
      instance = new Scanner(System.in);
    }
    return instance;
  }
}
