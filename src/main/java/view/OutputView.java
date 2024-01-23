package view;

import domain.Ladder;
import domain.Players;
import java.util.List;

public class OutputView {

  private final int MAKE_BLANK_FIVE = 6;

  public void showUpperPhase(Players players, Ladder ladder) {
    System.out.println("실행결과\n");
    showPlayers(players);
    showLadder(ladder);
  }

  public void showPlayers(Players players) {
    String result = "";
    for (int i = 0; i < players.numberOfPlayers(); i++) {
      String playersName = players.getPlayerByIndex(i).getPlayerNameString();
      String blank = makingBlank(playersName.length());
      result += playersName + blank;
    }
    System.out.println(result);
  }

  public void showLadder(Ladder ladder) {
    for (int i = 0; i < ladder.getDepthValue(); i++) {
      List<Boolean> lineValue = ladder.getLineValue(i);
      String ladderParts = "|";
      String result = drawLadder(lineValue, ladderParts);
      System.out.println(result);
    }
  }

  private String drawLadder(List<Boolean> lineValue, String ladderParts) {
    for (int j = 0; j < lineValue.size(); j++) {
      if (lineValue.get(j)) {
        ladderParts += "-----|";
      }
      if (!lineValue.get(j)) {
        ladderParts += "     |";
      }
    }
    return ladderParts;
  }

  public String makingBlank(int lengthOfName) {
    int count = MAKE_BLANK_FIVE - lengthOfName;
    String blank = "";
    for (int i = 0; i < count; i++) {
      blank += " ";
    }
    return blank;
  }
}
