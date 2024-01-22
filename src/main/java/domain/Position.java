package domain;

public class Position {

  private final int MOST_LEFT_POSITION = 0;

  private int position;

  public Position(int position) {
    this.position = position;
  }

  public void moveLeft() {
    if (this.position == MOST_LEFT_POSITION) {
      throw new IllegalArgumentException("위치값은 음수가 될 수 없습니다.");
    }
    this.position--;
  }

  public void moveRight() {
    this.position++;
  }

  public int getPosition() {
    return this.position;
  }
}
