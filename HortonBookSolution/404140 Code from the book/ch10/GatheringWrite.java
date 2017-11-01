import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.nio.channels.*;
import java.nio.*;
import java.util.*;
import java.io.IOException;

public class GatheringWrite {
  public static void main(String[] args) {
    int primesRequired = 100;                                          // Default count
    if (args.length > 0) {
      try {
        primesRequired = Integer.valueOf(args[0]).intValue();
      } catch (NumberFormatException e) {
        System.out.println("Prime count value invalid. Using default of " + primesRequired);
      }
    }

      long[] primes = new long[primesRequired];                        // Array to store primes
      primes[0] = 2L;                                                  // Seed the first prime
      primes[1] = 3L;                                                  // and the second
      // Count of primes found – up to now, which is also the array index
      int count = 2;
      // Next integer to be tested
      long number = 5L;

      outer:
      for (; count < primesRequired; number += 2) {

        // The maximum divisor we need to try is square root of number
        long limit = (long)ceil(sqrt((double)number));

        // Divide by all the primes we have up to limit
        for (int i = 1; i < count && primes[i] <= limit; ++i)
          if (number % primes[i] == 0L)                                // Is it an exact divisor?
            continue outer;                                            // yes, try the next number

        primes[count++] = number;                                      // We got one!
      }

    Path file = Paths.get("D:/Junk/primes2.txt");                      // Different file!
    try {
      Files.createDirectories(file.getParent());                       // Make sure we have the directory
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (GatheringByteChannel channel = (FileChannel)(Files.newByteChannel(
                                             file, EnumSet.of(WRITE, CREATE)))){
      ByteBuffer[] buffers = new ByteBuffer[3];                        // Array of buffer references
      buffers[0] = ByteBuffer.allocate(8);                             // To hold a double value
      buffers[2] = ByteBuffer.allocate(8);                             // To hold a long value

      String primeStr = null;
      for (long prime : primes) {
        primeStr = "prime = " + prime;
        buffers[0].putDouble((double) primeStr.length()).flip();

        // Create the second buffer to accommodate the string
        buffers[1] = ByteBuffer.allocate(primeStr.length());
        buffers[1].put(primeStr.getBytes()).flip();

        buffers[2].putLong(prime).flip();
        channel.write(buffers);
        buffers[0].clear();
        buffers[2].clear();
      }
      System.out.println("File written is " + ((FileChannel)channel).size() + " bytes.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
