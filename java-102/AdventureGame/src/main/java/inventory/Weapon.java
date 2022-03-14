package inventory;

import lombok.Getter;

@Getter
//Silah sınıfı
public class Weapon extends Tool {
  private int damage;

  public Weapon(int id, String name, int cost, int damage) {
    super(id, name, cost);
    this.damage = damage;
  }
}
