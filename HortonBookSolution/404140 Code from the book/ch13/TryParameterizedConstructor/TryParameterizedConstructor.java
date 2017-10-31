public class TryParameterizedConstructor {
  public static void main(String[] args) {
    Manager[] managers = {new Manager("Jane",1), new Manager("Joe",3),
                          new Manager("Freda",3), new Manager("Bert", 2),
                          new Manager("Ann", 2),new Manager("Dave", 2)};

    // Create the tree with an array of managers
    BinaryTree<Person> people = new BinaryTree<>(managers);

    // Create and add some Person objects
    Person[] persons = {new Person("Will"), new Person("Ann"), new Person("Mary"),
                        new Person("Tina"), new Person("Stan")};
    for(Person person : persons) {
      people.add(person);
    }
    listAll(people.sort());
  }

  // List the elements in any linked list
  public static <T> void listAll(LinkedList<T> list) {
    for(T obj : list) {
      System.out.println(obj);
    }
  }
}
