package domain;
import java.util.List;

public class Players {

  private final int MIN_PLAYERS_NUMBER = 2;

  private List<Player> players;
  private int numberOfPlayers;

  public Players(List<Player> players) {
    this.players = players;
    this.numberOfPlayers = players.size();
    validatePlayer();
  }

  public void validatePlayer() {
    if(this.numberOfPlayers < MIN_PLAYERS_NUMBER){
      throw new IllegalArgumentException("플레이어 수는 두명 이상이어야 합니다.");
    }
  }

  public int numberOfPlayers() {
    return this.numberOfPlayers;
  }

  public Player getPlayerByIndex(int index) {
    return this.players.get(index);
  }
}
