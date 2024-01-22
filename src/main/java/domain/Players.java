package domain;
import java.util.List;

public class Players {

  private final int MIN_PLAYERS_NUMBER = 2;

  private List<Player> players;

  public Players(List<Player> players) {
    validatePlayer(players);
    this.players = players;
  }

  public void validatePlayer(List<Player> players) {
    if(players.size() < MIN_PLAYERS_NUMBER){
      throw new IllegalArgumentException("플레이어 수는 두명 이상이어야 합니다.");
    }
  }
}
