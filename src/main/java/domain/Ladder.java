package domain;

import static tools.PointStatus.ENABLE;
import static tools.PointStatus.LEFT;
import static tools.PointStatus.RIGHT;

import tools.NumberGenerator;
import tools.PointStatus;

public class Ladder {

  private Lines lines;
  private LadderDepth depth;
  private NumberGenerator numberGenerator;

  public Ladder(int depth, int numberOfPlayers, NumberGenerator numberGenerator) {
    this.depth = new LadderDepth(depth, numberOfPlayers);
    this.numberGenerator = numberGenerator;
    this.lines = new Lines(depth, numberOfPlayers, this.numberGenerator);
  }

  public PointStatus isPossibleMoveNow(Player player, int currentDepth, int numberOfPlayers) {
    if (player.getPosition().isMostLeftPosition() || player.getPosition()
        .isMostRightPosition(numberOfPlayers)) {
      return checkForSpecialCase(player, currentDepth);
    }
    if (this.lines.hasHorizon(currentDepth, player.getPositionValue() - 1)) {
      return LEFT;
    }
    if (this.lines.hasHorizon(currentDepth, player.getPositionValue())) {
      return RIGHT;
    }
    return ENABLE;
  }

  private PointStatus checkForSpecialCase(Player player, int currentDepth) {
    if (player.getPosition().isMostLeftPosition()) {
      if (this.lines.hasHorizon(currentDepth, player.getPositionValue())) {
        return RIGHT;
      }
      return ENABLE;
    }
    if (this.lines.hasHorizon(currentDepth, player.getPositionValue() - 1)) {
      return LEFT;
    }
    return ENABLE;
  }

  public Line getLine(int index) {
    return this.lines.getValues().get(index);
  }

  public int getDepth() {
    return this.depth.getValue();
  }
}
