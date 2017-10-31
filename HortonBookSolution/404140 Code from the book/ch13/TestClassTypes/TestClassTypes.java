public class TestClassTypes {
  public static void main(String[] args) {

  LinkedList<String> proverbs = new LinkedList<>();
  LinkedList<Double> numbers = new LinkedList<>();
   System.out.println("numbers class name " + numbers.getClass().getName());
   System.out.println("proverbs class name " + proverbs.getClass().getName());
   System.out.println("Compare Class objects: " + numbers.getClass().equals(proverbs.getClass()));
/*
   Object obj = (Object)numbers;
   System.out.println("obj class name " + obj.getClass().getName());
   proverbs = (LinkedList<String>)obj;
   System.out.println("obj in proverbs class name " + obj.getClass().getName());
*/
  }
}
