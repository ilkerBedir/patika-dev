package util;

import model.Brand;
import model.product.Notebook;
import model.product.Phone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Store {
  private String name;
  private TreeSet<Brand> brandList;
  private ArrayList<Phone> phoneList;
  private ArrayList<Notebook> notebookList;
  ///Bunun için ayrı bir sınıf yazılacak.


  public Store() {
    this.name = "PATİKA STORE";
    this.brandList = UtilBrands.listBrands();
    this.phoneList = new ArrayList<Phone>();
    this.notebookList = new ArrayList<Notebook>();
  }

  public String getName() {
    return name;
  }

  public TreeSet<Brand> getBrandList() {
    return brandList;
  }

  public ArrayList<Notebook> getNotebookList() {
    return notebookList;
  }

  public ArrayList<Phone> getPhoneList() {
    return phoneList;
  }

  public void addPhone(Phone phone) {
    for (int i = 0; i < this.phoneList.size(); i++) {
      Phone phone1 = this.phoneList.get(i);
      if (phone1.getId() == phone.getId()) {
        System.out.println("ID Benzersiz olmalıdır, Telefon eklenemedi");
        return;
      }
    }
    phoneList.add(phone);
    System.out.println("Başarıyla Eklendi");
  }

  public void deletePhoneById(int id) {
    Phone phone = filterPhoneById(id);
    if (phone != null) {
      this.phoneList.remove(phone);
      System.out.println("Başarıyla Silindi");
    } else {
      System.out.println("İlgili Telefon silinemedi, Böyle bir id'de telefon yok");
    }
  }

  public Phone filterPhoneById(int id) {
    for (int i = 0; i < this.phoneList.size(); i++) {
      Phone phone = this.phoneList.get(i);
      if (phone.getId() == id) {
        return phone;
      }
    }
    return null;
  }

  public ArrayList<Phone> filterPhonesByBrand(Brand brand) {
    ArrayList<Phone> phoneListByBrand = new ArrayList<Phone>();
    Iterator<Phone> iterator = this.phoneList.iterator();
    while (iterator.hasNext()) {
      Phone phone = iterator.next();
      if (phone.getBrand().equals(brand)) {
        phoneListByBrand.add(phone);
      }
    }
    return phoneListByBrand;
  }

  public void addNotebook(Notebook notebook) {
    for (int i = 0; i < this.notebookList.size(); i++) {
      Notebook notebook1 = this.notebookList.get(i);
      if (notebook1.getId() == notebook.getId()) {
        System.out.println("ID Benzersiz olmalıdır, Notebook eklenemedi");
        return;
      }
    }
    notebookList.add(notebook);
    System.out.println("Başarıyla Eklendi");
  }

  public void deleteNotebookById(int id) {
    Notebook notebook = filterNotebookById(id);
    if (notebook != null) {
      this.notebookList.remove(notebook);
      System.out.println("Başarıyla Silindi");
    } else {
      System.out.println("İlgili Notebook silinemedi, Böyle bir id'de notebook yok");
    }
  }

  public Notebook filterNotebookById(int id) {
    for (int i = 0; i < this.notebookList.size(); i++) {
      Notebook notebook = this.notebookList.get(i);
      if (notebook.getId() == id) {
        return notebook;
      }
    }
    return null;
  }

  public ArrayList<Notebook> filterNotebooksByBrand(Brand brand) {
    ArrayList<Notebook> notebookListByBrand = new ArrayList<Notebook>();
    Iterator<Notebook> notebookIterator = this.notebookList.iterator();
    while (notebookIterator.hasNext()) {
      Notebook notebook = notebookIterator.next();
      if (notebook.getBrand().equals(brand)) {
        notebookListByBrand.add(notebook);
      }
    }
    return notebookListByBrand;
  }


}
