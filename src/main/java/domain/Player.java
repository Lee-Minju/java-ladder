package domain;

import java.util.Objects;

public class Player {

  private Name name;
  private Position position;

  public Player(String name, int position) {
    this.name = new Name(name);
    this.position = new Position(position);
  }

  public String getName() {
    return this.name.getValue();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Player)) {
      return false;
    }
    Player p = (Player) obj;
    return (this.getName().equals(p.getName()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getName());
  }
}
