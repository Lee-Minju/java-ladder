package domain;

import java.util.Objects;

public class Player {

  private Name playerName;
  private Position position;

  public Player(Name playerName, Position position) {
    this.playerName = playerName;
    this.position = position;
  }

  public int getPositionValue() {
    return this.position.getValue();
  }

  public Position getPosition() {
    return this.position;
  }

  public String getPlayerNameString() {
    return this.playerName.getNameValue();
  }

  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof Player)){
      return false;
    }
    Player p = (Player) obj;
    return (this.getPlayerNameString().equals(p.getPlayerNameString()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getPlayerNameString());
  }
}
