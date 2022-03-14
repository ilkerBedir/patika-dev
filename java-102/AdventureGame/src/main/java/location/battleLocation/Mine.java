package location.battleLocation;

import obstacle.Obstacle;
import obstacle.Snake;

import java.util.ArrayList;
import java.util.List;
//Maden Sınıfı - ÖDEV3
public class Mine extends BattleLocation {
  private static List<Obstacle> snakes;

  public Mine(String name) {
    super(5, name);
  }
  //Madende yılanların oluşmasını sağlayan statik kod bloğu.
  static {
    snakes = new ArrayList<>();
    int countSnakes = (int) (Math.random() * 5) + 1;
    for (int i = 0; i < countSnakes; i++) {
      snakes.add(new Snake());
    }
  }

  public List<Obstacle> getSnakes() {
    return snakes;
  }

  @Override
  public int getCountObstacles() {
    return snakes.size();
  }
}
