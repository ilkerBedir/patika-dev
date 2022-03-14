package obstacle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter
@Setter
//Canavar Sınıfı
public class Obstacle {
  public static final Logger LOGGER = LoggerFactory.getLogger(Obstacle.class);
  private int id;
  private int damage;
  private int health;
  private int money;

  //Canavarların özelliklerini gösteren metod.(ortak)
  public void showObstacleFeatures() {
    LOGGER.debug("---------CANAVAR ÖZELLİKLER-------");
    LOGGER.debug("ID : {} , HASAR : {} , SAĞLIK : {} , PARA : {}", id, damage, health, money);
  }
}
