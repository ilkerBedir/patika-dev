package util;

import model.Brand;

import java.util.Iterator;
import java.util.TreeSet;

public class UtilBrands {
  private static TreeSet<Brand> brands=new TreeSet<>();
  static {
    brands.add(new Brand(1,"Samsung"));
    brands.add(new Brand(2,"Lenovo"));
    brands.add(new Brand(3,"Apple"));
    brands.add(new Brand(4,"Huawei"));
    brands.add(new Brand(5,"Casper"));
    brands.add(new Brand(6,"Asus"));
    brands.add(new Brand(7,"HP"));
    brands.add(new Brand(8,"Xiaomi"));
    brands.add(new Brand(9,"Monster"));
  }
  public static TreeSet<Brand> listBrands() {
    return brands;
  }
  public static Brand getBrandByName(String brandName){
    Iterator<Brand> iterator = brands.iterator();
    while (iterator.hasNext()){
      Brand brand = iterator.next();
      if (brand.getName().equals(brandName)){
        return brand;
      }
    }
    return null;
  }
}
