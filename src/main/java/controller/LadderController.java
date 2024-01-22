package controller;

import domain.Position;
import java.util.ArrayList;
import java.util.List;
import domain.Players;
import domain.Player;
import view.InputView;
import domain.Name;

public class LadderController {

  InputView inputView = new InputView();

  public LadderController(InputView inputView) {
    this.inputView = inputView;
  }

  public void doLadderGame() {


  }

  public List<Player> makingPlayers() {
    List<String> namesInString = inputView.askName();
    List<Player> players = new ArrayList<>();
    for(int i = 0; i<namesInString.size(); i++){
      Player player = new Player(new Name(namesInString.get(i)), new Position(i));
      players.add(player);
    }
    return players;
  }



}
