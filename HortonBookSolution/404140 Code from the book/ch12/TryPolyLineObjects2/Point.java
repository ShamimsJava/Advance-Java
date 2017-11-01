import java.io.Serializable;

public class Point implements Serializable {
  // Create a point from its coordinates
  public Point(double xVal, double yVal) {
     x = xVal;
     y = yVal;
  }

  // Create a point from another point
  public Point(Point point) {
     x = point.x;
     y = point.y;
  }

  // Convert a point to a string
  @Override public String toString() {
     return x+","+y;
  }

  // Coordinates of the point
  protected double x;
  protected double y;
  private static final long serialVersionUID = 7001L;
}
