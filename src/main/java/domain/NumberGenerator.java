package domain;

import java.util.Random;

public class NumberGenerator {

  private final int NUMBER_BOUND = 10;
  private final int BLOCKED_NUMBER = 9;
  private final int NON_BLOCKED_NUMBER =  4;


  private Random random = new Random();

  public int generateRandomNumber() {
    return random.nextInt(NUMBER_BOUND);
  }

  public int generateBlockedNumber() {
    return BLOCKED_NUMBER;
  }

  public int generateNonBlockedNumber() {
    return NON_BLOCKED_NUMBER;
  }

}
