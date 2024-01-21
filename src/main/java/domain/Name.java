package domain;

public class Name {

  private final int MAX_NAME_LENGTH = 5;

  private final String name;

  public Name(String name) {
    validateName(name);
    this.name = name;
  }

  public void validateName(String name){
    if(name.length() > MAX_NAME_LENGTH){
      throw new IllegalArgumentException();
    }
    if(name.isBlank()){
      throw new IllegalArgumentException();
    }
  }
}
