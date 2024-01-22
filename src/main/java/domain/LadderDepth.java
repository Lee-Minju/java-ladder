package domain;

public class LadderDepth {

  private final int depth;

  public LadderDepth(int depth, int numberOfPlayers) {
    validateDepth(depth, numberOfPlayers);
    this.depth = depth;
  }

  private void validateDepth(int depth, int numberOfPlayers) {
    if (depth < numberOfPlayers - 1){
      throw new IllegalArgumentException();
    }
  }

  public int getDepth() {
    return this.depth;
  }

}
