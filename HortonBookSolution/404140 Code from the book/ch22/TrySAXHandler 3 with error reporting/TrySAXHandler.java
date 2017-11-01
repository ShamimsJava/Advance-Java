import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import java.io.*;

public class TrySAXHandler {
  public static void main(String args[]) {
    if(args.length == 0) {
      System.out.println("No file to process. Usage is:" + "\njava TrySax \"filename\" ");
      return;
    }
    File xmlFile = new File(args[0]);
    if(xmlFile.exists()) {
      process(xmlFile);
    } else {
      System.out.println(xmlFile + " does not exist.");
    }
  }

  private static void process(File file) {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser parser = null;
    spf.setNamespaceAware(true);
    spf.setValidating(true);
    System.out.println("Parser will " + (spf.isNamespaceAware() ? "" : "not ") + "be namespace aware");
    System.out.println("Parser will "+(spf.isValidating()?"":"not ") + "validate XML");
    try {
     spf.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
     parser = spf.newSAXParser();
     System.out.println("Parser object is: " + parser);

    } catch(SAXException | ParserConfigurationException e) {
      e.printStackTrace();
      System.exit(1);

    }

    System.out.println("\nStarting parsing of " + file + "\n");
    MySAXHandler handler = new MySAXHandler();
    try {
       parser.parse(file, handler);
    }  catch(IOException | SAXException e) {
      e.printStackTrace();

    }
  }
}
