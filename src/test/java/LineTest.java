import domain.Line;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  void 플레이어_수에_맞는_라인을_생성한다() {
    int numberOfPlayers = 4;
    Line testLine = new Line(numberOfPlayers);

    Assertions.assertEquals(testLine.getLength(), numberOfPlayers - 1);
  }

  @Test
  void 라인에_가로줄이_겹친다면_예외를_발생한다() {
    int numberOfPlayers = 4;
    Line testLine = new Line(numberOfPlayers);
    List<Boolean> testPoints = Arrays.asList(true, true, false);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      testLine.validateLine(testPoints, numberOfPlayers);
    });
  }
}
