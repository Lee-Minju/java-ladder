import domain.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  void 플레이어_수에_맞는_라인_생성() {
    int numberOfPlayers = 4;
    Line testLine = new Line(numberOfPlayers);

    Assertions.assertEquals(testLine.length(), numberOfPlayers - 1);
  }

  @Test
  void 라인에_가로줄이_겹칠_수_없다() {
    int numberOfPlayers = 4;
    Line testLine = new Line(numberOfPlayers);

    Assertions.assertDoesNotThrow(() -> {
      for (int i = 0; i < numberOfPlayers - 2; i++) {
        if (testLine.getPoint(i).equals(true) && testLine.getPoint(i + 1).equals(true)) {
          throw new IllegalArgumentException("가로줄 중복");
        }
      }
    });
  }
}
