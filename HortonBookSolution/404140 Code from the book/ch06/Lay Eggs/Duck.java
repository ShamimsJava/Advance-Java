public class Duck extends Animal {
  public Duck(String aName) {
    super("Duck");                                                     // Call the base constructor
    name = aName;                                                      // Supplied name
    breed = "Unknown";                                                 // Default breed value
  }

  public Duck(String aName, String aBreed) {
    super("Duck");                                                     // Call the base constructor
    name = aName;                                                      // Supplied name
    breed = aBreed;                                                    // Supplied breed
  }

  public void layEgg() {
    System.out.println("Egg laid");
  }

  // Return a String full of a duck's details
  @Override public String toString() {
    return super.toString() + "\nIt's " + name + " the " + breed;
  }

  // A quacking method
  @Override public void sound() {
    System.out.println("Quack quackquack");
  }

  protected String name;                                               // Duck name
  protected String breed;                                              // Duck breed
}
