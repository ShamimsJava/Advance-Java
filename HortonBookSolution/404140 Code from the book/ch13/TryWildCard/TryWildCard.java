public class TryWildCard {
  public static void main(String[] args) {
    int[] numbers = new int[30];
    for(int i = 0 ; i < numbers.length ; ++i) {
      numbers[i] = (int)(1000.0*Math.random());                        // Random integers 0 to 999
    }
    // List starting integer values
    int count = 0;
    System.out.println("Original values are:");
    for(int number : numbers) {
      System.out.printf("%6d", number);
      if(++count%6 == 0) {
        System.out.println();
      }
    }

    // Create the tree and add the integers to it
    BinaryTree<Integer> tree = new BinaryTree<>();
    for(int number:numbers) {
      tree.add(number);
    }

    // Get sorted values
    LinkedList<Integer> values = tree.sort();
    System.out.println("\nSorted values are:");
    listAll(values);

    // Create an array of words to be sorted
    String[] words = {"vacillate", "procrastinate", "arboreal",
                      "syzygy", "xenocracy", "zygote",
                      "mephitic", "soporific", "grisly", "gristly" };

    // List the words
    System.out.println("\nOriginal word sequence:");
    for(String word : words) {
      System.out.printf("%-15s", word);
      if(++count%5 == 0) {
        System.out.println();
      }
    }

    // Create the tree and insert the words
    BinaryTree<String> cache = new BinaryTree<>();
    for(String word : words) {
      cache.add(word);
    }

    // Sort the words
    LinkedList<String> sortedWords = cache.sort();

    // List the sorted words
    System.out.println("\nSorted word sequence:");
    listAll(sortedWords);
  }

  // List the elements in any linked list
  public static void listAll(LinkedList<?> list) {
    for(Object obj : list) {
      System.out.println(obj);
    }
  }
}