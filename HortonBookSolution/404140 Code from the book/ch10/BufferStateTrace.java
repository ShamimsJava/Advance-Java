import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.nio.channels.*;

import java.util.EnumSet;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BufferStateTrace {
  public static void main(String[] args) {
    String phrase = "Garbage in, garbage out.\n";

    Path file = Paths.get("D:/Junk/charData.txt");                     // Path object for the file
    try {
      Files.createDirectories(file.getParent());                       // Make sure we have the directory
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (WritableByteChannel channel = Files.newByteChannel(file, EnumSet.of(WRITE, CREATE, APPEND))) {
      ByteBuffer buf = ByteBuffer.allocate(1024);
      System.out.printf(
        "\nNew buffer:           position = %1$2d   Limit = %2$4d   capacity = %3$4d",
                        buf.position(), buf.limit(), buf.capacity());
      // Load the data into the buffer
      for(char ch : phrase.toCharArray())
        buf.putChar(ch);
      System.out.printf(
        "\nBuffer after loading: position = %1$2d   Limit = %2$4d   capacity = %3$4d",
                        buf.position(), buf.limit(), buf.capacity());
      buf.flip();                                                      // Flip the buffer ready for file write
      System.out.printf(
        "\nBuffer after flip:    position = %1$2d   Limit = %2$4d   capacity = %3$4d",
                        buf.position(), buf.limit(), buf.capacity());
      channel.write(buf);                                              // Write the buffer to the file channel

// Uncomment the following to get the size of the file in the output
//      System.out.println("\nThe file contains " + ((FileChannel)channel).size() + " bytes.");

      buf.flip();
      channel.write(buf);                // Write the buffer again to the file channel
      System.out.println("\nBuffer contents written to the file.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
