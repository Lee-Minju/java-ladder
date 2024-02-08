import domain.LadderDepth;
import domain.Lines;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.NumberGenerator;
import tools.UnBlockedNumberGenerator;

public class LinesTest {

  @Test
  void 사다리가_끊겨_있으면_검증단계에서_예외가_발생한다() {

    int numberOfPlayers = 4;
    NumberGenerator numberGenerator = new UnBlockedNumberGenerator();
    LadderDepth testDepth = new LadderDepth(5, numberOfPlayers);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Lines testLines = new Lines(testDepth.getValue(), numberOfPlayers, numberGenerator);
    });
  }
}
