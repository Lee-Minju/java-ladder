package controller;

import domain.GameResults;
import domain.Ladder;
import domain.Player;
import domain.Players;
import java.util.ArrayList;
import java.util.List;
import tools.NumberGenerator;
import tools.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

  private static final String END_COMMAND = "end";
  private static final String SHOW_ALL_COMMAND = "all";

  private final InputView inputView = new InputView();
  private final OutputView outputView = new OutputView();

  public void doLadderGame() {
    NumberGenerator ladderSetting = new RandomNumberGenerator();
    Players players = makePlayers();
    GameResults gameResults = makeGameResults(players.getNumberOfPlayers());
    Ladder ladder = makeLadder(players.getNumberOfPlayers(), ladderSetting);
    outputView.showUpperPhase(players, ladder, gameResults);
    processGame(players, ladder);
    presentResult(players, gameResults);
  }

  private void processGame(Players players, Ladder ladder) {
    for (int i = 0; i < players.getNumberOfPlayers(); i++) {
      Player currentPlayer = players.getPlayerByIndex(i);
      processPlayersPosition(currentPlayer, ladder, players.getNumberOfPlayers());
    }
  }

  private void presentResult(Players players, GameResults gameResults) {
    try {
      decideTarget(players, gameResults, " ");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      presentResult(players, gameResults);
    }
  }

  private void decideTarget(Players players, GameResults gameResults, String targetResult) {
    while (isEnd(targetResult)) {
      targetResult = inputView.askPlayer();
      presentTarget(players, gameResults, targetResult);
    }
  }

  private void presentTarget(Players players, GameResults gameResults, String targetResult) {
    if (!isEnd(targetResult)) {
      return;
    }
    if (targetResult.equals(SHOW_ALL_COMMAND)) {
      outputView.showAll(players, gameResults);
      return;
    }
    Player targetPlayer = players.getPlayerByName(targetResult);
    outputView.showResult(gameResults.getResult(targetPlayer.getPositionValue()));
  }

  private boolean isEnd(String targetResult) {
    if (targetResult.equals(END_COMMAND)) {
      return false;
    }
    return true;
  }

  private void processPlayersPosition(Player currentPlayer, Ladder ladder, int numberOfPlayers) {
    for (int i = 0; i < ladder.getDepth(); i++) {
      processPositionForEachDepth(currentPlayer, ladder, i, numberOfPlayers);
    }
  }

  private void processPositionForEachDepth(Player currentPlayer, Ladder ladder, int depth,
      int numberOfPlayers) {
    if (currentPlayer.getPosition().isMostLeftPosition() || currentPlayer.getPosition()
        .isMostRightPosition(numberOfPlayers)) {
      processSpecialCase(currentPlayer, ladder, depth, numberOfPlayers);
      return;
    }
    if (ladder.getLine(depth).getPoint(currentPlayer.getPositionValue() - 1)) {
      moveLeftIfPossible(currentPlayer, ladder, depth);
      return;
    }
    moveRightIfPossible(currentPlayer, ladder, depth);
  }

  private void processSpecialCase(Player currentPlayer, Ladder ladder, int depth,
      int numberOfPlayers) {
    if (currentPlayer.getPosition().isMostLeftPosition()) {
      moveRightIfPossible(currentPlayer, ladder, depth);
      return;
    }
    if (currentPlayer.getPosition().isMostRightPosition(numberOfPlayers)) {
      moveLeftIfPossible(currentPlayer, ladder, depth);
    }
  }

  private void moveRightIfPossible(Player currentPlayer, Ladder ladder, int depth) {
    if (ladder.getLine(depth).getPoint(currentPlayer.getPositionValue())) {
      currentPlayer.getPosition().moveRight();
    }
  }

  private void moveLeftIfPossible(Player currentPlayer, Ladder ladder, int depth) {
    if (ladder.getLine(depth).getPoint(currentPlayer.getPositionValue() - 1)) {
      currentPlayer.getPosition().moveLeft();
    }
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

  private Ladder makeLadder(int numberOfPlayers, NumberGenerator ladderSetting) {
    try {
      int depthInput = inputView.askLadderDepth();
      Ladder ladder = new Ladder(depthInput, numberOfPlayers, ladderSetting);
      return ladder;
    } catch (IllegalArgumentException e) {
      System.out.printf(e.getMessage(), numberOfPlayers - 1);
      return makeLadder(numberOfPlayers, ladderSetting);
    }
  }

  private GameResults makeGameResults(int numberOfPlayers) {
    try {
      GameResults gameResults = new GameResults(inputView.askGameResults(), numberOfPlayers);
      return gameResults;
    } catch (IllegalArgumentException e) {
      System.out.printf(e.getMessage(), numberOfPlayers);
      return makeGameResults(numberOfPlayers);
    }
  }
}
