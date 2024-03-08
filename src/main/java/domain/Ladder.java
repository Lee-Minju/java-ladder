package domain;

import tools.NumberGenerator;

public class Ladder {

  private Lines lines;
  private LadderDepth depth;
  private NumberGenerator numberGenerator;

  public Ladder(int depth, int numberOfPlayers, NumberGenerator numberGenerator) {
    this.depth = new LadderDepth(depth, numberOfPlayers);
    this.numberGenerator = numberGenerator;
    this.lines = buildLadder(this.depth.getValue(), numberOfPlayers);
  }

  private Lines buildLadder(int depth, int numberOfPlayers) {
    try {
      Lines candidateLines = new Lines(depth, numberOfPlayers, this.numberGenerator);
      return candidateLines;
    } catch (IllegalArgumentException e) {
      return buildLadder(depth, numberOfPlayers);
    }
  }

  public Line getLine(int index) {
    return this.lines.getValues().get(index);
  }

  public int getDepth() {
    return this.depth.getValue();
  }
}
