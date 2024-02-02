
import domain.Player;
import domain.Players;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayersTest {

  @Test
  void 플레이어리스트를_생성_한다() {
    Player testPlayer1 = new Player("pobi", 0);
    Player testPlayer2 = new Player("minju", 1);

    Assertions.assertDoesNotThrow(() -> {
      Players testPlayers = new Players(List.of(testPlayer1, testPlayer2));
    });
  }

  @Test
  void 플레이어_수는_두명_이상이어야_한다() {
    Player testPlayer1 = new Player("pobi", 0);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Players testPlayers = new Players(List.of(testPlayer1));
    });
  }

  @Test
  void 플레이어_이름이_중복되서는_안된다() {
    Player testPlayer1 = new Player("minju", 0);
    Player testPlayer2 = new Player("minju", 1);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Players testPlayers = new Players(List.of(testPlayer1, testPlayer2));
    });
  }
}
