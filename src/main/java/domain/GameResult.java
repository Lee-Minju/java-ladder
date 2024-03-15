package domain;

public class GameResult {

  private final String gameResult;

  public GameResult(String gameResult) {
    this.gameResult = gameResult;
  }

  public String getValue() {
    return this.gameResult;
  }
}
