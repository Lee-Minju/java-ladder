package domain;

import java.util.Objects;

public class Player {

  private Name name;
  private Position position;

  public Player(String name, int position) {
    this.name = new Name(name);
    this.position = new Position(position);
  }

  public String getPlayerNameValue() {
    return this.name.getNameValue();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Player)) {
      return false;
    }
    Player p = (Player) obj;
    return (this.getPlayerNameValue().equals(p.getPlayerNameValue()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getPlayerNameValue());
  }
}
