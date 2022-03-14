package inventory;

import lombok.Getter;

@Getter
//Zırh sınıfı
public class Armor extends Tool {
  private int block;

  public Armor(int id, String name, int cost, int block) {
    super(id, name, cost);
    this.block = block;
  }
}
