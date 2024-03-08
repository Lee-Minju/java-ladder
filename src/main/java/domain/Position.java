package domain;

public class Position {

  private static final int MOST_LEFT_POSITION = 0;

  private int value;

  public Position(int value) {
    this.value = value;
  }

  public boolean isMostLeftPosition() {
    return this.value == MOST_LEFT_POSITION;
  }

  public boolean isMostRightPosition(int numberOfPlayers) {
    return this.value == numberOfPlayers - 1;
  }

  public void moveLeft() {
    if (this.value == MOST_LEFT_POSITION) {
      throw new IllegalArgumentException("[ERROR] 위치값은 음수가 될 수 없습니다.");
    }
    this.value--;
  }

  public void moveRight() {
    this.value++;
  }

  public int getValue() {
    return this.value;
  }
}
