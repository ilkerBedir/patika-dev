package util;

import gameChar.Archer;
import gameChar.GameChar;
import gameChar.Knight;
import gameChar.Samurai;
import inventory.Armor;
import inventory.Inventory;
import inventory.Tool;
import inventory.Weapon;
import location.*;
import location.battleLocation.Cave;
import location.battleLocation.Forest;
import location.battleLocation.Mine;
import location.battleLocation.River;
import location.normalLocation.ToolStore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import obstacle.Obstacle;
import obstacle.Snake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//Projede Lombok encapsulation ve obje oluşturmak Lombok annotationları kullanılmıştır.Lombok, daha okunabilir olması amacıyla kullanılmıştır.
@Getter
@Setter
@Builder
public class Player implements IPlayer {
  public static final Logger LOGGER = LoggerFactory.getLogger(Player.class);
  private Inventory inventory;
  private int damage;
  private int health;
  private int initialHealth;
  private int money;
  private int block;
  private String name;
  private Location location;

  public GameChar selectChar() {
    GameChar gameCharacter = GameChar.builder().build();
    boolean exitFlag = true;
    while (exitFlag) {
      LOGGER.debug("--------------- KARAKTER SEÇİM EKRANI -------------");
      LOGGER.debug("Samuray : ( Hasar : 5 , Sağlık : 21 , Para : 15 ) seçmek için 1'e basınız");
      LOGGER.debug("Okçu : ( Hasar : 7 , Sağlık : 18 , Para : 20 ) seçmek için 2'e basınız");
      LOGGER.debug("Şövalye : ( Hasar : 8 , Sağlık : 24 , Para : 5 ) seçmek için 3'e basınız");
      LOGGER.debug("Çıkmak için ise E tuşuna basınız");
      LOGGER.debug("-----------------------------------------------------");
      LOGGER.debug("Lütfen Seçim Yapınız");
      Scanner input = InputScanner.getInstance();
      String selection = input.nextLine();
      selection = selection.toUpperCase();
      switch (selection) {
        case "1":
          LOGGER.debug("Samurayı seçtiniz");
          gameCharacter = new Samurai();
          exitFlag = false;
          break;
        case "2":
          LOGGER.debug("Okçuyuyi seçtiniz");
          gameCharacter = new Archer();
          exitFlag = false;
          break;
        case "3":
          LOGGER.debug("Şövalye seçtiniz");
          gameCharacter = new Knight();
          exitFlag = false;
          break;
        case "E":
          LOGGER.debug("Çıkış yaptınız");
          exitFlag = false;
          break;
        default:
          LOGGER.debug("Yanlış Tuşlama Tekrar Deneyiniz");
          break;
      }
    }
    return gameCharacter;
  }

