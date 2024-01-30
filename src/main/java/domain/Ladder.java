package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private List<Line> lines = new ArrayList<>();
  private LadderDepth depth;

  public Ladder(LadderDepth depth, int numberOfPlayers) {
    this.depth = depth;
    makeLadder(depth, numberOfPlayers);
  }

  private void makeLadder(LadderDepth depth, int numberOfPlayers) {
    try {
      List<Line> candidateLines = makeLines(depth, numberOfPlayers);
      validateLadder(candidateLines, numberOfPlayers);
      this.lines.addAll(candidateLines);
    } catch (IllegalArgumentException e) {
      makeLadder(depth, numberOfPlayers);
    }
  }

  public List<Line> makeLines(LadderDepth depth, int numberOfPlayers) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < depth.getDepth(); i++) {
      lines.add(new Line(numberOfPlayers));
    }
    return lines;
  }

  private void validateLadder(List<Line> candidateLines, int numberOfPlayers) {
    for (int i = 0; i < numberOfPlayers - 1; i++) {
      if (!isLadderSafe(candidateLines, i)) {
        throw new IllegalArgumentException("[ERROR] 사다리가 끊어져 있습니다.");
      }
    }
  }

  private Boolean isLadderSafe(List<Line> candidateLines, int lineIndex) {
    for (int i = 0; i < candidateLines.size(); i++) {
      if (hasHorizon(candidateLines, lineIndex, i)) {
        return true;
      }
    }
    return false;
  }

  private Boolean hasHorizon(List<Line> candidateLines, int lineIndex, int linesIndex) {
    return (candidateLines.get(linesIndex).getPoint(lineIndex));
  }

  public Line getLine(int index) {
    return this.lines.get(index);
  }

  public int getDepthValue() {
    return this.depth.getDepth();
  }
}
