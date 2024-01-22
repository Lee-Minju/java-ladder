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
    LadderDepth ladderDepth = makingLadderDepth();
    Ladder ladder = new Ladder(ladderDepth, players.numberOfPlayers());
    // 사다리랑 플레이어 출력


  }

  public Players makingPlayers() {
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

  public LadderDepth makingLadderDepth() {
    try {
      LadderDepth ladderDepth = new LadderDepth(inputView.askLadderDepth(),
          makingPlayers().numberOfPlayers());
      return ladderDepth;
    }catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
      return makingLadderDepth();
    }
  }

 /* public static Ladder makingLadder(LadderDepth depth, int numberOfPlayers) {
    try {
      Ladder ladder = new Ladder(depth, numberOfPlayers);
      return ladder;
    } catch (IllegalArgumentException e) {
      return makingLadder(depth, numberOfPlayers);
    }
  }*/


}
