package model.product;

import model.Brand;

public class Notebook extends Product{
  private String ram;
  private String memorySize;
  private String screenSize;

  public Notebook(int id, double unitPrice, double discountRate, int stockAmount,
                  String name, Brand brand, String ram, String memorySize,
                  String screenSize) {
    super(id, unitPrice, discountRate, stockAmount, name, brand);
    this.ram = ram;
    this.memorySize = memorySize;
    this.screenSize = screenSize;
  }

  public String getRam() {
    return ram;
  }

  public void setRam(String ram) {
    this.ram = ram;
  }

  public String getMemorySize() {
    return memorySize;
  }

  public void setMemorySize(String memorySize) {
    this.memorySize = memorySize;
  }

  public String getScreenSize() {
    return screenSize;
  }

  public void setScreenSize(String screenSize) {
    this.screenSize = screenSize;
  }


  public String toStringNoteBook() {
    return "Notebook{" +
      toStringProduct()+
      "RAM='" + ram + '\'' +
      ", Hafıza Alanı='" + memorySize + '\'' +
      ", Ekran Boyutu='" + screenSize + '\'' +
      '}';
  }
}
