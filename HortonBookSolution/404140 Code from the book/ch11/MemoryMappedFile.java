import static java.nio.file.StandardOpenOption.*;
import static java.nio.channels.FileChannel.MapMode.READ_WRITE;
import java.nio.file.*;
import java.nio.channels.FileChannel;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.util.EnumSet;

public class MemoryMappedFile {
  public static void main(String[] args) {
    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("primes_backup.bin");
    if(!Files.exists(file)) {
      System.out.println(file + " does not exist. Terminating program.");
      System.exit(1);
    }

    final int PRIMESREQUIRED = 10;
    final int LONG_BYTES = 8;
    long[] primes = new long[PRIMESREQUIRED];

    int index = 0;                                                     // Position for a prime in the file
    final long REPLACEMENT = 999999L;                                  // Replacement for a selected prime

    try {
      FileChannel channel = (FileChannel)(Files.newByteChannel(file, EnumSet.of(READ, WRITE)));
      final int PRIMECOUNT = (int)channel.size()/LONG_BYTES;
      MappedByteBuffer buf = channel.map(READ_WRITE, 0L, channel.size()).load();
      channel.close();                                                 // Close the channel

      for(int i = 0 ; i < PRIMESREQUIRED ; ++i) {
        index = LONG_BYTES*(int)(PRIMECOUNT*Math.random());
        primes[i] = buf.getLong(index);
        buf.putLong(index, REPLACEMENT);
      }
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
