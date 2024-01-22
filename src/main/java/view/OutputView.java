package view;

import domain.Ladder;
import domain.Players;
import java.util.List;

public class OutputView {

  public void showUpperPhase(Players players, Ladder ladder) {
    System.out.println("실행결과\n");
    showPlayers(players);
    showLadder(ladder);
  }

  public void showPlayers(Players players) {
    String result = "";
    for (int i = 0; i < players.numberOfPlayers(); i++) {
      result += players.getPlayerByIndex(i).getPlayerNameString() + " ";
    }
    System.out.println(result);
  }

  public void showLadder(Ladder ladder) {
    for (int i = 0; i < ladder.getDepthValue(); i++) {
      List<Boolean> lineValue = ladder.getLineValue(i);
      String result = "|";
      for (int j = 0; j < lineValue.size(); j++) {
        if (lineValue.get(j)) {
          result += "-----|";
        }
        if (!lineValue.get(j)) {
          result += "     |";
        }
      }
      System.out.println(result);
    }
  }
}
