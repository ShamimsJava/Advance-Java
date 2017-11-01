import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.nio.channels.*;
import java.io.IOException;
import java.util.EnumSet;

public class FileBackup {
  public static void main(String[] args) {
    if(args.length==0) {
      System.out.println("No file to copy. Application usage is:\n" + "java -classpath . FileCopy \"filepath\"" );
      System.exit(1);
    }
    Path fromFile = Paths.get(args[0]);
    fromFile.toAbsolutePath();

    if(Files.notExists(fromFile)) {
      System.out.printf("File to copy, %s, does not exist.", fromFile);
      System.exit(1);
    }

    Path toFile = createBackupFilePath(fromFile);
    try (FileChannel inCh = (FileChannel)(Files.newByteChannel(fromFile));
          WritableByteChannel outCh = Files.newByteChannel( toFile, EnumSet.of(WRITE,CREATE_NEW))){
      int bytesWritten = 0;
      long byteCount = inCh.size();
      while(bytesWritten < byteCount) {
        bytesWritten += inCh.transferTo(bytesWritten, byteCount-bytesWritten, outCh);
      }

      System.out.printf("File copy complete. %d bytes copied to %s%n", byteCount, toFile);
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  // Method to create a unique backup Path object under MS Windows
  public static Path createBackupFilePath(Path file) {
     Path parent = file.getParent();
     String name = file.getFileName().toString();                      // Get the file name
     int period = name.indexOf('.');                                   // Find the extension separator
     if(period == -1) {                                                // If there isn't one
       period = name.length();                                         // set it to the end of the string
     }
     String nameAdd = "_backup";                                       // String to be appended

     // Create a Path object that is a unique
      Path backup = parent.resolve(
                name.substring(0,period) + nameAdd + name.substring(period));
     while(Files.exists(backup)) {                                     // If the path already exists...
        name = backup.getFileName().toString();                        // Get the current file name
        backup = parent.resolve(name.substring(0,period) +             // add _backup
                                nameAdd + name.substring(period));
       period += nameAdd.length();                                     // Increment separator index
     }
     return backup;
  }
}
