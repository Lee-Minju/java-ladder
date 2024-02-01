package tools;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

  private static final int NUMBER_BOUND = 10;

  private final Random random = new Random();

  @Override
  public int generateNumber() {
    return random.nextInt(NUMBER_BOUND);
  }
}
