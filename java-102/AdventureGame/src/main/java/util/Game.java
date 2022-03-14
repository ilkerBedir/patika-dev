package util;

import gameChar.GameChar;
import inventory.Armor;
import inventory.Inventory;
import inventory.Weapon;
import location.*;
import location.battleLocation.Cave;
import location.battleLocation.Forest;
import location.battleLocation.Mine;
import location.battleLocation.River;
import location.normalLocation.SafeHouse;
import location.normalLocation.ToolStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
  private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);
  private static List<Location> locations;

  //Oyuncu oyuna başlamadan önce lokasyondaki canavarların oluşturulması ve yerleştirilmesini sağlayan metod.
  public static void initGame() {
    locations=new ArrayList<>();
    locations.add(new SafeHouse("Güvenli Ev"));
    locations.add(new ToolStore("Mağaza"));
    locations.add(new Forest("Orman"));
    locations.add(new Cave("Mağara"));
    locations.add(new River("Nehir"));
    locations.add(new Mine("Maden"));
  }

  //Oyun Başlatma Metodu.
  public static void startGame() {
    LOGGER.debug("Patika Dev -- Macera Oyununa Hoşgeldiniz");
    LOGGER.debug("Lütfen İsim Giriniz : ");
    Scanner input = InputScanner.getInstance();
    String playerName = input.nextLine();
    LOGGER.debug("Tekrar Hoşgeldin {}", playerName);
    Player player = Player.builder().name(playerName).block(0).build();
    GameChar gameCharacter = player.selectChar();
    if (gameCharacter.getClass().equals(GameChar.class)) {
      return;
    }
    Inventory inventory = new Inventory(false, false, false, new ArrayList<Weapon>(), new ArrayList<Armor>());
    player.setInventory(inventory);
    player.setDamage(gameCharacter.getDamage());
    player.setHealth(gameCharacter.getHealthy());
    player.setInitialHealth(gameCharacter.getHealthy());
    player.setMoney(gameCharacter.getMoney());
    player.setLocation(locations.get(0));
    LOGGER.debug("Şuanki Konumunuz : {}", player.getLocation().getName());
    player.selectLocation(locations);
    locations.clear();
  }

}
