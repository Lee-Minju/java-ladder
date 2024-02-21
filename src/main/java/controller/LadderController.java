package controller;

import domain.GameResults;
import domain.Ladder;
import domain.LadderDepth;
import domain.Player;
import domain.Players;
import java.util.ArrayList;
import java.util.List;
import tools.NumberGenerator;
import tools.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

  private final InputView inputView = new InputView();
  private final OutputView outputView = new OutputView();

  public void doLadderGame() {
    NumberGenerator ladderSetting = new RandomNumberGenerator();
    Players players = makePlayers();
    GameResults gameResults = makeGameResults(players.getNumberOfPlayers());
    LadderDepth ladderDepth = makeLadderDepth(players.getNumberOfPlayers());
    Ladder ladder = new Ladder(ladderDepth, players.getNumberOfPlayers(), ladderSetting);
    outputView.showUpperPhase(players, ladder, gameResults);
    processingGame();
    presentResult(players, gameResults);
  }

  private void processingGame() {
  }

  private void presentResult(Players players, GameResults gameResults) {
    try {
      boolean check = true;
      while (check) {
        String targetResult = inputView.askPlayer();
        if (targetResult.equals("all")) {
          outputView.showAll(players, gameResults);
          continue;
        }
        Player targetPlayer = players.getPlayerByName(targetResult);
        String result = gameResults.getResult(targetPlayer.getPosition());
        outputView.showResult(result);
      }
    }catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
      presentResult(players, gameResults);
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

  private LadderDepth makeLadderDepth(int numberOfPlayers) {
    try {
      LadderDepth ladderDepth = new LadderDepth(inputView.askLadderDepth(), numberOfPlayers);
      return ladderDepth;
    } catch (IllegalArgumentException e) {
      System.out.printf(e.getMessage(), numberOfPlayers - 1);
      return makeLadderDepth(numberOfPlayers);
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
