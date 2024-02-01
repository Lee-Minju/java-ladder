import domain.Line;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.BlockedNumberGenerator;
import tools.NumberGenerator;
import tools.RandomNumberGenerator;

public class LineTest {

  @Test
  void 플레이어_수에_맞는_라인을_생성한다() {
    int numberOfPlayers = 4;
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    Line testLine = new Line(numberOfPlayers,numberGenerator);

    Assertions.assertEquals(testLine.getLength(), numberOfPlayers - 1);
  }

  @Test
  void 라인에_가로줄이_겹친다면_검증단계에서_예외를_발생한다() {
    NumberGenerator numberGenerator1 = new BlockedNumberGenerator();
    NumberGenerator numberGenerator2 = new RandomNumberGenerator();
    int numberOfPlayers = 4;
    Line testLine = new Line(numberOfPlayers, numberGenerator2); //테스트용 인스턴스생성
    List<Boolean> testPoints = testLine.makePoints(numberOfPlayers, numberGenerator1);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      testLine.validateLine(testPoints, numberOfPlayers);
    });
  }
}
