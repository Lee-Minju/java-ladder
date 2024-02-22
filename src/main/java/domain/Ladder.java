package domain;

import tools.NumberGenerator;

public class Ladder {

  private Lines lines;
  private LadderDepth depth;
  private NumberGenerator numberGenerator;

  public Ladder(LadderDepth depth, int numberOfPlayers, NumberGenerator numberGenerator) {
    this.depth = depth;
    this.numberGenerator = numberGenerator;
    this.lines = validateLadder(depth.getValue(), numberOfPlayers);
  }

  private Lines validateLadder(int depth, int numberOfPlayers) {
    try {
      Lines candidateLines = new Lines(depth, numberOfPlayers, this.numberGenerator);
      return candidateLines;
    } catch (IllegalArgumentException e) {
      return validateLadder(depth, numberOfPlayers);
    }
  }

  public Line getLine(int index) {
    return this.lines.getValue().get(index);
  }

  public int getDepth() {
    return this.depth.getValue();
  }
}
