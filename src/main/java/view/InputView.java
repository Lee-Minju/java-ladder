package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private final Scanner scanner = new Scanner(System.in);

  public List<String> askName() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    String input = scanner.nextLine();
    List<String> namesInString = Arrays.asList(input.split(","));
    return namesInString;
  }

  public int askLadderDepth() {
    try {
      System.out.println("최대 사다리 높이는 몇 개인가요?");
      String input = scanner.nextLine();
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자를 입력해 주세요.");
    }
  }
}
