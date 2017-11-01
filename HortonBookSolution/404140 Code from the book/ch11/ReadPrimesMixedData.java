import java.nio.file.*;
import java.nio.channels.FileChannel;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ReadPrimesMixedData {
  public static void main(String[] args) {
    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("primes.txt");
    if(!Files.exists(file)) {
      System.out.println(file + " does not exist. Terminating program.");
      System.exit(1);;
    }

    try (FileChannel inCh = (FileChannel)Files.newByteChannel(file)){
      ByteBuffer lengthBuf = ByteBuffer.allocate(8);
      int strLength = 0;                                               // Stores the string length

      ByteBuffer[] buffers = {
                           null,                                       // Byte buffer to hold string
                           ByteBuffer.allocate(8)                      // Byte buffer to hold prime
                             };

      while(true) {
        if(inCh.read(lengthBuf) == -1)                                 // Read the string length,
          break;                                                       // if its EOF exit the loop

        lengthBuf.flip();

        // Extract the length and convert to int
        strLength = (int)lengthBuf.getDouble();

        // Now create the buffer for the string
        buffers[0] = ByteBuffer.allocate(2*strLength);

        if(inCh.read(buffers) == -1) {                                 // Read the string & binary prime value
          // Should not get here!
          System.err.println("EOF found reading the prime string.");
          break;                                                       // Exit loop on EOF
        }

        System.out.printf(
                "String length: %3s  String: %-12s  Binary Value: %3d%n",
                strLength,
                ((ByteBuffer)(buffers[0].flip())).asCharBuffer().toString(),
                ((ByteBuffer)buffers[1].flip()).getLong());

        // Clear the buffers for the next read
        lengthBuf.clear();
        buffers[1].clear();
      }
      System.out.println("\nEOF reached.");
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
