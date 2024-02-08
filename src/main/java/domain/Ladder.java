package domain;

import java.util.ArrayList;
import java.util.List;
import tools.NumberGenerator;

public class Ladder {

  private Lines lines;
  private LadderDepth depth;
  private NumberGenerator numberGenerator;

  public Ladder(LadderDepth depth, int numberOfPlayers, NumberGenerator ladderSetting) {
    this.depth = depth;
    this.numberGenerator = ladderSetting;
    makeLadder(depth.getValue(), numberOfPlayers);
  }

  private void makeLadder(int depth, int numberOfPlayers) {
    try {
      Lines candidateLines = new Lines(depth, numberOfPlayers, this.numberGenerator);
      this.lines = candidateLines;
    } catch (IllegalArgumentException e) {
      makeLadder(depth, numberOfPlayers);
    }
  }

  public Line getLine(int index) {
    return this.lines.getValue().get(index);
  }

  public int getDepthValue() {
    return this.depth.getValue();
  }
}
