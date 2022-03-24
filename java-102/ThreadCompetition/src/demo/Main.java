package demo;

import thread.FirstThread;
import thread.FourthThread;
import thread.SecondThread;
import thread.ThirdThread;

import java.util.ArrayList;

public class Main {
  public static volatile ArrayList<Integer> oddNumbers=new ArrayList<>();
  public static volatile ArrayList<Integer> evenNumbers=new ArrayList<>();
  public static void main(String[] args) throws InterruptedException {

    Thread firstThread = new FirstThread();
    Thread secondThread=new SecondThread();
    Thread thirdThread=new ThirdThread();
    Thread fourthThread=new FourthThread();
    firstThread.start();
    secondThread.start();
    thirdThread.start();
    fourthThread.start();
    firstThread.join();
    secondThread.join();
    thirdThread.join();
    fourthThread.join();
    System.out.println("TEK SAYILAR");
    for (int i = 0; i < oddNumbers.size(); i++) {
      System.out.println(oddNumbers.get(i));
    }
    System.out.println("ÇİFT SAYILAR");
    for (int i = 0; i < evenNumbers.size(); i++) {
      System.out.println(evenNumbers.get(i));
    }
  }
}
