import java.nio.file.*;
import java.nio.channels.ReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ReadAString {

  public static void main(String[] args) {

    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("charData.txt");
    if(!Files.exists(file)) {
      System.out.println(file + " does not exist. Terminating program.");
      System.exit(1);;
    }

    ByteBuffer buf = ByteBuffer.allocate(50);
    try (ReadableByteChannel inCh = Files.newByteChannel(file)){
      while(inCh.read(buf) != -1) {
        System.out.print("String read: " +
                   ((ByteBuffer)(buf.flip())).asCharBuffer().toString());
        buf.clear();                                                   // Clear the buffer for the next read
      }
      System.out.println("EOF reached.");
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
