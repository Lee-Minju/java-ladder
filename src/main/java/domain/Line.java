package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

  private final int RANDOM_STAND_NUMBER = 5;

  private Random random = new Random();
  private List<Boolean> points = new ArrayList<>();

  public Line(int numberOfPlayer) {
    this.points.add(makePoint());
    for (int i = 1; i < numberOfPlayer - 1; i++) {
      if (hasPreviousLineHorizon(i)) {
        this.points.add(i, false);
      }
      if (!hasPreviousLineHorizon(i)) {
        this.points.add(i, makePoint());
      }
    }
  }

  public Boolean hasLineHorizon(int index) {
    return this.getPoint(index);
  }

  public Boolean hasPreviousLineHorizon(int index) {
    return this.getPoint(index - 1);
  }

  public int length() {
    return this.points.size();
  }

  private boolean makePoint() {
    if (random.nextInt(10) < RANDOM_STAND_NUMBER) {
      return false;
    }
    return true;
  }

  public List<Boolean> getPoints() {
    return this.points;
  }

  public Boolean getPoint(int index) {
    return this.points.get(index);
  }

}
