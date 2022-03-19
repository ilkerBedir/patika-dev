package model;

public class Brand implements Comparable<Brand> {
  private int id;
  private String name;

  public Brand(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Brand brand) {
    return name.compareTo(brand.getName());
  }
}
