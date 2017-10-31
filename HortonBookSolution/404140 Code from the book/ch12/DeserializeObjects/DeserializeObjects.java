import java.io.*;
import java.nio.file.*;

class DeserializeObjects {
  public static void main(String args[]) {
    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("JunkObjects.bin");
    if(Files.notExists(file)) {
      System.out.printf("\nFile %s does not exist.", file);
      System.exit(1);
    }

    int objectCount = 0;                                               // Number of objects read
    try (ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(file)))){
       // Read from the stream until we hit the end
       Junk object = null;                                             // Stores an object reference
       while(true) {
        object = (Junk)objectIn.readObject();                          // Read an object
        ++objectCount;                                                 // Increment the count
        System.out.println(object);                                    // Output the object
      }

    } catch(EOFException e) {                                          // This will execute when we reach EOF
      System.out.println("EOF reached. "+ objectCount + " objects read.");

    } catch(IOException|ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
