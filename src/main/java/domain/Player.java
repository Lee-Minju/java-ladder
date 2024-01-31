package domain;

import java.util.Objects;

public class Player {

  private Name playerName;
  private Position position;

  public Player(String name, int position) {
    this.playerName = new Name(name);
    this.position = new Position(position);
  }

  public int getPositionValue() {
    return this.position.getValue();
  }

  public String getPlayerNameValue() {
    return this.playerName.getNameValue();
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
