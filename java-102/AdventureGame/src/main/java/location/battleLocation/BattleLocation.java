package location.battleLocation;

import location.Location;
import obstacle.Obstacle;

import java.util.List;
//BattleLocation orta sınıfı.
public abstract class BattleLocation extends Location {
  protected static List<Obstacle> obstacleList;
  public BattleLocation(int id, String name) {
    super(id, name);
  }
  abstract int getCountObstacles();
}
