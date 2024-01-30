import domain.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {

  @Test
  void 포지션을_왼쪽으로이동한다() {
    int position = 1;

    Position test = new Position(position);
    test.moveLeft();
    Assertions.assertEquals(test.getValue(), 0);
  }

  @Test
  void 포지션을_오른쪽으로_이동한다() {
    int position = 0;

    Position test = new Position(position);
    test.moveRight();
    Assertions.assertEquals(test.getValue(), 1);
  }
}
