package domain;

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

  public Position getPosition() {
    return this.position;
  }

  public int getPositionValue() {
    return this.position.getValue();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Player)) {
      return false;
    }

    Player player = (Player) o;

    return name.equals(player.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
