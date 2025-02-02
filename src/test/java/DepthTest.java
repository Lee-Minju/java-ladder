import domain.LadderDepth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepthTest {

  @Test
  void 깊이를_받아서_저장한다() {
    int depth = 5;
    int numberOfPlayer = 4;

    Assertions.assertDoesNotThrow(() -> {
      LadderDepth ladderDepth = new LadderDepth(depth, numberOfPlayer);
    });
  }

  @Test
  void 깊이를_요청하면_반환한다() {
    LadderDepth ladderDepth = new LadderDepth(5, 4);
    int result = ladderDepth.getValue();

    Assertions.assertEquals(result, 5);
  }

  @Test
  void 깊이가_적절하지_않게_작다면_예외가_발생한다() {
    int depth = 1;
    int numberOfPlayers = 5;

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      LadderDepth ladderDepth = new LadderDepth(depth, numberOfPlayers);
    });
  }
}
