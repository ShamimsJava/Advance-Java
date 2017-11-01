import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.nio.channels.SeekableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.EnumSet;

public class RandomReadWrite {
  public static void main(String[] args)
  {
    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("primes_backup.bin");
    if(!Files.exists(file)) {
      System.out.println(file + " does not exist. Terminating program.");
      System.exit(1);
    }

    final int PRIMESREQUIRED = 10;
    ByteBuffer buf = ByteBuffer.allocate(8);

    long[] primes = new long[PRIMESREQUIRED];
    int index = 0;                                                     // Position for a prime in the file
    final long REPLACEMENT = 99999L;                                   // Replacement for a selected prime

    try (SeekableByteChannel channel = Files.newByteChannel(file, EnumSet.of(READ, WRITE))){
      final int PRIMECOUNT = (int)channel.size()/8;
      System.out.println("Prime count = "+PRIMECOUNT);
      for(int i = 0 ; i < PRIMESREQUIRED ; ++i) {
        index = 8*(int)(PRIMECOUNT*Math.random());
        channel.position(index).read(buf);                             // Read at a random position
        buf.flip();                                                    // Flip the buffer
        primes[i] = buf.getLong();                                     // Extract the prime
        buf.flip();                                                    // Flip to ready for insertion
        buf.putLong(REPLACEMENT);                                      // Replacement into buffer
        buf.flip();                                                    // Flip ready to write
        channel.position(index).write(buf);                            // Write the replacement to file
        buf.clear();                                                   // Reset ready for next read
      }

      // Alternate loop code to avoid selecting REPLACEMENT values
/*      for(int i = 0 ; i < PRIMESREQUIRED ; ++i)
      {
        while(true)
        {
          index = 8*(int)(PRIMECOUNT*Math.random());
            channel.position(index).read(buf);   // Read at a random position
          buf.flip();                            // Flip the buffer
          primes[i] = buf.getLong();             // Extract the prime
          if(primes[i] != REPLACEMENT) {
            break;                               // It's good so exit the inner loop
          } else {
            buf.clear();                         // Clear ready to read another
          }
        }
        buf.flip();                              // Flip to ready for insertion
        buf.putLong(REPLACEMENT);                // Replacement into buffer
        buf.flip();                              // Flip ready to write
          channel.position(index).write(buf);    // Write the replacement to file
        buf.clear();                             // Reset ready for next read
      }*/

      int count = 0;                                                   // Count of primes written
      for(long prime : primes) {
        System.out.printf("%12d", prime);
        if(++count%5 == 0) {
          System.out.println();
        }
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
