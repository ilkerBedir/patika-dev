package util;

import gameChar.GameChar;
import location.Location;
import location.normalLocation.ToolStore;
import obstacle.Obstacle;

import java.util.List;

public interface IPlayer {

  //Oyuncunu oynayacağı karakteri seçmesini sağlayan metod.
  GameChar selectChar();

  //Kullanıcının gideceğin lokasyonun seçmesini sağlayan metod.
  void selectLocation(List<Location> locations);

  //Oyuncunun canavarlarla savaşma veya kaçmasını seçtirmeyi sağlayan metod.
  boolean combat(List<Obstacle> obstacles);

  //Oyuncunun Mağazadan eşya almasını sağlayan metod.
  void buy(ToolStore location);

  //Güvenli Evdeki can yenileme metodu.
  boolean refreshHealth(Location location);

  //Oyuncunun mevcut durumunu gösteren metod.
  void showStatePlayer();
}
