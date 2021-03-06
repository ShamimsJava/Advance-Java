import java.io.Serializable;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Person implements Comparable<Person>, Serializable {
  // Constructor
  public Person(String firstName, String surname) {
    this.firstName = firstName;
    this.surname = surname;
  }

  @Override
  public String toString() {
    return firstName + " " + surname;
  }

  public String getSecondName() {
    return surname;
  }

  // Compare Person objects
  public int compareTo(Person person) {
    int result = surname.compareTo(person.surname);
    return result == 0 ? firstName.compareTo(person.firstName):result;
  }


  @Override
  public boolean equals(Object person) {
    return compareTo((Person)person) == 0;
  }


  @Override
  public int hashCode() {
    return 7*firstName.hashCode() + 13*surname.hashCode();
  }

  // Read a person from the keyboard
  public static Person readPerson() {
    String firstName = null;
    String surname = null;
    try {
      System.out.print("Enter first name: ");
      firstName = keyboard.readLine().trim();
      System.out.print("Enter surname: ");
      surname = keyboard.readLine().trim();
    } catch(IOException e) {
      System.err.println("Error reading a name.");
      e.printStackTrace();
      System.exit(1);
    }
    return new Person(firstName,surname);
  }

  private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

  private String firstName;                                                                        // First name of person
  private String surname;                                                                          // Second name of person
  private static final long serialVersionUID = 1002L;
}
