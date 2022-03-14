package obstacle;

import inventory.Armor;
import inventory.Weapon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Yılan Sınıfı
public class Snake extends Obstacle {
  public static final Logger LOGGER = LoggerFactory.getLogger(Snake.class);
  static int damageSnake = ((int) (Math.random() * 6)) + 3;

  public Snake() {
    super(4, damageSnake, 12, 0);
  }

  //ÖDEV3 Silah ödüllerinin olasılıkları
  public Weapon awardWeapon() {
    int probability = ((int) (Math.random() * 100)) + 1;
    if (probability <= 20) {
      LOGGER.debug("Tebrikler Tüfek Kazandınız");
      return new Weapon(2, "Tüfek", 45, 7);
    } else if (probability <= 50) {
      LOGGER.debug("Tebrikler Kılıç Kazandınız");
      return new Weapon(1, "Kılıç", 35, 3);
    }
    LOGGER.debug("Tebrikler Tabanca Kazandınız");
    return new Weapon(0, "Tabanca", 25, 2);
  }

  //ÖDEV3 Zırh ödüllerinin olasılıkları
  public Armor awardArmor() {
    int probability = ((int) (Math.random() * 100)) + 1;
    if (probability <= 20) {
      LOGGER.debug("Tebrikler Ağır Zırh Kazandınız");
      return new Armor(5, "Ağır Zırh", 40, 5);
    } else if (probability <= 50) {
      LOGGER.debug("Tebrikler Orta Zırh Kazandınız");
      return new Armor(4, "Orta Zırh", 25, 3);
    }
    LOGGER.debug("Tebrikler Hafif Zırh Kazandınız");
    return new Armor(3, "Hafif Zırh", 15, 1);
  }

  //ÖDEV3 Para ödüllerinin olasılıkları
  public int awardMoney() {
    int probability = ((int) (Math.random() * 100)) + 1;
    if (probability <= 20) {
      LOGGER.debug("Tebrikler 10 para Kazandınız");
      return 10;
    } else if (probability <= 50) {
      LOGGER.debug("Tebrikler 5 para Kazandınız");
      return 5;
    }
    LOGGER.debug("Tebrikler 1 para Kazandınız");
    return 1;
  }
}
