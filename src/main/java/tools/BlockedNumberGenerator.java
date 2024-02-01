package tools;

public class BlockedNumberGenerator implements NumberGenerator {

  private final int BLOCKED_NUMBER = 9;

  @Override
  public int generateNumber() {
    return BLOCKED_NUMBER;
  }
}
