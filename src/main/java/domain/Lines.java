package domain;

import java.util.ArrayList;
import java.util.List;
import tools.NumberGenerator;

public class Lines {

  private List<Line> value;

  public Lines(int depth, int numberOfPlayers, NumberGenerator ladderSetting) {
    List<Line> candidateLines = makeLines(depth, numberOfPlayers, ladderSetting);
    validateLines(candidateLines);
    this.value = candidateLines;
  }

  private List<Line> makeLines(int depth, int numberOfPlayers, NumberGenerator ladderSetting) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < depth; i++) {
      lines.add(new Line(numberOfPlayers, ladderSetting));
    }
    return lines;
  }

  private void validateLines(List<Line> candidateLines) {
    int numberOfLine = candidateLines.get(0).getLength();
    for (int i = 0; i < numberOfLine; i++) {
      if (isRowEmpty(candidateLines, i)) {
        throw new IllegalArgumentException("[ERROR] 사다리가 끊어져 있습니다.");
      }
    }
  }

  private boolean isRowEmpty(List<Line> candidateLines, int lineIndex) {
    for (int i = 0; i < candidateLines.size(); i++) {
      if (hasHorizon(candidateLines, lineIndex, i)) {
        return false;
      }
    }
    return true;
  }

  private boolean hasHorizon(List<Line> candidateLines, int lineIndex, int linesIndex) {
    return (candidateLines.get(linesIndex).getPoint(lineIndex));
  }

  public List<Line> getValue() {
    return value;
  }
}
