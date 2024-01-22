package controller;

import domain.Ladder;
import domain.LadderDepth;
import domain.Name;
import domain.Player;
import domain.Position;
import java.util.ArrayList;
import java.util.List;
import view.InputView;

public class LadderController {

  InputView inputView = new InputView();

  public LadderController(InputView inputView) {
    this.inputView = inputView;
  }

  public void doLadderGame() {
    List<Player> players = makingPlayers();
    LadderDepth ladderDepth = new LadderDepth(inputView.askLadderDepth(), players.size());

  }

  public List<Player> makingPlayers() {
    List<String> namesInString = inputView.askName();
    List<Player> players = new ArrayList<>();
    for (int i = 0; i < namesInString.size(); i++) {
      Player player = new Player(new Name(namesInString.get(i)), new Position(i));
      players.add(player);
    }
    return players;
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
