package domain;

import tools.NumberGenerator;

public class Ladder {

  private Lines lines;
  private LadderDepth depth;
  private NumberGenerator numberGenerator;

  public Ladder(int depth, int numberOfPlayers, NumberGenerator numberGenerator) {
    this.depth = new LadderDepth(depth, numberOfPlayers);
    this.numberGenerator = numberGenerator;
    this.lines = new Lines(depth, numberOfPlayers, this.numberGenerator);
  }

  public Line getLine(int index) {
    return this.lines.getValues().get(index);
  }

  public int getDepth() {
    return this.depth.getValue();
  }
}
