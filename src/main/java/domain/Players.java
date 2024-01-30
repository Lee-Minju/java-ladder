package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {

  private final int MIN_PLAYERS_NUMBER = 2;

  private List<Player> players;

  public Players(List<Player> players) {
    this.players = players;
    validatePlayers();
  }

  private void validatePlayers() {
    if (this.players.size() < MIN_PLAYERS_NUMBER) {
      throw new IllegalArgumentException("[ERROR] 플레이어 수는 두명 이상이어야 합니다.");
    }
    hasDuplicatedName();
  }

  private void hasDuplicatedName() {
    Set<Player> playersInSet = new HashSet<>();
    for(int i=0; i<this.players.size(); i++){
      playersInSet.add(this.getPlayerByIndex(i));
      if(playersInSet.size() != i+1){
        throw new IllegalArgumentException("[ERROR] 중복된 이름을 입력할 수 없습니다.");
      }
    }
  }

  public int getNumberOfPlayers() {
    return this.players.size();
  }

  public Player getPlayerByIndex(int index) {
    return this.players.get(index);
  }

}
