package domain;

public class LadderDepth {

  private final int depth;

  public LadderDepth(int depth, int numberOfPlayers) {
    validateDepth(depth, numberOfPlayers);
    this.depth = depth;
  }

  private void validateDepth(int depth, int numberOfPlayers) {
    if (depth < numberOfPlayers - 1) {
      throw new IllegalArgumentException("[ERROR] 사다리의 높이는 (플레이어 수 - 1) 값 이상이어야 합니다.");
    }
  }

  public int getDepth() {
    return this.depth;
  }

}
