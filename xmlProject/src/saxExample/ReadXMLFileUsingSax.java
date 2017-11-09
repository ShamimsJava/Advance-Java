package saxExample;

import org.xml.sax.Attributes;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFileUsingSax {

    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bfname = false;
                boolean bsalary = false;
                boolean bage = false;

        
                @Override
                public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {

                    //System.out.println("Start Element :" + qName);

                    if (qName.equalsIgnoreCase("FULLNAME")) {
                        bfname = true;
                    }

                    if (qName.equalsIgnoreCase("SALARY")) {
                        bsalary = true;
                    }
                    
                    if (qName.equalsIgnoreCase("AGE")) {
                        bage = true;
                    }

                }

                @Override
                public void endElement(String uri, String localName,
                        String qName) throws SAXException {

                    //System.out.println("End Element :" + qName);

                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bfname) {
                        System.out.println("Full Name : " + new String(ch, start, length));
                        bfname = false;
                    }

                    if (bsalary) {
                        System.out.println("Salary : " + new String(ch, start, length));
                        bsalary = false;
                    }
                    
                    if (bage) {
                        System.out.println("Age : " + new String(ch, start, length));
                        bage = false;
                    }

                }

            };

            saxParser.parse("D:\\Git\\Advance-Java\\xmlProject\\src\\saxExample/staff.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
