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
      throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
    }
  }

  public List<String> askGameResults() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    String input = scanner.nextLine();
    List<String> results = Arrays.asList(input.split(","));
    return results;
  }

  public String askPlayer() {
    System.out.println("결과를 보고 싶은 사람은? (종료를 원하면 end 를 입력해 주세요)");
    String input = scanner.nextLine();
    return input;
  }
}
