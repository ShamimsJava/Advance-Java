import java.nio.file.*;
import java.nio.channels.*;
import java.io.IOException;
import java.nio.*;

public class LockingPrimesRead {
  public static void main(String[] args) {
    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("primes.bin");
    final int PRIMECOUNT = 6;
    final int LONG_BYTES = 8;
    ByteBuffer buf = ByteBuffer.allocate(LONG_BYTES*PRIMECOUNT);
    long[] primes = new long[PRIMECOUNT];

    try (FileChannel inCh = (FileChannel)(Files.newByteChannel(file))){
      int primesRead = 0;
      FileLock inLock = null;

      // File reading loop
      while(true) {
        int tryLockCount = 0;

        // Loop to get a lock on the file region you want to read
        while(true) {
          inLock = inCh.tryLock(inCh.position(), buf.remaining(), true);
          if(inLock != null) {                                         // If you have a lock
           System.out.println("\nAcquired file lock.");
           break;                                                      // exit the loop
          }

          if(++tryLockCount >= 100) {                                  // If you've tried too often
            System.out.printf("Failed to acquire lock after %d tries." + "Terminating...%n", tryLockCount);
            System.exit(1);                                            // end the program
          }

          // Wait 200 msec before the next try for a file lock
          try {
                Thread.sleep(200);                                     // Wait for 200 milliseconds
          } catch(InterruptedException e) {
              e.printStackTrace();
          }
        }

        // You have a lock so now read the file
        if(inCh.read(buf) == -1) {
          break;
        }
        inLock.release();                                              // Release lock as read is finished
        System.out.println("Released file lock.");

        LongBuffer longBuf = ((ByteBuffer)(buf.flip())).asLongBuffer();
        primesRead = longBuf.remaining();
        longBuf.get(primes,0, longBuf.remaining());
        for(int i = 0 ; i < primesRead ; ++i) {
          if(i%6 == 0) {
            System.out.println();
          }
          System.out.printf("%12d", primes[i]);
        }
        buf.clear();                                                   // Clear the buffer for the next read
      }

      System.out.println("\nEOF reached.");
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
