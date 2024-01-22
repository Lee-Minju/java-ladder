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

  public void validateLadder(LadderDepth depth, int numberOfPlayers) {
    for (int i = 0; i < numberOfPlayers - 1; i++) {
      Boolean check = false;
      for (int j = 0; j < depth.getDepth(); j++) {
        if (this.getLine(j).getPoint(i).equals(true)) {
          check = true;
          break;
        }
      }
      if (!check) {
        throw new IllegalArgumentException("사다리가 끊어져 있습니다.");
      }
    }
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
