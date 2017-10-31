public class PetDog extends Dog {
  // Constructor
  public PetDog(String name, String breed, String fleaName, String fleaSpecies) {
    super(name, breed);
    petFlea = new Flea("Max","circus flea");                           // Initialize petFlea
  }

  // Copy constructor
  public PetDog(PetDog pet) {
    super(pet);                                                        // Call base copy constructor
    petFlea = new Flea(pet.petFlea);                                   // Duplicate the flea
  }

  // Return the flea
  public Flea getFlea() {
    return petFlea;
  }

  public void sound() {
    System.out.println("Woof");
  }

  // Return a String for the pet dog
  @Override public String toString() {
    return super.toString() + " - a pet dog.\nIt has a flea:\n" + petFlea;
  }

  protected Flea petFlea;                                              // The pet flea
}
