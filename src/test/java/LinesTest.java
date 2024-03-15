import domain.LadderDepth;
import domain.Line;
import domain.Lines;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tools.NumberGenerator;
import tools.UnBlockedNumberGenerator;

public class LinesTest {

  @DisplayName("사다리 후보인 Lines에 끊어진 줄이 있다면 랜덤으로 다시 만들게 해서 끊어진 Lines를 해결한다.")
  @Test
  void 사다리가_끊겨_있으면_검증단계에서_다시_만들게_한다() {
    int numberOfPlayers = 4;
    NumberGenerator numberGenerator = new UnBlockedNumberGenerator();
    LadderDepth testDepth = new LadderDepth(5, numberOfPlayers);
    Lines testLines = new Lines(testDepth.getValue(), numberOfPlayers, numberGenerator);

    Assertions.assertDoesNotThrow(() -> {
      if(!checkLinesForRow(testLines.getValues())) {
        throw new IllegalArgumentException();
      }
    });
  }


  private boolean checkLinesForRow(List<Line> candidateLines) {
    int numberOfPoints = candidateLines.get(0).getLength();
    for (int i = 0; i < numberOfPoints; i++) {
      if (isRowEmpty(candidateLines, i)) {
        return false;
      }
    }
    return true;
  }

  private boolean isRowEmpty(List<Line> candidateLines, int lineIndex) {
    for (int i = 0; i < candidateLines.size(); i++) {
      if (hasHorizon(candidateLines.get(i), lineIndex)) {
        return false;
      }
    }
    return true;
  }

  private boolean hasHorizon(Line candidateLine, int lineIndex) {
    return (candidateLine.getPoint(lineIndex));
  }
}
