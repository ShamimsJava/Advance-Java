public class Animal {
  public Animal(String aType) {
    type = aType;
  }
  
  // Copy constructor
  public Animal(Animal animal) {
    type = animal.type;
  }

  @Override public String toString() {
    return "This is a " + type;
  }


   // Dummy method to be implemented in the derived classes
   public void sound(){}

  private String type;
}
