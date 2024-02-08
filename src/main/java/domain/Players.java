package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {

  private static final int MIN_PLAYERS_NUMBER = 2;

  private List<Player> players;

  public Players(List<Player> players) {
    validatePlayers(players);
    this.players = players;
  }

  private void validatePlayers(List<Player> players) {
    if (players.size() < MIN_PLAYERS_NUMBER) {
      throw new IllegalArgumentException("[ERROR] 플레이어 수는 두명 이상이어야 합니다.");
    }
    hasDuplicatedName(players);
  }

  private void hasDuplicatedName(List<Player> players) {
    Set<Player> duplicateChecker = new HashSet<>();
    duplicateChecker.addAll(players);
    if(duplicateChecker.size() != players.size()){
      throw new IllegalArgumentException("[ERROR] 중복된 이름을 입력할 수 없습니다.");
    }
  }

  public int getNumberOfPlayers() {
    return this.players.size();
  }

  public Player getPlayerByIndex(int index) {
    return this.players.get(index);
  }
}
