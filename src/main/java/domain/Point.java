package domain;

public class Point {

  private static final int RANDOM_STAND_NUMBER = 5;

  private boolean value;

  public Point(int number) {
    this.value = makePoint(number);
  }

  private boolean makePoint(int number) {
    if (number < RANDOM_STAND_NUMBER) {
      return false;
    }
    return true;
  }

  public Boolean getValue() {
    return this.value;
  }

  public void setValue(boolean value) {
    this.value = value;
  }
}
