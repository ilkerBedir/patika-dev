package location.normalLocation;

import inventory.Armor;
import inventory.Tool;
import inventory.Weapon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

//Mağaza Sınıfı
public class ToolStore extends NormalLocation {
  public static final Logger LOGGER = LoggerFactory.getLogger(ToolStore.class);
  private static List<Tool> toolList;

  public ToolStore(String name) {
    super(1, name);
  }

  //Mağazadaki ürün listesinin sınıf çağrıldıktan sonra liste oluşturmasını sağlayan static kod bloğu.
  static {
    toolList = new ArrayList<Tool>();
    Weapon revolver = new Weapon(0, "Tabanca", 25, 2);
    Weapon sword = new Weapon(1, "Kılıç", 35, 3);
    Weapon gun = new Weapon(2, "Tüfek", 45, 7);
    Armor light = new Armor(3, "Hafif Zırh", 15, 1);
    Armor medium = new Armor(4, "Orta Zırh", 25, 3);
    Armor heavy = new Armor(5, "Ağır Zırh", 40, 5);
    toolList.add(revolver);
    toolList.add(sword);
    toolList.add(gun);
    toolList.add(light);
    toolList.add(medium);
    toolList.add(heavy);
  }
  //Menu yazdıran metod.
  public void toolMenu() {
    LOGGER.debug("--------------------MAĞAZAYA HOŞGELDİNİZ------------------");
    for (Tool tool : toolList) {
      if (tool.getClass().equals(Weapon.class)) {
        LOGGER.debug("ID : {} , İSİM : {} ,PARA : {} , DAMAGE : {} almak için eşyanın id sini tuşlayınız.", tool.getId(), tool.getName(), tool.getCost(), ((Weapon) tool).getDamage());
      } else {
        LOGGER.debug("ID : {} , İSİM : {} ,PARA : {} , ENGELLEME : {} almak için eşyanın id sini tuşlayınız.", tool.getId(), tool.getName(), tool.getCost(), ((Armor) tool).getBlock());
      }
    }
    LOGGER.debug("Mağazadan Çıkış yapmak E tuşuna basınız.");

  }

  public List<Tool> getToolList() {
    return this.toolList;
  }

}
