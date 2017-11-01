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

  // Copy constructor
  public Dog(Dog dog) {
    super(dog);                                                        // Call base copy constructor
    name = dog.name;
    breed = dog.breed;
  }

  // Rename the dog
  public void setName(String name) {
    this.name = name;
  }

  // Return the dog's name
  public String getName() {
    return name;
  }

  // Return the breed
  public String getBreed() {
    return breed;
  }

  // Present a dog's details as a string
  @Override public String toString() {
  return super.toString() + "\nIt's " + name + " the " + breed;
  }

  // A barking method
  @Override public void sound() {
    System.out.println("Woof    Woof");
  }

  protected String name;                                               // Name of a Dog
  protected String breed;                                              // Dog breed
}
