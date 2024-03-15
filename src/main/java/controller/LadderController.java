package controller;

import static tools.PointStatus.LEFT;
import static tools.PointStatus.RIGHT;

import domain.GameResult;
import domain.GameResults;
import domain.Ladder;
import domain.Player;
import domain.Players;
import java.util.ArrayList;
import java.util.List;
import tools.NumberGenerator;
import tools.PointStatus;
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
    outputView.showResult(gameResults.getResults().get(targetPlayer.getPositionValue()).getValue());
  }

  private boolean isEnd(String targetResult) {
    if (targetResult.equals(END_COMMAND)) {
      return false;
    }
    return true;
  }

  private void processPlayersPosition(Player currentPlayer, Ladder ladder, int numberOfPlayers) {
    for (int currentDepth = 0; currentDepth < ladder.getDepth(); currentDepth++) {
      processPositionForEachDepth(currentPlayer, ladder, currentDepth, numberOfPlayers);
    }
  }

  private void processPositionForEachDepth(Player currentPlayer, Ladder ladder, int currentDepth,
      int numberOfPlayers) {
    PointStatus currentStatus = ladder.isPossibleMoveNow(currentPlayer, currentDepth,
        numberOfPlayers);
    if (currentStatus.equals(LEFT)) {
      currentPlayer.getPosition().moveLeft();
    }
    if (currentStatus.equals(RIGHT)) {
      currentPlayer.getPosition().moveRight();
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
      List<String> gameResultsInString = inputView.askGameResults();
      List<GameResult> gameResultLineUp = makeGameResultLineUp(gameResultsInString);
      return new GameResults(gameResultLineUp, numberOfPlayers);
    } catch (IllegalArgumentException e) {
      System.out.printf(e.getMessage(), numberOfPlayers);
      return makeGameResults(numberOfPlayers);
    }
  }

  private List<GameResult> makeGameResultLineUp(List<String> gameResultsInString) {
    List<GameResult> gameResultLineUp = new ArrayList<>();
    for (int i = 0; i < gameResultsInString.size(); i++) {
      GameResult gameResult = new GameResult(gameResultsInString.get(i));
      gameResultLineUp.add(gameResult);
    }
    return gameResultLineUp;
  }
}
