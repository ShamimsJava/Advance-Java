import java.util.Vector;

public class TrySimpleVector {
  public static void main(String[] args) {
    Vector<String> names = new Vector<>();
    String[] firstnames = { "Jack", "Jill", "John", "Joan", "Jeremiah", "Josephine"};

    // Add the names to the vector
    for(String firstname : firstnames) {
      names.add(firstname);
    }

    // List the contents of the vector
    for(String name : names) {
      System.out.println(name);
    }
  }
}
