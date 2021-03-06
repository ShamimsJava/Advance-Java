public class Dog extends Animal {
  public Dog(String aName) {
    super("Dog");                                                      // Call the base constructor
    name = aName;                                                      // Supplied name
    breed = "Unknown";                                                 // Default breed value
  }

  public Dog(String aName, String aBreed) {
    super("Dog");                                                      // Call the base constructor
    name = aName;                                                      // Supplied name
    breed = aBreed;                                                    // Supplied breed
  }

  // Present a dog's details as a string
  @Override public String toString() {
  return super.toString() + "\nIt's " + name + " the " + breed;
  }

  protected String name;                                               // Name of a Dog
  protected String breed;                                              // Dog breed
}
