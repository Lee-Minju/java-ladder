package domain;

import java.util.ArrayList;
import java.util.List;
import tools.NumberGenerator;
import tools.RandomNumberGenerator;

public class Line {

  private final int RANDOM_STAND_NUMBER = 5;

  private List<Boolean> points = new ArrayList<>();

  public Line(int numberOfPlayer, NumberGenerator numberGenerator) {
    makeLine(numberOfPlayer, numberGenerator);
  }

  private void makeLine(int numberOfPlayers, NumberGenerator numberGenerator) {
    try {
      List<Boolean> candidatePoints = makePoints(numberOfPlayers, numberGenerator);
      validateLine(candidatePoints, numberOfPlayers);
      this.points.addAll(candidatePoints);
    } catch (IllegalArgumentException e) {
      makeLine(numberOfPlayers, numberGenerator);
    }
  }

  public List<Boolean> makePoints(int numberOfPlayers, NumberGenerator numberGenerator) {
    List<Boolean> points = new ArrayList<>();
    for (int i = 0; i < numberOfPlayers - 1; i++) {
      int number = numberGenerator.generateNumber();
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
