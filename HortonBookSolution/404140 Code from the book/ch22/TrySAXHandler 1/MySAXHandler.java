import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class MySAXHandler extends DefaultHandler {
  @Override
  public void startDocument() {
    System.out.println("Start document: ");
  }

  @Override
  public void endDocument()  {
    System.out.println("End document");
  }

  @Override
  public void startElement(String uri, String localName, String qname, Attributes attr) {
    System.out.println("Start element: local name: " + localName + " qname: " + qname + " uri: "+uri);
    int attrCount = attr.getLength();
    if(attrCount>0) {
      System.out.println("Attributes:");
      for(int i = 0 ; i < attrCount ; ++i) {
        System.out.println("  Name : " + attr.getQName(i));
        System.out.println("  Type : " + attr.getType(i));
        System.out.println("  Value: " + attr.getValue(i));
      }
    }
  }

  @Override
  public void endElement(String uri, String localName, String qname) {
    System.out.println("End element: local name: " + localName + " qname: " + qname + " uri: "+uri);
  }

  @Override
  public void characters(char[] ch, int start, int length) {
    System.out.println("Characters: " + new String(ch, start, length));
  }

  @Override
  public void ignorableWhitespace(char[] ch, int start, int length) {
    System.out.println("Ignorable whitespace: " + length + " characters.");
  }
}
