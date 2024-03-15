package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import tools.NumberGenerator;
import tools.RandomNumberGenerator;

public class Lines {

  private List<Line> values;

  public Lines(int depth, int numberOfPlayers, NumberGenerator ladderSetting) {
    List<Line> lines = makeLines(depth, numberOfPlayers, ladderSetting);
    this.values = lines;
  }

  private List<Line> makeLines(int depth, int numberOfPlayers, NumberGenerator ladderSetting) {
    List<Line> candidateLines = makeCandidateLines(depth, numberOfPlayers, ladderSetting);
    if (checkLinesForRow(candidateLines)) {
      return candidateLines;
    }
    NumberGenerator randomSetting = new RandomNumberGenerator();
    return makeLines(depth, numberOfPlayers, randomSetting);
  }

  private List<Line> makeCandidateLines(int depth, int numberOfPlayers,
      NumberGenerator ladderSetting) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < depth; i++) {
      lines.add(new Line(numberOfPlayers, ladderSetting));
    }
    return lines;
  }

  private boolean checkLinesForRow(List<Line> candidateLines) {
    int numberOfPoints = candidateLines.get(0).getLength();
    for (int i = 0; i < numberOfPoints; i++) {
      if (isRowEmpty(candidateLines, i)) {
        return false;
      }
    }
    return true;
  }

  private boolean isRowEmpty(List<Line> candidateLines, int lineIndex) {
    for (int i = 0; i < candidateLines.size(); i++) {
      if (candidateLines.get(i).getPoint(lineIndex)) {
        return false;
      }
    }
    return true;
  }

  public boolean hasHorizon(int linesDepth, int lineIndex) {
    return this.values.get(linesDepth).getPoint(lineIndex);
  }

  public List<Line> getValues() {
    return values.stream().map(Line::new).collect(Collectors.toUnmodifiableList());
  }
}
