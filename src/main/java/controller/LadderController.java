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

  InputView inputView = new InputView();
  OutputView outputView = new OutputView();

  public LadderController(InputView inputView, OutputView outputView) {
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public void doLadderGame() {
    Players players = makingPlayers();
    LadderDepth ladderDepth = makingLadderDepth(players.numberOfPlayers());
    Ladder ladder = new Ladder(ladderDepth, players.numberOfPlayers());
    outputView.showUpperPhase(players, ladder);
  }

  private Players makingPlayers() {
    try {
      List<String> namesInString = inputView.askName();
      List<Player> players = new ArrayList<>();
      for (int i = 0; i < namesInString.size(); i++) {
        Player player = new Player(new Name(namesInString.get(i)), new Position(i));
        players.add(player);
      }
      return new Players(players);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return makingPlayers();
    }
  }

  private LadderDepth makingLadderDepth(int numberOfPlayers) {
    try {
      LadderDepth ladderDepth = new LadderDepth(inputView.askLadderDepth(), numberOfPlayers);
      return ladderDepth;
    } catch (IllegalArgumentException e) {
      System.out.printf(e.getMessage(), numberOfPlayers - 1);
      return makingLadderDepth(numberOfPlayers);
    }
  }
}
