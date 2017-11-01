public class TryAutoboxing {
  public static void main(String[] args) {
    LinkedList<Double> temperatures = new LinkedList<>();

    // Insert 6 temperature values 0 to 25 degress Centigrade
    for(int i = 0 ; i < 6 ; ++i) {
      temperatures.addItem(25.0*Math.random());
    }

    Double value = temperatures.getFirst();
    while(value != null) {
      System.out.printf("%.2f degrees Fahrenheit%n", toFahrenheit(value));
      value=temperatures.getNext();
    }
  }

  // Convert Centigrade to Fahrenheit
  public static double toFahrenheit(double temperature) {
    return 1.8*temperature + 32.0;
  }
}