  public void selectLocation(List<Location> locations) {
    showStatePlayer();
    boolean exitFlag = true;
    boolean isAlive = true;
    boolean winningGame = false;
    while (exitFlag && isAlive && !winningGame) {
      LOGGER.debug("-----------Gidilecek Konum Ekranı----------");
      for (Location location : locations) {
        if (location.getClass().equals(Forest.class)) {
          LOGGER.debug("ID : {} ,İSİM : {} ; {} adet vampir bulunmaktadır,girmek için konumun id'sini tuşlayınız",
            location.getId(), location.getName(), ((Forest) location).getCountObstacles());
        } else if (location.getClass().equals(Cave.class)) {
          LOGGER.debug("ID : {} ,İSİM : {} ; {} adet zombi bulunmaktadır,girmek için konumun id'sini tuşlayınız",
            location.getId(), location.getName(), ((Cave) location).getCountObstacles());
        } else if (location.getClass().equals(River.class)) {
          LOGGER.debug("ID : {} ,İSİM : {} ; {} adet ayı bulunmaktadır,girmek için konumun id'sini tuşlayınız",
            location.getId(), location.getName(), ((River) location).getCountObstacles());
        } else if (location.getClass().equals(Mine.class)) {
          LOGGER.debug("ID : {} ,İSİM : {} ; {} adet yılan bulunmaktadır,girmek için konumun id'sini tuşlayınız",
            location.getId(), location.getName(), ((Mine) location).getCountObstacles());
        } else {
          LOGGER.debug("ID : {} ,İSİM : {} ; girmek için konumun id'sini tuşlayınız.", location.getId(), location.getName());
        }
      }
      LOGGER.debug("Oyundan Çıkmak İçin E tuşuna basınız");

      Scanner input = InputScanner.getInstance();
      String selection = input.nextLine();
      selection = selection.toUpperCase(Locale.ROOT);
      switch (selection) {
        case "0":
          LOGGER.debug("Güvenli Evdesiniz");
          winningGame = refreshHealth(locations.get(0));
          break;
        case "1":
          LOGGER.debug("Mağazadasınız");
          buy((ToolStore) locations.get(1));
          break;
        case "2":
          LOGGER.debug("Ormandasınız");
          Forest forest = ((Forest) locations.get(2));
          if (forest.getCountObstacles() == 0) {
            LOGGER.debug("Hiç vampir kalmadı , burada savaşamazsınız");
            break;
          }
          List<Obstacle> vampires = forest.getVampires();
          isAlive = combat(vampires);
          if (vampires.size() == 0) {
            this.inventory.setFirewood(true);
            LOGGER.debug("Bölgeyi temizlediniz");
            LOGGER.debug("Bölge ödülünü aldınız");
          }
          break;
        case "3":
          LOGGER.debug("Mağaradasınız");
          Cave cave = (Cave) locations.get(3);
          if (cave.getCountObstacles() == 0) {
            LOGGER.debug("Hiç zombi kalmadı , burada savaşamazsınız");
            break;
          }
          List<Obstacle> zombies = cave.getZombies();
          isAlive = combat(zombies);
          if (zombies.size() == 0) {
            this.inventory.setFood(true);
            LOGGER.debug("Bölgeyi temizlediniz");
            LOGGER.debug("Bölge ödülünü aldınız");
          }
          break;
        case "4":
          LOGGER.debug("Nehirdesiniz");
          River river = (River) locations.get(4);
          if (river.getCountObstacles() == 0) {
            LOGGER.debug("Hiç ayı kalmadı , burada savaşamazsınız");
            break;
          }
          List<Obstacle> bears = river.getBears();
          isAlive = combat(bears);
          if (bears.size() == 0) {
            this.inventory.setWater(true);
            LOGGER.debug("Bölgeyi temizlediniz");
            LOGGER.debug("Bölge ödülünü aldınız");
          }
          break;
        case "5":
          LOGGER.debug("Madendesin");
          Mine mine = (Mine) locations.get(5);
          if (mine.getCountObstacles() == 0) {
            LOGGER.debug("Hiç yılan kalmadı , burada savaşamazsınız");
            break;
          }
          List<Obstacle> snakes = mine.getSnakes();
          isAlive = combat(snakes);
          if (snakes.size() == 0) {
            LOGGER.debug("Bölgeyi temizlediniz");
          }
          break;
        case "E":
          LOGGER.debug("Çıkış yaptınız");
          exitFlag = false;
          break;
        default:
          LOGGER.debug("Tanımsız Tuşa Bastınız");
          break;
      }

    }
  }

