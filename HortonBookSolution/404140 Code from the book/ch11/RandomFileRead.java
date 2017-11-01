import java.nio.file.*;
import java.nio.channels.FileChannel;
import java.io.IOException;
import java.nio.ByteBuffer;

public class RandomFileRead {
  public static void main(String[] args) {
    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("primes.bin");
    if(!Files.exists(file)) {
      System.out.println(file + " does not exist. Terminating program.");
      System.exit(1);
    }

    final int PRIMESREQUIRED = 10;
      final int LONG_BYTES = 8;                                        // Number of bytes for type long
    ByteBuffer buf = ByteBuffer.allocate(LONG_BYTES*PRIMESREQUIRED);

    long[] primes = new long[PRIMESREQUIRED];
    int index = 0;                                                     // Position for a prime in the file

    try (FileChannel inCh = (FileChannel)(Files.newByteChannel(file))){
      // Count of primes in the file
      final int PRIMECOUNT = (int)inCh.size()/LONG_BYTES;

      // Read the number of random primes required
      for(int i = 0 ; i < PRIMESREQUIRED ; ++i) {
        index = LONG_BYTES*(int)(PRIMECOUNT*Math.random());
        inCh.read(buf, index);                                         // Read the value
            //    inCh.position(index).read(buf);                      // Read the value
        buf.flip();
        primes[i] = buf.getLong();                                     // Save it in the array
        buf.clear();
      }

      // Output the selection of random primes 5 to a line in field width of 12
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
