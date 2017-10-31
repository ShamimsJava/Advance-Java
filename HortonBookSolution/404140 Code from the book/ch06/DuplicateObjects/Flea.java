public class Flea extends Animal {
  // Constructor
  public Flea(String aName, String aSpecies) {
    super("Flea");                                                     // Pass the type to the base
    name = aName;                                                      // Supplied name
    species = aSpecies;                                                // Supplied species
  }

  // Copy Constructor
  public Flea(Flea flea) {
    super(flea);                                                       // Call the base class copy constructor
    name = flea.name;
    species = flea.species;
  }

  // Change the flea's name
  public void setName(String aName) {
    name = aName;                                                      // Change to the new name
  }

  // Return the flea's name
  public String getName() {
    return name;
  }

  // Return the species
  public String getSpecies() {
    return species;
  }

  @Override public void sound() {
    System.out.println("Psst");
  }

  // Present a flea's details as a String
  @Override public String toString() {
    return super.toString() + "\nIt's " + name + " the " + species;
  }

  protected String name;                                               // Name of flea!
  protected String species;                                            // Flea species
}
