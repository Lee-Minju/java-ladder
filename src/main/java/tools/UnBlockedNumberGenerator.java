package tools;

public class UnBlockedNumberGenerator implements NumberGenerator {

  private final int UNBLOCKED_NUMBER = 4;

  @Override
  public int generateNumber() {
    return UNBLOCKED_NUMBER;
  }
}
