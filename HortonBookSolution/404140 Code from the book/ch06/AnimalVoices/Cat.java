public class Cat extends Animal {
  public Cat(String aName) {
    super("Cat");                                                      // Call the base constructor
    name = aName;                                                      // Supplied name
    breed = "Unknown";                                                 // Default breed value
  }

  public Cat(String aName, String aBreed) {
    super("Cat");                                                      // Call the base constructor
    name = aName;                                                      // Supplied name
    breed = aBreed;                                                    // Supplied breed
  }

  // Return a String full of a cat's details
  @Override public String toString() {
    return super.toString() + "\nIt's " + name + " the " + breed;
  }

  // A miaowing method
  @Override public void sound() {
    System.out.println("Miiaooww");
  }

  protected String name;                                               // Name of a cat
  protected String breed;                                              // Cat breed
}
