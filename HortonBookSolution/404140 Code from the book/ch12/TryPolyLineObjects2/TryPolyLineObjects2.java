import java.io.*;
import java.nio.file.*;

/*
 * Uncomment the two statements commented out to get all the objects
 *correctly written to the file.
 */

public class TryPolyLineObjects2 {
  public static void main(String[] args) {
    // Create an array of coordinate pairs
    double[][] coords = { {1., 1.}, {1., 2.}, { 2., 3.},
                          {-3., 5.}, {-5., 1.}, {0., 0.} };

    Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("Polygons.bin");
    try {
      Files.createDirectories(file.getParent());                       // Make sure we have the directory
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    // Create the polyline objects and write them to the file
    System.out.println("Writing objects to file.");
    try (ObjectOutputStream objectOut =
          new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))){

      // Create a polyline from the coordinates
      PolyLine polygon = new PolyLine(coords);
      System.out.println(polygon);
      objectOut.writeObject(polygon);                                  // Write first object
//      objectOut.reset();                                               // Reset the stream

      polygon.addPoint(10., 10.);
      System.out.println(polygon);                                     // Add a point
      objectOut.writeObject(polygon);                                  // Write second object
//      objectOut.reset();                                               // Reset the stream

      polygon.addPoint(10., 15.);
      System.out.println(polygon);                                     // Add a point
      objectOut.writeObject(polygon);                                  // Write third object
      System.out.println("File written.");
    } catch(IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    // Read the objects back from the file
    PolyLine polylines[] = new PolyLine[3];
    System.out.println("\nReading objects from the file:");
    try (ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(file)))){
      for(int i = 0 ; i < polylines.length ; ++i) {
        polylines[i] = (PolyLine)objectIn.readObject();
      }
    } catch(ClassNotFoundException  e) {
      System.err.println("Class not found.");
      e.printStackTrace();
    } catch(IOException e){
      e.printStackTrace();
    }
    // Display the objects read from the file
    for(int i = 0 ; i < polylines.length ; ++i) {
      System.out.println(polylines[i]);
    }
  }
}
