import domain.Line;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tools.BlockedNumberGenerator;
import tools.NumberGenerator;
import tools.RandomNumberGenerator;

public class LineTest {

  @Test
  void 플레이어_수에_맞는_라인을_생성한다() {
    int numberOfPlayers = 4;
    NumberGenerator numberGenerator = new RandomNumberGenerator();

    Line testLine = new Line(numberOfPlayers, numberGenerator);
    Assertions.assertEquals(testLine.getLength(), numberOfPlayers - 1);
  }

  @DisplayName("가로줄이 겹쳐져서 생성된 라인을 발견하면 validateLine()에서 겹치지 않게 수정해서 Line을 생성한다")
  @Test
  void 라인에_가로줄이_겹친다면_검증단계에서_겹침을_해결한다() {
    NumberGenerator numberGenerator = new BlockedNumberGenerator();
    int numberOfPlayers = 4;
    Line testLine = new Line(numberOfPlayers, numberGenerator);

    Assertions.assertDoesNotThrow(() -> {
      for(int i=0; i<numberOfPlayers -2; i++) {
        if(testLine.getPoint(i).equals(true && testLine.getPoint(i+1).equals(true))){
          throw new IllegalArgumentException();
        }
      }
    });
  }
}
