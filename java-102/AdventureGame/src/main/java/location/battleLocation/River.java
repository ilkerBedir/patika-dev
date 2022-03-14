package location.battleLocation;

import obstacle.Bear;
import obstacle.Obstacle;

import java.util.ArrayList;
import java.util.List;
//Nehir sınıfı.
public class River extends BattleLocation {
  private static List<Obstacle> bears;

  public River(String name) {
    super(4, name);
  }
  //Nehirde ayıların oluşmasını sağlayan statik kod bloğu.
  static {
    bears = new ArrayList<>();
    int countBears = (int) (Math.random() * 3) + 1;
    for (int i = 0; i < countBears; i++) {
      bears.add(new Bear());
    }
  }

  public static List<Obstacle> getBears() {
    return bears;
  }

  @Override
  public int getCountObstacles() {
    return bears.size();
  }
}
