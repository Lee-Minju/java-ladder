import domain.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  @Test
  void 이름과_포지션을_받아서_플레이어를_생성한다() {
    Assertions.assertDoesNotThrow(() -> {
      Player player = new Player("pobi", 1);
    });
  }
}
