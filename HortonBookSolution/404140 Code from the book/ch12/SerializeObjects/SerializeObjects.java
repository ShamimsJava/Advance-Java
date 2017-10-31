import java.io.*;
import java.nio.file.*;
import java.io.IOException;

public class SerializeObjects {
  public static void main(String[] args) {
    Junk obj1 = new Junk("A green twig is easily bent.");
    Junk obj2 = new Junk("A little knowledge is a dangerous thing.");
    Junk obj3 = new Junk("Flies light on lean horses.");

    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("JunkObjects.bin");
    try {
      Files.createDirectories(file.getParent());    // Make sure we have the directory
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    try (ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))){
      // Write three objects to the file
      objectOut.writeObject(obj1);                                     // Write object
      objectOut.writeObject(obj2);                                     // Write object
      objectOut.writeObject(obj3);                                     // Write object
      System.out.println("\n\nobj1:\n" + obj1
                        +"\n\nobj2:\n" + obj2
                        +"\n\nobj3:\n" + obj3);

    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
