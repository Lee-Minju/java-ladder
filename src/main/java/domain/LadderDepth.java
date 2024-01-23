package domain;

public class LadderDepth {

  private final int depth;

  public LadderDepth(int depth, int numberOfPlayers) {
    validateDepth(depth, numberOfPlayers);
    this.depth = depth;
  }

  private void validateDepth(int depth, int numberOfPlayers) {
    int depthMinimum = numberOfPlayers - 1;
    if (depth < depthMinimum) {
      throw new IllegalArgumentException("[ERROR] 사다리의 높이는 %d 이상이 되어야 합니다.\n");
    }
  }

  public int getDepth() {
    return this.depth;
  }
}
