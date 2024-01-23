package domain;

public class Player {

  private Name playerName;
  private Position position;

  public Player(Name playerName, Position position) {
    this.playerName = playerName;
    this.position = position;
  }

  public String getPlayerNameString() {
    return this.playerName.getNameValue();
  }
}
