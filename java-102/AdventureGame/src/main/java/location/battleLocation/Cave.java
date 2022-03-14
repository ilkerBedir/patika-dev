package location.battleLocation;

import obstacle.Obstacle;
import obstacle.Zombie;

import java.util.ArrayList;
import java.util.List;
//Mağara sınıfı.
public class Cave extends BattleLocation{
  private static List<Obstacle> zombies;
  public Cave(String name) {
    super(3, name);
  }

  //Mağarada zombilerin oluşmasını sağlayan statik kod bloğu.
  static{
    zombies=new ArrayList<>();
    int countZombies=(int) (Math.random()*3)+1;
    for (int i = 0; i < countZombies; i++) {
      zombies.add(new Zombie());
    }
  }

  public static List<Obstacle> getZombies() {
    return zombies;
  }

  @Override
  public int getCountObstacles() {
    return zombies.size();
  }
}
