package model.product;

import model.Brand;

public class Phone extends Product {
  private String memorySize;
  private String screenSize;
  private String batteryPower;
  private String ram;
  private String colour;

  public Phone(int id, double unitPrice, double discountRate, int stockAmount,
               String name, Brand brand, String memorySize, String screenSize,
               String batteryPower, String ram, String colour) {
    super(id, unitPrice, discountRate, stockAmount, name, brand);
    this.memorySize = memorySize;
    this.screenSize = screenSize;
    this.batteryPower = batteryPower;
    this.ram = ram;
    this.colour = colour;
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

  public String getBatteryPower() {
    return batteryPower;
  }

  public void setBatteryPower(String batteryPower) {
    this.batteryPower = batteryPower;
  }

  public String getRam() {
    return ram;
  }

  public void setRam(String ram) {
    this.ram = ram;
  }

  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public String toStringPhone() {
    return "Cep Telefonu{" +
      toStringProduct()+
      "Hafıza Alanı='" + memorySize + '\'' +
      ", Ekran Boyutu='" + screenSize + '\'' +
      ", Pil Gücü='" + batteryPower + '\'' +
      ", RAM='" + ram + '\'' +
      ", Renk='" + colour + '\'' +
      '}';
  }
}

