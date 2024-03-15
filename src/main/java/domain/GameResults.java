package domain;

import java.util.List;

public class GameResults {

  private List<GameResult> gameResults;

  public GameResults(List<GameResult> gameResults, int numberOfPlayers) {
    validateGameResults(gameResults, numberOfPlayers);
    this.gameResults = gameResults;
  }

  private void validateGameResults(List<GameResult> value, int numberOfPlayers) {
    if (value.size() != numberOfPlayers) {
      throw new IllegalArgumentException("[ERROR] 결과의 갯수는 %d가 되어야 합니다.\n");
    }
  }

  public List<GameResult> getResults() {
    return List.copyOf(this.gameResults);
  }

  public int getSize() {
    return this.gameResults.size();
  }
}
