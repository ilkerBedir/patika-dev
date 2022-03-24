package demo;

import thread.MyThread;

import java.util.ArrayList;

public class Main {
  public static ArrayList<Integer> oddNumbers = new ArrayList<>();
  public static ArrayList<Integer> evenNumbers = new ArrayList<>();

  public static void main(String[] args) throws InterruptedException {
    ArrayList<Thread> threads = new ArrayList<>();
    threads.add(new MyThread(1, 2500));
    threads.add(new MyThread(2501, 5000));
    threads.add(new MyThread(5001, 7500));
    threads.add(new MyThread(7501, 10000));
    for (int i = 0; i < threads.size(); i++) {
      threads.get(i).start();
    }
    for (int i = 0; i < threads.size(); i++) {
      threads.get(i).join();
    }

    System.out.println("Tek Sayıların Adeti : " + oddNumbers.size());
    System.out.println("Çift Sayıların Adeti : " + evenNumbers.size());

    System.out.println("--------TEK SAYILAR-------");
    for (int i = 0; i < oddNumbers.size(); i++) {
      System.out.println(oddNumbers.get(i));
    }

    System.out.println("--------ÇİFT SAYILAR-------");
    for (int i = 0; i < evenNumbers.size(); i++) {
      System.out.println(evenNumbers.get(i));
    }
  }
}
