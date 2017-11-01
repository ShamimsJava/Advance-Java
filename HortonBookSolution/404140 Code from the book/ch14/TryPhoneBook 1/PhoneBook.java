import java.io.Serializable;
import java.util.HashMap;

class PhoneBook implements Serializable {
  public void addEntry(BookEntry entry) {
    phonebook.put(entry.getPerson(), entry);
  }

  public BookEntry getEntry(Person key) {
    return phonebook.get(key);
  }

  public PhoneNumber getNumber(Person key) {
    BookEntry entry = getEntry(key);
    if(entry != null) {
    return entry.getNumber();
    } else {
      return null;
    }
  }

  private HashMap<Person,BookEntry> phonebook = new HashMap<>();
  private static final long serialVersionUID = 1001L;
}
