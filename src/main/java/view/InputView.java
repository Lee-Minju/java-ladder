package view;
import domain.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import domain.Name;

public class InputView {

  private final int MIN_PLAYERS_NUM = 2;

  private final Scanner scanner = new Scanner(System.in);

  public List<Name> askName() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    String input = scanner.next();
    List<String> namesInString = Arrays.asList(input.split(","));
    if(namesInString.size() < MIN_PLAYERS_NUM){
      throw new IllegalArgumentException();
    }
    List<Name> names = new ArrayList<>();
    for(int i=0; i<namesInString.size(); i++){
      Name name = new Name(namesInString.get(i));
    }
    return names;
  }
}
