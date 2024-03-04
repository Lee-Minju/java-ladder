package domain;

import java.util.List;

public class GameResults {

  private List<String> value;

  public GameResults(List<String> value, int numberOfPlayers) {
    validateGameResults(value, numberOfPlayers);
    this.value = value;
  }

  private void validateGameResults(List<String> value, int numberOfPlayers) {
    if (value.size() != numberOfPlayers) {
      throw new IllegalArgumentException("[ERROR] 결과의 갯수는 %d가 되어야 합니다.\n");
    }
  }

  public String getResult(int index) {
    return this.value.get(index);
  }

  public int getSize() {
    return this.value.size();
  }
}
