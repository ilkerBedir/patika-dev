package inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
//Silah ve zırhın ana sınıfı olan Alet sınıfı
public class Tool {
  private int id;
  private String name;
  private int cost;
}