  @Override
  public boolean combat(List<Obstacle> obstacles) {
    boolean exitFlag = true;
    boolean isAlive = true;
    while (exitFlag && obstacles.size() > 0 && isAlive) {
      showStatePlayer();
      Obstacle obstacle = obstacles.get(0);
      obstacle.showObstacleFeatures();
      LOGGER.debug("Vurmak için V , Kaçmak için R basınız.");
      Scanner input = InputScanner.getInstance();
      String selection = input.nextLine();
      selection = selection.toUpperCase();
      switch (selection) {
        case "V":
          LOGGER.debug("Savastınız");
          int priority = ((int) (Math.random() * 2)) + 1;//ÖDEV2 %50 şans ile canavarın ilk vurması
          if (priority == 1) {
            health -= (obstacle.getDamage() - block);
            LOGGER.debug("CANAVAR VURDU");
          }
          while (health > 0) {
            showStatePlayer();
            obstacle.showObstacleFeatures();
            obstacle.setHealth(obstacle.getHealth() - damage);
            LOGGER.debug("SİZ VURDUNUZ");
            if (obstacle.getHealth() <= 0) {
              LOGGER.debug("Canavarı Öldürdünüz");
              money += obstacle.getMoney();
              obstacles.remove(obstacle);
              break;
            }
            health -= (obstacle.getDamage() - block);
            LOGGER.debug("CANAVAR VURDU");
          }
          if (health <= 0) {
            LOGGER.debug("Öldünüz ve oyunu kaybettiniz");
            isAlive = false;
          }
          if (obstacle.getClass().equals(Snake.class)) {//ÖDEV3 Yılanın olasılık ödülü
            int awardProbability = ((int) (Math.random() * 100)) + 1;
            if (awardProbability <= 15) {
              Weapon weapon = ((Snake) obstacle).awardWeapon();
              this.damage += weapon.getDamage();
              inventory.getWeapon().add(weapon);
            } else if (awardProbability <= 30) {
              Armor armor = ((Snake) obstacle).awardArmor();
              this.block += armor.getBlock();
              inventory.getArmor().add(armor);
            } else if (awardProbability <= 55) {
              int moneyAward = ((Snake) obstacle).awardMoney();
              money += moneyAward;
            } else {
              LOGGER.debug("Hiçbir şey kazanamadınız");
            }
          }
          break;
        case "R":
          LOGGER.debug("Kaçtınız");
          exitFlag = false;
          break;
        default:
          LOGGER.debug("Tanımsız Tuş");
          break;
      }
    }
    return isAlive;
  }

  @Override
  public void buy(ToolStore toolStore) {
    List<Tool> toolList = toolStore.getToolList();
    boolean exitFlag = true;
    while (exitFlag) {
      showStatePlayer();
      toolStore.toolMenu();
      Scanner input = InputScanner.getInstance();
      String selection = input.nextLine();
      selection = selection.toUpperCase();
      Weapon weapon;
      Armor armor;
      switch (selection) {
        case "0":
          weapon = ((Weapon) toolList.get(0));
          buyWeapon(weapon);
          break;
        case "1":
          weapon = ((Weapon) toolList.get(1));
          buyWeapon(weapon);
          break;
        case "2":
          weapon = ((Weapon) toolList.get(2));
          buyWeapon(weapon);
          break;
        case "3":
          armor = ((Armor) toolList.get(3));
          buyArmor(armor);
          break;
        case "4":
          armor = ((Armor) toolList.get(4));
          buyArmor(armor);
          break;
        case "5":
          armor = ((Armor) toolList.get(5));
          buyArmor(armor);
          break;
        case "E":
          LOGGER.debug("Mağazadan Çıkış Yaptınız");
          exitFlag = false;
          showStatePlayer();
          break;
        default:
          LOGGER.debug("Tanımsız Tuş");
          break;
      }
    }

  }

  //Siliah alma metod.
  private void buyWeapon(Weapon weapon) {
    if (this.money >= weapon.getCost()) {
      this.money -= weapon.getCost();
      this.damage += weapon.getDamage();
      this.inventory.getWeapon().add(weapon);
      LOGGER.debug("Silah Envantere Eklendi");
    } else {
      LOGGER.debug("Yetersiz Bakiye");
    }
  }

  //Zırh alma metodu.
  private void buyArmor(Armor armor) {
    if (this.money >= armor.getCost()) {
      this.money -= armor.getCost();
      this.block += armor.getBlock();
      this.inventory.getArmor().add(armor);
      LOGGER.debug("Zırh Envantere Eklendi");
    } else {
      LOGGER.debug("Yetersiz Bakiye");
    }
  }

  public boolean refreshHealth(Location location) {
    LOGGER.debug("Can Yenilendi");
    this.health = this.initialHealth;
    showStatePlayer();
    if (inventory.isFirewood() && inventory.isFood() && inventory.isWater()) {//ÖDEV1
      LOGGER.debug("Tebrikler Oyunu Kazandınız");
      return true;
    }
    return false;
  }

  public void showStatePlayer() {
    LOGGER.debug("-------OYUNCU GÜNCEL BİLGİSİ--------");
    LOGGER.debug("HASAR : {} , CAN : {} , PARA : {} , ENGELLEME {}", this.damage, this.health, this.money, this.block);
  }


}
