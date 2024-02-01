import domain.Ladder;
import domain.LadderDepth;
import domain.Line;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.NumberGenerator;
import tools.UnBlockedNumberGenerator;

public class LadderTest {
  @Test
  void 사다리가_끊겨_있으면_검증단계에서_예외가_발생한다() {
    int numberOfPlayers = 4;
    NumberGenerator numberGenerator = new UnBlockedNumberGenerator();
    LadderDepth testDepth = new LadderDepth(5, numberOfPlayers);
    Ladder testLadder = new Ladder(testDepth, numberOfPlayers); //테스트용 인스턴스 생성
    List<Line> testLines = testLadder.makeLines(testDepth, numberOfPlayers, numberGenerator);
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      testLadder.validateLadder(testLines, numberOfPlayers);
    });
  }
}
