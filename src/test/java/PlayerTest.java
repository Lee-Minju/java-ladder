import domain.Player;
import domain.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  @Test
  void 이름을_받아서_플레이어_생성() {
    Name playerName = new Name("pobi");

    Assertions.assertDoesNotThrow(() -> {
      Player player = new Player(playerName);
    });
  }
}
