import java.nio.file.*;
import java.nio.*;
import java.nio.channels.ReadableByteChannel;
import java.io.IOException;

public class ReadPrimes {
  public static void main(String[] args) {
    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("primes.bin");
    if(!Files.exists(file)) {
      System.out.println(file + " does not exist. Terminating program.");
      System.exit(1);
    }

    final int PRIMECOUNT = 6;
    final int LONG_BYTES = 8;                                          // Number of bytes for type long
    ByteBuffer buf = ByteBuffer.allocate(LONG_BYTES*PRIMECOUNT);
    long[] primes = new long[PRIMECOUNT];
    try (ReadableByteChannel inCh = Files.newByteChannel(file)){
      int primesRead = 0;
      while(inCh.read(buf) != -1) {
        LongBuffer longBuf = ((ByteBuffer)(buf.flip())).asLongBuffer();
        primesRead = longBuf.remaining();
        longBuf.get(primes, 0, primesRead);

        // List the primes read on the same line
        System.out.println();
        for(int i = 0 ; i < primesRead ; ++i) {
          System.out.printf("%10d", primes[i]);
        }
        buf.clear();                                                   // Clear the buffer for the next read
      }
      System.out.println("\nEOF reached.");
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}