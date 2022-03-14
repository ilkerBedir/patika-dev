package inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
@AllArgsConstructor
//Envanter sınıfı
public class Inventory {
  private boolean water;
  private boolean food;
  private boolean firewood;
  private ArrayList<Weapon> weapon;
  private ArrayList<Armor> armor;
}
