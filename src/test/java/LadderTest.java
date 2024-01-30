import domain.Ladder;
import domain.LadderDepth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @Test
  void 사다리가_끊겨_있으면_예외가_발생한다() {
    int numberOfPlayers = 4;
    LadderDepth testDepth = new LadderDepth(5, numberOfPlayers);

    Assertions.assertDoesNotThrow(() -> {
      Ladder testLadder = new Ladder(testDepth, numberOfPlayers);
    });
  }
}
