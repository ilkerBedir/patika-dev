package gameChar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
//Oyunda Seçilen Karakterlerin Ana sınıfı.
public class GameChar {
  private int id;
  private int damage;
  private int healthy;
  private int money;
}
