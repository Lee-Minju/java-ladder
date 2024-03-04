package domain;

import java.util.ArrayList;
import java.util.List;
import tools.NumberGenerator;

public class Lines {

  private List<Line> values;

  public Lines(int depth, int numberOfPlayers, NumberGenerator ladderSetting) {
    List<Line> candidateLines = makeLines(depth, numberOfPlayers, ladderSetting);
    validateLines(candidateLines);
    this.values = candidateLines;
  }

  private List<Line> makeLines(int depth, int numberOfPlayers, NumberGenerator ladderSetting) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < depth; i++) {
      lines.add(new Line(numberOfPlayers, ladderSetting));
    }
    return lines;
  }

  private void validateLines(List<Line> candidateLines) {
    int numberOfPoints = candidateLines.get(0).getLength();
    for (int i = 0; i < numberOfPoints; i++) {
      if (isRowEmpty(candidateLines, i)) {
        throw new IllegalArgumentException("[ERROR] 사다리가 끊어져 있습니다.");
      }
    }
  }

  private boolean isRowEmpty(List<Line> candidateLines, int lineIndex) {
    for (int i = 0; i < candidateLines.size(); i++) {
      if (hasHorizon(candidateLines.get(i), lineIndex)) {
        return false;
      }
    }
    return true;
  }

  private boolean hasHorizon(Line candidateLine, int lineIndex) {
    return (candidateLine.getPoint(lineIndex));
  }

  public List<Line> getValues() {
    return values;
  }
}
