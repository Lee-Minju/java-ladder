package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

  private final int RANDOM_STAND_NUMBER = 5;

  private List<Boolean> points = new ArrayList<>();
  private NumberGenerator numberGenerator = new NumberGenerator();

  public Line(int numberOfPlayer) {
    makeLine(numberOfPlayer);
  }

  private void makeLine(int numberOfPlayers) {
    try {
      List<Boolean> candidatePoints = makePoints(numberOfPlayers);
      validateLine(candidatePoints, numberOfPlayers);
      this.points.addAll(candidatePoints);
    } catch (IllegalArgumentException e) {
      makeLine(numberOfPlayers);
    }
  }

  private List<Boolean> makePoints(int numberOfPlayers) {
    List<Boolean> points = new ArrayList<>();
    for (int i = 0; i < numberOfPlayers - 1; i++) {
      int number = numberGenerator.generateRandomNumber();
      points.add(makePoint(number));
    }
    return points;
  }

  public void validateLine(List<Boolean> candidatePoints, int numberOfPlayers) {
    for (int i = 0; i < numberOfPlayers - 2; i++) {
      if (candidatePoints.get(i).equals(true) && candidatePoints.get(i + 1).equals(true)) {
        throw new IllegalArgumentException("[ERROR] 가로줄 겹침");
      }
    }
  }

  private Boolean makePoint(int number) {
    if (number < RANDOM_STAND_NUMBER) {
      return false;
    }
    return true;
  }

  public int getLength() {
    return this.points.size();
  }

  public Boolean getPoint(int index) {
    return this.points.get(index);
  }
}
