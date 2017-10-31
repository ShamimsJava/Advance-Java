import javax.xml.parsers.*;
import java.io.*;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import static javax.xml.XMLConstants.*;

public class TryParsingSchemaInstance {
  public static void main(String args[]) {
    if(args.length == 0) {
      System.out.println("No file to process. Usage is:" +
            "\n  java TrySax \"xmlFilename\" " +
            "\nor:\n  java TrySaxHandler \"xmlFilename\" \"schemaFileName\" ");
      return;
    }
    File xmlFile = new File(args[0]);
    File schemaFile = args.length > 1 ? new File(args[1]) : null;
    process(xmlFile, schemaFile);
  }

  private static void process(File file, File schemaFile) {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser parser = null;
    spf.setNamespaceAware(true);
    try {
      SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
      spf.setSchema(schemaFile == null ? sf.newSchema() : sf.newSchema(schemaFile));
      parser = spf.newSAXParser();
    } catch(SAXException | ParserConfigurationException e) {
      e.printStackTrace();
      System.exit(1);
    }

    System.out.println("\nStarting parsing of " + file + "\n");
    MySAXHandler handler = new MySAXHandler();
    try {
      parser.parse(file, handler);
    } catch(IOException | SAXException e) {
      e.printStackTrace();
    }
  }
}
