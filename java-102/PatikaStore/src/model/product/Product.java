package model.product;

import model.Brand;

public class Product {
  private int id;
  private double unitPrice;
  private double discountRate;
  private int stockAmount;
  private String name;
  private Brand brand;

  public Product(int id, double unitPrice, double discountRate, int stockAmount, String name, Brand brand) {
    this.id = id;
    this.unitPrice = unitPrice;
    this.discountRate = discountRate;
    this.stockAmount = stockAmount;
    this.name = name;
    this.brand = brand;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public double getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(double discountRate) {
    this.discountRate = discountRate;
  }

  public int getStockAmount() {
    return stockAmount;
  }

  public void setStockAmount(int stockAmount) {
    this.stockAmount = stockAmount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public String toStringProduct() {
    return "" +
      "ID=" + id +
      ", Birim Fiyat=" + unitPrice +
      ", İndirim Oranı=" + discountRate +
      ", Stok Miktarı=" + stockAmount +
      ", İsim='" + name + '\'' +
      ", Marka=" + brand.getName()+" ,"
      ;
  }
}
