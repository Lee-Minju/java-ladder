package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {

  private final int MIN_PLAYERS_NUMBER = 2;

  private List<Player> players;
  private int numberOfPlayers;

  public Players(List<Player> players) {
    this.players = players;
    this.numberOfPlayers = players.size();
    validatePlayers();
  }

  private void validatePlayers() {
    if (this.numberOfPlayers < MIN_PLAYERS_NUMBER) {
      throw new IllegalArgumentException("[ERROR] 플레이어 수는 두명 이상이어야 합니다.");
    }
    hasDuplicatedName();
  }

  private void hasDuplicatedName() {
    Set<Player> playersInSet = new HashSet<>();
    for(int i=0; i<this.numberOfPlayers; i++){
      playersInSet.add(this.getPlayerByIndex(i));
      if(playersInSet.size() != i+1){
        throw new IllegalArgumentException("[ERROR] 중복된 이름을 입력할 수 없습니다.");
      }
    }
  }

  public int numberOfPlayers() {
    return this.numberOfPlayers;
  }

  public Player getPlayerByIndex(int index) {
    return this.players.get(index);
  }

}
