package controller;

import domain.Ladder;
import domain.LadderDepth;
import domain.Name;
import domain.Player;
import domain.Players;
import domain.Position;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderController {

  private final InputView inputView = new InputView();
  private final OutputView outputView = new OutputView();

  public void doLadderGame() {
    Players players = makePlayers();
    LadderDepth ladderDepth = makeLadderDepth(players.getNumberOfPlayers());
    Ladder ladder = new Ladder(ladderDepth, players.getNumberOfPlayers());
    outputView.showUpperPhase(players, ladder);
  }

  private Players makePlayers() {
    try {
      List<String> namesInString = inputView.askName();
      List<Player> playerLineUp = makePlayerLineUp(namesInString);
      return new Players(playerLineUp);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return makePlayers();
    }
  }

  private List<Player> makePlayerLineUp(List<String> namesInString) {
    List<Player> playerLineUp = new ArrayList<>();
    for (int i = 0; i < namesInString.size(); i++) {
      Player player = new Player(namesInString.get(i), i);
      playerLineUp.add(player);
    }
    return playerLineUp;
  }

  private LadderDepth makeLadderDepth(int numberOfPlayers) {
    try {
      LadderDepth ladderDepth = new LadderDepth(inputView.askLadderDepth(), numberOfPlayers);
      return ladderDepth;
    } catch (IllegalArgumentException e) {
      System.out.printf(e.getMessage(), numberOfPlayers - 1);
      return makeLadderDepth(numberOfPlayers);
    }
  }
}
