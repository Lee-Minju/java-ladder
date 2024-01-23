package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private List<Line> lines = new ArrayList<>();
  private LadderDepth depth;

  public Ladder(LadderDepth depth, int numberOfPlayers) {
    this.depth = depth;
    makingLadder(depth, numberOfPlayers);
  }

  public void makingLadder(LadderDepth depth, int numberOfPlayers) {
    try {
      for (int i = 0; i < depth.getDepth(); i++) {
        this.lines.add(new Line(numberOfPlayers));
      }
      validateLadder(depth, numberOfPlayers);
    } catch (IllegalArgumentException e) {
      this.lines.clear();
      makingLadder(depth, numberOfPlayers);
    }
  }

  private void validateLadder(LadderDepth depth, int numberOfPlayers) {
    for (int i = 0; i < numberOfPlayers - 1; i++) {
      if (!isLadderSafe(i, depth.getDepth())) {
        throw new IllegalArgumentException("[ERROR] 사다리가 끊어져 있습니다.");
      }
    }
  }

  private Boolean isLadderSafe(int lineIndex, int depth) {
    for (int i = 0; i < depth; i++) {
      if (hasHorizon(lineIndex, i)) {
        return true;
      }
    }
    return false;
  }

  private Boolean hasHorizon(int lineIndex, int linesIndex) {
    return (this.getLine(linesIndex).getPoint(lineIndex));
  }

  public Line getLine(int index) {
    return this.lines.get(index);
  }

  public List<Boolean> getLineValue(int index) {
    return this.getLine(index).getPoints();
  }

  public int getDepthValue() {
    return this.depth.getDepth();
  }
}
