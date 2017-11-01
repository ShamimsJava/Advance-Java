import javax.xml.parsers.*;
import javax.xml.parsers.ParserConfigurationException;

public class TryDOM {
  public static void main(String args[]) {
     DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
     DocumentBuilder builder = null;
     try {
       builder = builderFactory.newDocumentBuilder();
     }
     catch(ParserConfigurationException e) {
       e.printStackTrace();
       System.exit(1);
     }
     System.out.println("Builder Factory = " + builderFactory +"\nBuilder = " + builder);
  }
}
