package view;

import domain.GameResults;
import domain.Ladder;
import domain.Line;
import domain.Players;

public class OutputView {

  private static final int BLANK_BASE = 6;

  public void showUpperPhase(Players players, Ladder ladder, GameResults gameResults) {
    System.out.println("실행결과\n");
    showPlayers(players);
    showLadder(ladder);
    showGameResults(gameResults);
  }

  private void showGameResults(GameResults gameResults) {
    String result = "";
    for (int i = 0; i < gameResults.getSize(); i++) {
      String resultName = gameResults.getResult(i);
      String blank = makeBlank(resultName.length());
      result += resultName + blank;
    }
    System.out.println(result);
  }

  public void showPlayers(Players players) {
    String result = "";
    for (int i = 0; i < players.getNumberOfPlayers(); i++) {
      String playersName = players.getPlayerByIndex(i).getName();
      String blank = makeBlank(playersName.length());
      result += playersName + blank;
    }
    System.out.println(result);
  }

  private void showLadder(Ladder ladder) {
    for (int i = 0; i < ladder.getDepthValue(); i++) {
      Line line = ladder.getLine(i);
      String result = drawLadder(line);
      System.out.println(result);
    }
  }

  private String drawLadder(Line line) {
    String ladderParts = "|";
    for (int j = 0; j < line.getLength(); j++) {
      if (line.getPoint(j)) {
        ladderParts += "-----|";
        continue;
      }
      ladderParts += "     |";
    }
    return ladderParts;
  }

  private String makeBlank(int lengthOfName) {
    int count = BLANK_BASE - lengthOfName;
    String blank = " ";
    blank = blank.repeat(count);
    return blank;
  }
}
