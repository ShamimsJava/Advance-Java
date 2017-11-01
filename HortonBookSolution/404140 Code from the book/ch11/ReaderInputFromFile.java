import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;

public class ReaderInputFromFile {
  public static void main(String[] args) {
    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("Sayings.txt");
    if(!Files.exists(file)) {
      System.out.println(file + " does not exist. Terminating program.");
      System.exit(1);;
    }

    try(BufferedReader fileIn =
                  new BufferedReader(Files.newBufferedReader(file, Charset.forName("UTF-16")))){
      String saying = null;                                            // Stores a saying
      int totalRead = 0;                                               // Acumulates number of sayings
      // Read sayings until we reach reach EOF
      while((saying = fileIn.readLine()) != null) {
        System.out.println(saying);
        ++totalRead;                                                   // Increment count
      }
    System.out.format("%d  sayings read.%n", totalRead);
    } catch(IOException e) {
      System.err.println("Error writing file: " + file);
      e.printStackTrace();
    }
  }
}
