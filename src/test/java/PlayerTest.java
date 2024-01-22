import domain.Player;
import domain.Name;
import domain.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  @Test
  void 이름과_포지션을_받아서_플레이어_생성() {
    Name playerName = new Name("pobi");
    Position testPosition = new Position(1);

    Assertions.assertDoesNotThrow(() -> {
      Player player = new Player(playerName, testPosition);
    });
  }
}
