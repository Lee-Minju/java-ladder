package view;

import domain.Ladder;
import java.util.List;

public class OutputView {

  public static void showLadder(Ladder ladder) {
    for (int i = 0; i < ladder.getDepthValue(); i++) {
      List<Boolean> lineValue = ladder.getLineValue(i);
      String result = "|";
      for(int j=0; j < lineValue.size(); j++){
        if(lineValue.get(j)){
          result += "-----|";
        }
        if(!lineValue.get(j)){
          result += "     |";
        }
      }
      System.out.println(result);
    }
  }

}
