package util;

import model.Brand;
import model.product.Notebook;
import model.product.Phone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class ApplicationUser {
  private static Scanner input = new Scanner(System.in);
  private static Store store = new Store();

  public static void managementPanel() {
    boolean exitFlag = true;
    System.out.println("PatikaStore Ürün Yönetim Paneli !");
    while (exitFlag) {
      System.out.println("1 - Notebook İşlemleri");
      System.out.println("2 - Cep Telefonu İşlemleri");
      System.out.println("3 - Marka Listele");
      System.out.println("0 - Çıkış Yap");
      System.out.print("Tercihiniz : ");
      String selection = input.nextLine();
      switch (selection) {
        case "1":
          System.out.println("Notebook İşlemleri");
          System.out.println("------------------");
          operationsNotebookMenu();
          break;
        case "2":
          System.out.println("Cep Telefonu İşlemleri");
          System.out.println("------------------");
          operationsPhoneMenu();
          break;
        case "3":
          System.out.println("Markalarımız");
          System.out.println("------------");
          writeBrandList();
          System.out.println("------------");
          break;
        case "0":
          exitFlag = false;
          System.out.println("Çıkış Yaptınız");
          break;
        default:
          System.out.println("Yanlış Tuşlama Girdiniz");
          break;
      }
    }
  }

  private static void writeBrandList() {
    TreeSet<Brand> brands = store.getBrandList();
    Iterator<Brand> iterator = brands.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next().getName());
    }
  }

  private static void operationsNotebookMenu() {
    boolean exitFlag = true;
    int id = -1;
    while (exitFlag) {
      System.out.println("1 - Notebook Ekle");
      System.out.println("2 - Notebook Sil");
      System.out.println("3 - Notebook Listeleme");
      System.out.println("4 - Id'ye Göre Notebook Filtrele");
      System.out.println("5 - Marka'ya Göre Notebook Filtrele");
      System.out.println("0 -Çıkış Yap");
      String selection = input.nextLine();
      Notebook notebook;
      switch (selection) {
        case "1":
          notebook = createNotebookByUser();
          store.addNotebook(notebook);
          break;
        case "2":
          System.out.println("Silinecek Notebook'un ID'sini giriniz.");
          id = Integer.parseInt(input.nextLine());
          store.deleteNotebookById(id);
          break;
        case "3":
          writeNotebookList(store.getNotebookList());
          break;
        case "4":
          System.out.println("ID'yi giriniz.");
          id = Integer.parseInt(input.nextLine());
          notebook=store.filterNotebookById(id);
          if (notebook!=null){
            System.out.println(notebook.toStringNoteBook());
          }else {
            System.out.println("İlgili ID'de Notebook yok");
          }
          break;
        case "5":
          System.out.println("Marka İsmini Giriniz");
          String brandName = input.nextLine();
          Brand brand = UtilBrands.getBrandByName(brandName);
          writeNotebookList(store.filterNotebooksByBrand(brand));
          break;
        case "0":
          exitFlag = false;
          System.out.println("Notebook İşlemlerinden Çıkış Yaptınız");
          break;
        default:
          System.out.println("Yanlış Tuşlama Girdiniz");
          break;
      }
    }
  }

  private static void operationsPhoneMenu() {
    boolean exitFlag = true;
    int id = -1;
    while (exitFlag) {
      System.out.println("1 - Cep Telefonu Ekle");
      System.out.println("2 - Cep Telefonu Sil");
      System.out.println("3 - Cep Telefonu Listeleme");
      System.out.println("4 - Id'ye Göre Cep Telefonu Filtrele");
      System.out.println("5 - Marka'ya Göre Cep Telefonu Filtrele");
      System.out.println("0 -Çıkış Yap");
      String selection = input.nextLine();
      Phone phone;
      switch (selection) {
        case "1":
          phone = createPhoneByUser();
          store.addPhone(phone);
          break;
        case "2":
          System.out.println("Silinecek Cep Telefonun ID'sini giriniz.");
          id = Integer.parseInt(input.nextLine());
          store.deletePhoneById(id);
          break;
        case "3":
          writePhoneList(store.getPhoneList());
          System.out.println("Boyutu : " + store.getPhoneList().size());
          break;
        case "4":
          System.out.println("ID'yi giriniz.");
          id = Integer.parseInt(input.nextLine());
          phone = store.filterPhoneById(id);
          if (phone != null) {
            System.out.println(phone.toStringPhone());
          }else {
            System.out.println("İlgili Id'de Telefon Yok");
          }
          break;
        case "5":
          System.out.println("Lütfen Markayı Giriniz");
          String brandName = input.nextLine();
          Brand brand = UtilBrands.getBrandByName(brandName);
          writePhoneList(store.filterPhonesByBrand(brand));
          break;
        case "0":
          exitFlag = false;
          System.out.println("Cep Telefonu İşlemlerinden Çıkış Yaptınız");
          break;
        default:
          System.out.println("Yanlış Tuşlama Girdiniz");
          break;
      }
    }
  }

  private static void writeNotebookList(ArrayList<Notebook> notebookList) {
    System.out.println("--------Notebook Listesi---------");
    for (Notebook notebook:notebookList) {
      System.out.println(notebook.toStringNoteBook());
    }
  }

  private static void writePhoneList(ArrayList<Phone> phoneList) {
    System.out.println("--------Cep Telefon Listesi---------");
    for (Phone phone:phoneList) {
      System.out.println(phone.toStringPhone());
    }
  }

  private static Notebook createNotebookByUser() {
    System.out.println("Lütfen İstenen Notebook Bilgileri Giriniz");
    System.out.print("Notebook Id : ");
    int id = Integer.parseInt(input.nextLine());
    while (store.filterPhoneById(id) != null) {
      System.out.print("Id Benzersiz Olmalıdır\nLütfen Tekrar Giriniz : ");
      id = Integer.parseInt(input.nextLine());
    }
    System.out.print("Notebook Birim Fiyat : ");
    double unitPrice = Double.valueOf(input.nextLine());
    System.out.print("Notebook Miktar : ");
    int stockAmount = Integer.parseInt(input.nextLine());
    System.out.print("Notebook İndirim Oranı : ");
    double discountRate = Double.valueOf(input.nextLine());
    System.out.print("Notebook İsim : ");
    String name = input.nextLine();
    System.out.print("Notebook Marka : ");
    String brandName = input.nextLine();
    Brand brand = UtilBrands.getBrandByName(brandName);
    while (brand == null) {
      System.out.println("Mağazada Böyle İsimde Marka Yoktur\nLütfen Tekrar Mağaza İsmini Tekrar giriniz");
      brandName = input.nextLine();
      brand = UtilBrands.getBrandByName(brandName);
    }
    System.out.print("Notebook Hafıza Boyutu : ");
    String memorySize = input.nextLine();
    System.out.print("Notebook Ekran Boyutu : ");
    String screenSize = input.nextLine();
    System.out.print("Notebook RAM : ");
    String ram = input.nextLine();

    return new Notebook(id, unitPrice, discountRate, stockAmount, name, brand, ram, memorySize, screenSize);
  }

  private static Phone createPhoneByUser() {
    System.out.println("Lütfen İstenen Telefon Bilgileri Giriniz");
    System.out.print("Telefon Id : ");
    int id = Integer.parseInt(input.nextLine());
    while (store.filterPhoneById(id) != null) {
      System.out.print("Id Benzersiz Olmalıdır\nLütfen Tekrar Giriniz : ");
      id = Integer.parseInt(input.nextLine());
    }
    System.out.print("Telefon Birim Fiyat : ");
    double unitPrice = Double.valueOf(input.nextLine());
    System.out.print("Telefon Miktar : ");
    int stockAmount = Integer.parseInt(input.nextLine());
    System.out.print("Telefon İndirim Oranı : ");
    double discountRate = Double.valueOf(input.nextLine());
    System.out.print("Telefon İsim : ");
    String name = input.nextLine();
    System.out.print("Telefon Marka : ");
    String brandName = input.nextLine();
    Brand brand = UtilBrands.getBrandByName(brandName);
    while (brand == null) {
      System.out.println("Mağazada Böyle İsimde Marka Yoktur\nLütfen Tekrar Mağaza İsmini Tekrar giriniz");
      brandName = input.nextLine();
      brand = UtilBrands.getBrandByName(brandName);
    }
    System.out.print("Telefon Hafıza Boyutu : ");
    String memorySize = input.nextLine();
    System.out.print("Telefon Ekran Boyutu : ");
    String screenSize = input.nextLine();
    System.out.print("Telefon Pil Gücü : ");
    String batteryPower = input.nextLine();
    System.out.print("Telefon RAM : ");
    String ram = input.nextLine();
    System.out.print("Telefon Renk : ");
    String colour = input.nextLine();
    return new Phone(id, unitPrice, discountRate, stockAmount, name, brand, memorySize, screenSize, batteryPower, ram, colour);
  }
}
