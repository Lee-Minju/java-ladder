import domain.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTest {
  @Test
  void 이름을_생성(){
    String name = "pobi";

    Assertions.assertDoesNotThrow(() -> {
      Name playerName = new Name(name);
    });
  }

  @Test
  void 이름이_5자를_넘으면_예외발생() {
    String name = "leeminju";

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Name playerName = new Name(name);
    });
  }

  @Test
  void 이름이_공백으로만_구성되면_예외발생() {
    String name = " ";

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Name playerName = new Name(name);
    });
  }

}
