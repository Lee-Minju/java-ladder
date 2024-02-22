package domain;

import java.util.ArrayList;
import java.util.List;
import tools.NumberGenerator;

public class Line {

  private List<Point> points;

  public Line(int numberOfPlayer, NumberGenerator numberGenerator) {
    makeLine(numberOfPlayer, numberGenerator);
  }

  private void makeLine(int numberOfPlayers, NumberGenerator numberGenerator) {
    List<Point> candidatePoints = makePoints(numberOfPlayers, numberGenerator);
    validateLine(candidatePoints, numberOfPlayers);
    this.points = new ArrayList<>(candidatePoints);
  }

  private List<Point> makePoints(int numberOfPlayers, NumberGenerator numberGenerator) {
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < numberOfPlayers - 1; i++) {
      int number = numberGenerator.generateNumber();
      points.add(new Point(number));
    }
    return points;
  }

  private void validateLine(List<Point> candidatePoints, int numberOfPlayers) {
    for (int i = 0; i < numberOfPlayers - 2; i++) {
      if (candidatePoints.get(i).getValue().equals(true) && candidatePoints.get(i + 1).getValue()
          .equals(true)) {
        candidatePoints.get(i + 1).setValue(false);
      }
    }
  }

  public int getLength() {
    return this.points.size();
  }

  public Boolean getPoint(int index) {
    return this.points.get(index).getValue();
  }
}
