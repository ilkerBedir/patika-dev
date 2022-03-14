import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Game;

//Oyunun Çağrıldığı ana fonksiyonun sınıfı, LOGGER parametresi konsola yazmak için kullanılmıştır.
public class Main {
  public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    Game.initGame();
    Game.startGame();
  }
}
