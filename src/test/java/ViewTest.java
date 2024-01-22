import controller.LadderController;
import domain.Ladder;
import domain.LadderDepth;
import org.junit.jupiter.api.Test;
import view.OutputView;

public class ViewTest {

  @Test
  void 뷰테스트() {
    System.out.println("*****");
    int numberOfPlayers = 4;
    LadderDepth testDepth = new LadderDepth(5, numberOfPlayers);
    Ladder testLadder = new Ladder(testDepth, numberOfPlayers);

    OutputView.showLadder(testLadder);

  }

}
