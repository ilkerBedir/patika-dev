package location.battleLocation;

import obstacle.Obstacle;
import obstacle.Vampire;

import java.util.ArrayList;
import java.util.List;

//Orman Sınıfı
public class Forest extends BattleLocation {
  private static List<Obstacle> vampires;

  public Forest(String name) {
    super(2, name);
  }

  //Ormanda vampirlerin oluşmasını sağlayan statik kod bloğu.
  static {
    vampires = new ArrayList<>();
    int countVampires = (int) (Math.random() * 3) + 1;
    for (int i = 0; i < countVampires; i++) {
      vampires.add(new Vampire());
    }
  }

  public List<Obstacle> getVampires() {
    return vampires;
  }

  @Override
  public int getCountObstacles() {
    return vampires.size();
  }
}
