package view;

import domain.Ladder;
import domain.Line;
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
    for (int i = 0; i < players.getNumberOfPlayers(); i++) {
      String playersName = players.getPlayerByIndex(i).getPlayerNameValue();
      String blank = makeBlank(playersName.length());
      result += playersName + blank;
    }
    System.out.println(result);
  }

  public void showLadder(Ladder ladder) {
    for (int i = 0; i < ladder.getDepthValue(); i++) {
      Line line = ladder.getLine(i);
      String ladderParts = "|";
      String result = drawLadder(line, ladderParts);
      System.out.println(result);
    }
  }

  private String drawLadder(Line line, String ladderParts) {
    for (int j = 0; j < line.getLength(); j++) {
      if (line.getPoint(j)) {
        ladderParts += "-----|";
      }
      if (!line.getPoint(j)) {
        ladderParts += "     |";
      }
    }
    return ladderParts;
  }

  public String makeBlank(int lengthOfName) {
    int count = MAKE_BLANK_FIVE - lengthOfName;
    String blank = "";
    for (int i = 0; i < count; i++) {
      blank += " ";
    }
    return blank;
  }
}
