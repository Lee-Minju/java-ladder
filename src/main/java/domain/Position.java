package domain;

public class Position {

  private final int MOST_LEFT_POSITION = 0;

  private int value;

  public Position(int value) {
    this.value = value;
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
